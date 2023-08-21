package model;

public class Coach {
    private Team team1, team2;
    private Ball ball;
    private int timeout;
    private boolean isRunning;

    public Coach(Team team1, Team team2, Ball ball) {
        this.team1 = team1;
        this.team2 = team2;
        this.ball = ball;
        timeout = 60;
        isRunning = false;
    }

    public void start() {
        isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }

    public void update() {
        if (isRunning) {
            
        }
    }
}

