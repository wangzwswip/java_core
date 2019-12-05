import javax.swing.*;
import java.awt.*;

public class CalculatorTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            JFrame frame = new SliderFrame();
            frame.setTitle("Calculate-test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
/*
class CalculateFrame extends JFrame {
    public CalculateFrame() {
        add(new CalculatorPanel());
        pack();
    }
}
 */