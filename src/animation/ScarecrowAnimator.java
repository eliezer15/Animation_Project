package animation;

import shapes.Avatar;
import util.misc.ThreadSupport;

public class ScarecrowAnimator extends Animator {
	
	public ScarecrowAnimator(BroadcastingClearanceManager clearanceManager) {
		super(clearanceManager);
	}
	
	
	public synchronized void danceToBeat(Avatar avatar, int beat, int steps) {
		
		avatar.setText("1");
		avatar.turnArms(16);
		avatar.rotateElbows(-3);
		avatar.turnLegs(-16);
		avatar.rotateCalfs(-3);
		ThreadSupport.sleep(beat/2);
		
		for (int i = 2; i <= steps; i ++) {
		
			avatar.turnArms(-32);
			avatar.turnLegs(32);
			ThreadSupport.sleep(beat/2);
			
			avatar.setText(Integer.toString(i));
			avatar.turnArms(32);
			avatar.turnLegs(-32);
			ThreadSupport.sleep(beat/2);

		}
			
			avatar.turnArms(-16);
			avatar.turnLegs(16);
			avatar.rotateElbows(3);
			avatar.rotateCalfs(3);
			avatar.setText("");
			
		
				
	}


}