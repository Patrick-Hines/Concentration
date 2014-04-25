/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majprog3spr2014;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

    public GameFrame() {

        //Instantiate all components
        turnLbl = new JLabel("Turn: ");
        turnNumber = new JLabel("0:00:00");
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

        levelSelectionCBox = new JComboBox();

        newGameBtn = new JButton("New Game");
        closeBtn = new JButton("Close Window");

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
    /**
     *
     * @param input Simple method to test output during development
     */
    static public void test(String input) {
        System.out.println(input);
    }

}
