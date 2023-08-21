package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        
        setTitle("Main Menu");
        
        setSize(300, 200);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        JButton startGameButton = new JButton("Start game");
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartGameMenu();
            }
        });

        
        JButton optionsButton = new JButton("Options");
        optionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OptionsMenu();
            }
        });

        
        JButton exitGameButton = new JButton("Exit game");
        exitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startGameButton);
        buttonPanel.add(optionsButton);
        buttonPanel.add(exitGameButton);

       
        add(buttonPanel);

        
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }

    private class OptionsMenu extends JFrame {

        public OptionsMenu() {
            
            setTitle("Options");
            
            setSize(300, 600);
            
            setLocationRelativeTo(null);
            
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            
            JPanel levelSelectionPanel = new JPanel();
            levelSelectionPanel.setBorder(BorderFactory.createTitledBorder("Level Selection"));
            String[] levelOptions = {"Easy", "Medium", "Hard"};
            JComboBox<String> levelSelection = new JComboBox<>(levelOptions);
            levelSelectionPanel.add(levelSelection);

           
            JPanel volumePanel = new JPanel();
            volumePanel.setBorder(BorderFactory.createTitledBorder("Volume"));
            JSlider volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
            volumeSlider.setMajorTickSpacing(25);
            volumeSlider.setMinorTickSpacing(5);
            volumeSlider.setPaintTicks(true);
            volumeSlider.setPaintLabels(true);
            volumePanel.add(volumeSlider);

            
            JPanel colorPanel = new JPanel();
            colorPanel.setBorder(BorderFactory.createTitledBorder("Color"));
            String[] colorOptions = {"Red", "Blue", "Green"};
            JComboBox<String> colorSelection = new JComboBox<>(colorOptions);
            colorPanel.add(colorSelection);

            
            JButton saveButton = new JButton("Back to main menu");
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MainMenu();
                }
            });

            
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.add(levelSelectionPanel);
            mainPanel.add(volumePanel);
            mainPanel.add(colorPanel);
            mainPanel.add(saveButton);

            
            add(mainPanel);

            
            setVisible(true);
        }
    }
    
    private class StartGameMenu extends JFrame {
        public StartGameMenu() {
            
            setTitle("Start Game");
            
            setSize(300, 200);
            
            setLocationRelativeTo(null);
            
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel teamSelectionPanel = new JPanel();
            teamSelectionPanel.setBorder(BorderFactory.createTitledBorder("NBA Teams"));
            String[] teamOptions = {"Los Angeles Lakers", "Boston Celtics", "Golden State Warriors", "Chicago Bulls", "Detroit Pistons"};
            JComboBox<String> favoriteTeamSelection = new JComboBox<>(teamOptions);
            JComboBox<String> opponentTeamSelection = new JComboBox<>(teamOptions);
            teamSelectionPanel.add(new JLabel("Home team: "));
            teamSelectionPanel.add(favoriteTeamSelection);
            teamSelectionPanel.add(new JLabel("Away team: "));
            teamSelectionPanel.add(opponentTeamSelection);

            JButton playButton = new JButton("Play Game");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String favoriteTeam = (String) favoriteTeamSelection.getSelectedItem();
                    String opponentTeam = (String) opponentTeamSelection.getSelectedItem();
                    System.out.println("The game will be displayed here");
                }
            });
          
            JPanel mainPanel = new JPanel();
            mainPanel.add(teamSelectionPanel);
            mainPanel.add(playButton);
      
            add(mainPanel);
            
            setVisible(true);
        }
    }
}

