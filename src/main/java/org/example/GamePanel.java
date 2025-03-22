package org.example;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int innitTileSize = 16;
    final int scale = 3;

    final int tileSize = innitTileSize * scale;
    final int columns = 16;
    final int rows = 16;
    final int width = columns * tileSize;
    final int height = rows * tileSize;

    double FPS = 5.0;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    boolean running = false;

    Cursor cursor = new Cursor();

    int playerSpeed=1;

    public GamePanel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        if (!running) {
            running = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
    }
    public void stopGameThread() {
        running = false;
    }

    @Override
    public void run() {

        double drawFrame = 1000000000/FPS;
        double nextDrawFrame = drawFrame + System.nanoTime();

        while (running) {
//            System.out.println("waiting for draw frame");
            update();

            repaint();
            try {
                double delta = nextDrawFrame - System.nanoTime();
                delta /= 1000000000;
                if (delta < 0) delta = 0;
                Thread.sleep((long) delta);
                nextDrawFrame += drawFrame;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update() {
        if (keyH.didMove == false) {
            if (keyH.upPressed == true) {
                if (cursor.getPositionY()-tileSize >= 0) {
                    cursor.setPositionY(cursor.getPositionY()-tileSize);
                    keyH.didMove = true;
                }
            }
            if (keyH.downPressed == true) {
                System.out.println("Key pressed: " );
                if (cursor.getPositionY()+tileSize <= height - tileSize) {
                    cursor.setPositionY(cursor.getPositionY()+tileSize);
                    keyH.didMove = true;

                }
            }
            if (keyH.leftPressed == true) {
                if (cursor.getPositionX()-tileSize >= 0) {
                    cursor.setPositionX(cursor.getPositionX()-tileSize);
                    keyH.didMove = true;
                }
            }
            if (keyH.rightPressed == true) {
                if (cursor.getPositionX()+tileSize <= width - tileSize) {
                    cursor.setPositionX(cursor.getPositionX()+tileSize);
                    keyH.didMove = true;
                }
            }
        }
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);

        drawCursor(g,cursor);

        g.dispose();
    }
    public void drawCursor(Graphics g, Cursor cursor) {
        g.setColor(Color.RED);
        g.drawLine(cursor.getPositionX(), cursor.getPositionY(),cursor.getPositionX()+tileSize,cursor.getPositionY());
        g.drawLine(cursor.getPositionX(), cursor.getPositionY()+tileSize,cursor.getPositionX()+tileSize,cursor.getPositionY()+tileSize);
        g.drawLine(cursor.getPositionX(), cursor.getPositionY(),cursor.getPositionX(),cursor.getPositionY()+tileSize);
        g.drawLine(cursor.getPositionX() +tileSize, cursor.getPositionY(),cursor.getPositionX()+tileSize,cursor.getPositionY()+tileSize);
    }
    public void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int col = 0; col <= columns; col++) {
            int x = col * tileSize;
            g.drawLine(x, 0, x, height);
        }
        for (int row = 0; row <= rows; row++) {
            int y = row * tileSize;
            g.drawLine(0, y, width, y);
        }
    }

}