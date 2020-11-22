import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.WindowConstants;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }
}

class UserInterface implements Runnable {

    private JFrame frame;
    
    public UserInterface() {
    }

    @Override
    public void run() {
        frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(1080, 720));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JButton button = new JButton("Click!");
        container.add(button);
        JLabel text = new JLabel("Text.");
        container.add(text);
    }

    public JFrame getFrame() {
        return frame;
    }
}

