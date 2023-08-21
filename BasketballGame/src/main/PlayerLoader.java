package main;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

import model.Basket;
import model.Player;
import view.PlayerView;
import controller.PlayerController;

public class PlayerLoader {

    public static void main(String[] args) {
        Player player = new Player("Player 1", 200, 200);
        Basket basket = new Basket(500, 500, 50);
        PlayerView playerView = new PlayerView();
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocation(new Point(200, 200));
        frame.setSize(new Dimension(800, 800));

        PlayerController playerController = new PlayerController(player, basket);
        playerView.addKeyListener(playerController);
        playerView.setFocusable(true);
        playerView.requestFocusInWindow();
        frame.add(playerView);
        frame.setVisible(true);
    }
}





