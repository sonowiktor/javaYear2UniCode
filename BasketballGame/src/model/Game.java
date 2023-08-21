package model;

import model.Court;

public class Game {
    private Court court;
    private Coach coach;
    private Ball ball;
    private Team team1, team2;
    private int scoreTeam1, scoreTeam2;
    private boolean isRunning;
    
    public Game() {
        court = new Court(600,800,100,100);
        team1 = new Team("Home team");
        team2 = new Team("Away team");
        ball = new Ball();
        coach = new Coach(team1, team2, ball);
        scoreTeam1 = 0;
        scoreTeam2 = 0;
        isRunning = false;
    }

    public Court getCourt() {
        return court;
    }

    public Coach getCoach() {
        return coach;
    }

    public Ball getBall() {
        return ball;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void start() {
    	team1 = new Team("Home Team");
        team2 = new Team("Away Team");
        ball = new Ball();
        coach = new Coach(team1, team2, ball);
        isRunning = true;
        coach.start();
    }

    public void stop() {
    	team1 = new Team("Home Team");
        team2 = new Team("Away Team");
        ball = new Ball();
        coach = new Coach(team1, team2, ball);
        isRunning = false;
        coach.stop();
    }

    public void update() {
       if(isRunning) {
            coach.update();
        }
    }
}
