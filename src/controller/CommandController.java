package controller;
//This class is a view and a controller
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import commandInterpreter.Interpreter;

import toolkit.TextComponentInterface;


public class CommandController implements ActionListener, PropertyChangeListener {

	JFrame frame;
	TextComponentInterface commandField;
	Interpreter interpreter;
	
	public CommandController(Interpreter interpreter, TextComponentInterface textField, JFrame frame) {
		
		this.interpreter = interpreter;
		this.commandField = textField;
		this.frame = frame;
		this.commandField.addActionListener(this);
		
	}


	public void actionPerformed(ActionEvent event) {
		
		String text = commandField.getText();
		interpreter.setInput(text);
	}

	public void propertyChange(PropertyChangeEvent event) {
		String propertyName = event.getPropertyName();
		if (propertyName.equalsIgnoreCase("input")) {
			
			String errorValue = (String)event.getNewValue();
			commandField.setText(errorValue);	
		}
		
		frame.pack();
		
	}

}
