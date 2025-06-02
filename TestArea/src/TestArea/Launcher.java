package TestArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Launcher  {

    public static void main(String[] args) {
        // JFrame
        JFrame frame = new JFrame();
        frame.setTitle("Launcher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 725);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // ImageIcon
        ImageIcon cpImage = new ImageIcon("tech.png");
        ImageIcon ruppImage = new ImageIcon("rupp.png");
        ImageIcon homeImage = new ImageIcon("home.png");
        ImageIcon monitorImage = new ImageIcon("monitor.png");
        ImageIcon menuImage = new ImageIcon("menu.png");
        ImageIcon memberImage = new ImageIcon("member.png");

        // Custom RoundedButton
        class RoundedButton extends JButton {
            public RoundedButton(String text, ImageIcon icon) {
                super(text, icon);
                setOpaque(false);
                setContentAreaFilled(false); 
                setFocusPainted(false);
                setBorderPainted(false);
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fill the button with background color
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                super.paintComponent(g);
                g2.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw the button border
                g2.setColor(getForeground());
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);

                g2.dispose();
            }
        }

        // Panel
        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(null);
        iconPanel.setBackground(Color.black);
        iconPanel.setPreferredSize(new Dimension(70, 725));

        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(ruppImage);
        logoLabel.setBounds(10, 8, 50, 50);
        logoLabel.setVerticalAlignment(JLabel.CENTER);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        iconPanel.add(logoLabel);

        // Rounded Buttons
        RoundedButton homeButton = new RoundedButton("", homeImage);
        homeButton.setBounds(15, 80, 40, 40);
        homeButton.setBackground(Color.DARK_GRAY);
        iconPanel.add(homeButton);

        RoundedButton monitorButton = new RoundedButton("", monitorImage);
        monitorButton.setBounds(14, 140, 40, 40);
        monitorButton.setBackground(Color.DARK_GRAY);
        iconPanel.add(monitorButton);
        
        RoundedButton memberButton = new RoundedButton("", memberImage);
        memberButton.setBounds(15,580,40,40);
        memberButton.setBackground(Color.DARK_GRAY);
        iconPanel.add(memberButton);

        RoundedButton menuButton = new RoundedButton("", menuImage);
        menuButton.setBounds(15, 630, 40, 40);
        menuButton.setBackground(Color.DARK_GRAY);
        iconPanel.add(menuButton);
        

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(null);
        imagePanel.setBackground(Color.white);

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(cpImage);
        imageLabel.setBounds(0, 0, 1210, 725);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imageLabel.setHorizontalAlignment(JLabel.CENTER); // Center the image within the label
        imagePanel.add(imageLabel);

        // Add Panels to frame
        frame.add(iconPanel, BorderLayout.WEST);
        frame.add(imagePanel, BorderLayout.CENTER);
        // ActionListener
        monitorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	try {
					new ProjectWithLayoutWithDataBase();
				} catch (SQLException e) {

					e.printStackTrace();
				}
            }
        });

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ImageIcon newImage = new ImageIcon("rupppic.png");
                imageLabel.setIcon(newImage);
                imagePanel.revalidate();
                imagePanel.repaint();	
            }
        });
        memberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new membersInfo();
            }
        });

        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Gamecenter();
            }
        });

        frame.setVisible(true);
    }
}
