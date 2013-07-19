package shapes;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import listenerSupport.ListenerSupport;
import util.annotations.ObserverRegisterer;
import util.annotations.ObserverTypes;
import util.annotations.StructurePattern;
import util.models.PropertyListenerRegisterer;

@StructurePattern("Bean Pattern")
public abstract class Shape implements ShapeInterface, PropertyListenerRegisterer {

	int x,y,height,width;
	double angle,radius;
	Color color;
	
	ListenerSupport listenerSupport = new ListenerSupport();
	
	public Shape() {
		x = 0;
		y = 0;
		radius = 0;
		angle = 0;
	}
	
	public Shape(int x, int y, double angle, double radius,
			 Color color) {

		this.x = x;
		this.y = y;
		this.radius = radius; //I have to add this line because setAngle depends on the radius
		setAngle(angle);
		setRadius(radius);
		this.color = color;
	}
	
	public Shape(int x, int y, double radius,
			double angle) {

		this.x = x;
		this.y = y;
		this.radius = radius; //I have to add this line because setAngle depends on the radius
		setAngle(angle);
		setRadius(radius);
	}
	
	@ObserverRegisterer(ObserverTypes.PROPERTY_LISTENER)
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listenerSupport.addElement(listener);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int newX) {
		int oldX = x;
		x = newX;
		
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this,"x",oldX, newX));
		}
		
	}

	public int getY() {
		return y;
	}

	public void setY(int newY) {
		int oldY = y;
		y = newY;
		
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this,"y",oldY, newY));
		}
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double newAngle) {
		double oldAngle = angle;
		double oldWidth = width;
		double oldHeight = height;
		
		angle = newAngle;
		width = (int)(radius*Math.cos(angle));
		height = (int)(radius*Math.sin(angle));
		
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this,"angle",oldAngle, newAngle));
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this,"height",oldHeight, height));
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this,"width",oldWidth, width));
		}
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double newRadius) {
		double oldRadius = radius;
		double oldWidth = width;
		double oldHeight = height;
		
		radius = newRadius;
		width = Math.abs((int)(radius*Math.cos(angle)));
		height = Math.abs((int)(radius*Math.sin(angle)));
		
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this,"radius",oldRadius, newRadius));
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this,"height",oldHeight, height));
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this,"weight",oldWidth, width));
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color newColor) {
		Color oldColor = color;
		color = newColor;
		
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this,"color",oldColor, color));
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}	

}
