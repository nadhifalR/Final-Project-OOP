import java.awt.*;
import javax.swing.*;

class Options extends JFrame {
    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel lbl1 = new JLabel("Select Difficulty:");
        //JLabel lbl2 = new JLabel("Your Score:");
        JLabel score = new JLabel("(route this label)");
        String difficulty[] = {"Easy", "Medium", "Hard"};
        JComboBox jc = new JComboBox(difficulty);
        
        panel.add(lbl1);
        panel.add(jc);
        //panel.add(lbl2);
        panel2.add(score);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(1000, 100));
        panel.setMaximumSize(new Dimension(1500, 100));
        panel.setBorder(BorderFactory.createTitledBorder("Options"));
        panel2.setBorder(BorderFactory.createTitledBorder("Your Score"));
        frame.getContentPane().add(panel);
        frame.getContentPane().add(panel2);
        frame.setSize(550, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
