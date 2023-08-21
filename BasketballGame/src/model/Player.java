package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Player {
    private String name;
    private int x, y;
    private Image sprite;
    private int points;
    private final int speed = 5;
    private List<String> hand;

    public Player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        sprite = new ImageIcon("player.png").getImage();
        points = 0;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void jump() {
        y -= speed;
    }

    public Image getSprite() {
        return sprite;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void score() {
        points++;
    }

    public void shoot(Basket basket) {
        // calculate the distance between the player and the basket
        double distance = Math.sqrt(Math.pow(basket.getX() - x, 2) + Math.pow(basket.getY() - y, 2));

        // if the distance is less than or equal to the shooting range, it's a successful shot
        if (distance <= basket.getShootingRange()) {
            score();
        }
    }
    
    public void draw(List<String> deck) {
        Random random = new Random();
        int index = random.nextInt(deck.size());
        String card = deck.remove(index);
        hand.add(card);
    }

    public void showHand() {
        System.out.printf("%s's hand: %s\n", name, hand.toString());
    }
}
