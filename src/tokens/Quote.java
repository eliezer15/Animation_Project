package tokens;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class Quote extends Token {

	public Quote() {
		super();
	}

	public Quote(String token) {
		super(token);

	}
	
	
}
