/*
 * Autor: Daniel Elias Becerra
 * 14/09/18 - 16/09/18
 * Esta clase implementa Runnable y utiliza un thread para crear
 * un ciclo de animación que utiliza Update() Render() Sleep()
 */


package test;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.imageio.ImageIO;
import java.lang.*;
import javax.swing.*;
import java.util.*;
import javax.swing.*;


public class GamePanel extends JPanel implements Runnable{

	private static final int PWIDTH = 1080; // largo del panel
	private static final int PHEIGHT = 720; // alto del panel

	private Thread animator; // the thread for the animation
	private boolean running = false; // tells us if the thread is running or the animation is running
	private boolean gameOver = false; // tell us if the game is lost;

	private long sleep_time;

	private boolean isPaused = false;
	private Random r = new Random ();
	private Color c = new Color (0,0,0);
	private Graphics dbg;
	private Image dbImage=null;
	private Circle circ;
	//private Circle pepe;

//////////////////////////////////////////////////////
	private Background background1; // se crea el background
/////////////////////////////////////////////////////7

	private boolean right;
	private boolean left;
	private boolean up;
	private boolean down;

	public GamePanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
		setVisible(true);
		setFocusable(true);
		requestFocus(); //JPanel now receives keyEvents;
		readyForTermination();

		addMouseListener( new MouseAdapter() { // this is quite complex i dont understand
				public void mousePressed(MouseEvent e){
					testPress(e.getX(), e.getY()); /////////////////////////
				}
			});
		circ= new Circle(0,600);
		System.out.println(circ.getX());
		//pepe=new Circle(250,200);

		sleep_time=50;

		//addKeyListener(new KeyAdapter());

