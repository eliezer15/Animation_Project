package controller;

/*The button directly animates the Oz Scene instead
 * of working through the command
 * In addition, the button will have an observable property time
 * that will let the progress bar know how much time an animation 
 * has remaining
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import shapes.Scene;
import util.misc.ThreadSupport;


public class ButtonController implements ActionListener {

	ArrayList<JButton> buttons = new ArrayList<JButton>();
	Scene scene;
	
	public ButtonController (Scene scene) {
		
		this.scene = scene;
	}
	
	public void addButton(JButton button) {
		
		buttons.add(button);
		int index = buttons.indexOf(button);
		
		buttons.get(index).addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent event) {
		
		String button = event.getActionCommand();
		if (button.equalsIgnoreCase("Animation 1")) {
			
			//Dance sequence
			scene.getDorothy().setText("We're up to see the wizard");
			scene.getOz().setText("We're up to see the wizard");
			scene.getScarecrow().setText("We're up to see the wizard");
			
			scene.getDorothy().rotateArms(15);
			scene.getOz().rotateArms(15);
			scene.getScarecrow().rotateArms(15);
			ThreadSupport.sleep(500);
			
			
			scene.getDorothy().rotateArms(-15);
			scene.getOz().rotateArms(-15);
			scene.getScarecrow().rotateArms(-15);
			ThreadSupport.sleep(500);
			
			
			scene.getDorothy().rotateArms(25);
			scene.getOz().rotateArms(25);
			scene.getScarecrow().rotateArms(25);
			
			scene.getDorothy().rotateLegs(20);
			scene.getOz().rotateLegs(20);
			scene.getScarecrow().rotateLegs(20);
			ThreadSupport.sleep(500);
			
			
			scene.getDorothy().rotateArms(-25);
			scene.getOz().rotateArms(-25);
			scene.getScarecrow().rotateArms(-25);
			
			scene.getDorothy().rotateLegs(-20);
			scene.getOz().rotateLegs(-20);
			scene.getScarecrow().rotateLegs(-20);
			ThreadSupport.sleep(500);
			
	
		}
		
		else if (button.equalsIgnoreCase("Animation 2")) {
			
			//Scarecrow flexes
			scene.getDorothy().setText("");
			scene.getOz().setText("");
			scene.getScarecrow().setText("Look how strong I am");
			scene.getScarecrow().rotateArms(25);
			scene.getScarecrow().rotateElbows(32);
			ThreadSupport.sleep(700);
			
			scene.getScarecrow().rotateElbows(9);
			ThreadSupport.sleep(500);
			
			scene.getScarecrow().rotateElbows(-9);
			ThreadSupport.sleep(500);
			
			scene.getScarecrow().rotateElbows(9);
			ThreadSupport.sleep(500);
			
			scene.getScarecrow().rotateElbows(-9);
			ThreadSupport.sleep(500);
			
			scene.getScarecrow().rotateArms(-25);
			scene.getScarecrow().rotateElbows(-32);
			ThreadSupport.sleep(500);

		}
		
	}

}
