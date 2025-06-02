package TestArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class membersInfo {
    public membersInfo() {
        // Main frame
        JFrame frame = new JFrame("Team Members");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(900, 450);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBounds(360,10,500,350);
        infoPanel.setBorder(BorderFactory.createTitledBorder("Member's Infomation"));
        
        JLabel imageLabel = new JLabel();
        imageLabel.setLayout(new BorderLayout());
        imageLabel.setBounds(20,60,150,200);
        imageLabel.setBorder(BorderFactory.createTitledBorder("image"));
        infoPanel.add(imageLabel);
        JLabel titleLabel = new JLabel("STUDENT OF RUPP");
        titleLabel.setLayout(null);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(Color.blue);
        titleLabel.setBounds(180,10,200,50);
        infoPanel.add(titleLabel);
        JLabel nameLabel = new JLabel();
        nameLabel.setLayout(null);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 15));
        nameLabel.setBounds(190,65,200,20);
        infoPanel.add(nameLabel);
        JLabel sexLabel = new JLabel();
        sexLabel.setLayout(null);
        sexLabel.setFont(new Font("Serif", Font.BOLD, 15));
        sexLabel.setBounds(190,90,200,20);
        infoPanel.add(sexLabel);
        JLabel dobLabel = new JLabel();
        dobLabel.setLayout(null);
        dobLabel.setFont(new Font("Serif", Font.BOLD, 15));
        dobLabel.setBounds(190,115,200,20);
        infoPanel.add(dobLabel);
        JLabel majorLabel = new JLabel();
        majorLabel.setLayout(null);
        majorLabel.setFont(new Font("Serif", Font.BOLD, 15));
        majorLabel.setBounds(190,140,300,20);
        infoPanel.add(majorLabel);
        JLabel bacLabel = new JLabel();
        bacLabel.setLayout(null);
        bacLabel.setFont(new Font("Serif", Font.BOLD, 15));
        bacLabel.setBounds(190,165,200,20);
        infoPanel.add(bacLabel);
        JLabel addLabel = new JLabel();
        addLabel.setLayout(null);
        addLabel.setFont(new Font("Serif", Font.BOLD, 15));
        addLabel.setBounds(190,190,200,20);
        infoPanel.add(addLabel);
        JLabel roleLabel = new JLabel();
        roleLabel.setLayout(null);
        roleLabel.setFont(new Font("Serif", Font.BOLD, 15));
        roleLabel.setBounds(190,215,200,20);
        infoPanel.add(roleLabel);
        JLabel ruppLabel = new JLabel();
        ruppLabel.setLayout(null);
        ruppLabel.setBounds(400,10,90,90);
        infoPanel.add(ruppLabel);
        
        // Panel for JRadioButton
        JPanel namesPanel = new JPanel();
        namesPanel.setLayout(null);
        namesPanel.setBounds(10, 10, 305, 350);
        namesPanel.setBorder(BorderFactory.createTitledBorder("Team Members"));
        
        JRadioButton danielRadioButton = new JRadioButton("Chin Daniel");
        danielRadioButton.setBounds(10, 30, 200, 30);
        danielRadioButton.setFocusable(false);
        JRadioButton khengRadioButton = new JRadioButton("Kheang Sokheng");
        khengRadioButton.setBounds(10, 60, 200, 30);
        khengRadioButton.setFocusable(false);
        JRadioButton leapRadioButton = new JRadioButton("Meng Kemleap");
        leapRadioButton.setBounds(10, 90, 200, 30);
        leapRadioButton.setFocusable(false);
        JRadioButton mengRadioButton = new JRadioButton("Sunvannak Sievmeng");
        mengRadioButton.setBounds(10, 120, 200, 30);
        mengRadioButton.setFocusable(false);
        JRadioButton ulyRadioButton = new JRadioButton("Jeav uly");
        ulyRadioButton.setBounds(10, 150, 200, 30);
        ulyRadioButton.setFocusable(false);
        JRadioButton kenRadioButton = new JRadioButton("Cheng Ken");
        kenRadioButton.setBounds(10, 180, 200, 30);
        kenRadioButton.setFocusable(false);
        JRadioButton polinRadioButton = new JRadioButton("Chang Polin");
        polinRadioButton.setBounds(10, 210, 200, 30);
        polinRadioButton.setFocusable(false);
        JRadioButton chunRadioButton = new JRadioButton("Chum Kemchhun");
        chunRadioButton.setBounds(10, 240, 200, 30);
        chunRadioButton.setFocusable(false);
        
        //add all JRadioButtons into one group
        ButtonGroup memberGroup = new ButtonGroup();
        memberGroup.add(danielRadioButton);
        memberGroup.add(khengRadioButton);
        memberGroup.add(leapRadioButton);
        memberGroup.add(mengRadioButton);
        memberGroup.add(polinRadioButton);
        memberGroup.add(ulyRadioButton);
        memberGroup.add(kenRadioButton);
        memberGroup.add(chunRadioButton);
        
        
        // Add JRadioButtons to the panel
        namesPanel.add(danielRadioButton);
        namesPanel.add(mengRadioButton);
        namesPanel.add(leapRadioButton);
        namesPanel.add(ulyRadioButton);
        namesPanel.add(chunRadioButton);
        namesPanel.add(kenRadioButton);
        namesPanel.add(khengRadioButton);
        namesPanel.add(polinRadioButton);
        
        // Add component to frame
        frame.add(namesPanel);
        frame.add(infoPanel);
     
        
        //ActionListener
        danielRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		if(danielRadioButton.isSelected()) {
        			ImageIcon danielImage = new ImageIcon("Daniel.png");
        			ImageIcon ruppImage = new ImageIcon("rupp1.png");
        			imageLabel.setIcon(danielImage);
        			imageLabel.setHorizontalAlignment(JLabel.CENTER);
        			imageLabel.setVerticalAlignment(JLabel.CENTER);
        			nameLabel.setText(" -> CHIN DANIEL");
        			sexLabel.setText(" -> Male");
        			dobLabel.setText(" -> 02/02/2005");
        			majorLabel.setText(" -> Department of Computer Science");
        			bacLabel.setText(" -> Bachelor");
        			addLabel.setText(" -> Phnom Penh");
        			roleLabel.setText(" -> Team Leader");
        			ruppLabel.setIcon(ruppImage);
        		}
        	}
        });
        khengRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		if(khengRadioButton.isSelected()) {
        			ImageIcon khengImage = new ImageIcon("Kheng.png");
        			ImageIcon ruppImage = new ImageIcon("rupp1.png");
        			imageLabel.setIcon(khengImage);
        			imageLabel.setHorizontalAlignment(JLabel.CENTER);
        			imageLabel.setVerticalAlignment(JLabel.CENTER);
        			nameLabel.setText(" -> KHEANG SOKHENG");
        			sexLabel.setText(" -> Male");
        			dobLabel.setText(" -> NA");
        			majorLabel.setText(" -> Department of Computer Science");
        			bacLabel.setText(" -> Bachelor");
        			addLabel.setText(" -> Svay Rieng");
        			roleLabel.setText(" -> Co Leader");
        			ruppLabel.setIcon(ruppImage);
        		}
        	}
        });
        polinRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		if(polinRadioButton.isSelected()) {
        			ImageIcon polinImage = new ImageIcon("Polin.png");
        			ImageIcon ruppImage = new ImageIcon("rupp1.png");
        			imageLabel.setIcon(polinImage);
        			imageLabel.setHorizontalAlignment(JLabel.CENTER);
        			imageLabel.setVerticalAlignment(JLabel.CENTER);
        			nameLabel.setText(" -> CHANG POLIN");
        			sexLabel.setText(" -> Male");
        			dobLabel.setText(" -> NA");
        			majorLabel.setText(" -> Department of Computer Science");
        			bacLabel.setText(" -> Bachelor");
        			addLabel.setText(" -> Phnom Penh");
        			roleLabel.setText(" -> Member");
        			ruppLabel.setIcon(ruppImage);
        		}
        	}
        });
        kenRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		if(kenRadioButton.isSelected()) {
        			ImageIcon kenImage = new ImageIcon("Ken.png");
        			ImageIcon ruppImage = new ImageIcon("rupp1.png");
        			imageLabel.setIcon(kenImage);
        			imageLabel.setHorizontalAlignment(JLabel.CENTER);
        			imageLabel.setVerticalAlignment(JLabel.CENTER);
        			nameLabel.setText(" -> CHENG KEN");
        			sexLabel.setText(" -> Male");
        			dobLabel.setText(" -> NA");
        			majorLabel.setText(" -> Department of Computer Science");
        			bacLabel.setText(" -> Bachelor");
        			addLabel.setText(" -> Phnom Penh");
        			roleLabel.setText(" -> Member");
        			ruppLabel.setIcon(ruppImage);
        		}
        	}
        });
        mengRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		if(mengRadioButton.isSelected()) {
        			ImageIcon mengImage = new ImageIcon("meng.png");
        			ImageIcon ruppImage = new ImageIcon("rupp1.png");
        			imageLabel.setIcon(mengImage);
        			imageLabel.setHorizontalAlignment(JLabel.CENTER);
        			imageLabel.setVerticalAlignment(JLabel.CENTER);
        			nameLabel.setText(" -> SUNVANNAK SIEVMENG");
        			sexLabel.setText(" -> Male");
        			dobLabel.setText(" -> NA");
        			majorLabel.setText(" -> Department of Computer Science");
        			bacLabel.setText(" -> Bachelor");
        			addLabel.setText(" -> Phnom Penh");
        			roleLabel.setText(" -> Member");
        			ruppLabel.setIcon(ruppImage);
        		}
        	}
        });
        leapRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		if(leapRadioButton.isSelected()) {
        			ImageIcon leapImage = new ImageIcon("");
        			ImageIcon ruppImage = new ImageIcon("rupp1.png");
        			imageLabel.setIcon(leapImage);
        			imageLabel.setHorizontalAlignment(JLabel.CENTER);
        			imageLabel.setVerticalAlignment(JLabel.CENTER);
        			nameLabel.setText(" -> MENG KEMLEAP");
        			sexLabel.setText(" -> Female");
        			dobLabel.setText(" -> NA");
        			majorLabel.setText(" -> Department of Computer Science");
        			bacLabel.setText(" -> Bachelor");
        			addLabel.setText(" -> Phnom Penh");
        			roleLabel.setText(" -> Member");
        			ruppLabel.setIcon(ruppImage);
        		}
        	}
        });
        ulyRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		if(ulyRadioButton.isSelected()) {
        			ImageIcon mengImage = new ImageIcon("");
        			ImageIcon ruppImage = new ImageIcon("rupp1.png");
        			imageLabel.setIcon(mengImage);
        			imageLabel.setHorizontalAlignment(JLabel.CENTER);
        			imageLabel.setVerticalAlignment(JLabel.CENTER);
        			nameLabel.setText(" -> JEAV ULY");
        			sexLabel.setText(" -> Female");
        			dobLabel.setText(" -> NA");
        			majorLabel.setText(" -> Department of Computer Science");
        			bacLabel.setText(" -> Bachelor");
        			addLabel.setText(" -> Phnom Penh");
        			roleLabel.setText(" -> Member");
        			ruppLabel.setIcon(ruppImage);
        		}
        	}
        });
        mengRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		if(mengRadioButton.isSelected()) {
        			ImageIcon mengImage = new ImageIcon("meng.png");
        			ImageIcon ruppImage = new ImageIcon("rupp1.png");
        			imageLabel.setIcon(mengImage);
        			imageLabel.setHorizontalAlignment(JLabel.CENTER);
        			imageLabel.setVerticalAlignment(JLabel.CENTER);
        			nameLabel.setText(" -> SUNVANNAK SIEVMENG");
        			sexLabel.setText(" -> Male");
        			dobLabel.setText(" -> NA");
        			majorLabel.setText(" -> Department of Computer Science");
        			bacLabel.setText(" -> Bachelor");
        			addLabel.setText(" -> Phnom Penh");
        			roleLabel.setText(" -> Member");
        			ruppLabel.setIcon(ruppImage);
        		}
        	}
        });
        chunRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		if(chunRadioButton.isSelected()) {
        			ImageIcon chunImage = new ImageIcon("");
        			ImageIcon ruppImage = new ImageIcon("rupp1.png");
        			imageLabel.setIcon(chunImage);
        			imageLabel.setHorizontalAlignment(JLabel.CENTER);
        			imageLabel.setVerticalAlignment(JLabel.CENTER);
        			nameLabel.setText(" -> CHUM KEMCHHUN");
        			sexLabel.setText(" -> Male");
        			dobLabel.setText(" -> NA");
        			majorLabel.setText(" -> Department of Computer Science");
        			bacLabel.setText(" -> Bachelor");
        			addLabel.setText(" -> Phnom Penh");
        			roleLabel.setText(" -> Member");
        			ruppLabel.setIcon(ruppImage);
        		}
        	}
        });
        frame.setVisible(true);
    }
    public static void main(String[] args) {
    	new membersInfo();
    }
}
