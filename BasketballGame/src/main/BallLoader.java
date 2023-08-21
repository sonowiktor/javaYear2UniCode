package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.BallController;
import model.Ball;
import view.BallView;

public class BallLoader extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;
    private Ball ball;
    private BallView ballView;
    private BallController ballController;
    
    public BallLoader() {
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        ball = new Ball();
        ballView = new BallView();
        ballController = new BallController(ball);
        addKeyListener(ballController);
        setFocusable(true);
        ball.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.update(GAME_WIDTH, GAME_HEIGHT);
        ballView.draw(g, ball);
        repaint();
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Loader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new BallLoader());
        frame.pack();
        frame.setVisible(true);
    }
}


