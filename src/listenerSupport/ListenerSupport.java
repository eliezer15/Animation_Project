package listenerSupport;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ListenerSupport implements PropertyListenerSupport {

	ArrayList<PropertyChangeListener> contents = new ArrayList<PropertyChangeListener>();
	
	public int size() {
		return contents.size();
	}
	
	public PropertyChangeListener elementAt(int index) {
		return contents.get(index);
	}
	
	public void addElement(PropertyChangeListener l) {
		
		contents.add(l);
	}
	
	public void notifyAllListeners(PropertyChangeEvent event) {
		
		for (int i = 0; i < size(); i++) {
			elementAt(i).propertyChange(event);
		}
	}
}
