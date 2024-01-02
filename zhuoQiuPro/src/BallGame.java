import java.awt.*;
import javax.swing.*;
public class BallGame  extends JFrame{

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");

    double x = 70;
    double y = 70;

    double degree = 3.14/3; // 弧度 3.14 = 180degree, so 60 degree



    public void paint(Graphics g){
        System.out.println("Window is being drawn");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);

        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);

        // 碰到上下边界
        if (y>501-60|| y<60){
            degree = - degree;
        }
        // 碰到左右边界
        if (x>856-60 || x<60){
            degree = 3.14-degree;
        }
    }

    // create the window
    void launchFrame(){
        setSize( 856, 501);
        setLocation(100,100);
        setVisible(true);


        // realize ball's animation by repain the window 40 times/second
        while (true) {
            repaint();
            try {
                Thread.sleep(40); // 1s= 1000ms; so 1000/40 = 25 times.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        System.out.println("Starting the ball game");

        BallGame game = new BallGame();
        game.launchFrame();

    }
}

