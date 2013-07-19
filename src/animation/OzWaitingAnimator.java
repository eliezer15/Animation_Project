package animation;

import shapes.Avatar;

public class OzWaitingAnimator extends OzAnimator {

	public OzWaitingAnimator(BroadcastingClearanceManager clearanceManager) {
		super(clearanceManager);
	}

	@Override
	public synchronized void clap(Avatar avatar, int beat, int claps) {
		
		clearanceManager.waitForProceed();
		super.clap(avatar, beat, claps);
				
	}	
	
	@Override
	public String toString() {
		return "Waiting " + super.toString();
	}

}
