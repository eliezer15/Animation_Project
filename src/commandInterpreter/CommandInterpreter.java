package commandInterpreter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import animation.BroadcastingClearanceManager;
import animation.DorothyAnimator;
import animation.DorothyWaitingAnimator;
import animation.OzAnimator;
import animation.OzWaitingAnimator;
import animation.ScarecrowAnimator;
import animation.ScarecrowWaitingAnimator;

import listenerSupport.ListenerSupport;


import collection.TableClass;
import scanner.Scanner;
import shapes.Scene;
import commandObjects.CommandList;
import commandObjects.DorothyCommandObject;
import commandObjects.MoveCommand;
import commandObjects.OzCommandObject;
import commandObjects.RepeatCommand;
import commandObjects.SayCommand;
import commandObjects.ScarecrowCommandObject;
import commands.Move;
import commands.Say;
import commands.Repeat;
import shapes.Avatar;
import tokens.Minus;
import tokens.Plus;
import tokens.Number;
import tokens.Quote;
import tokens.Token;
import tokens.Start;
import tokens.End;
import tokens.Word;

import util.annotations.ObserverRegisterer;
import util.annotations.ObserverTypes;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class CommandInterpreter implements Interpreter{
	
	DorothyAnimator dorothyAnimator;
	DorothyAnimator dorothyWaitingAnimator;
	OzAnimator ozAnimator;
	OzAnimator ozWaitingAnimator;
	ScarecrowAnimator scarecrowAnimator;
	ScarecrowAnimator scarecrowWaitingAnimator;
	CommandList commandList;
	String input;
	Scanner scanner;
	Scene scene;
	TableClass table;
	String errorMessage;
	ListenerSupport listenerSupport;
	int nextIndex;
	Token[] tokens;
	BroadcastingClearanceManager clearanceManager;
	
	
	public CommandInterpreter(Scene theScene, Scanner theScanner, CommandList commandList, BroadcastingClearanceManager clearanceManager) {
		
		
		input = "";
		table = new TableClass();
		scanner = theScanner;
		scene = theScene;
		this.commandList = commandList;
		
		//Animators
		this.clearanceManager = clearanceManager;
		dorothyAnimator = new DorothyAnimator(clearanceManager);
		dorothyWaitingAnimator = new DorothyWaitingAnimator(clearanceManager);
		ozAnimator = new OzAnimator(clearanceManager);
		ozWaitingAnimator = new OzWaitingAnimator(clearanceManager);
		scarecrowAnimator = new ScarecrowAnimator(clearanceManager);
		scarecrowWaitingAnimator = new ScarecrowWaitingAnimator(clearanceManager);
		
		//initialize table
		table.put("oz",scene.getOz());
		table.put("dorothy",scene.getDorothy());
		table.put("scarecrow",scene.getScarecrow());
		
		//initialize listener
		listenerSupport = new ListenerSupport();
	}	
	
	@ObserverRegisterer(ObserverTypes.PROPERTY_LISTENER)
	public void addPropertyChangeListener(PropertyChangeListener listener) {	
		listenerSupport.addElement(listener);
	}
	
	public String getInput() {
		return input;
		
	}
	
	public void setInput(String in) {

		String oldInput = input;
		input = in;
		setErrorMessage("");
		
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this,"input", oldInput, input));
		}
		
		scanner.setInput(input);
		tokens = scanner.getTokens();
		
		if (tokens.length < 3) {	
			setErrorMessage("Error: Not enough parameters found");
			return;	
		}

		nextIndex = 0;
		try {
			Runnable command = parseCommand();
			command.run();
			commandList.addElement(command);
		} catch (NullPointerException e) { }

		
	}
	
	Runnable parseCommand() {
		
		Token nextToken;
		
		Runnable command = null;
		while (nextIndex < tokens.length) {
			nextToken = tokens[nextIndex];
			
			if (nextToken instanceof Move) {
				updateIndex();
				command =  parseMove();
				break;
			}
			
			else if (nextToken instanceof Say) {
				updateIndex();
				command = parseSay ();
				break;
			}
			
			else if (nextToken instanceof Repeat) {
				updateIndex();
				command = parseRepeat();
				break;
			}
			
			else if (nextToken instanceof Start) {
				updateIndex();
				command = parseList();
				break;
				
			}
			
			else {
				setErrorMessage("Error: Invalid command found");
				break;
			}	
		}
		return command;
	}
	
	Runnable parseMove() {
		
		Runnable command = null;
		try {
			String character = parseCharacter();
			int x = parseNumber();
			int y = parseNumber();
			command = new MoveCommand((Avatar)table.get(character), x,y);	
			
		} catch (ArrayIndexOutOfBoundsException e) {
			updateIndex();
			setErrorMessage("Error: Not enough parameters for Move command");

		}
		
		return command;
	}
	
	Runnable parseSay() {
	
		Runnable command = null;
		try {
			String character = parseCharacter();
			String text = parseQuote();
		    command = new SayCommand((Avatar)table.get(character), text);
		}
		
		catch (ArrayIndexOutOfBoundsException e) {
			updateIndex();
			setErrorMessage("Error: Not enough parameters for Say command");
		}
		
		return command;
		
	}
	
	Runnable parseRepeat() {
		int count = parseNumber();
		Runnable command = parseCommand();
		
		return new RepeatCommand(command, count);
		
	}
	
	Runnable parseList() {
		
		Runnable list = new CommandList();
		while (!(tokens[nextIndex] instanceof End)) {
			 ((CommandList)list).addElement(parseCommand());
		}
		
		return list;
		
	}
	String parseCharacter() {
		
		String character = ((Word)tokens[nextIndex]).getLowerCase();
			
		if (!(character.equalsIgnoreCase("dorothy") || character.equalsIgnoreCase("oz") || character.equalsIgnoreCase("scarecrow"))) {
			setErrorMessage("Error: Character must be 'oz', 'dorothy', or 'scarecrow'");
			updateIndex();
			return null;		
		}
		
		else {
			updateIndex();
			return character;
		}
	}
	
	int parseNumber() {
		
		int number;
			if (tokens[nextIndex] instanceof Minus) 
				number = -((Number)scanner.getTokens()[nextIndex + 1]).getNumber();
		
			else if (tokens[nextIndex] instanceof Plus) 
				number = ((Number)scanner.getTokens()[nextIndex + 1]).getNumber();	
		
			else if (tokens[nextIndex] instanceof Number)
				number = ((Number)scanner.getTokens()[nextIndex]).getNumber();
		
			else {
				setErrorMessage("Error: Expected number parameter for Move command");
				number = (Integer) null;
			}
		updateIndex();
		return number;
		
	}
	
	String parseQuote() {
		
		String quote = null;
		if (tokens[nextIndex] instanceof Quote) {
			quote = tokens[nextIndex].getToken();
			updateIndex();
		}
		else {
			updateIndex();
			setErrorMessage("Error: No quote found for Say command");
		}
		
		return quote;
	}
		
	public void setErrorMessage(String message) {
		String oldErrorMessage = errorMessage;
		errorMessage = message;
		
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this,"errorMessage",oldErrorMessage, errorMessage));
		}
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public CommandList getCommandList() {
		return commandList;
	}
	
	//Animation methods	
	public void  concurrentDorothyDance(int beat, int steps) {
		assert scene.preGetDorothy();
		DorothyCommandObject dorothy = new DorothyCommandObject(dorothyAnimator, scene.getDorothy(), beat, steps);
		Thread thread = new Thread(dorothy);
		commandList.addElement(dorothy);
		thread.start();
	}
		
	public void concurrentOzClap(int beat, int claps) {
		assert scene.preGetOz();
		OzCommandObject oz = new OzCommandObject(ozAnimator, scene.getOz(),beat, claps);
		Thread thread = new Thread(oz);
		commandList.addElement(oz);
		thread.start();
	}
	
	public void concurrentScarecrowDance(int beat, int steps) {
		assert scene.preGetScarecrow();
		ScarecrowCommandObject scarecrow = new ScarecrowCommandObject(scarecrowAnimator, scene.getScarecrow(),beat, steps);
		Thread thread = new Thread(scarecrow);
		commandList.addElement(scarecrow);
		thread.start();
	}
	
	public void allAvatarsConcurrentDance(int beat, int steps) {
		assert scene.preGetScarecrow();
		assert scene.preGetOz();
		assert scene.preGetDorothy();
		
		concurrentOzClap(beat, steps);
		concurrentScarecrowDance(beat, steps);
		concurrentDorothyDance(beat, steps);
		
	}
	
	public void  waitingDorothyDance(int beat, int steps) {
		assert scene.preGetDorothy();
		
		DorothyCommandObject dorothy = new DorothyCommandObject(dorothyWaitingAnimator, scene.getDorothy(), beat, steps);
		Thread thread = new Thread(dorothy);
		commandList.addElement(dorothy);
		thread.start();
	}
		
	public void waitingOzClap(int beat, int claps) {
		assert scene.preGetOz();
		
		OzCommandObject oz = new OzCommandObject(ozWaitingAnimator, scene.getOz(),beat, claps);
		Thread thread = new Thread(oz);
		commandList.addElement(oz);
		thread.start();
	}
	
	public void waitingScarecrowDance(int beat, int steps) {
		assert scene.preGetScarecrow();
		
		ScarecrowCommandObject scarecrow = new ScarecrowCommandObject(scarecrowWaitingAnimator, scene.getScarecrow(),beat, steps);
		Thread thread = new Thread(scarecrow);
		commandList.addElement(scarecrow);
		thread.start();
	}
	
	public void animateAll() {
		clearanceManager.proceedAll();
	}
	
	public void updateIndex() {
		this.nextIndex++;
	}
	@Override
	public String toString() {
		return "CommandInterpreter input=" + input;
	}	
}
