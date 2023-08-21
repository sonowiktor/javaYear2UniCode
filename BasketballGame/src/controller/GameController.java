package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.GameLoader;
import model.Game;

public class GameController extends KeyAdapter {

    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            game.getTeam1().getPlayer(0).moveLeft();
        }
        if (key == KeyEvent.VK_RIGHT) {
            game.getTeam1().getPlayer(0).moveRight();
        }
        if (key == KeyEvent.VK_UP) {
            game.getTeam1().getPlayer(0).jump();
        }
    }
}