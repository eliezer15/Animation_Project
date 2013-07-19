package commandObjects;

import shapes.Avatar;
import util.annotations.DisplayToString;
import animation.ScarecrowAnimator;

@DisplayToString(true)
public class ScarecrowCommandObject implements Runnable {
	
	ScarecrowAnimator animator;
	Avatar scarecrow;
	int beat;
	int steps;
	
	public ScarecrowCommandObject(ScarecrowAnimator animator, Avatar avatar, int beat, int steps) {
		this.animator = animator;
		this.scarecrow = avatar;
		this.beat = beat;
		this.steps = steps;
		
	}
	
	public void run() {
		animator.danceToBeat(scarecrow, beat, steps);
		
	}
	
	@Override
	public String toString() {
		return "Scarecrow dance " + "beat:" + beat + " steps:" + steps;
	}
	
	

}
