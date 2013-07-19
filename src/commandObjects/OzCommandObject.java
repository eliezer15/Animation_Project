package commandObjects;

import animation.OzAnimator;
import shapes.Avatar;
import util.annotations.DisplayToString;

@DisplayToString(true)
public class OzCommandObject implements Runnable{

	OzAnimator animator;
	Avatar oz;
	int beat;
	int claps;
	
	public OzCommandObject(OzAnimator animator, Avatar avatar, int sleepTime, int claps) {
		this.animator = animator;
		this.oz = avatar;
		this.beat = sleepTime;
		this.claps = claps;
	}
	
	public void run() {
		animator.clap(oz, beat, claps);
		
	}

	@Override
	public String toString() {
		return "Oz clap " + "beat:" + beat + " claps:" + claps;
	}
	
	
}
