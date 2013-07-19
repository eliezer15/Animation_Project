 package commandObjects;

import shapes.Avatar;
import util.annotations.DisplayToString;

@DisplayToString(true)
public class SayCommand implements Runnable {

	Avatar avatar;
	String text;
	
	public SayCommand(Avatar avatar, String text) {
		this.avatar = avatar;
		this.text = text;
		
	}
	
	@Override
	public void run() {
		avatar.setText(text);

	}

	@Override
	public String toString() {
		String avatarName = "";
		if ((avatar.getHead().getImageFileName().contains("dorothy")))
			avatarName = "dorothy";
		else if ((avatar.getHead().getImageFileName().contains("oz")))
			avatarName = "oz";
		else if ((avatar.getHead().getImageFileName().contains("scarecrow")))
			avatarName = "scarecrow";
		
		return "Say " + avatarName + " \"" + text + "\"";
	}
	
	

}
