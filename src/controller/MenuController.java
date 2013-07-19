package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import commandInterpreter.Interpreter;

public class MenuController implements ActionListener{

	ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();
	Interpreter interpreter;

	public MenuController(Interpreter interpreter) {
		this.interpreter = interpreter;
	}
	
	public void addMenuItem(JMenuItem item) {
		menuItems.add(item);
		int index = menuItems.indexOf(item);
		
		menuItems.get(index).addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		
		String menuOption = event.getActionCommand();
		if (menuOption.equalsIgnoreCase("move avatars x")) {
			
			interpreter.setInput("move oz 10 0");
			interpreter.setInput("move dorothy 10 0");
			interpreter.setInput("move scarecrow 10 0");		
		}
		
		else if (menuOption.equalsIgnoreCase("move avatars y")) {
			
			interpreter.setInput("move oz 0 10");
			interpreter.setInput("move dorothy 0 10");
			interpreter.setInput("move scarecrow 0 10");
		}
		
	}
	

}
