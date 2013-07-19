package listenerSupport;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface PropertyListenerSupport {
    public void addElement(PropertyChangeListener l);
    public PropertyChangeListener elementAt(int index); 
    public int size();
    public void notifyAllListeners(PropertyChangeEvent event);

}
