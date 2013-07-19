 
package toolkit;
import java.awt.TextField;

@SuppressWarnings("serial")
public class ATextField extends TextField implements TextComponentInterface {

	boolean enabled;
	
    public boolean getEnabled() {
    	return enabled;
    }
    
    public void setEnabled(boolean Enabled) {
    	this.enabled = Enabled;
    	repaint();
    }
}