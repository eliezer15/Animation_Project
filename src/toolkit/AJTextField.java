package toolkit;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AJTextField extends JTextField implements TextComponentInterface {

	boolean enabled;
	
    public boolean getEnabled() {
    	return enabled;
    }
    
    public void setEnabled(boolean Enabled) {
    	this.enabled = Enabled;
    	repaint();
    }
}
