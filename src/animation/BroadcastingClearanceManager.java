package animation;

import util.annotations.ComponentWidth;
import util.annotations.Row;

public interface BroadcastingClearanceManager {

	@Row(0)
	@ComponentWidth(100)
	public void proceed();

	public void waitForProceed();

	public void proceedAll();

}