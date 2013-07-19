package animation;

import util.annotations.ComponentWidth;
import util.annotations.Row;
import util.annotations.StructurePattern;

@StructurePattern("Bean Pattern")
public class ABroadcastingClearanceManager implements BroadcastingClearanceManager {
	
	@Row(0)
	@ComponentWidth(100)
	public synchronized void proceed() {
		notify();
	}
	
	public synchronized void waitForProceed() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void proceedAll() {
		notifyAll();
	}
}


