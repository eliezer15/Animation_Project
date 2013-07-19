package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import commandInterpreter.CommandInterpreter;


public class AsynchronousAnimationButtonController implements ActionListener {

	ArrayList<JButton> buttons = new ArrayList<JButton>();
	CommandInterpreter interpreter;
	final int NUMBER_STEPS = 5;
	final int BEAT = 1500;
	
	public AsynchronousAnimationButtonController (CommandInterpreter interpreter) {
		
		this.interpreter = interpreter;
	}
	
	public void addButton(JButton button) {
		
		buttons.add(button);
		int index = buttons.indexOf(button);
		buttons.get(index).addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent event) {
		
		String button = event.getActionCommand();
		if (button.equalsIgnoreCase("Dorothy Dance")) {
			interpreter.concurrentDorothyDance(BEAT, NUMBER_STEPS);
			
		}
		
		else if (button.equalsIgnoreCase("Oz clap")) {
			interpreter.concurrentOzClap(BEAT, NUMBER_STEPS);

		}
		
		else if (button.equalsIgnoreCase("Scarecrow Dance")) {
			interpreter.concurrentScarecrowDance(BEAT, NUMBER_STEPS);

		}
		
		else if (button.equalsIgnoreCase("All Dance")) {
			interpreter.allAvatarsConcurrentDance(BEAT, NUMBER_STEPS);

		}

	}
		
}
