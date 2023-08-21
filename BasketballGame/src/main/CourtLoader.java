package main;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import model.Court;
import view.CourtView;
import controller.CourtController;

public class CourtLoader {

    public static void main(String[] args) {
        // Create the court
        Court court = new Court(500, 500, 0, 0);

        // Create the view and the controller for the court
        CourtView courtView = new CourtView(court);
        CourtController courtController = new CourtController(court);

        // Create a JFrame to display the court
        JFrame frame = new JFrame("Court");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Set the content of the frame to be the court view
        frame.setContentPane(courtView);

        // Set the size of the frame to fit the court view
        frame.pack();

        // Make the frame visible
        frame.setVisible(true);
        frame.setSize(new Dimension(500, 500));
    }
}

