package toolkit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AKeyListener implements KeyListener {

	StringBuffer buffer;
	ARoundedTextField textField;
	
	public AKeyListener(ARoundedTextField textField, StringBuffer buffer) {
		this.buffer = buffer;
		this.textField = textField;
		this.textField.setFocusable(true);
	}
    public void keyTyped(KeyEvent keyEvent) {
    	
        if (keyEvent.getKeyChar() == '\n') {
        	textField.notifyActionListeners();
            return;
        }
        
        if (!Character.isDigit(keyEvent.getKeyChar()) && keyEvent.getKeyChar()==8 ) 
        	buffer.deleteCharAt(buffer.length()-1);
        else  
        	buffer.append(Character.toLowerCase(keyEvent.getKeyChar())); 
        
        textField.repaint();  
    }
    
    public void keyPressed(KeyEvent arg0) {         
    }
    
    public void keyReleased(KeyEvent arg0) {
        
    }
	

}
