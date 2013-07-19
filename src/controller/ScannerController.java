package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import scanner.Scanner;

public class ScannerController implements ActionListener{
	
	JTextField scannerField;
	Scanner scanner;
	
	public ScannerController(Scanner scanner, JTextField textField) {
		
		this.scanner = scanner;
		this.scannerField = textField;
		this.scannerField.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		
		String text = scannerField.getText();
		scanner.setInput(text);
	}


}
