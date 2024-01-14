import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class HandCricket {
    private static int sum1 = 0, sum2 = 0;
    private static Random r = new Random();
    private static int n = 0;
    private static int i = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hand Cricket");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);
        frame.add(panel);
        placeComponents(panel, frame);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);
        JLabel inf=new JLabel("Runs should be in between 1-6");
        inf.setBounds(10,10,200,25);
        inf.setForeground(Color.red);
       
        panel.add(inf);
        JLabel userLabel = new JLabel("Enter your number:");
        userLabel.setBounds(10, 40, 200, 25);
        userLabel.setForeground(Color.black);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 40, 165, 25);
        panel.add(userText);

        JButton play = new JButton("Submit");
        play.setBounds(100, 80, 80, 25);
        play.setBorderPainted(true);
        play.setForeground(Color.blue);
        panel.add(play);

        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(userText.getText());
                userText.setText(""); 
                if (a > 6 || a<1) {
                    JOptionPane.showMessageDialog(null, "Number should be in 1-6");
                    return;
                }
                int b = 1+r.nextInt(6);
                if (a == b) {
                    JOptionPane.showMessageDialog(null, "Out! Final scores are: " + ((sum1 += a) - a) + " " + ((sum2 += b) - b));
                    displayWinner(frame);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Scores are: " + (sum1 += a) + " " + (sum2 += b));
                }
                i++;
                if (i == n) {
                    displayWinner(frame);
                }
            }
        });
    }

    private static void resetGame() {
        sum1 = 0;
        sum2 = 0;
        i = 0;
    }

    private static void displayWinner(JFrame frame) {
        if (sum1 > sum2) {
            JOptionPane.showMessageDialog(null, "You won");
        } else if (sum1 < sum2) {
            JOptionPane.showMessageDialog(null, "System won");
        } else {
            JOptionPane.showMessageDialog(null, "Tied");
        }
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Play Again?","Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            resetGame();
        } else {
            frame.dispose();
        }
    }
}
