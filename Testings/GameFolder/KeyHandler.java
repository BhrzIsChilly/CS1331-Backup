package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent event) {
        // Not used for this project.
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            upPressed = true;
            leftPressed = rightPressed = downPressed = false;
        }

        if (keyCode == KeyEvent.VK_A) {
            leftPressed = true;
            upPressed = rightPressed = downPressed = false;
        }

        if (keyCode == KeyEvent.VK_D) {
            rightPressed = true;
            leftPressed = upPressed = downPressed = false;
        }

        if (keyCode == KeyEvent.VK_S) {
            downPressed = true;
            leftPressed = rightPressed = upPressed = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        int keyCode = event.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (keyCode == KeyEvent.VK_A) {
            leftPressed = false;
        }

        if (keyCode == KeyEvent.VK_D) {
            rightPressed = false;
        }

        if (keyCode == KeyEvent.VK_S) {
            downPressed = false;
        }
    }


}