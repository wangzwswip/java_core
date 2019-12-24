import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Shows animated bouncing balls.
 * @version 1.34
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
/**
 * The frame wih panel and buttons.
 */
class BounceFrame extends JFrame {
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 5;

    /**
     * Constructs the frame with the component for showing the bouncing ball and Start and Close buttons
     */
    public BounceFrame() {
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel,"Start",event -> addBall());
        addButton(buttonPanel,"Close",event -> System.exit(0));
        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }

    /**
     * Adds a button to a container
     * @param c the container
     * @param title the button title
     * @param listener the action listener for the button
     */
    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * Adds a bouncing ball to the panel and makes it bounce 1,000 times.
     */
    public void addBall() {
        Ball ball = new Ball();
        comp.add(ball);
        Runnable r = () -> {
            try {
                for (int i = 1; i <= STEPS; i++) {
                    ball.move(comp.getBounds());
                    comp.repaint();
                    Thread.sleep(DELAY);
                }
            }
            catch (InterruptedException e) {}
        };
        Thread t = new Thread(r);
        t.start();
    }
}