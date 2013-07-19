package view;

import java.awt.Graphics;
import java.beans.PropertyChangeListener;

public interface PaintListener extends PropertyChangeListener{

	public void paint(Graphics g);

	public void setVisible(boolean visible);
}
