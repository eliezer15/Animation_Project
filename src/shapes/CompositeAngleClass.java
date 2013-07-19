package shapes;

import java.awt.Color;

import util.annotations.StructurePattern;

@StructurePattern("Bean Pattern")
public class CompositeAngleClass extends Shape implements CompositeAngle {

	LineClass line1;
	LineClass line2;

	public CompositeAngleClass() {
		super();
		line1 = new LineClass();
		line2 = new LineClass();
	}
	
	public CompositeAngleClass(int x, int y, int newRadius, double newAngle, Color color){
		this.x = x;
		this.y = y;
		this.angle = newAngle;
		line1 = new LineClass(x,y,0,0);
		line2 = new LineClass(x,y,0,0);	
		setRadius(newRadius);
		setAngle(newAngle);		
	}
	
	public CompositeAngleClass(int x, int y, int newRadius, double newAngle){
		this.x = x;
		this.y = y;
		line1 = new LineClass(x,y,0,0);
		line2 = new LineClass(x,y,0,0);	
		setRadius(newRadius);
		setAngle(newAngle);
	}
	
	public LineClass getLine1() {
		return line1;
	}

	public LineClass getLine2() {
		return line2;
	}

	public void setX(int x) {
		line1.setX(x);
		line2.setX(x);
		this.x = x;
	}

	public void setY(int y) {
		line1.setY(y);
		line2.setY(y);
		this.y = y;
	}
	
	public void setColor(Color color) {
		line1.setColor(color);
		line2.setColor(color);
	}

	public void setAngle(double newAngle) {
		this.angle = newAngle;
		double newAngle1 = (-angle + Math.PI)/2;
		line1.setAngle(newAngle1);
		
		double newAngle2 = (angle + Math.PI)/2;
		line2.setAngle(newAngle2);
		
	}
	
	public void setRadius(int radius) {
		line1.setRadius(radius/2);
		line2.setRadius(radius/2);
	}
	
	public double getRadius(){
		return line1.getRadius()*2;
	}
	public void shiftAngle(int shift) {
		line1.shiftAngle(shift/2);
		line2.shiftAngle(-(shift/2));	
	}
	
	public void turnAngle(int turn) {
		line1.shiftAngle(turn);
		line2.shiftAngle(turn);
	}


}
