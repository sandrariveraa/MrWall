/*
 * Autor: Daniel Elias Becerra
 * 16/09/18
 * Esta clase es la clase padre de la cual se heredan las figuras.
 */


package test;

import java.awt.*;


public abstract class Shape {
	
	protected int x;
	protected int y;
	protected Color c;
	protected Rectangle rect;
	
	public abstract void draw(Graphics g);
	public abstract void move();
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Rectangle getRectangle() {
		return rect;
	}
	
	public boolean collision(Rectangle r) {
		Rectangle rec = this.getRectangle();
		System.out.println(r.getX()+r.getY());
		return rec.contains(r.getX(), r.getY());
	}

}
