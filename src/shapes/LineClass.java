package shapes;

import java.awt.Color;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.LINE_PATTERN)

public class LineClass extends Shape implements Line {
		
	public LineClass() {
		super();
	}

	public LineClass(int x, int y, double angle, double radius,   Color color) {
		super(x, y, angle, radius, color);
	}
	
	public LineClass(int x, int y, double angle, double radius) {
		super(x, y, angle, radius);
	}

	public void shiftAngle(int shift) {
		double newAngle = angle - (shift*(Math.PI/32));
		setAngle(newAngle);

	}

}
