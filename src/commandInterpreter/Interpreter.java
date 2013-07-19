package commandInterpreter;

public interface Interpreter {

	public String getInput();
	public void setInput(String command);
	public void setErrorMessage(String message);
	public String getErrorMessage();
	
}
