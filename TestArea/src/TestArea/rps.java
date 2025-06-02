package TestArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class rps {
    public rps() {
        JFrame frame = new JFrame();
        frame.setTitle("Rock_Paper_Scissors");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,535);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        
        // images
        ImageIcon paperImage = new ImageIcon("papers.png");
        ImageIcon backgroundImage = new ImageIcon("rpsbackground.png");
        ImageIcon rockImage = new ImageIcon("rocks.png");
        ImageIcon scissorsImage = new ImageIcon("scissorss.png");
        ImageIcon paperImage1 = new ImageIcon("papers1.png");
        ImageIcon rockImage1 = new ImageIcon("rocks1.png");
        ImageIcon scissorsImage1 = new ImageIcon("scissorss1.png");
        
        JLabel resultLabel = new JLabel();
        resultLabel.setLayout(null);
        resultLabel.setBounds(240,220,150,100);
        
        JLabel resultLabel1 = new JLabel();
        resultLabel1.setLayout(null);
        resultLabel1.setBounds(410,220,150,100);
        
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setVerticalAlignment(JLabel.CENTER);
        backgroundLabel.setHorizontalAlignment(JLabel.CENTER);
        backgroundLabel.setBounds(0,0,800,500);

        JLabel youLabel = new JLabel();
        youLabel.setBounds(100,20,100,50);
        youLabel.setText("You");
        youLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
        JLabel opponentLabel = new JLabel();
        opponentLabel.setBounds(600,20,100,50);
        opponentLabel.setText("Opponent");
        opponentLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
        
        JButton rockButton = new JButton();
        rockButton.setBounds(50,100,150,100);
        rockButton.setIcon(rockImage);
        JButton paperButton = new JButton();
        paperButton.setBounds(50,220,150,100);
        paperButton.setIcon(paperImage);
        JButton scissorsButton = new JButton();
        scissorsButton.setBounds(50,340,150,100);
        scissorsButton.setIcon(scissorsImage);
        
        JButton backButton = new JButton("Exit");
        backButton.setBounds(650,450,100,30);
        backButton.setBackground(Color.white);
        backButton.setFocusable(false);
        
        JLabel rockLabel = new JLabel();
        rockLabel.setBounds(600,100,150,100);
        rockLabel.setIcon(rockImage1);
        JLabel paperLabel = new JLabel();
        paperLabel.setBounds(600,220,150,100);
        paperLabel.setIcon(paperImage1);
        JLabel scissorsLabel = new JLabel();
        scissorsLabel.setBounds(600,340,150,100);
        scissorsLabel.setIcon(scissorsImage1);
        
        // Rand
        Random rand = new Random();
        List<String> givenList = new ArrayList<>(Arrays.asList("rock","paper","scissors"));
        
        // actionListener
        rockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	resultLabel.setIcon(rockImage);
            	
                int randomIndex = rand.nextInt(givenList.size());
                String randomElement = givenList.get(randomIndex);
                
                if(randomElement.equals("rock")) { 
                    resultLabel1.setIcon(rockImage1);
                	JOptionPane.showMessageDialog(frame, "There's no next time, Peasant!!!", "Draw", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(randomElement.equals("paper")) {
                    resultLabel1.setIcon(paperImage1);
                    JOptionPane.showMessageDialog(frame, "Haha!What a Goober.", "Lose", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(randomElement.equals("scissors")) {
                    resultLabel1.setIcon(scissorsImage1);
                    JOptionPane.showMessageDialog(frame, "Imagine winning one out of 10 games", "Win", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        paperButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int randomIndex = rand.nextInt(givenList.size());
                String randomElement = givenList.get(randomIndex);
                
                resultLabel.setIcon(paperImage);
                if(randomElement.equals("rock")) {
                    resultLabel1.setIcon(rockImage1);
                    JOptionPane.showMessageDialog(frame, "Okay Okay", "Win", JOptionPane.INFORMATION_MESSAGE);
                } 
                else if(randomElement.equals("paper")) {
                    resultLabel1.setIcon(paperImage1);
                    JOptionPane.showMessageDialog(frame, "Bruhhh", "Draw", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(randomElement.equals("scissors")) {
                    resultLabel1.setIcon(scissorsImage1);
                    JOptionPane.showMessageDialog(frame, "Imagine losing to a Bottt", "Lose", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        scissorsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int randomIndex = rand.nextInt(givenList.size());
                String randomElement = givenList.get(randomIndex);
                
                resultLabel.setIcon(scissorsImage);
                if(randomElement.equals("rock")) {
                    resultLabel1.setIcon(rockImage1);
                    JOptionPane.showMessageDialog(frame, "How are you so bad at this!", "Lose", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(randomElement.equals("paper")) {
                    resultLabel1.setIcon(paperImage1);
                    JOptionPane.showMessageDialog(frame, "Beginner's Luck", "Win", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(randomElement.equals("scissors")) {
                    resultLabel1.setIcon(scissorsImage1);
                    JOptionPane.showMessageDialog(frame, "How are you so bad at this!", "Lose", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		frame.dispose();
        	}
        });
        
        frame.add(resultLabel1);
        frame.add(resultLabel);
        frame.add(youLabel);
        frame.add(opponentLabel);
        frame.add(rockButton);
        frame.add(paperButton);
        frame.add(scissorsButton);
        frame.add(backButton);
        frame.add(rockLabel);
        frame.add(paperLabel);
        frame.add(scissorsLabel);
        frame.add(backgroundLabel);
        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new rps();
    }
}
