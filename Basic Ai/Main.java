// this project is made thanks to the help of kevinsguide.com
// https://kevinsguides.com/guides/code/java/javaprojs/simple-2d-pong/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
    
    // declare and initialize the frame
    static JFrame f = new JFrame("Pong");

    public static void main(String[] args){
        // make it so the program exists on close button click
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // the size of the game will be 480x640, so the size of the JFrame needs to be slightly larger
        f.setSize(650, 495);

        // make the new pong game
        PongGame game = new PongGame();
        
        // add the game to the JFrame
        f.add(game);

        // show the window
        f.setVisible(true);
        
        // create a new timer from java.swing
        Timer timer = new Timer(33, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // game logic
                game.gameLogic();
                
                // repaint the screen
                game.repaint();
            }
        });

        // start the timer
        timer.start();
    }

    
}
