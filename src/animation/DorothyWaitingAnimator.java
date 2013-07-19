package animation;

import shapes.Avatar;

public class DorothyWaitingAnimator extends DorothyAnimator {

	public DorothyWaitingAnimator(BroadcastingClearanceManager clearanceManager) {
		super(clearanceManager);
	}

	@Override
	public synchronized void danceToBeat(Avatar avatar, int beat, int steps) {
		
		clearanceManager.waitForProceed();
		super.danceToBeat(avatar, beat, steps);
	}

	@Override
	public String toString() {
		return "Waiting " + super.toString();
	}
	
	

}
