/*
 * Autor: Daniel Elias Becerra
 * 14/09/18
 * Esta clase hereda de Shape su posición en x, y y color.
 * Así mismo tiene la posibilidad de moverse hacía arriba, abajo, derecha, izquierda
 */


import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;


public class Circle extends Shape {
 private int radio;

 public Circle(int x, int y, int width, int height, Color c) {
   super(x, y, width, height, c);
 }

 public void move(){} //abstract method of shape class

 public void move(boolean r, boolean l, boolean u, boolean d, Background bg) {
   if(u && y>0)
     y -= 1;
   if(d && y+height<700)
     y += 1;
   if(r) {
      if(x<480 || (bg.getX()<=-1080 && x+width<1080))
        x += 1;
      else
        bg.setX(-1);
   }
   if(l) {
      if(x>480 || (bg.getX()>=0 && x>0))
        x -= 1;
      else
        bg.setX(1);
   }
 }

 public void setX(int n) {
	 this.x += n;
 }

 public void setY(int n) {
	 this.y += n;
 }

 public void draw(Graphics g) {
   g.setColor(c);
	 g.fillOval(x, y, width, height);
 }


}
