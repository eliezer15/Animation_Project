package commandObjects;
import java.util.ArrayList;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)
public class CommandList implements CommandListInterface, Runnable {

	ArrayList<Runnable> commandList;
	
	public CommandList() {
		commandList = new ArrayList<Runnable>();
	}
	
	public void run() {
		for (Runnable r: commandList) {
			r.run();
		}
	}
	public void addElement(Runnable r) {
		if (r != null)
			commandList.add(r);
	}
	
	public Runnable elementAt(int index) {
		return commandList.get(index);
	}
	
	public int size() {
		return commandList.size();
		
	}
	

}
