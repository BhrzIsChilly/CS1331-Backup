package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public void keyTyped(KeyEvent event) {
        // Not used for this project. Although, is needed for compliation.
    }

    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            upPressed = true;
            System.out.println("W_D");
            // leftPressed = rightPressed = downPressed = false;
        }

        if (keyCode == KeyEvent.VK_A) {
            leftPressed = true;
            System.out.println("A_D");
            // upPressed = rightPressed = downPressed = false;
        }

        if (keyCode == KeyEvent.VK_D) {
            rightPressed = true;
            System.out.println("D_D");
            // leftPressed = upPressed = downPressed = false;
        }

        if (keyCode == KeyEvent.VK_S) {
            downPressed = true;
            System.out.println("S_D");
            // leftPressed = rightPressed = upPressed = false;
        }
    }

    public void keyReleased(KeyEvent event) {
        int keyCode = event.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            System.out.println("W_U");
            upPressed = false;
        }

        if (keyCode == KeyEvent.VK_A) {
            System.out.println("A_U");
            leftPressed = false;
        }

        if (keyCode == KeyEvent.VK_D) {
            System.out.println("D_U");
            rightPressed = false;
        }

        if (keyCode == KeyEvent.VK_S) {
            System.out.println("S_U");
            downPressed = false;
        }
    }
}