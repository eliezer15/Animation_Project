package main;
import java.awt.GridLayout;
import java.beans.PropertyChangeListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import commandInterpreter.CommandInterpreter;
import commandObjects.CommandList;
import controller.AdaptingMethodsMenuController;
import controller.AsynchronousAnimationButtonController;
import controller.CommandController;
import controller.MenuController;

import scanner.Scanner;
import shapes.Scene;
import toolkit.ATextField;
import view.ErrorView;
import view.OzSceneView;
import animation.ABroadcastingClearanceManager;
import animation.BroadcastingClearanceManager;
import bus.uigen.ObjectEditor;

public class Assignment11 {
	
	//Oz View components
	static JFrame frame= new JFrame ("Oz");
	static JMenuBar menuBar = new JMenuBar();
	static JMenu menu = new JMenu("Menu");
	
	static JMenuItem backgroundLeaves =  new JMenuItem("Background Leaves");
	static JMenuItem backgroundEnters =  new JMenuItem("Background Enters");
	static JMenuItem dorothyLeaves =  new JMenuItem("Dorothy Leaves");
	static JMenuItem dorothyEnters =  new JMenuItem("Dorothy Enters");
	static JMenuItem ozLeaves =  new JMenuItem("Oz Leaves");
	static JMenuItem ozEnters =  new JMenuItem("Oz Enters");
	static JMenuItem scarecrowLeaves =  new JMenuItem("Scarecrow Leaves");
	static JMenuItem scarecrowEnters =  new JMenuItem("Scarecrow Enters");
	
	//Command interpreter components
	static JFrame commandFrame = new JFrame("Command Interpreter");
	
	static JPanel commandInputPanel = new JPanel();
	static JLabel commandInputLabel = new JLabel("Input:");
	static ATextField commandInput = new ATextField();
	
	static JPanel commandErrorPanel = new JPanel();
	static JLabel commandErrorLabel = new JLabel("Error:");
	static ATextField commandError = new ATextField();
	
	static JPanel commandButtonPanel = new JPanel();
	static JButton animationButton1 = new JButton("All Dance");
	static JButton animationButton2 = new JButton("Dorothy Dance");
	static JButton animationButton3 = new JButton("Scarecrow Dance");
	static JButton animationButton4 = new JButton("Oz Clap");
	
	
	static JMenuBar commandMenuBar = new JMenuBar();
	static JMenu commandMenu = new JMenu("Menu");
	static JMenuItem commandMoveX = new JMenuItem("Move Avatars X");
	static JMenuItem commandMoveY = new JMenuItem("Move Avatars Y");
	
	static CommandList commandList = new CommandList();
	static Scene scene = new Scene();
	static Scanner scanner = new Scanner();
	static BroadcastingClearanceManager clearanceManager = new ABroadcastingClearanceManager();
	static CommandInterpreter command = new CommandInterpreter(scene, scanner, commandList, clearanceManager);
	
	public static void main(String[] args) {
		
//		buildOzView();
//		buildCommandInterface();
//		buildMVC();
		
		ObjectEditor.edit(scene);
		ObjectEditor.edit(clearanceManager);
		ObjectEditor.edit(command);
		
		clearanceManager.waitForProceed();
		command.setInput("move Dorothy 5 4");
		clearanceManager.waitForProceed();
		command.setInput("say Oz \"one\"");
		clearanceManager.waitForProceed();
		command.setInput("{move Scarecrow 5 4 say Oz \"two\" say Dorothy \"Hello\"}");
		clearanceManager.waitForProceed();
		command.setInput("repeat 5 move Dorothy 2 3");
		clearanceManager.waitForProceed();
		command.setInput("repeat 5 {move Scarecrow 2 3 say Oz \"three\"}");
		clearanceManager.waitForProceed();
		command.setInput("repeat 4 repeat 5 {move Dorothy 2 3 say Oz \"four\"}");
		clearanceManager.waitForProceed();
	}
	
	public static void buildCommandInterface() {
		
		commandFrame.setLayout(new GridLayout(4,1));
		
		commandInputPanel.setLayout(new GridLayout(1,2));
		commandInputPanel.add(commandInputLabel);
		commandInputPanel.add(commandInput);
		
		commandErrorPanel.setLayout(new GridLayout(1,2));
		commandErrorPanel.add(commandErrorLabel);
		commandErrorPanel.add(commandError);
		
		commandButtonPanel.setLayout(new GridLayout(2,2));
		commandButtonPanel.add(animationButton1);
		commandButtonPanel.add(animationButton2);
		commandButtonPanel.add(animationButton3);
		commandButtonPanel.add(animationButton4);
		
		commandMenu.add(commandMoveX);
		commandMenu.add(commandMoveY);
		commandMenuBar.add(commandMenu);
		
		commandFrame.setJMenuBar(commandMenuBar);
		commandFrame.add(commandInputPanel);
		commandFrame.add(commandErrorPanel);
		commandFrame.add(commandButtonPanel);
		commandFrame.setSize(300, 250);
		commandFrame.setResizable(false);
		commandFrame.setVisible(true);
			
	}
	
	public static void buildOzView() {

		OzSceneView view = new OzSceneView(scene);
		AdaptingMethodsMenuController menuController = new AdaptingMethodsMenuController(scene);
		
		frame.add(view);
		
		menu.add(backgroundLeaves);
		menu.add(backgroundEnters);
		menu.add(dorothyLeaves);
		menu.add(dorothyEnters);
		menu.add(ozLeaves);
		menu.add(ozEnters);
		menu.add(scarecrowLeaves);
		menu.add(scarecrowEnters);
		
		menuController.addMenuItem(backgroundLeaves);
		menuController.addMenuItem(backgroundEnters);
		menuController.addMenuItem(dorothyLeaves);
		menuController.addMenuItem(dorothyEnters);
		menuController.addMenuItem(ozLeaves);
		menuController.addMenuItem(ozEnters);
		menuController.addMenuItem(scarecrowLeaves);
		menuController.addMenuItem(scarecrowEnters);
		
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		frame.setSize(400,400);
		frame.setVisible(true);
		
		scene.addPropertyChangeListener(view);
		scene.addPropertyChangeListener(menuController);
		
	}
	
	public static void buildMVC() {
		//Command interface controllers
		@SuppressWarnings("unused")
		CommandController commandController = new CommandController(command, commandInput, commandFrame);
		MenuController menuController = new MenuController(command);
		menuController.addMenuItem(commandMoveX);
		menuController.addMenuItem(commandMoveY);
		
		AsynchronousAnimationButtonController animationController = new AsynchronousAnimationButtonController(command);
		animationController.addButton(animationButton1);
		animationController.addButton(animationButton2);
		animationController.addButton(animationButton3);
		animationController.addButton(animationButton4);
		
		//Command interface views
		PropertyChangeListener errorView = new ErrorView(commandError, commandFrame);
		command.addPropertyChangeListener(errorView);
		
	}
}

	