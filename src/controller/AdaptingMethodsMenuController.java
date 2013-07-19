package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import shapes.Scene;

public class AdaptingMethodsMenuController implements ActionListener, PropertyChangeListener {

	ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();
	Scene scene;

	public AdaptingMethodsMenuController(Scene scene) {
		this.scene = scene;
		
	}
	
	public void addMenuItem(JMenuItem item) {
		menuItems.add(item);
		int index = menuItems.indexOf(item);
		
		menuItems.get(index).addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		
		String menuOption = event.getActionCommand();
		
		if (menuOption.equalsIgnoreCase("Dorothy Leaves")) {
			scene.dorothyLeaves();
		}
	
		else if (menuOption.equalsIgnoreCase("Dorothy Enters")) {
			scene.dorothyEnters();
		}
		
		else if (menuOption.equalsIgnoreCase("Background Leaves")) {
			scene.backgroundLeaves();
		}
		
		else if (menuOption.equalsIgnoreCase("Background Enters")) {
			scene.backgroundEnters();
		}
		
		else if (menuOption.equalsIgnoreCase("Scarecrow Leaves")) {
			scene.scarecrowLeaves();
		}
		
		else if (menuOption.equalsIgnoreCase("Scarecrow Enters")) {
			scene.scarecrowEnters();
		}
		
		else if (menuOption.equalsIgnoreCase("Oz Leaves")) {
			scene.ozLeaves();
		}
		
		else if (menuOption.equalsIgnoreCase("Oz Enters")) {
			scene.ozEnters();
		}
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		/*
		 * JMenuItems will be in the order:
		 * 0-Background Leaves
		 * 1-Background Enters
		 * 2-Dorothy Leaves
		 * 3-Dorothy Enters
		 * 4-Oz Leaves
		 * 5-Oz Enters
		 * 6-Scarecrow Leaves
		 * 7-Scarecrow Enters
		 */
		if (evt.getPropertyName().equals("this")) {
			String shape = (String)evt.getOldValue();
			boolean enabled = ((boolean)evt.getNewValue());
			
			switch(shape) {
			case "background":
				menuItems.get(0).setEnabled(enabled);
				menuItems.get(1).setEnabled(!enabled);
				break;
				
			case "dorothy":
				menuItems.get(2).setEnabled(enabled);
				menuItems.get(3).setEnabled(!enabled);
				break;
				
			case "oz":
				menuItems.get(4).setEnabled(enabled);
				menuItems.get(5).setEnabled(!enabled);
				break;
				
			case "scarecrow":
				menuItems.get(6).setEnabled(enabled);
				menuItems.get(7).setEnabled(!enabled);
				break;			
				
			}
		}
		
	}

}
