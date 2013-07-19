package tokens;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class Word extends Token implements LowerWord{
	
	String lowerCase;
	
	public Word() {
		super();
	}

	public Word(String token) {
		super(token);
	}

	@Override
	public void setToken(String token) {
		this.token = token;
		lowerCase = this.toLower();
	}
	
	
	public String getLowerCase() {	
		return lowerCase;
	}
	
	public String toLower() {
		
		String lowerCaseWord = "";
		char letter;
		for (int i=0; i < token.length();i++) {
			
			if (token.charAt(i) < 91 && token.charAt(i) > 64) 
				letter = (char) (token.charAt(i) + 32);
			else
				letter = token.charAt(i);
			
			lowerCaseWord+= letter;	
		}	
		return lowerCaseWord;
	}

}
