/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majprog3spr2014;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Patrick Hines
 */
public class GameFrame extends JFrame {

    JLabel turnLbl;
    JLabel turnNumber;
    JLabel timeLbl;
    JLabel timeNumber;
    JLabel fastestTimeLbl;
    JLabel fastestTimeNumber;

    JPanel turnPnl;
    JPanel timePnl;
    JPanel fastestTimePnl;
    JPanel commandsPnl;
    JPanel statsContainer;

    CardPanel gameboard;

    JComboBox levelSelectionCBox;

    JButton newGameBtn;
    JButton closeBtn;

    int userRows;
    int userCols;

    public GameFrame() {

        userRows = 2;
        userCols = 3;

        //Instantiate all components
        turnLbl = new JLabel("Turn: ");
        turnNumber = new JLabel("2014");
        timeLbl = new JLabel("Current Time:");
        timeNumber = new JLabel("0:00:00");
        fastestTimeLbl = new JLabel("Fastest Time: ");
        fastestTimeNumber = new JLabel("0:00:00");

        turnPnl = new JPanel();
        timePnl = new JPanel();
        fastestTimePnl = new JPanel();
        commandsPnl = new JPanel();
        statsContainer = new JPanel();

        gameboard = new CardPanel();

        //Queue in the options for levelSelection
        String[] tempLevel = new String[6];
        for (int i = 0; i < 6; i++) {
            tempLevel[i] = "Level " + (i + 1);
        }

        levelSelectionCBox = new JComboBox(tempLevel);
        levelSelectionCBox.addActionListener(new LevelListener());

        newGameBtn = new JButton("New Game");
        closeBtn = new JButton("Close Window");

        newGameBtn.addActionListener(new ButtonListener());
        closeBtn.addActionListener(new ButtonListener());

        //Set appropriate layouts
        turnPnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        timePnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        fastestTimePnl.setLayout(new FlowLayout(FlowLayout.CENTER));

        statsContainer.setLayout(new GridLayout(1, 3));

        commandsPnl.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.setLayout(new BorderLayout());

        //Add items to the screen
        turnPnl.add(turnLbl);
        turnPnl.add(turnNumber);
        timePnl.add(timeLbl);
        timePnl.add(timeNumber);
        fastestTimePnl.add(fastestTimeLbl);
        fastestTimePnl.add(fastestTimeNumber);

        statsContainer.add(turnPnl);
        statsContainer.add(timePnl);
        statsContainer.add(fastestTimePnl);

        commandsPnl.add(levelSelectionCBox);
        commandsPnl.add(newGameBtn);
        commandsPnl.add(closeBtn);

        this.add(statsContainer, BorderLayout.NORTH);
        this.add(gameboard, BorderLayout.CENTER);
        this.add(commandsPnl, BorderLayout.SOUTH);

    }

    //TODO: Add inner class for button listeners.
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent eventObject) {

            JButton referenceBtn = (JButton) eventObject.getSource();

            String referenceText = referenceBtn.getText();

            if (referenceText.equalsIgnoreCase("Close Window")) {
                System.exit(0);

            } else if (referenceText.equalsIgnoreCase("New Game")) {
                //Send dimensions over to gameboard object based on the levelSelectionCBox choice.
                gameboard.setRows(userRows);
                gameboard.setCols(userCols);
                gameboard.activateCards();

            }

        }

    }

    private class LevelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent eventObject) {

            JComboBox referenceCBox = (JComboBox) eventObject.getSource();

            String userOption = (String) referenceCBox.getSelectedItem();
            if (userOption.equals("Level 1")) {
                userRows = 2;
                userCols = 3;
            } else if (userOption.equals("Level 2")) {
                userRows = 2;
                userCols = 4;
            } else if (userOption.equals("Level 3")) {
                userRows = 4;
                userCols = 4;
            } else if (userOption.equals("Level 4")) {
                userRows = 4;
                userCols = 6;
            } else if (userOption.equals("Level 5")) {
                userRows = 6;
                userCols = 6;
            } else if (userOption.equals("Level 6")) {
                userRows = 8;
                userCols = 8;
            }

        }
    }

    /**
     *
     * @param input Simple method to test output during development
     */
    static public void test(String input) {
        System.out.println(input);
    }

}
