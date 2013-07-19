package commandObjects;

import shapes.Avatar;
import util.annotations.DisplayToString;

@DisplayToString(true)
public class MoveCommand implements Runnable {

	Avatar avatar;
	int x;
	int y;
	
	public MoveCommand(Avatar avatar, int x, int y) {
		this.avatar = avatar;
		this.x = x;
		this.y = y;
		
	}
	@Override
	public void run() {
		avatar.moveUnits(x, y);
		
	}
	@Override
	public String toString() {
		String avatarName = "";
		
		if ((avatar.getHead().getImageFileName().contains("dorothy")))
				avatarName = "dorothy";
		else if ((avatar.getHead().getImageFileName().contains("oz")))
			avatarName = "oz";
		else if ((avatar.getHead().getImageFileName().contains("crow")))
			avatarName = "scarecrow";
		
		return "Move " + avatarName + " " +  x + " " + y;
	}
	
	

}
