package toolkit;


import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ARoundedTextField extends Panel implements TextComponentInterface  {
    
	boolean enabled;
	int eventId;
    StringBuffer stringBuffer;
    KeyListener keyListener;
    List<ActionListener> actionListeners = new ArrayList<ActionListener>();
    public static final int X_OFFSET = 10;
    public static final int Y_OFFSET = 20;
    public static final int ROUND_RECTANGLE_ARC_WIDTH = 20;
    public static final int ROUND_RECTANGLE_ARC_HEIGHT = 20;
    
    public ARoundedTextField() {
        stringBuffer = new StringBuffer("");
        this.setFocusable(true);  
        enabled = true;
        keyListener = new AKeyListener(this, stringBuffer);
        this.addKeyListener(keyListener);
    }
    
    public void addActionListener(ActionListener actionListener) {
        if (actionListeners.contains(actionListener)) return;
        actionListeners.add(actionListener);
    }
    
    public void notifyActionListeners() {
        for (int index = 0; index <actionListeners.size(); index++) {
            actionListeners.get(index).actionPerformed(new ActionEvent(this, eventId, stringBuffer.toString().toLowerCase()));
        }
        eventId++;  
    }
    
    public void paint(Graphics g) {
        super.paint(g); 
        if (enabled) {	
        	g.drawRoundRect(0, 0, getWidth(), getHeight(), ROUND_RECTANGLE_ARC_WIDTH, ROUND_RECTANGLE_ARC_HEIGHT); 
        	g.drawString(stringBuffer.toString(), X_OFFSET, Y_OFFSET); 
        	int textLength = 0;
        	for (int i =0; i < stringBuffer.length();i++){
        		textLength += g.getFontMetrics().charWidth(stringBuffer.toString().charAt(i));
        		
        	}
        	
        	g.drawLine(textLength+11, 6, textLength+11, ROUND_RECTANGLE_ARC_HEIGHT);
        	
        } else {
        	g.fillRoundRect(0, 0, getWidth(), getHeight(), ROUND_RECTANGLE_ARC_WIDTH, ROUND_RECTANGLE_ARC_HEIGHT);
        
        }
    }
    
    public String getText() {
        return stringBuffer.toString();
    }   
    
    public void setText(String newVal) {        
        stringBuffer.delete(0, stringBuffer.length());
        stringBuffer.append(newVal);
        repaint();
    }
    
    public boolean getEnabled() {
    	return enabled;
    }
    
    public void setEnabled(boolean Enabled) {
    	this.enabled = Enabled;
    	repaint();
    }

}