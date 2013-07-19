package tokens;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class End extends Token{

	public End() {
		super();
	}

	public End(String token) {
		super(token);
	}

}
