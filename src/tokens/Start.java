package tokens;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class Start extends Token {

	public Start() {
		super();
	}

	public Start(String token) {
		super(token);
	}
	
	
}
