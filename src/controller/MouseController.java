package controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import shapes.Scene;

public class MouseController implements MouseListener {

	Scene scene;
	Component sceneComponent;
	Point clickLocation;
	
	public MouseController(Scene scene, Component sceneComponent, Point clickLocation) {
		
		this.scene = scene;
		this.sceneComponent = sceneComponent;
		this.sceneComponent.addMouseListener(this);
		this.clickLocation = clickLocation;
	}

	public void mouseClicked(MouseEvent e) {	
		this.clickLocation.setLocation(e.getPoint().x, e.getPoint().y);
		System.out.println("Mouse clicked");
		System.out.println(clickLocation.x);
		System.out.println(clickLocation.y);
	}
	
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
}
