package animation;

import shapes.Avatar;
import util.misc.ThreadSupport;

public class DorothyAnimator extends Animator {
	
	public DorothyAnimator(BroadcastingClearanceManager clearanceManager) {
		super(clearanceManager);
	}
	
	public synchronized void danceToBeat(Avatar avatar, int beat, int steps) {
		
		for (int i=1; i <= steps; i++) {
			
			avatar.setText(Integer.toString(i));			
			avatar.rotateArms(25);
			avatar.rotateLegs(20);
			ThreadSupport.sleep(beat/2);
			
			avatar.rotateArms(-25);
			avatar.rotateLegs(-20);
			ThreadSupport.sleep(beat/2);
		}		
		
		avatar.setText("");
	}
}
