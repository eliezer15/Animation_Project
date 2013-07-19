package tokens;

import util.annotations.StructurePattern;

@StructurePattern("Bean Pattern")
public abstract class Token implements TokenInterface {

	String token;
	
	public Token(String token) {
		setToken(token);
	}
	
	public Token() {
		setToken("");
	}
	
	@Override
	public String getToken() {
		return token;
	}

	@Override
	public void setToken(String token) {
		this.token = token;
	}
	
		
}
