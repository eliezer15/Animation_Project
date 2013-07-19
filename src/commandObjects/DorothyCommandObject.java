package commandObjects;

import animation.DorothyAnimator;
import shapes.Avatar;
import util.annotations.DisplayToString;

@DisplayToString(true)
public class DorothyCommandObject implements Runnable{

	DorothyAnimator animator;
	Avatar dorothy;
	int beat;
	int steps;
	
	public DorothyCommandObject(DorothyAnimator animator, Avatar avatar, int sleepTime, int steps) {
		this.animator = animator;
		this.dorothy = avatar;
		this.beat = sleepTime;
		this.steps = steps;
	}
	
	public void run() {
		animator.danceToBeat(dorothy, beat, steps);
		
	}

	@Override
	public String toString() {
		return "Dorothy dance " + "beat:" + beat + " steps:" + steps;
	}
	
	
}
