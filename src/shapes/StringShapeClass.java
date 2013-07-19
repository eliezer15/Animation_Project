package shapes;

import java.awt.Color;
import java.beans.PropertyChangeEvent;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.STRING_PATTERN)

public class StringShapeClass extends Shape implements StringShape {

	String text;
	
	public StringShapeClass() {
		super();
		text = "";
	}
	public StringShapeClass(int x, int y, String text, Color color) {
		super(x, y, 0, 0, color);
		this.text = text;
	}
	
	public StringShapeClass(int x, int y, String text) {
		super(x, y, 0, 0);
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "text", oldText, newText));
		}
		
	}
		
}
