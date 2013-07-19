package tokens;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class Number extends Token implements NumberGetter {
	
	int number;
	
	public Number() {
		super("0");
	}
	
	public Number(String token){
		super(token);
	}

	@Override
	public void setToken(String token) {
		 this.token = token;
		 number = Integer.parseInt(token);
	}
	
	public int getNumber() {
		return number;
	}

}