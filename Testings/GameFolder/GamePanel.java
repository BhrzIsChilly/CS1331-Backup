package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

    // Game Settings
    final static int originalTileSize = 16; // 16x16 tile size pretty small for a HI-DPI screen.
    final static int screenScale = 4; // It would be best to get the screen resolution, then scale it using it's res.

    final static int tileSize = originalTileSize * screenScale;
    final static int maxScreenColumnTiles = 40; // 24
    final static int maxScreenRowTiles = 18;
    final static int screenWidth = tileSize * maxScreenColumnTiles;
    final static int screenHeight = tileSize * maxScreenRowTiles;  // ALL SHOULD BE UPPERCASED
    
    final static int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4; // 4


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS; // 1 second / 60 fps
        double nextDrawTime = System.nanoTime() + drawInterval;

        // Game Loop
        while(gameThread != null) {
            // 1: UPDATES: Update information such as character positions.
            this.update();
            // 2: DRAW: Draw the updated screen with the new information.
            repaint(); // might be a super method. I'm not sure if super.repaint() is what's proper.
            // this repaint() is apart of paintComponent but is from the super class
            try {
                double remainingTimeLeft = nextDrawTime - System.nanoTime();
                remainingTimeLeft /= 1000000;

                if (remainingTimeLeft < 0) {
                    System.out.println("Game is lagging behind! Lag: " + remainingTimeLeft + " - in milliseconds");
                    remainingTimeLeft = 0;
                }
                
                Thread.sleep((long) remainingTimeLeft);

                nextDrawTime += drawInterval;// new nextDrawTime for next draw time.

            } catch (InterruptedException event) {
                event.printStackTrace();
            }
        }
    }

    public void update() {

        if (keyHandler.upPressed == true) {
            playerY -= playerSpeed;
            if (playerY <= 0) {
                playerY = 0;
            }
        }

        if (keyHandler.downPressed == true) {
            playerY += playerSpeed;
            if (playerY >= screenHeight - tileSize) { // same as rightPressed
                playerY = screenHeight - tileSize;
            }
        }

        if (keyHandler.leftPressed == true) {
            playerX -= playerSpeed;
            if (playerX <= 0) {
                playerX = 0;
            }
        }

        if (keyHandler.rightPressed == true) {
            playerX += playerSpeed;
            if (playerX >= screenWidth - tileSize) { //screenWidth - tileSize would be a nice opportunity to name a new variable for boundaries.
                playerX = screenWidth - tileSize;
            }
        }
    }

    public void paintComponent(Graphics graphicsG) { // a method inside of JPanel, a type of constructor (?).
        super.paintComponent(graphicsG);

        Graphics2D graphicsG2 = (Graphics2D) graphicsG; // Has a little more function. Casting Graphics2D onto the variable.
        
        // Background
        graphicsG2.setColor(Color.red);
        graphicsG2.fillRect(tileSize, tileSize, screenWidth - 2*tileSize, screenHeight - 2*tileSize);
        // graphicsG2.dispose();

        // Player
        graphicsG2.setColor(Color.white);
        graphicsG2.fillRect(playerX, playerY, tileSize, tileSize); // x, y, width, height
        graphicsG2.dispose(); // saves memory
    }
}