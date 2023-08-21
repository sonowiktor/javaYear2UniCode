package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Basket;
import model.Player;

public class PlayerController implements KeyListener {
    private Player player;
    private Basket basket;

    public PlayerController(Player player, Basket basket) {
        this.player = player;
        this.basket = basket;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                player.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                player.moveRight();
                break;
            case KeyEvent.VK_UP:
                player.jump();
                break;
            case KeyEvent.VK_SPACE:
                player.shoot(basket);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Do nothing
    }
}





