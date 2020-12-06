import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.WindowConstants;

import javax.swing.SwingUtilities;

public abstract class Main implements ActionListener{
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        JPanel panel = new JPanel();
        JButton btn1 = new JButton("Single-player");
        JButton btn2 = new JButton("Multi-player");
        JButton btn3 = new JButton("Options");

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(1000, 100));
        panel.setMaximumSize(new Dimension(1500, 100));
        panel.setBorder(BorderFactory.createTitledBorder("Main Menu"));
        frame.getContentPane().add(panel);
        frame.setSize(550, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        btn1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                int mode = 1;
                GameFrame frame1 = new GameFrame(mode);
                frame.dispose();
            } 
          } );

        btn2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                int mode = 2;
                GameFrame frame1 = new GameFrame(mode);
                frame.dispose();
            } 
          } );

          btn3.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                Options frame1 = new Options();
                frame.dispose();
            } 
          } );
    }
}

