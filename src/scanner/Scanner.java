package scanner;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

import listenerSupport.ListenerSupport;


import commands.*;
import commands.Thread;
import tokens.*;
import tokens.Number;
import util.annotations.ObserverRegisterer;
import util.annotations.ObserverTypes;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class Scanner {
	
	String input;
	Token[] tokens;
	String[] errors; 
	ListenerSupport listenerSupport;
	
	public Scanner() {
		this.input = "";
		listenerSupport = new ListenerSupport();
	}
	
	@ObserverRegisterer(ObserverTypes.PROPERTY_LISTENER)
	public void addPropertyChangeListener(PropertyChangeListener listener) {	
		listenerSupport.addElement(listener);
	}
	
	public String getInput() {
		return input;
	} 
	public void setInput(String newInput) {
		
		String oldInput = this.input;
		
    	//temporary arrays
    	Token[] tempTokens = new Token[30]; //max 30 tokens
		String[] tempErrors = new String[10]; //max 10 errors
    	input = " " + newInput + " "; //cushion the input with opening and closing spaces to avoid out of bound errors
		
		String token;
     	int stringIndex = 0;
		int arrayIndex = 0;
		int errorIndex = 0;
		
		for (int i=1; i < input.length(); i++) {
			
			if (Character.isLetter(input.charAt(i))) {
				if (!Character.isLetter(input.charAt(i-1))) 
					stringIndex = i; 
								
				if (!Character.isLetter(input.charAt(i+1))){
				
					token = input.substring(stringIndex, i+1);
					this.instanciateCommand(token, tempTokens, arrayIndex);
					arrayIndex++;		
				}
			}	
			
			if (isNumber(input.charAt(i))) {
				
				if (!isNumber(input.charAt(i-1))) 
					stringIndex = i; 
								
				if (!isNumber(input.charAt(i+1))){
					token = input.substring(stringIndex, i+1);
					tempTokens[arrayIndex] = new Number(token);
					arrayIndex++;
				}
			}
			
			if (isPlus(input.charAt(i))) {
				token = input.substring(i, i+1);
				tempTokens[arrayIndex] = new Plus(token);
				arrayIndex++;
			}
			
			if (isMinus(input.charAt(i))) {
				token = input.substring(i, i+1);
				tempTokens[arrayIndex] = new Minus(token);
				arrayIndex++;
			}
			
			if (isStart(input.charAt(i))) {
				token = input.substring(i, i+1);
				tempTokens[arrayIndex] = new Start(token);
				arrayIndex++;
			}
			
			if (isEnd(input.charAt(i))) {
				token = input.substring(i, i+1);
				tempTokens[arrayIndex] = new End(token);
				arrayIndex++;
			}
			
			if (isIllegalCharacter(input.charAt(i))) {
				tempErrors[errorIndex] = input.substring(i,i+1);
				errorIndex++;
			}
			
			if ((input.charAt(i)) == '"') {	
				stringIndex = i+1;
				int index = i+1;
				while(index < input.length()) {
					
					if (input.charAt(index)=='"') {
						token = input.substring(stringIndex-1, index+1);
						tempTokens[arrayIndex] = new Quote(token);
						arrayIndex++;
						i = index;
						break;
					}
					
					if (index == input.length()-1) {
						tempErrors[errorIndex] = "Missing closing quote";
						errorIndex++;
						break;	
					}//end else
					index++;		
					
				}//end while	
				
			}//	end if	
						
		}//end for	
		
		//Send notification
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "input", oldInput, this.input));
		}
		
		setErrors(tempErrors);
		setTokens(tempTokens);
	}
    
    void setTokens(Token[] array){
    	
    	Token[] oldTokens = tokens;
    	
    	Token value = array[0];
    	int i = 0;
    	int arraySize = 0;
    	
    	while(value!=null) {
    		arraySize++;
    		i++;
    		value = array[i];
    	}
    	
    	tokens = new Token[arraySize];
    	value = array[0];
    	i = 0;
    	
    	while(value!=null){
    		tokens[i] = value;
    		i++;
    		value = array[i];
    	}
    	
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "tokens", oldTokens, tokens));
		}
    }
    public Token[] getTokens(){
    	return tokens;
    }
   
    void setErrors(String[] array) {
    	
    	String[] oldErrors = errors;
    	String value = array[0];
    	int i = 0;
    	int arraySize = 0;
    	
    	while(value!=null) {
    		arraySize++;
    		i++;
    		value = array[i];
    	}
    	
    	errors = new String[arraySize];
    	value = array[0];
    	i = 0;
    	
    	while(value!=null){
    		errors[i] = value;
    		i++;
    		value = array[i];
    	}
    	
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "errors", oldErrors, errors));
		}
    	
    }
    public String[] getErrors() {
    	return errors;
    } 

    void instanciateCommand(String parameter, Token[] temp, int arrayIndex) {
    	if (parameter.equalsIgnoreCase("move")){
    		temp[arrayIndex] = new Move(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("say")){
    		temp[arrayIndex] = new Say(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("rotateleftarm")){
    		temp[arrayIndex] = new RotateLeftArm(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("rotaterightarm")){
    		temp[arrayIndex] = new RotateRightArm(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("repeat")){
    		temp[arrayIndex] = new Repeat(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("define")){
    		temp[arrayIndex] = new Define(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("call")){
    		temp[arrayIndex] = new Call(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("thread")){
    		temp[arrayIndex] = new Thread(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("wait")){
    		temp[arrayIndex] = new Wait(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("proceedall")){
    		temp[arrayIndex] = new ProceedAll(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("sleep")){
    		temp[arrayIndex] = new Sleep(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("undo")){
    		temp[arrayIndex] = new Undo(parameter);
    		return;
    	}
    	
    	if (parameter.equalsIgnoreCase("redo")){
    		temp[arrayIndex] = new Redo(parameter);
    		return;
    	}
    	
    	//default case
    	temp[arrayIndex] = new Word(parameter);
    }
    
    boolean isEnd(char c) {
		if (c=='}')
			return true;
		else
			return false;
	}
	boolean isStart(char c) {
		if (c=='{')
			return true;
		else
			return false;
	}
	boolean isPlus(char c) {
		
		if (c == '+')
			return true;
		else
			return false;
	}	
	boolean isMinus(char c) {
		
		if (c == '-')
			return true;
		else
			return false;
	}
	boolean isSpace(char c) {
		if ( c == ' ')
			return true;
		else
			return false;
	}
	boolean isNumber(char c) {	
		try {
			
			Integer.parseInt(String.valueOf(c));
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
	boolean isIllegalCharacter(char c) {
		
		if ((Character.isLetter(c)) || isNumber(c) || isSpace(c) || isMinus(c) || isPlus(c) || c == '"' || isStart(c) || isEnd(c))
			return false;
		else
			return true;
	}
	
	@Override	
	public String toString() {
		return "Scanner input=" + input + "\n" + "tokens="
				+ Arrays.toString(tokens);
	}

	
}
	


