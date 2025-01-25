import java.awt.*;

public class Ball {
    
    // decare instance variables
    private int x, y, cx, cy, speed, size;
    private Color color;

    static final int MAX_SPEED = 20;
    // 
    /**
     * ball constructor assings values to instance variables
     * 
     * @param x the horizontal location of the upper left corner of the ball
     * @param y the vertical location of the upper left corner of the ball
     * @param cx the change in x per frame
     * @param cy the change in y per frame
     * @param speed the speed of the ball
     * @param color the color of the ball
     * @param size the size of the ball
     */

    public Ball(int x, int y, int cx, int cy, int speed, Color color, int size){
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.speed = speed;
        this.color = color;
        this.size = size;
    }

    public Ball(Ball b){
        this.x = b.x;
        this.y = b.y;
        this.cx = b.cx;
        this.cy = b.cy;
        this.speed = b.speed;
        this.color = Color.WHITE;
        this.size = b.size;
    }

    public void paint(Graphics g){
        // set the brush color to the ball color
        g.setColor(color);

        // paint the ball at x, y with a width and height of the ball size
        g.fillOval(x, y, size, size);
    }

    /**
     * Adds the cx and cy to the balls current x and y positions, moving the ball accross the screen
     */
    public void moveBall(){
        x += cx;
        y += cy;
    }

    public void increaseSpeed(){
        // make sure current speed is less than max speed before incrementing
        if(speed < MAX_SPEED){
            speed++;

            if(cx > 0)
            cx = speed;
            else if( cx < 0)
            cx = speed * -1;
            if(cy > 0)
            cy = speed;
            else if(cy < 0)
            cy = speed * -1;
        }
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setCX(int cx){
        this.cx = cx;
    }
    public void setCY(int cy){
        this.cy = cy;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public int getSize(){
        return size;
    }
    /**
     * Detect collision with screen borders and reverse direction
     * @param top the y value of the top of the screen
     * @param bottom the y value of the bottom of the screen
     */
    public void bounceOffEdges(int top, int bottom){
        // if the y value is at the bottom of the screen
        if(y > bottom - 20){
            reverseY();
        }
        // if y value is at top of screen
        else if(y < top + size){
            reverseY();
        }
    }
    /**
     * reverses the balls change in y value
     */
    public void reverseY(){
        cy *= -1;
    }
    /**
     * reverses the balls change in x value
     */
    public void reverseX(){
        cx *= -1;
    }
}
