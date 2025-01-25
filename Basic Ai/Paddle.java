import java.awt.*;// needed for color

public class Paddle {
    private int height, x, y;
    private double speed;
    private Color color;

    static final int PADDLE_WIDTH = 15;

    /**
     * A paddle is a rectangle that can move up and down that interacts with the ball
     * @param x the x position of the paddle
     * @param y the y position to start drawing the paddle
     * @param height the height of the paddle
     * @param speed the speed the paddle can move each frame
     * @param color the color of the paddle
     */
    public Paddle(int x, int y, int height, double speed, Color color){
        this.x = x;
        this.y = y;
        this.height = height;
        this.speed = speed;
        this.color = color;
    }
    public int getHeight(){
        return height;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getBottomY(){
        return y + height;
    }
    public void setBottomY(int a){
        setY(a - height);
    }
    public void paint(Graphics g){
        // set the brush color to the ball color
        g.setColor(color);

        // paint the ball at x, y with a width and height of the ball size
        g.fillRect(x, y, PADDLE_WIDTH, height);
    }

    /**
     * move the paddle towards this y position every fram(centered)
     * @param moveToY position the paddle is centered on
     */
    public void moveTowards(int moveToY){
        // find the location of the center of the paddle
        int centerY = y + height / 2;

        // determine if we need to move more than the speed away from where we are now
        if(Math.abs(centerY - moveToY) > speed){
            if(centerY > moveToY){
                // move the paddle up by speed
                y -= speed;
            }
            if(centerY < moveToY){
                // move the paddle down by speed
                y += speed;
            }
        }
    }
    public void increaseSpeed(){
        speed += 0.5;
    }
    public int getCenterY(){
        return y + height / 2;
    }
    public int getX(){
        return x;
    }
    /**
     * 
     * @param b the ball we are checking for a collision with
     * @return true if collision is detected
     */
    public boolean checkCollision(Ball b){
        int rightX = x + PADDLE_WIDTH;
        int bottomY = y + height;
        
        // check if ball is between the x values
        if(b.getX() > (x - b.getSize()) && b.getX() < rightX){
            // check if ball is between the y values
            if(b.getY() > y && b.getY() < bottomY){
                return true;
            }
        }

        return false;
    }
}
