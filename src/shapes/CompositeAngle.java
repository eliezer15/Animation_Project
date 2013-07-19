package shapes;

public interface CompositeAngle extends ShapeInterface {
	
	public LineClass getLine1();
	public LineClass getLine2();
	public void shiftAngle(int shift);
	public void turnAngle(int turn);

}