		background1 = new Background(0,0,"img/bg1.png");

	}

	public void addNotify() { // waits for the JPanel to be added to the JFrame/JApplet before starting;
		super.addNotify();
		startGame(); // this method starts the thread
	}

	public void startGame() {

		if (animator==null || !running) { // si el thread no se ha creado y la animación no está corriendo...
			animator = new Thread(this); // se crea el thread
			animator.start();
		}
	}

	public void stopGame() {
		// called by the user to stop execution
		running=false;
	}

	public void run() { // lo que corre el thread
		/// UPDATE - RENDER - SLEEP
		running = true;
		while(running) {

			long start=System.currentTimeMillis();

			gameUpdate(); // el estado del juego se actualiza
			gameRender(); // render to buffer
			paintScreen(); // draw buffer to screen

			// sleep:
			long end=System.currentTimeMillis();
			sleep_time = 50+end-start;
			if(sleep_time<=0) {
				sleep_time=20;
			}

		try {
			Thread.sleep(sleep_time); // wait for other CPU processes to happen
		}
		catch(InterruptedException ex) {}

		//System.out.println(sleep_time);
		}// final del while
		System.exit(0);
	}

	private void gameUpdate() {
		if(!gameOver) { // if game is not over
			// update game
		}
	}

	//THIS IS THE DOUBLE BUFFERING
	private void gameRender() { // draw the current frame to an image buffer
		if(dbImage==null) { // el buffer es dbImage
			dbImage = createImage(PWIDTH,PHEIGHT);
			if(dbImage == null) {
				System.out.println("dbImage is Null, has nothing, not created");
				return;
			}
			else {
				dbg = dbImage.getGraphics(); //dbg es el drawing background
			}
		}

		// clear the background
		//dbg.setColor(Color.white);
		//dbg.fillRect(0, 0, PWIDTH, PHEIGHT);
		background1.draw(dbg);
		circ.draw(dbg);
		//pepe.draw(dbg);

		//Here draw the game elements

		/*if(gameOver) {
			gameOverMessage(dbg);
		}*/
	}

	private void gameOverMessage() {
		Graphics g;
		g=this.getGraphics();
		g.drawString("GAME OVER", 10, 10);
	}

	private void readyForTermination() { // Too complex I don´t understand what is happening here
		addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
		        //System.out.println("re"+e.getKeyChar());

		        if(KeyEvent.VK_RIGHT==e.getKeyCode())
		        {
		            right=true;
		            System.out.println("entra right");
		        }

		        if(KeyEvent.VK_LEFT==e.getKeyCode())
		        {
		            left=true;
		        }

		        if(KeyEvent.VK_UP==e.getKeyCode())
		        {
		            up=true;
		            System.out.println("entra up");
		        }

		        if(KeyEvent.VK_DOWN==e.getKeyCode())
		        {
		            down=true;
		        }
		        eval();
		    }

			public void keyReleased(KeyEvent e) {
		        //System.out.println("re"+e.getKeyChar());

		        if(KeyEvent.VK_RIGHT==e.getKeyCode())
		        {
		            right=false;
		        }

		        if(KeyEvent.VK_LEFT==e.getKeyCode())
		        {
		            left=false;
		        }

		        if(KeyEvent.VK_UP==e.getKeyCode())
		        {
		            up=false;
		        }

		        if(KeyEvent.VK_DOWN==e.getKeyCode())
		        {
		            down=false;
		        }
		        eval();
		    }


			/*public void keyPressed(KeyEvent e) {
				int keyCode =e.getKeyCode();
				if((keyCode == KeyEvent.VK_ESCAPE) ||
					(keyCode == KeyEvent.VK_Q) ||
					(keyCode == KeyEvent.VK_END) ||
					((keyCode == KeyEvent.VK_C) && e.isControlDown())) {
					running = false;
				}
				//eval(keyCode);

			}*/

		}
		);
	} // end of ready for Termination


	public void keyPressed(KeyEvent e) {
        //System.out.println("re"+e.getKeyChar());

        if(KeyEvent.VK_RIGHT==e.getKeyCode())
        {
            right=true;
            System.out.println("entra right");
        }

        if(KeyEvent.VK_LEFT==e.getKeyCode())
        {
            left=true;
        }

        if(KeyEvent.VK_UP==e.getKeyCode())
        {
            up=true;
            System.out.println("entra up");
        }

        if(KeyEvent.VK_DOWN==e.getKeyCode())
        {
            down=true;
        }
    }

	public void keyReleased(KeyEvent e) {
        //System.out.println("re"+e.getKeyChar());

        if(KeyEvent.VK_RIGHT==e.getKeyCode())
        {
            right=false;
        }

        if(KeyEvent.VK_LEFT==e.getKeyCode())
        {
            left=false;
        }

        if(KeyEvent.VK_UP==e.getKeyCode())
        {
            up=false;
        }

        if(KeyEvent.VK_DOWN==e.getKeyCode())
        {
            down=false;
        }
    }

	private void eval() {
		if(right) {

			if((circ.getX()>=0) && (circ.getX()<=480)) {
				circ.setX(10);
			}

			if(circ.getX()>=480) {
				background1.setX(-10);
			}

			if(background1.getX()==-1080 && circ.getX()<=1080-90){
				circ.setX(10);
			}
		}

		if(left) {

			if((circ.getX()>=480) && (circ.getX()<=1080) && background1.getX()<0) {
				circ.setX(-10);
			}

			if(circ.getX()<=480)
				background1.setX(10);

			if(background1.getX()==0 && circ.getX()>=3){
				circ.setX(-10);
			}
		}

		if(up) {
			circ.setY(-10);
		}

		if(down) {
			circ.setY(10);
		}
	}

	private void eval(int k) {// lo ideal es hacerlo con switch

		/*switch(k){
		case KeyEvent.VK_RIGHT:
			circ.setX(10);
				if(circ.getX()>=480)
				background1.setX(-10);
			break;

		case KeyEvent.VK_LEFT:
				if(background1.getX()<=1080)
				circ.setX(-10);
			//circ.setY(0);
				if(circ.getX()<=480)
				background1.setX(10);
			break;

		case KeyEvent.VK_UP:
			//circ.setX(0);
			circ.setY(-10);
			break;

		case KeyEvent.VK_DOWN:
			//circ.setX(0);
			circ.setY(10);
			break;

		case KeyEvent.VK_D:
			//pepe.setX(0);
			//pepe.setY(0);
			break;

		case KeyEvent.VK_A:
			//pepe.setX(0);
			//pepe.setY(0);
			break;

		}*/
	}

	private void testPress(int x, int y) {
		// is (x,y) important to the game???
		if(!gameOver) {
			// do something
		}
	}

	private void paintScreen()
	{
		Graphics g;

	    try {
	      g = this.getGraphics();

	      g.drawImage(background1.draw(g),background1.getX(),background1.getY(),null);
	      //if ((g != null) && (dbImage != null))
	        //g.drawImage(dbImage,0,0,null);

	      background1.draw(g);
	      circ.draw(g);
	      //pepe.draw(dbg);


	      g.dispose();

	   }
	    catch (Exception e)
	    { System.out.println("Graphics context error: " + e);  }
	}

}
