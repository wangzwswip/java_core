import java.awt.*;
import javax.swing.*;

/**
 * @version 1.33 2019
 * @author wzw
 */
public class SizedFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            JFrame frame = new SizedFrame();
            frame.setTitle("SizedFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class SizedFrame extends JFrame {
    public SizedFrame() {
        //get screen dimensions
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        //set Frame width,height and let platform pick screen location
        setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);
        //set frame icon
        Image img = new ImageIcon("icon.gif").getImage();
        setIconImage(img);
    }
}
