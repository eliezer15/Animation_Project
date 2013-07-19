package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;

import shapes.Avatar;
import shapes.CompositeAngle;
import shapes.ImageClass;
import shapes.Line;
import shapes.Shape;
import shapes.StringShape;

public class PaintListenerClass implements PaintListener {

	ObservablePainter view;
	Shape observableShape;
	boolean visible;
	
	public PaintListenerClass(ObservablePainter painter, Avatar avatar) {
		view = painter;
		observableShape = avatar;
		visible = true;
		
		//Paint listener automatically registers itself as a listener for its two parameters
		view.addPaintListener(this);
		observableShape.addPropertyChangeListener(this);
	}
	
	public PaintListenerClass(ObservablePainter painter, ImageClass image) {
		this.view = painter;
		observableShape = image;
		visible = true;
		
		//Paint listener automatically registers itself as a listener for its two parameters
		view.addPaintListener(this);
		observableShape.addPropertyChangeListener(this);
		
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		view.repaint();
	}

	public void paint(Graphics g) {
		
		if (observableShape instanceof ImageClass)
			draw(g, (ImageClass)observableShape);
		
		else
			draw(g, (Avatar)observableShape);		
	}
	
    void draw(Graphics g, ImageClass background) {
    	
    	if (visible) {
    		Image img = 
    				Toolkit.getDefaultToolkit().getImage(background.getImageFileName());
    		g.drawImage(img, background.getX(), background.getY(), view);
    	}
	}
	
	void draw(Graphics g, Avatar avatar) {
		if (visible) {
			g.setColor(avatar.getColor());
			
			StringShape text = avatar.getText();
			g.drawString(text.getText(), text.getX(),text.getY());
			
			Image img =
				Toolkit.getDefaultToolkit().getImage(avatar.getHead().getImageFileName());
			g.drawImage(img, avatar.getHead().getX(), avatar.getHead().getY(), view);
			
			Line neck = avatar.getNeck();
			g.drawLine(neck.getX(), neck.getY(), neck.getX() + neck.getWidth(), neck.getY() + neck.getHeight());
			
			Line torso = avatar.getTorso();
			g.drawLine(torso.getX(), torso.getY(), torso.getX() + torso.getWidth(), torso.getY() + torso.getHeight());
			
			CompositeAngle arms = avatar.getArms();
			g.drawLine(arms.getX(), arms.getY(), arms.getX() + arms.getLine1().getWidth(), arms.getY() + arms.getLine1().getHeight());
			g.drawLine(arms.getX(), arms.getY(), arms.getX() + arms.getLine2().getWidth(), arms.getY() + arms.getLine2().getHeight());
			
			Line leftElbow = avatar.getLeftElbow();
			Line rightElbow = avatar.getRightElbow();
			g.drawLine(leftElbow.getX(), leftElbow.getY(), leftElbow.getX() + leftElbow.getWidth(), leftElbow.getY() + leftElbow.getHeight());
			g.drawLine(rightElbow.getX(), rightElbow.getY(), rightElbow.getX() + rightElbow.getWidth(), rightElbow.getY() + rightElbow.getHeight());
			
			CompositeAngle legs = avatar.getLegs();
			g.drawLine(legs.getX(), legs.getY(), legs.getX() + legs.getLine1().getWidth(), legs.getY() + legs.getLine1().getHeight());
			g.drawLine(legs.getX(), legs.getY(), legs.getX() + legs.getLine2().getWidth(), legs.getY() + legs.getLine2().getHeight());
			
			Line leftCalf = avatar.getLeftCalf();
			Line rightCalf = avatar.getRightCalf();
			g.drawLine(leftCalf.getX(), leftCalf.getY(), leftCalf.getX() + leftCalf.getWidth(), leftCalf.getY() + leftCalf.getHeight());
			g.drawLine(rightCalf.getX(), rightCalf.getY(), rightCalf.getX() + rightCalf.getWidth(), rightCalf.getY() + rightCalf.getHeight());
		}	
	}

}
