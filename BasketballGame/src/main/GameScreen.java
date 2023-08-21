package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.BallController;
import controller.PlayerController;
import model.Ball;
import model.Basket;
import model.Player;
import view.BallView;
import view.PlayerView;

public class GameScreen extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 800;

    private Ball ball;
    private BallView ballView;
    private BallController ballController;
    private Player player;
    private Basket basket;
    private PlayerView playerView;
    private PlayerController playerController;

    public GameScreen() {
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));

        // Create the ball
        ball = new Ball();
        ballView = new BallView();
        ballController = new BallController(ball);
        addKeyListener(ballController);

        // Create the player and the basket
        player = new Player("Player 1", 200, 200);
        basket = new Basket(500, 500, 50);
        playerView = new PlayerView();
        playerController = new PlayerController(player, basket);
        playerView.addKeyListener(playerController);

        // Add the components to the panel
        add(playerView);
        ball.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.update(GAME_WIDTH, GAME_HEIGHT);
        ballView.draw(g, ball);
        playerView.draw(player);
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocation(new Point(200, 200));
        frame.setSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        frame.add(new GameScreen());
        frame.setVisible(true);
    }
}
