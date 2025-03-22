package org.example;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel.startGameThread();

    }
}