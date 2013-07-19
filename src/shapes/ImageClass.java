package shapes;
import java.awt.Color;
import java.beans.PropertyChangeEvent;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class ImageClass extends Shape implements Image {

	String fileName;
	
	public ImageClass() {
		super();
		fileName = "";
	}
	public ImageClass(int x, int y, String file, Color color) {
		super(x, y, 0, 0, color);
		this.fileName = file;
	}
	
	public ImageClass(int x, int y, String file) {
		super(x, y, 0, 0);
		this.fileName = file;
	}
	
	public String getImageFileName() {
		return fileName;
	}
	public void setImageFileName(String newFile) {
		String oldImageFileName = fileName;
		fileName = newFile;
		
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "imageFileName", oldImageFileName, fileName));
		}
	}
		
	
}
