package shapes;
import java.awt.Color;

import util.annotations.StructurePattern;
import util.annotations.Visible;

@StructurePattern("Bean Pattern")
public class Avatar extends Shape implements AvatarInterface  {
	
	//The overall x and y direction are given by the x,y coordinates of the torso
	int x;
	int y;
	
	//The overall size is the size of the Torso
	double size;
	Color color;
	StringShapeClass text;
	ImageClass head;
	LineClass neck;
	LineClass torso;
	CompositeAngleClass arms;
	LineClass leftElbow;
	LineClass rightElbow;
	CompositeAngleClass legs;
	LineClass leftCalf;
	LineClass rightCalf;
	Rectangle leftFoot;
	Rectangle rigthFoot;
	
	public Avatar(String headFile){
		
		int defaultPositionAndSize = 40;
		x = defaultPositionAndSize;
		y = defaultPositionAndSize;
		size = defaultPositionAndSize;
		
		//head and neck sizes are constant
		head = new ImageClass(0,0,headFile);
		neck = new LineClass(x,y-(int)(size*0.2),(int)(size*0.2), 3*Math.PI/2);
		torso = new LineClass(x,y,size,Math.PI/2);
		
		//arms, elbow, hands
		arms = new CompositeAngleClass(x,y,0, Math.PI/3);
		leftElbow = new LineClass(0, 0,0, Math.PI/2);
		rightElbow = new LineClass(0, 0,0, Math.PI/2); 
		
		//legs, calfs, feet
		legs = new CompositeAngleClass(x,0,0, Math.PI/3);
		leftCalf = new LineClass(0,0,0,Math.PI/2);
		rightCalf = new LineClass(0,0,0,Math.PI/2);
		
		text =  new StringShapeClass(0,0,"");
		moveHead();
		setSize(size);
		rotateArms(0);
		rotateLegs(0);
	}
	
    public Avatar(String headFile, int newX, int newY, double newSize, Color color){
				
    	y = newY;
    	x = newX;
    	size = newSize;
    	
		//head and neck sizes are constant
		head = new ImageClass(0,0,headFile);
		neck = new LineClass(x,y-(int)(size*0.2),(int)(size*0.2), Math.PI/2);
		torso = new LineClass(x,y,size,Math.PI/2);
		
		//arms, elbow, hands
		arms = new CompositeAngleClass(x,y,0, Math.PI/3);
		leftElbow = new LineClass(0, 0,0, Math.PI/2);
		rightElbow = new LineClass(0, 0,0, Math.PI/2); 
		
		//legs, calfs, feet
		legs = new CompositeAngleClass(x,0,0, Math.PI/3);
		leftCalf = new LineClass(0,0,0,Math.PI/2);
		rightCalf = new LineClass(0,0,0,Math.PI/2);
		
		text =  new StringShapeClass(0,0,"");
		
		moveHead();
		setSize(size);
		rotateArms(0);
		rotateLegs(0);
		setColor(color);
		
	}
    
	//Read only properties
	@Override
	public Line getTorso() {
		return torso;
	}
	@Override
	public Line getNeck(){
		return neck;
	}
	@Override
	public CompositeAngle getArms() {
		return arms;
	}
	@Override
	public LineClass getLeftElbow(){
		return leftElbow;
	}
	@Override
	public LineClass getRightElbow(){
		return rightElbow;
	}
	@Override
	public CompositeAngle getLegs() {
		return legs;
	}
	@Override
	public LineClass getLeftCalf() {
		return leftCalf;
	}
	@Override
	public LineClass getRightCalf() {
		return rightCalf;
	}
	
	//Animations
	@Override
	public void rotateArms(int shift) {
		arms.shiftAngle(shift);
		moveElbows();
	}
	@Override
	public void turnArms(int turn) {
		arms.turnAngle(turn);
		turnElbows();
	}
	@Override
	public void rotateLegs(int shift){
		legs.shiftAngle(shift);
		moveCalfs();
	}
	@Override
	public void turnLegs(int turn) {
		legs.turnAngle(turn);
		turnCalfs();
	}
	public void rotateElbows(int shift){
		leftElbow.shiftAngle(-shift);
		rightElbow.shiftAngle(shift);
		
	}
	public void rotateCalfs(int shift){
		leftCalf.shiftAngle(-shift);
		rightCalf.shiftAngle(shift);
		
	}

