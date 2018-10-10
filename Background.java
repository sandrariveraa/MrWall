/*
 * Autor: Daniel Elias Becerra
 * 16/09/18
 * Esta clase crea un background para ser usado en el GamePanel
 * Utiliza un Image Loader para obtener la imagen del background
 * Tambien tiene método de dibujar y mover para manipular su posición y que se recorra
 * en el GamePanel
 */


package test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


public class Background {
	
 //private int addX = 10;
 //private int addY = 10;
 private int x;
 private int y;
 private ImageLoader background_loader;
 private int width = 1080;
 private int height= 720;
 
 public Background(int x, int y, String path) {
	 this.x=x;
	 this.y=y;
	 this.background_loader = new ImageLoader(path);
 }
 
 public void move() {
	 
 }
 
 public void setX(int n) {
	 int aux= this.x+n;
	 if((aux<=0) && (aux>=-1080))
	 this.x += n;
 }
 
 public void setY(int n) {
	 this.y += n;
 }
 
 public int getX() {
	 return x;
 }
 
 public int getY() {
	 return y;
 }
 
 public Image draw(Graphics g) {
	 return background_loader.load();
 }
 
}
	

