/*
 * Autor: Daniel Elias Becerra
 * 14/09/18
 * Esta clase hereda de Shape su posición en x, y y color.
 * Así mismo tiene la posibilidad de moverse hacía arriba, abajo, derecha, izquierda
 */



package test;
import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;


public class Circle extends Shape {
 private int radio;
 
 public Circle(int x, int y) {
	 this.x=x;
	 this.y=y;
	 
	 this.c=Color.CYAN;
	 
	 this.radio=70;
	 
	 this.rect = new Rectangle(x,y,radio,radio);
 }
 
 public void move() {
	 
 }
 
 public void setX(int n) {
	 int aux=this.x+n;
	 this.x += n;
 }
 
 public void setY(int n) {
	 this.y += n;
 }
 
 public void draw(Graphics g) {
	 g.setColor(c);
	 g.fillOval(x, y, radio, radio);
 }
	

}
