import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.*;

/**
 * A test for change look-and-fell.
 * @version 1.3
 * @author ww
 */
public class PerformTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            JFrame frame = new PlatFrame();
            frame.setTitle("Look-and-feel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame with a button panel for changing look-and-feel
 */
class PlatFrame extends JFrame {
    private JPanel buttonPanel;
    public PlatFrame() {
        buttonPanel = new JPanel();
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos)
            makeButton(info.getName(),info.getClassName());
        add(buttonPanel);
        pack();
    }

    /**
     * Makes a button to change the pluggable look-and-feel
     * @param name the button name
     * @param className the name of the look-and-feel class
     */
    private void makeButton(String name,String className) {
        //add button to panel
        JButton button = new JButton(name);
        buttonPanel.add(button);
        //set button action
        button.addActionListener(event->{
            try
            {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}