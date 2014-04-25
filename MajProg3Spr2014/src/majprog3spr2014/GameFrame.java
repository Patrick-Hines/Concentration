/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majprog3spr2014;

import javax.swing.JFrame;

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

    CardPanel gameboard;

    JComboBox levelSelectionCBox;

    JButton newGameBtn;
    JButton closeBtn;

    public GameFrame() {

    	//Instantiate all components

    	//Set appropriate layouts

    }


    /**
     *
     * @param input Simple method to test output during development
     */
    static public void test(String input) {
        System.out.println(input);
    }

}
