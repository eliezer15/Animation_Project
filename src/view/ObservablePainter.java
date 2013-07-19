package view;

import java.awt.Component;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ObservablePainter extends Component implements PropertyChangeListener {

	ArrayList<PaintListener> listeners;
	
	public ObservablePainter() {
		listeners = new ArrayList<PaintListener>();
	}

	public void addPaintListener(PaintListener p) {
		listeners.add(p);
	}
	
	public void paint(Graphics g) {
		for (PaintListener l: listeners)
			l.paint(g);
			
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	/*
	 * Always register the PaintListeners to the shapes in the following order
	 * 0-Background
	 * 1-Dorothy
	 * 2-Oz
	 * 3-Scarecrow
	 */
		if (evt.getPropertyName().equals("this")){
			boolean visible = (boolean)evt.getNewValue();
			
			switch((String)evt.getOldValue()) {
			case "background":
				listeners.get(0).setVisible(visible);
				break;
			case "dorothy":
				listeners.get(1).setVisible(visible);
				break;
			case "oz":
				listeners.get(2).setVisible(visible);
				break;
			case "scarecrow":
				listeners.get(3).setVisible(visible);
				break;
			}
		}
		repaint();
		
	}	
}
