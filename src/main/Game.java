package main;

import javax.swing.JFrame;

/**
 * Created by robin on 2014-11-03.
 */
public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame("Dragon Tale");
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
}
