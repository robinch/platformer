package main;


import gameState.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created by robin on 2014-11-03.
 */
public class GamePanel extends JPanel implements Runnable, KeyListener{
    // Dimensions
    public static final int WIDTH = 320;
    public static final int HEIGHT = 249;
    public static final int SCALE = 2;

    // Game thread
    private Thread thread;
    private boolean running;
    private int FPS = 60;
    private long targetTime = 1000/FPS;

    // image
    private BufferedImage image;
    private Graphics2D g;

    // Game state manager
    private GameStateManager gsm;

    public GamePanel(){
        super();
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    private void init(){
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        gsm = new GameStateManager();
    }

    public void run(){
        init();

        long start;
        long elapsed;
        long wait;
        // Game loop

        while(running){
            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;

            try{
                Thread.sleep(wait);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    private void update(){
        gsm.update();
    }
    private void draw(){
        gsm.draw(g);
    }
    private void drawToScreen(){
       Graphics g2 = getGraphics();
        g2.drawImage(image, 0,0,null);
        g2.dispose();
    }

    public void keyTyped(KeyEvent key){

    }
    public void keyPressed(KeyEvent key){
        gsm.keyPressed(key.getKeyCode());
    }
    public void keyReleased(KeyEvent key){
        gsm.keyReleased(key.getKeyCode());
    }

}
