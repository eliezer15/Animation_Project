package view;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tokens.Token;

public class ScannerView implements PropertyChangeListener{

	JTextField inputField;
	JPanel errorPanel;
	JPanel tokenPanel;
	JFrame scannerFrame;
	
	public ScannerView(JPanel tokenPanel, JPanel errorPanel, JTextField inputField, JFrame scannerFrame ) {
		this.errorPanel = errorPanel;	
		this.tokenPanel = tokenPanel;	
		this.inputField = inputField;
		this.scannerFrame = scannerFrame;
	}	
	
	public void propertyChange(PropertyChangeEvent event) {
		
		String propertyName = event.getPropertyName();
		
		if (propertyName.equalsIgnoreCase("errors")) {
			
			String[] errors = (String[])event.getNewValue();
			displayArrayValues(errors, errorPanel);
		}
		
		else if (propertyName.equalsIgnoreCase("tokens")) {
			
			Token[] tokens = (Token[])event.getNewValue();
			displayArrayValues(tokens, tokenPanel);
		}
		
		else if (propertyName.equalsIgnoreCase("input")) {
			inputField.setText(((String)event.getNewValue()).trim());
		}
		
		scannerFrame.pack();
	}
	
	void displayArrayValues(Object[] array, JPanel panel) {
		
		Component[] panelComponents = panel.getComponents();
		for (int i = 0; i < panelComponents.length; i++) {
			
			panel.remove(panelComponents[i]);
		}
		
		//Dynamically add text boxes depending on the array size
		
		if (array.length > 0 && array[0] instanceof String) {	
			for(int i = 0; i < array.length; i++) 
				panel.add(new JTextField((String)array[i]));	
		}
		
		else {
			
			for(int i = 0; i < array.length; i++) 
				panel.add(new JTextField(((Token)array[i]).getToken()));
		}
	}
	
}
