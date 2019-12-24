import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * The component that draws the balls.
 * @version 1.34
 */
public class BallComponent extends JPanel {
    private static final int DEFAUTL_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    private java.util.List<Ball> balls = new ArrayList<>();

    /**
     * Add a ball to the component.
     * @param b the ball to add
     */
    public void add(Ball b) {
        balls.add(b);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//erase background
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }
    public Dimension getPreferredSize() {
        return new Dimension(DEFAUTL_WIDTH,DEFAULT_HEIGHT);
    }
}
