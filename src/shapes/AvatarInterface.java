package shapes;

import java.awt.Color;

public interface AvatarInterface {

	//Read only properties
	public Line getTorso();

	public Line getNeck();

	public CompositeAngle getArms();

	public Line getLeftElbow();

	public Line getRightElbow();

	public CompositeAngle getLegs();

	public Line getLeftCalf();

	public Line getRightCalf();

	//Animations
	public void rotateArms(int shift);

	public void turnArms(int turn);

	public void rotateLegs(int shift);

	public void turnLegs(int turn);

	public void rotateElbows(int shift);
	
	public void rotateCalfs(int shift);

	//Mutable properties
	public Image getHead();

	public void setHead(ImageClass head);

	public StringShape getText();

	public void setText(String t);

	public Color getColor();

	public void setColor(Color color);

	//Methods to change the avatar
	public void moveUnits(int unitsX, int unitsY);
	
	public void move(int newX, int newY);

	public void setSize(double newSize);

	public void scale(int unit);

}