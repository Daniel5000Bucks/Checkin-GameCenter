package TestArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class LotteryGame {
    private JLabel numberLabel;
    private JButton startButton;
    private JButton stopButton;
    private JTextField betTextField;
    private Random rand;
    private Timer timer;
    private JFrame frame;
    private DefaultTableModel model;
    private JComboBox<String> lotsizeComboBox;

    public LotteryGame() {
        frame = new JFrame();
        frame.setTitle("Number Guesser");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 540);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        rand = new Random();

        // ImageICons
        ImageIcon backgroundImage = new ImageIcon("lotterybackground.psd.png");
        ImageIcon startImage = new ImageIcon("start.png");
        ImageIcon stopImage = new ImageIcon("stop.png");
        ImageIcon betImage = new ImageIcon("bet.png");
        
        // JPanel
        JPanel numberPanel = new JPanel();
        numberPanel.setBounds(450, 30, 300, 150);
        numberPanel.setBackground(Color.black);
        numberPanel.setLayout(new BorderLayout());
        
        numberLabel = new JLabel("00", SwingConstants.CENTER);
        numberLabel.setFont(new Font("Serif", Font.BOLD, 50));
        numberLabel.setForeground(Color.white);
       numberPanel.add(numberLabel);

        JPanel betPanel = new JPanel();
        betPanel.setBounds(50, 30, 350, 50);
        betPanel.setBackground(Color.black);
        betPanel.setLayout(new BorderLayout());
        JLabel letterLabel = new JLabel("BET AREA", SwingConstants.CENTER);
        letterLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        letterLabel.setForeground(Color.white);
        betPanel.add(letterLabel, BorderLayout.CENTER);

        JLabel betnLabel = new JLabel("Numbers: ");
        betnLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        betnLabel.setBounds(50, 100, 120, 50);
        betnLabel.setForeground(Color.white);
        betTextField = new JTextField();
        betTextField.setFont(new Font("Segoe UI", Font.BOLD, 20));
        betTextField.setBounds(180, 110, 150, 30);
        JLabel betsizeLabel = new JLabel("Lots Size: ");
        betsizeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        betsizeLabel.setBounds(50, 150, 120, 50);
        betsizeLabel.setForeground(Color.white);
        lotsizeComboBox = new JComboBox<>(new String[] {"5%", "10%", "20%", "30%", "50%", "60%", "70%", "80%", "90%", "100%"});
        lotsizeComboBox.setBounds(180, 165, 150, 30);
        lotsizeComboBox.setFocusable(false);

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setVerticalAlignment(JLabel.CENTER);
        backgroundLabel.setHorizontalAlignment(JLabel.CENTER);
        backgroundLabel.setBounds(0, 0, 800, 540);

        // buttons
        startButton = new JButton("Start  ");
        startButton.setFont(new Font("Segoe", Font.BOLD,20));
        startButton.setBackground(Color.green);
        startButton.setBounds(450, 200, 145, 50);
        startButton.setIcon(startImage);
        startButton.setHorizontalAlignment(JButton.RIGHT);
        startButton.setHorizontalTextPosition(JButton.LEFT);
        startButton.setFocusable(false);
        stopButton = new JButton("Stop  ");
        stopButton.setFont(new Font("Segoe UI", Font.BOLD,20));
        stopButton.setBackground(Color.red);
        stopButton.setIcon(stopImage);
        stopButton.setHorizontalAlignment(JButton.RIGHT);
        stopButton.setHorizontalTextPosition(JButton.LEFT);
        stopButton.setBounds(605, 200, 145, 50);
        stopButton.setFocusable(false);
        JButton orderButton = new JButton("Place Bet     ");
        orderButton.setBounds(50, 250, 280, 50);
        orderButton.setFont(new Font("Segoe UI", Font.BOLD,30));
        orderButton.setBackground(Color.white);
        orderButton.setIcon(betImage);
        orderButton.setHorizontalAlignment(JButton.RIGHT);
        orderButton.setHorizontalTextPosition(JButton.LEFT);
        orderButton.setFocusable(false);
        JButton backButton = new JButton("Exit");
        backButton.setBounds(650,450,100,30);
        backButton.setBackground(Color.white);
        backButton.setFocusable(false);
        

        // table
        String[] columns = {"Numbers", "Lot Size", "Result"};
        model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(450, 280, 300, 100);

        frame.add(orderButton);
        frame.add(stopButton);
        frame.add(startButton);
        frame.add(backButton);
        frame.add(scrollPane);
        frame.add(lotsizeComboBox);
        frame.add(betsizeLabel);
        frame.add(betTextField);
        frame.add(betnLabel);
        frame.add(betPanel);
        frame.add(numberPanel);
        frame.add(backgroundLabel);
        frame.setVisible(true);

        // ActionListener
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startShuffling();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopShuffling();
            }
        });
        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String userInput = betTextField.getText();
                if (!userInput.isEmpty()) {
                    String lotSize = (String) lotsizeComboBox.getSelectedItem();
                    model.addRow(new Object[]{userInput, lotSize, "Pending"});
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a number to bet.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Initialize the timer with a faster delay (10 milliseconds)
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shuffleNumber();
            }
        });
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		frame.dispose();
        	}
        });
    }

    // Method to start shuffling the numbers
    private void startShuffling() {
        timer.start();
    }

    // Method to stop shuffling the numbers and check if the user won
    private void stopShuffling() {
        timer.stop();
        checkIfWon();
    }

    // Method to generate and display a random two-digit number
    private void shuffleNumber() {
        int number = rand.nextInt(90) + 10; // Generates a number between 10 and 99
        numberLabel.setText(String.format("%02d", number));
    }

    // Method to check if the generated number matches the user's input
    private void checkIfWon() {
        String generatedNumber = numberLabel.getText();
        String userInput = betTextField.getText();

        if (generatedNumber.equals(userInput)) {
            JOptionPane.showMessageDialog(frame, "You won!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            updateTable("Win");
        } else {
            JOptionPane.showMessageDialog(frame, "Try again!", "Result", JOptionPane.INFORMATION_MESSAGE);
            updateTable("Lose");
        }
    }

    // Method to update the table with the result
    private void updateTable(String result) {
        int rowCount = model.getRowCount();//1
        for (int i = 0; i < rowCount; i++) {
            if (model.getValueAt(i, 2).equals("Pending")) {
                model.setValueAt(result, i, 2);
                break;
            }
        }
    }

    public static void main(String[] args) {
        new LotteryGame();
    }
    
}
