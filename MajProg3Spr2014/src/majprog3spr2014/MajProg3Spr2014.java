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
public class MajProg3Spr2014 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GameFrame window = new GameFrame();

        window.setTitle("Concentration");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setSize(525, 620);
        window.setVisible(true);

    }

    /**
     *
     * @param input Simple method to test output during development
     */
    static public void test(String input) {
        System.out.println(input);
    }

}
