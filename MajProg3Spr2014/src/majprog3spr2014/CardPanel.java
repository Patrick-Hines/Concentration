/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majprog3spr2014;

import javax.swing.JPanel;

/**
 *
 * @author Patrick Hines
 */
public class CardPanel extends JPanel {

	//Declare class properties

	//Constructor
		//Instantiate 2D Array to hold 8x8 cards
		//Display cards to the screen

	//Method to pull in image filepaths based on dimensions 
		//shuffle deck

	//Method to switch on the active cards based on dimensions given by GamePanel

	//Inner class for panel clicks
		//actionPerformed()
			//Store clicked card reference in cardReference1 if flippedCards = 0, cardReference 2 if flippedCards = 1;
			//Set flipped to true
			//Increment flippedCards

			//If "flippedCards" = 2, then send both "cardReference" object to compareCards() method.
				//If compareCards() returns true, mark cardReference1 and 2 as "matched"

			//If no other cards are "matched = false", then the game is over.

	//Method to check for matched cards
		//Compare the imagepaths of the cards.
		//Returns boolean

    /**
     *
     * @param input Simple method to test output during development
     */
    static public void test(String input) {
        System.out.println(input);
    }
}