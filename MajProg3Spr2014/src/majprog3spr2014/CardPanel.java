/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majprog3spr2014;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Patrick Hines
 */
public class CardPanel extends JPanel {

    //Declare class properties
    private Card[][] cards;
    private int rows;
    private int cols;

    Card selectedCard1;
    Card selectedCard2;

    private int flippedCards;

    int totalMatched;
    boolean gameOver;

    Timer timer;

    //Constructor
    public CardPanel() {
        rows = cols = 8;
        cards = new Card[rows][cols];

        flippedCards = 0;
        gameOver = false;

        timer = new Timer(1000, new TimerListener());

        //Load in the card objects
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cards[i][j] = new Card();

            }
        }

        //Display cards to the screen
        this.setLayout(new GridLayout(8, 8, 1, 1));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.add(cards[i][j]);
            }
        }

    }

    //Method to pull in image filepaths based on dimensions
    public void setCardImages(String[] filepaths) {

        //Create a 2D Array of filenames
        String[][] tempArr = new String[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tempArr[i][j] = filepaths[index];
                index++;
            }
        }

        //Shuffle the array 5 times
        for (int x = 0; x < 5; x++) {
            Random random = new Random();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    int tempIndex = random.nextInt(tempArr.length);
                    String temp = tempArr[i][j];
                    tempArr[i][j] = tempArr[i][tempIndex];
                    tempArr[i][tempIndex] = temp;
                }

            }
        }

        //Copy the 2D Array of filenames to the main Card array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cards[i][j].setPropertyPath(tempArr[i][j]);
                cards[i][j].repaint();
            }
        }
    }

    //Method to switch on the active cards based on dimensions given by GamePanel
    public void activateCards() {

        //Clear out all cards on the field
        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                cards[k][l].setActive(false);
                cards[k][l].repaint();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                cards[i][j].setActive(true);
                cards[i][j].addMouseListener(new PanelListener());
                cards[i][j].repaint();
            }
        }
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent eventObject) {

            selectedCard1.setFlipped(false);
            selectedCard1.repaint();

            selectedCard2.setFlipped(false);
            selectedCard2.repaint();

            timer.stop();

        }

    }

    //Inner class for panel clicks
    private class PanelListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent eventObject) {
            test("Hi");
            Card referenceCard = (Card) eventObject.getSource();

            //Flip the card
            referenceCard.setFlipped(true);
            referenceCard.repaint();

            //Determine whether this is the first or second flipped card.
            if (flippedCards == 0) {
                selectedCard1 = referenceCard;
                flippedCards++;

            } else if (flippedCards == 1) {
                selectedCard2 = referenceCard;

                //Create timer
                timer.start();

                //Check for a matched set
                if (isMatchedSet(selectedCard1, selectedCard2)) {
                    selectedCard1.setMatched(true);
                    selectedCard2.setMatched(true);

                    selectedCard1.repaint();
                    selectedCard2.repaint();

                    //Check if this was the final set.
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {

                            if (cards[i][j].isMatched()) {
                                totalMatched++;
                            }

                        }
                    }

                    //Declare game over if all cards are matched
                    if (totalMatched == (rows * cols)) {
                        gameOver = true;
                    }

                    if (gameOver) {
                        JOptionPane.showMessageDialog(null, "You win! Congratulations!");
                        System.exit(0);
                    }
                } else {
                    selectedCard1.setFlipped(true);
                    selectedCard2.setFlipped(true);

                    selectedCard1.repaint();
                    selectedCard2.repaint();
                }

                //Reset flippedCards
                flippedCards = 0;
            }
            //Reset totalMatched
            totalMatched = 0;

            //Flip the card back over
//            referenceCard.setFlipped(false);
//            referenceCard.repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    public boolean isMatchedSet(Card card1, Card card2) {
        return card1.getPropertyPath().equalsIgnoreCase(card2.getPropertyPath());
    }

    /**
     *
     * @param input Simple method to test output during development
     */
    static public void test(String input) {
        System.out.println(input);
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the cols
     */
    public int getCols() {
        return cols;
    }

    /**
     * @param cols the cols to set
     */
    public void setCols(int cols) {
        this.cols = cols;
    }
}
