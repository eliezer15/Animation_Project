package shapes;

import java.awt.Color;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.RECTANGLE_PATTERN)

public class Rectangle extends Shape {

	public Rectangle() {
		super();
	}

	public Rectangle(int x, int y, double radius, double angle, Color color) {
		super(x, y, radius, angle, color);
	}

	public Rectangle(int x, int y, double radius, double angle) {
		super(x, y, radius, angle);
	}

	
}
