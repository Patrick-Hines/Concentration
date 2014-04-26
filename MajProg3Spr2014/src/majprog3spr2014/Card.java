/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majprog3spr2014;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Patrick Hines
 */
public class Card extends JPanel {

    //Create class properties
    private boolean flipped;
    private boolean matched;
    private boolean active;

    private String propertyPath;

    private JLabel imageLbl;

    private ImageIcon image;

    //Make Constructor
    public Card() {

        flipped = active = matched = false;

        imageLbl = new JLabel();

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(imageLbl);

    }

    //Repaint method
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Check if card is active or not
        if (active) {
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, 64, 64);

            //Check if flipped or not
            if (flipped) {

                //Set the icon to the JLabel
                super.paintComponent(g);
                imageLbl.setIcon(image);

                //Check if matched or not
                if (matched) {
                    super.paintComponent(g);
                    g.setColor(Color.GREEN);
                    g.fillRect(0, 0, 64, 64);
                }
            }

        } else { //Means that the card is disabled
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, 64, 64);
        }

    } 

    /**
     *
     * @param input Simple method to test output during development
     */
    static public void test(String input) {
        System.out.println(input);
    }

    /**
     * @return the flipped
     */
    public boolean isFlipped() {
        return flipped;
    }

    /**
     * @param flipped the flipped to set
     */
    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    /**
     * @return the matched
     */
    public boolean isMatched() {
        return matched;
    }

    /**
     * @param matched the matched to set
     */
    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the propertyPath
     */
    public String getPropertyPath() {
        return propertyPath;
    }

    /**
     * @param propertyPath the propertyPath to set
     */
    public void setPropertyPath(String propertyPath) {
        this.propertyPath = propertyPath;
        image = new ImageIcon(propertyPath);
        repaint();
    }

}
