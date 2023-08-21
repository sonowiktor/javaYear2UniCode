package controller;

import model.Court;

public class CourtController {
    private Court court;

    public CourtController(Court court) {
        this.court = court;
    }

    public void update(int gameWidth, int gameHeight) {
        // Do nothing, the court does not need to be updated in this example.
    }
}
