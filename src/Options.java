import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

abstract class Options extends JFrame implements ActionListener{
    static void Options(){
        JFrame frame = new JFrame("Options");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        
        JLabel lbl1 = new JLabel("Select Difficulty:");
        JLabel lbl2 = new JLabel("Enter maximum score to win:");
        JTextField MaxScore = new JTextField();
        String difficulty[] = {"Easy", "Medium", "Hard"};
        JComboBox jc = new JComboBox(difficulty);
        JButton sbmt = new JButton("Sumbit");
        JLabel valid = new JLabel("");

        
        panel.add(lbl1);
        panel.add(jc);
        panel2.add(lbl2);
        panel2.add(MaxScore);
        panel2.add(valid);
        panel3.add(sbmt);
        MaxScore.setMaximumSize(new Dimension(85, 20));
        //panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
        MaxScore.setAlignmentX(Component.CENTER_ALIGNMENT);
        valid.setAlignmentX(Component.CENTER_ALIGNMENT);
        valid.setForeground(Color.RED);
        panel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(1000, 100));
        panel.setMaximumSize(new Dimension(1500, 100));
        panel2.setPreferredSize(new Dimension(1000, 100));
        panel2.setMaximumSize(new Dimension(1500, 100));
        panel3.setPreferredSize(new Dimension(1000, 100));
        panel3.setMaximumSize(new Dimension(1500, 100));
        panel.setBorder(BorderFactory.createTitledBorder("Difficulty"));
        panel2.setBorder(BorderFactory.createTitledBorder("Max Score"));
        panel3.setBorder(BorderFactory.createTitledBorder("Submit"));
        

        frame.getContentPane().add(panel);
        frame.getContentPane().add(panel2);
        frame.getContentPane().add(panel3);
        frame.setSize(550, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        sbmt.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                int score=Integer.parseInt(MaxScore.getText()); 
                AIPaddle.setDifficulty(jc.getSelectedItem().toString());
                GamePanel.setScore(score);
                frame.dispose();
            } 
        } );

        MaxScore.addKeyListener(new KeyAdapter() { 
            @Override
            public void keyPressed(KeyEvent e) { 
                
                try{
                    int i = Integer.parseInt(MaxScore.getText()+e.getKeyChar());
                    valid.setText("");
                }
                catch (NumberFormatException e1){
                    valid.setText("Number Only");
                }
            } 
        } );

    }
}
