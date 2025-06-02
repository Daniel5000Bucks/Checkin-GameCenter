package TestArea;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Deposit {
	public Deposit() {
			//JFrame
		JFrame frame = new JFrame();
		frame.setTitle("Game Center");
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Deposit();
	}

}
