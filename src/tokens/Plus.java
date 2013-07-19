package tokens;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class Plus extends Token {

	public Plus() {
		super();
	}

	public Plus(String token) {
		super(token);
	}

	
}
