import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Action class test
 * @version 1.0
 * @author wzw
 */
public class ActionRun {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            JFrame frame = new ActionFrame();
            frame.setTitle("Look-and-feel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame with a panel that demonstrates color change actions
 */
class ActionFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ActionFrame() {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        buttonPanel =new JPanel();

        //Define actions
        Action yellowAction = new ColorAction("Yellow",new ImageIcon("yellow-ball.gif"),Color.YELLOW);
        Action blueAction = new ColorAction("Blue", new ImageIcon("blue-ball.gif"),Color.BLUE);
        Action redAction = new ColorAction("Red", new ImageIcon("red-ball.gif"),Color.RED);

        //Add buttons for these actions
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        //add panel to frame
        add(buttonPanel);

        //associate the Y,B AND R keys with names
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"),"panel.red");

        //associate the names with actions
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow",yellowAction);
        amap.put("panel.blue",blueAction);
        amap.put("panel.red",redAction);
    }
    class ColorAction extends AbstractAction {
        /**
         * Constructs a color action
         * @param name the name to show on the button
         * @param icon the icon to display on the button
         * @param c the background color
         */
        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME,name);
            putValue(Action.SMALL_ICON,icon);
            putValue(Action.SHORT_DESCRIPTION,"Set panel  to "+name.toLowerCase());
            putValue("color",c);
        }
        public void actionPerformed(ActionEvent event) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}
