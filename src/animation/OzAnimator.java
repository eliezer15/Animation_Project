package animation;

import shapes.Avatar;
import util.misc.ThreadSupport;

public class OzAnimator extends Animator {
	
	public OzAnimator(BroadcastingClearanceManager clearanceManager) {
		super(clearanceManager);
	}
	
	public synchronized void clap(Avatar avatar, int beat, int claps) {
		
		avatar.setText(Integer.toString(1));
		avatar.rotateArms(50);
		avatar.rotateElbows(35);
		ThreadSupport.sleep(beat/2);
		
		for (int i=1; i < claps; i++) {
			avatar.rotateArms(-30);
			avatar.rotateElbows(-10);
			ThreadSupport.sleep(beat/2);
			
			avatar.rotateArms(30);
			avatar.rotateElbows(10);
			avatar.setText(Integer.toString(i+1));
			ThreadSupport.sleep(beat/2);

		}
		
		avatar.rotateArms(-50);
		avatar.rotateElbows(-35);
		avatar.setText("");
				
	}

}
