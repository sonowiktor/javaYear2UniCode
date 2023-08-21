package model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Basket {
    private int x, y;
    private Image sprite;
    private double shootingRange;

    public Basket(int x, int y, double shootingRange) {
        this.x = x;
        this.y = y;
        sprite = new ImageIcon("basket.png").getImage();
        this.shootingRange = shootingRange;
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

    public Image getSprite() {
        return sprite;
    }

    public double getShootingRange() {
        return shootingRange;
    }

    public void setShootingRange(double shootingRange) {
        this.shootingRange = shootingRange;
    }

}
