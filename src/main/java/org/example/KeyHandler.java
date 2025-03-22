package org.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed = false;
    public boolean downPressed = false;
    public boolean leftPressed = false;
    public boolean rightPressed = false;
    public boolean spacePressed = false;
    public boolean didMove = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //System.out.println("Key pressed: " + code);
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        else if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        else if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        else if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = false;
            didMove = false;
        }
        else if (code == KeyEvent.VK_A) {
            leftPressed = false;
            didMove = false;
        }
        else if (code == KeyEvent.VK_S) {
            downPressed = false;
            didMove = false;
        }
        else if (code == KeyEvent.VK_D) {
            rightPressed = false;
            didMove = false;
        }
    }
}
