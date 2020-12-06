import java.awt.*;
import javax.swing.*;

class Options extends JFrame {
    Options(){
        JFrame frame = new JFrame("Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        JLabel lbl1 = new JLabel("Select Difficulty:");
        JLabel lbl2 = new JLabel("Enter maximum score to win:");
        JTextField MaxScore = new JTextField();
        String difficulty[] = {"Easy", "Medium", "Hard"};
        JComboBox jc = new JComboBox(difficulty);
        
        panel.add(lbl1);
        panel.add(jc);
        panel2.add(lbl2);
        panel2.add(MaxScore);
        MaxScore.setMaximumSize(new Dimension(85, 20));
        //panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(1000, 100));
        panel.setMaximumSize(new Dimension(1500, 100));
        panel2.setPreferredSize(new Dimension(1000, 100));
        panel2.setMaximumSize(new Dimension(1500, 100));
        panel.setBorder(BorderFactory.createTitledBorder("Difficulty"));
        panel2.setBorder(BorderFactory.createTitledBorder("Max Score"));
        frame.getContentPane().add(panel);
        frame.getContentPane().add(panel2);
        frame.setSize(550, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
