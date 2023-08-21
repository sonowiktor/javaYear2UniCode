package model;

import java.awt.Color;
import model.Game;
import java.awt.Graphics;
import java.awt.Point;

public class Court {
    private int width, height, x, y;

    public Court(int width, int height, int x, int y) {
    	this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
