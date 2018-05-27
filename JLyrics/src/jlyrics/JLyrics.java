/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package jlyrics;

import javax.swing.*;

/**
 * @author mark
 */
public class JLyrics 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        final int FRAME_WIDTH = 350;
        final int FRAME_HEIGHT = 400;
        JFrame sk8erboi;
        sk8erboi = new JFrame("Sk8er Boi");
        sk8erboi.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        sk8erboi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lyrics;
        lyrics = new JLabel("<html>He was a skater boy<br/>" +
                "She said see you later boy<br/>" +
                "He wasn't good enough for her<br/>" +
                "She had a pretty face<br/>" +
                "But her head was up in space<br/>" +
                "She needed to come back down to earth<br/>" +
                "Five years from now<br/>" +
                "She sits at home<br/>" +
                "Feeding the baby she's all alone<br/>" +
                "She turns on TV<br/>" +
                "Guess who she sees<br/>" +
                "Skater boy rockin' up MTV</html>", SwingConstants.CENTER);
        
        sk8erboi.add(lyrics);
        sk8erboi.setVisible(true);
        
    }
}