	//Mutable properties
	@Override
	public Image getHead() {
		return head;
	}
	@Override
	public void setHead(ImageClass head) {
		this.head = head;
	}
	@Override
	public StringShapeClass getText(){
		return text;
	}
	@Override
	public void setText(String t){
		this.text.setText(t);
	}
	@Override
	@Visible(false)
	public Color getColor(){
		return color;
	}
	@Override
	public void setColor(Color color){
		this.color = color;
		torso.setColor(color);
		text.setColor(color);
		neck.setColor(color);
		legs.setColor(color);
		leftCalf.setColor(color);
		rightCalf.setColor(color);
		arms.setColor(color);
		rightElbow.setColor(color);
		leftElbow.setColor(color);
	}

	//Methods to change the avatar
	
	public void move(int newX, int newY){
		moveUnits(newX-x, newY-y);

	}
	
	@Override
	public void moveUnits(int unitsX, int unitsY){
		
		x += unitsX;
		y += unitsY;
		head.setX(head.getX() + unitsX);
		head.setY(head.getY() + unitsY);
		neck.setX(neck.getX() + unitsX);
		neck.setY(neck.getY() + unitsY);
		
		torso.setX(torso.getX() + unitsX);
		torso.setY(torso.getY() + unitsY);
		
		arms.setX(arms.getX() + unitsX);
		arms.setY(arms.getY() + unitsY);
		moveElbows();
		
		legs.setX(legs.getX() + unitsX);
		legs.setY(legs.getY() + unitsY);
		moveCalfs();
		
		text.setX(text.getX() + unitsX);
		text.setY(text.getY() + unitsY);

	}

	
	@Override
	public void setSize(double newSize) {
		size = newSize;
		torso.setRadius(newSize);
		
		//arms, elbows, hands
		arms.setY(y);
		arms.setRadius((int)(newSize));
		arms.setAngle(arms.getAngle());
		moveElbows();
		
		//legs, calfs, feet
		legs.setY((int)(y + size));
		legs.setRadius((int)(newSize*1.3));	
		legs.setAngle(legs.getAngle());
		moveCalfs();
		
		//text
		text.setX(head.getX()-20);
		text.setY(head.getY()-20);
		
	}
	@Override
	public void scale(int unit) {
		
		double newSize = size + unit;
		setSize(newSize);
	}
	
	//Methods to keep all body parts together
	private void moveHead() {
		//All the heads have the same, read-only size
		head.setX(x-(int)(size*0.20));
		head.setY(y-(int)(size*0.85));
		
	}
	private void moveElbows() {
		
		leftElbow.setX(arms.getX()-arms.getLine1().getWidth());
		leftElbow.setY(arms.getY()+arms.getLine1().getHeight());
		leftElbow.setRadius(arms.getRadius()/3);
		
		rightElbow.setX(arms.getX()+arms.getLine1().getWidth());
		rightElbow.setY(arms.getY()+arms.getLine1().getHeight());
		rightElbow.setRadius(arms.getRadius()/3);
		
	}
	private void turnElbows(){
		
		leftElbow.setX(arms.getX()+arms.getLine2().getWidth());
		leftElbow.setY(arms.getY()+arms.getLine2().getHeight());
		leftElbow.setRadius(arms.getRadius()/3);
		
		rightElbow.setX(arms.getX()+arms.getLine1().getWidth());
		rightElbow.setY(arms.getY()+arms.getLine1().getHeight());
		rightElbow.setRadius(arms.getRadius()/3);
		
	}	
	private void moveCalfs() {
		
		leftCalf.setX(legs.getX()-legs.getLine1().getWidth());
		leftCalf.setY(legs.getY()+legs.getLine1().getHeight());
		leftCalf.setRadius(legs.getRadius()/3);
		
		rightCalf.setX(legs.getX()+legs.getLine1().getWidth());
		rightCalf.setY(legs.getY()+legs.getLine1().getHeight());
		rightCalf.setRadius(legs.getRadius()/3);
		
	}
	private void turnCalfs(){
		
		leftCalf.setX(legs.getX()+legs.getLine2().getWidth());
		leftCalf.setY(legs.getY()+legs.getLine2().getHeight());
		leftCalf.setRadius(legs.getRadius()/3);
		
		rightCalf.setX(legs.getX()+legs.getLine1().getWidth());
		rightCalf.setY(legs.getY()+legs.getLine1().getHeight());
		rightCalf.setRadius(legs.getRadius()/3);
	}
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y + ", text=" + text.getText();
	}
	
	
}
