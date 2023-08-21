package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ball {
    private int x, y;
    private int dx, dy;
    private Color color;

    public Ball() {
        x = 400;
        y = 300;
        dx = 2;
        dy = 2;
        color = Color.CYAN;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setdX(int dx) {
        this.dx = dx;
    }

    public void setdY(int dy) {
        this.dy = dy;
    }

    public int getdX() {
    	return dx;
    }

    public int getdY() {
    	return dy;
    }

    public Color getColor() {
        return color;
    }

    public void update(int gameWidth, int gameHeight) {
        y += dy;
        if (y - 20 < 0 || y + 20 > gameHeight) {
            dy = -dy;
        }
    }

    public void start() {
        dx = 2;
        dy = 2;
    }
}





