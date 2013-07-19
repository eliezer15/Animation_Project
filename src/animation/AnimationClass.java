package animation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import listenerSupport.ListenerSupport;


import shapes.Scene;
import util.annotations.ObserverRegisterer;
import util.annotations.ObserverTypes;
import util.misc.ThreadSupport;

public class AnimationClass implements Animation {

	int time;
	int totalTime;
	Scene scene;
	ListenerSupport listenerSupport;
	
	public AnimationClass(Scene scene) {
		this.scene = scene;
		setTime(0);
		setTotalTime(0);
		listenerSupport = new ListenerSupport();
	}
	
	public void animate() {

			setTotalTime(14200);
			setTime(0);
		
			//First sequence
			scene.getDorothy().setText("Op op op");
			scene.getOz().setText("Op op op");
			scene.getScarecrow().setText("Op op op");
			
			scene.getDorothy().rotateArms(15);
			scene.getOz().rotateArms(15);
			scene.getScarecrow().rotateArms(15);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getDorothy().rotateArms(-15);
			scene.getOz().rotateArms(-15);
			scene.getScarecrow().rotateArms(-15);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getDorothy().rotateArms(25);
			scene.getOz().rotateArms(25);
			scene.getScarecrow().rotateArms(25);
			
			scene.getDorothy().rotateLegs(20);
			scene.getOz().rotateLegs(20);
			scene.getScarecrow().rotateLegs(20);	
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getDorothy().rotateArms(-25);
			scene.getOz().rotateArms(-25);
			scene.getScarecrow().rotateArms(-25);
			
			scene.getDorothy().rotateLegs(-20);
			scene.getOz().rotateLegs(-20);
			scene.getScarecrow().rotateLegs(-20);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getDorothy().setText("Gangnam style!");
			scene.getOz().setText("Gangnam style!");
			scene.getScarecrow().setText("Gangnam style!");
			
			scene.getDorothy().rotateArms(15);
			scene.getOz().rotateArms(15);
			scene.getScarecrow().rotateArms(15);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getDorothy().rotateArms(-15);
			scene.getOz().rotateArms(-15);
			scene.getScarecrow().rotateArms(-15);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getDorothy().rotateArms(25);
			scene.getOz().rotateArms(25);
			scene.getScarecrow().rotateArms(25);
			
			scene.getDorothy().rotateLegs(20);
			scene.getOz().rotateLegs(20);
			scene.getScarecrow().rotateLegs(20);	
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getDorothy().rotateArms(-25);
			scene.getOz().rotateArms(-25);
			scene.getScarecrow().rotateArms(-25);
			
			scene.getDorothy().rotateLegs(-20);
			scene.getOz().rotateLegs(-20);
			scene.getScarecrow().rotateLegs(-20);
			setTime(time+500);
			ThreadSupport.sleep(500);

			//Scarecrow flexes
			scene.getDorothy().setText("");
			scene.getOz().setText("");
			scene.getScarecrow().setText("Look how strong I am");
			scene.getScarecrow().rotateArms(25);
			scene.getScarecrow().rotateElbows(32);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getScarecrow().rotateElbows(9);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getScarecrow().rotateElbows(-9);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getScarecrow().rotateElbows(9);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getScarecrow().rotateElbows(-9);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getScarecrow().rotateArms(-25);
			scene.getScarecrow().rotateElbows(-32);
			setTime(time+500);
			ThreadSupport.sleep(500);
	
			//Oz Dances
			scene.getOz().setText("Thriller! Thriller night!");
			scene.getScarecrow().setText("");
			scene.getOz().turnArms(16);
			scene.getOz().rotateElbows(-3);
			scene.getOz().turnLegs(-16);
			scene.getOz().rotateCalfs(-3);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getOz().turnArms(-32);
			scene.getOz().turnLegs(32);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getOz().turnArms(32);
			scene.getOz().turnLegs(-32);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getOz().turnArms(-32);
			scene.getOz().turnLegs(32);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			scene.getOz().turnArms(16);
			scene.getOz().turnLegs(-16);
			scene.getOz().rotateElbows(3);
			scene.getOz().rotateCalfs(3);
			setTime(time+500);
			ThreadSupport.sleep(500);
			
			//Dorothy grows
			scene.getOz().setText("");
			scene.getDorothy().scale(10);
			setTime(time+200);
			ThreadSupport.sleep(200);
			
			scene.getDorothy().scale(10);
			setTime(time+200);
			ThreadSupport.sleep(200);
			
			scene.getDorothy().scale(10);
			setTime(time+200);
			ThreadSupport.sleep(200);
			
			scene.getDorothy().scale(10);
			setTime(time+200);
			ThreadSupport.sleep(200);
			
			scene.getDorothy().scale(10);
			setTime(time+200);
			ThreadSupport.sleep(200);
			
			scene.getDorothy().scale(10);
			setTime(time+200);
			ThreadSupport.sleep(200);
			
			scene.getDorothy().scale(10);
			setTime(time+200);
			ThreadSupport.sleep(200);
			
			scene.getDorothy().scale(10);
			setTime(time+200);
			ThreadSupport.sleep(200);
			
			scene.getDorothy().setText("Game over boys!");
			
			setTime(time+2000);
			ThreadSupport.sleep(2000);
			//Dorothy follows the others
			
			scene.getDorothy().moveUnits(-5, 0);
			setTime(time+100);
			ThreadSupport.sleep(100);
			
			scene.getDorothy().moveUnits(-5, 0);
			setTime(time+100);
			ThreadSupport.sleep(100);
			
			scene.getDorothy().moveUnits(-5, 0);
			setTime(time+100);
			ThreadSupport.sleep(100);
			
			scene.getDorothy().moveUnits(-5, 0);
			setTime(time+100);
			ThreadSupport.sleep(100);
			
			scene.getOz().setText("Run you fool!");
			scene.getScarecrow().setText("Oh no!");
			scene.getDorothy().moveUnits(-5, 0);
			scene.getOz().moveUnits(-5, 0);
			scene.getScarecrow().moveUnits(-5, 0);
			setTime(time+100);
			ThreadSupport.sleep(100);
			
			scene.getDorothy().moveUnits(-5, 0);
			scene.getOz().moveUnits(-5, 0);
			scene.getScarecrow().moveUnits(-5, 0);
			setTime(time+100);
			ThreadSupport.sleep(100);
			
			scene.getDorothy().moveUnits(-5, 0);
			scene.getOz().moveUnits(-5, 0);
			scene.getScarecrow().moveUnits(-5, 0);
			setTime(time+100);
			ThreadSupport.sleep(100);
			
			scene.getDorothy().moveUnits(-5, 0);
			scene.getOz().moveUnits(-5, 0);
			scene.getScarecrow().moveUnits(-5, 0);
			setTime(time+100);
			ThreadSupport.sleep(100);
			
			scene.getDorothy().moveUnits(-5, 0);
			scene.getOz().moveUnits(-5, 0);
			scene.getScarecrow().moveUnits(-5, 0);
			setTime(time+100);
			ThreadSupport.sleep(100);
			
			scene.getDorothy().moveUnits(-5, 0);
			scene.getOz().moveUnits(-5, 0);
			scene.getScarecrow().moveUnits(-5, 0);
			setTime(time+100);
			ThreadSupport.sleep(100);
			
			scene.getDorothy().moveUnits(-5, 0);
			scene.getOz().moveUnits(-5, 0);
			scene.getScarecrow().moveUnits(-5, 0);
			setTime(time+100);
			ThreadSupport.sleep(100);				
	}

	@ObserverRegisterer(ObserverTypes.PROPERTY_LISTENER)
	public void addPropertyChangeListener(PropertyChangeListener listener) {		
		listenerSupport.addElement(listener);
	}
	
	public void setTime(int time) {
		int oldTime = 0;
		this.time = time;
		
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "time", oldTime, this.time));
		}

	}

    public void setTotalTime(int totalTime) {
		int oldTotalTime = 0;
		this.totalTime = totalTime;
		
		if (listenerSupport != null) {
			listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "totalTime", oldTotalTime, this.totalTime));
		}
	}

}
