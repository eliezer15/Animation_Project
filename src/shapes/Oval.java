package shapes;

import java.awt.Color;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.OVAL_PATTERN)
public class Oval extends Shape{

	public Oval() {
		super();
	}

	public Oval(int x, int y, double radius, double angle, Color color) {
		super(x, y, radius, angle, color);
	}

	public Oval(int x, int y, double radius, double angle) {
		super(x, y, radius, angle);
	}

}
