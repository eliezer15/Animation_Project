package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import toolkit.TextComponentInterface;

public class ErrorView implements PropertyChangeListener {

	TextComponentInterface error;
	JFrame frame;
	
	public ErrorView(TextComponentInterface errorField, JFrame frame) {
		error = errorField;
		this.frame = frame;
	}
	
	public void propertyChange(PropertyChangeEvent event) {
		String propertyName = event.getPropertyName();
		if (propertyName.equalsIgnoreCase("errorMessage")) {
			
			String errorValue = (String)event.getNewValue();
			error.setText(errorValue);	
		}
		
		frame.pack();		
	}
}
