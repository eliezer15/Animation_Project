package animation;

public abstract class Animator {

	BroadcastingClearanceManager clearanceManager;
	
	public Animator(BroadcastingClearanceManager manager) {
		this.clearanceManager = manager;
		
	}
}
