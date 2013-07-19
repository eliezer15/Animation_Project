package controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import shapes.Scene;

public class KeyController implements KeyListener {

	Scene scene;
	Component sceneComponent;
	Point clickLocation;
	
	public KeyController(Scene scene, Component sceneComponent, Point clickLocation) {
		this.scene = scene;
		this.sceneComponent = sceneComponent;
		this.sceneComponent.addKeyListener(this);
		this.sceneComponent.setFocusable(true);
		this.clickLocation = clickLocation;
	}
	
	
	public void keyPressed(KeyEvent arg0) {}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent e) {
		
		char typedChar = e.getKeyChar();
		switch(typedChar) {
		case 'd':
			scene.getDorothy().move(clickLocation.x, clickLocation.y);
			System.out.println("Key pressed");
			break;
		case 's':
			scene.getScarecrow().move(clickLocation.x, clickLocation.y);
			break;
		case 'o':
			scene.getOz().move(clickLocation.x, clickLocation.y);
			break;
		case 'r':
			scene.getDorothy().move(275, 150);
			scene.getOz().move(175, 150);
			scene.getScarecrow().move(75, 150);
			break;
		}
	}

}
