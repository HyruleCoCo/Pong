import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class PongGame extends JPanel implements MouseMotionListener{
    // declare the size of the window
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball gameBall;
    private Paddle userPaddle, pcPaddle;
    private int userMouseY;
    private int userScore, pcScore;
    static int bounceCount = 0;

    public PongGame(){
        gameBall = new Ball(300, 200, 3, 3, 5, Color.YELLOW, 10);
        userPaddle = new Paddle(10, 200, 75, 5, Color.BLUE);
        pcPaddle = new Paddle(610, 200, 75, 5, Color.RED);

        userMouseY = 0;
        userScore = 0;
        pcScore = 0;

        addMouseMotionListener(this);
    }

    /**
     * Updates and draws all the graphics on the screen
     */
    public void paintComponent(Graphics g){
        // draw the background, set color to BLACK and fill in a rectangle
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // possibly add a border drawn using g.drawRect
        g.setColor(Color.WHITE);
        g.drawRect(5, 3, 625, WINDOW_HEIGHT - 10);

        // update score
        g.setColor(Color.WHITE);
        g.drawString("Score - User[ " + userScore + " ]\t PC[ " + pcScore + " ]", 250, 20);
        // draw the components
        gameBall.paint(g);
        userPaddle.paint(g);
        pcPaddle.paint(g);
    }

    /**
     * this function will update ball position, paddle positions, and more frame by frame
     */
    public void gameLogic(){
        // move the ball one frame
        gameBall.moveBall();

        // edge check/bounce
        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);

        // move the paddle towards where the mouse is
        userPaddle.moveTowards(userMouseY);

        // move the pc paddle towards the balls y position
        pcPaddle.moveTowards(gameBall.getY());

        if(pcPaddle.checkCollision(gameBall) || userPaddle.checkCollision(gameBall)){
            gameBall.reverseX();

            bounceCount++;

            if(userPaddle.checkCollision(gameBall)){
                gameBall.setX(userPaddle.getX() + Paddle.PADDLE_WIDTH + 1);
                if(gameBall.getY() > userPaddle.getCenterY() + (userPaddle.getHeight() / 4)){
                    gameBall.reverseY();
                }
                else if(gameBall.getY() < userPaddle.getCenterY() - (userPaddle.getHeight() / 4)){
                    gameBall.reverseY();
                }
            }

            if(pcPaddle.checkCollision(gameBall)){
                gameBall.setX(pcPaddle.getX() - 10);
                if(gameBall.getY() > pcPaddle.getCenterY() + (pcPaddle.getHeight() / 4)){
                    gameBall.reverseY();
                }
                else if(gameBall.getY() < pcPaddle.getCenterY() - (pcPaddle.getHeight() / 4)){
                    gameBall.reverseY();
                }
            }
        }

        if(bounceCount == 5){
            gameBall.increaseSpeed();
            userPaddle.increaseSpeed();
            pcPaddle.increaseSpeed();

            bounceCount = 0;
        }
        // check if someone won or lost
        if(gameBall.getX() < 0){
            // user has lost
            pcScore++;
            reset();
        }
        else if(gameBall.getX() > WINDOW_WIDTH){
            // pc has lost
            userScore++;
            reset();
        }

        // make sure paddles stay on screen
        if(userPaddle.getY() < 5){
            userPaddle.setY(0);
        }
        else if(userPaddle.getBottomY() > WINDOW_HEIGHT - 10){
            userPaddle.setBottomY(WINDOW_HEIGHT - 10);
        }
        
        if(pcPaddle.getY() < 5){
            pcPaddle.setY(0);
        }
        else if(pcPaddle.getBottomY() > WINDOW_HEIGHT - 10){
            pcPaddle.setBottomY(WINDOW_HEIGHT - 10);
        }
    }

    public void reset(){
        // reset ball
        gameBall.setX(300);
        gameBall.setY(200);
        gameBall.setSpeed(0);
        gameBall.setCX(0);
        gameBall.setCY(0);
        // pause for a second
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        gameBall.setSpeed(3);
        gameBall.setCX(3);
        gameBall.setCY(3);
    }
    
   @Override
   public void mouseMoved(MouseEvent e){
    userMouseY = e.getY();
   }

   @Override
   public void mouseDragged(MouseEvent e){
    // will not be used
   }
}
