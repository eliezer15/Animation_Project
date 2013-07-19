package commandObjects;

import util.annotations.DisplayToString;

@DisplayToString(true)
public class RepeatCommand implements Runnable{
	
	int count;
	Runnable command;
	
	public RepeatCommand(Runnable command, int count) {
		this.command = command;
		this.count = count;
		
	}
	
	public void run() {
		for (int i = 0; i < count; i++) {
			command.run();
		}
		
	}
	
	@Override
	public String toString() {
		return "Repeat " + count + " " + command.toString();
		
		
	}

}
