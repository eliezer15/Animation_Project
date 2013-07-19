package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;

import shapes.Avatar;
import shapes.CompositeAngle;
import shapes.ImageClass;
import shapes.Line;
import shapes.Scene;
import shapes.StringShape;
import util.models.PropertyListenerRegisterer;

//This is the regular version of the OZ view
@SuppressWarnings("serial")
public class OzSceneView extends JComponent 
				implements PropertyChangeListener, PropertyListenerRegisterer {

	Scene scene;
	
	public OzSceneView(Scene s) {
		scene = s;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		repaint();	
	}
	
	public void paint(Graphics g) {
		
		draw(g, (ImageClass)scene.getBackground());
		
		draw(g, scene.getDorothy());
		draw(g, scene.getOz());
		draw(g, scene.getScarecrow());
		
	}
	
	public void draw(Graphics g, ImageClass background) {
		Image img = 
			Toolkit.getDefaultToolkit().getImage(scene.getBackground().getImageFileName());
		g.drawImage(img, background.getX(), background.getY(), this);
	}
	
	public void draw(Graphics g, Avatar avatar) {
		g.setColor(avatar.getColor());
		
		StringShape text = avatar.getText();
		g.drawString(text.getText(), text.getX(),text.getY());
		
		Image img =
			Toolkit.getDefaultToolkit().getImage(avatar.getHead().getImageFileName());
		g.drawImage(img, avatar.getHead().getX(), avatar.getHead().getY(), this);
		
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
