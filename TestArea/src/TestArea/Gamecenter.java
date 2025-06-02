package TestArea;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Gamecenter {
	 public Gamecenter() {
		//JFrame 
		JFrame frame = new JFrame();
		frame.setTitle("Game Center");
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		
		
		//ImageICon
		ImageIcon backgroundImage = new ImageIcon("Gamecenter.png");
		ImageIcon rpsImage = new ImageIcon("rps.png");
		ImageIcon lotteryImage = new ImageIcon("lottery.png");
		ImageIcon diceImaege = new ImageIcon("dice.png");
		ImageIcon groupImage = new ImageIcon("group.psd.png");

		//JLabel
		  JLabel imageLabel = new JLabel();
	      imageLabel.setIcon(backgroundImage);
	      imageLabel.setBounds(0, 0, 1000, 600);
	      imageLabel.setVerticalAlignment(JLabel.CENTER);
	      imageLabel.setHorizontalAlignment(JLabel.CENTER); 
	      
	    //JMenu 
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));
			menuBar.setBorderPainted(true);
			frame.add(menuBar, BorderLayout.NORTH);
			
			JMenu accMenu = new JMenu("Account Management");
			menuBar.add(accMenu);
			JMenuItem depositMenu = new JMenuItem("Deposit");
			accMenu.add(depositMenu);
			JMenuItem withdrawalMenu = new JMenuItem("Withdrawal");
			accMenu.add(withdrawalMenu);
			
	     //JButton 
	      JButton diceButton = new JButton();
	      diceButton.setBounds(30,400,200,100);
	      diceButton.setIcon(diceImaege);
	      diceButton.setFocusable(false);
	      JButton groupButton = new JButton();
	      groupButton.setBounds(270,400,200,100);
	      groupButton.setIcon(groupImage);
	      groupButton.setFocusable(false);
	      JButton rpsButton = new JButton();
	      rpsButton.setBounds(510,400,200,100);
	      rpsButton.setIcon(rpsImage);
	      rpsButton.setFocusable(false);
	      JButton lotteryButton = new JButton();
	      lotteryButton.setBounds(750,400,200,100);
	      lotteryButton.setIcon(lotteryImage);
	      lotteryButton.setFocusable(false);
	      JButton backButton = new JButton("Back");
	      backButton.setBounds(850,520,100,30);
	      backButton.setBackground(Color.white);
	      backButton.setFocusable(false);
	    
	      
	      frame.add(lotteryButton);
	      frame.add(rpsButton);
	      frame.add(diceButton);
	      frame.add(groupButton);
	      frame.add(backButton);
	      frame.add(imageLabel);
		frame.add(menuBar, BorderLayout.NORTH);
		
	      //actionListener
	      rpsButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent ae) {
	    		  new rps();
	    	  }
	      });
	      lotteryButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent ae) {
	    		  new LotteryGame();
	    	  }
	      });
	      backButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent ae) {
	    		  frame.dispose();
	    	  }
	      });
	    

		
		  frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Gamecenter();
	}
}
