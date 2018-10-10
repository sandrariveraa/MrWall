/*
 * Autor: Daniel Elias Becerra
 * 16/09/18
 * Esta clase es ImageLoader que utiliza BufferedImage para regresar 
 * la imagen del path dado.
 */


package test;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.*;

public class ImageLoader {
	
	private String path;
	
	public ImageLoader(String path) {
		this.path=path;
	}
	
	public BufferedImage load() {
		try {
			return ImageIO.read(new File(path)); 
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
