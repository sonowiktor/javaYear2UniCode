package main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import model.Ball;

public class GameLoader extends JFrame implements ActionListener {
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;
    private static final int DELAY = 10;

    private Player player;
    private Ball ball;

    public GameLoader() {
        player = new Player("Player 1", GAME_WIDTH / 2, GAME_HEIGHT - 50);
        ball = new Ball();

        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.update(GAME_WIDTH, GAME_HEIGHT);

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(player.getSprite(), player.getX(), player.getY(), this);

        g.setColor(ball.getColor());
        g.fillOval(ball.getX() - 20, ball.getY() - 20, 40, 40);
    }

    public static void main(String[] args) {
        GameLoader gameLoader = new GameLoader();

        gameLoader.pack();
        gameLoader.setLocationRelativeTo(null);
        gameLoader.setVisible(true);
    }

    private static class Player {
        private String name;
        private int x, y;
        private Image sprite;
        private int points;
        private final int speed = 5;

        public Player(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
            sprite = new ImageIcon("player.png").getImage();
            points = 0;
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

        public void shoot(Ball ball) {
            // calculate the distance between the player and the ball
            double distance = Math.sqrt(Math.pow(ball.getX() - x, 2) + Math.pow(ball.getY() - y, 2));

            // if the distance is less than or equal to the shooting range, it's a successful shot
            if (distance <= 20) {
                score();
            }
        }
    }
    
    private static class Ball {
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

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x - 20, y - 20, 40, 40);
        }
    }
}