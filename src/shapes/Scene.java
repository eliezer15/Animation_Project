package shapes;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import collection.TableClass;

import util.annotations.Position;
import util.annotations.StructurePattern;
import util.models.PropertyListenerRegisterer;

@StructurePattern("Bean Pattern")
public class Scene implements SceneInterface, PropertyListenerRegisterer {

	ImageClass background;
	Avatar dorothy;
	Avatar scarecrow;
	Avatar oz;
	
	TableClass avatarVisible = new TableClass();
	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	public Scene() {
		background = new ImageClass(25,1,"background.jpg");
		scarecrow = new Avatar("crow.jpg", 75, 150, 40, Color.YELLOW);
		oz = new Avatar("oz.jpg",175,150,40,Color.GREEN);
		dorothy = new Avatar("dorothy.jpg", 275, 150, 40, Color.PINK);
		
		avatarVisible.put(dorothy, true);
		avatarVisible.put(oz, true);
		avatarVisible.put(scarecrow, true);
		avatarVisible.put(background, true);
		
	}
	
	public Scene(Color dorothyColor, Color scarecrowColor, Color ozColor) {
		this();
		dorothy.setColor(dorothyColor);
		scarecrow.setColor(scarecrowColor);
		oz.setColor(ozColor);
				
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
//		dorothy.addPropertyChangeListener(listener);
//		oz.addPropertyChangeListener(listener);
//		scarecrow.addPropertyChangeListener(listener);
//		dorothy.addPropertyChangeListener(listener);
//		propertyChangeSupport.addPropertyChangeListener(listener);
//		
//		if (propertyChangeSupport != null) {
//			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","background", avatarVisible.get(dorothy)));
//			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","dorothy", avatarVisible.get(dorothy)));
//			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","oz", avatarVisible.get(dorothy)));
//			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","scarecrow", avatarVisible.get(dorothy)));
//		}
//		
	}
	
	/*
	 * The preLeaves and preEnters value work in opposite of the preGet values. If an avatar's
	 * visibility is true, then you want to display the leaves method and disable the enter method,
	 * and viceversa
	 */
	
	public boolean preDorothyLeaves() {
		return (boolean)avatarVisible.get(dorothy);
	}
	
	public void dorothyLeaves() {
		
		assert preDorothyLeaves();
		avatarVisible.put(dorothy, false);
		if (propertyChangeSupport != null) {
			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","dorothy", false));
		}
	}
	
	public boolean preDorothyEnters() {
		return !((boolean)avatarVisible.get(dorothy));
	}
	
	public void dorothyEnters() {
		
		assert preDorothyEnters();
		avatarVisible.put(dorothy, true);
		if (propertyChangeSupport != null) {
			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","dorothy", true));
		}
	}
	
	public boolean preOzLeaves() {
		return ((boolean)avatarVisible.get(oz));
	}
	
	public void ozLeaves() {
		avatarVisible.put(oz, false);
		if (propertyChangeSupport != null) {
			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","oz", false));
		}
	}
	
	public boolean preOzEnters() {
		return !((boolean)avatarVisible.get(oz));
	}
	
	public void ozEnters() {
		avatarVisible.put(oz, true);
		if (propertyChangeSupport != null) {
			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","oz", true));
		}
	}
	
	public boolean preScarecrowLeaves() {
		return ((boolean)avatarVisible.get(scarecrow));
	}
	
	public void scarecrowLeaves() {
		avatarVisible.put(scarecrow, false);
		if (propertyChangeSupport != null) {
			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","scarecrow", false));
		}
	}
	
	public boolean preScarecrowEnters() {
		return !((boolean)avatarVisible.get(scarecrow));
	}
	
	public void scarecrowEnters() {
		avatarVisible.put(scarecrow, true);
		if (propertyChangeSupport != null) {
			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","scarecrow", true));
		}
	}
	
	public boolean preBackgroundLeaves() {
		return ((boolean)avatarVisible.get(background));
	}
	
	public void backgroundLeaves() {
		avatarVisible.put(background, false);
		if (propertyChangeSupport != null) {
			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","background", false));
		}
	}
	
	public boolean preBackgroundEnters() {
		return !((boolean)avatarVisible.get(background));
	}
	
	public void backgroundEnters() {
		avatarVisible.put(background, true);
		if (propertyChangeSupport != null) {
			propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this,"this","background", true));
		}
	}
	
	public boolean preGetBackground() {
		return (boolean)avatarVisible.get(background);
	}
		
	@Position(4)
	public ImageClass getBackground() {
		assert preGetBackground();
		return background;
	}
	
	public boolean preGetScarecrow() {
		return (boolean)avatarVisible.get(scarecrow);
	}

	@Position(2)
	public Avatar getScarecrow() {
		assert preGetScarecrow();
		return scarecrow;
	}
	
	public boolean preGetOz() {
		return (boolean)avatarVisible.get(oz);
	}

	@Position(1)
	public Avatar getOz() {
		assert preGetOz();
		return oz;
	}	
	
	public boolean preGetDorothy() {
		return (boolean)avatarVisible.get(dorothy);
	}
	
	@Position(0)
	public Avatar getDorothy(){
		assert preGetDorothy();
		return dorothy;
	}
	
	public void scroll(int x, int y) {
		
		background.setX(background.getX() + x);
		background.setY(background.getY() + y);
		
		dorothy.moveUnits(x, y);
		oz.moveUnits(x, y);
		scarecrow.moveUnits(x, y);
	}

	@Override
	public String toString() {
		return "Scene dorothy=" + dorothy + "\n" + "scarecrow=" + scarecrow
				+ "\n" +  "oz=" + oz;
	}
	
}
