package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Ball;

public class BallController implements KeyListener {
    private Ball ball;

    public BallController(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                ball.setdX(-1);
                break;
            case KeyEvent.VK_RIGHT:
                ball.setdX(1);
                break;
            case KeyEvent.VK_UP:
                ball.setdY(-1);
                break;
            case KeyEvent.VK_DOWN:
                ball.setdY(1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                ball.setdX(0);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                ball.setdY(0);
                break;
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
