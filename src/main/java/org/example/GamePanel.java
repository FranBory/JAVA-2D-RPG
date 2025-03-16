package org.example;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    final int innitTileSize = 16;
    final int scale = 3;

    final int tileSize = innitTileSize * scale;
    final int columns = 16;
    final int rows = 16;
    final int width = columns * innitTileSize;
    final int height = rows * innitTileSize;

    public GamePanel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
    }


}