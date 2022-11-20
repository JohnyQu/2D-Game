package Main;

import javax.swing.*;

public class Main {

    public static void main(String[]args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Zamykanie krzyżykiem
        window.setResizable(false);
        window.setTitle("Otter Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null); //Wyświetlanie na środku ekranu
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
