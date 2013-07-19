package animation;

import shapes.Avatar;

public class ScarecrowWaitingAnimator extends ScarecrowAnimator {

	public ScarecrowWaitingAnimator(
			BroadcastingClearanceManager clearanceManager) {
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
