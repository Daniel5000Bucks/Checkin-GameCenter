package TestArea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class ProjectWithLayoutWithDataBase {
   private Connection con;
   private Statement stm;
   private ResultSet rs;

   public ProjectWithLayoutWithDataBase() throws SQLException {
      // Main frame
      JFrame frame = new JFrame("Attendance System");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setSize(1150, 700);
      frame.setLocationRelativeTo(null);
      frame.setLayout(null);
      frame.setResizable(false);
      // frame.getContentPane().setBackground(Color.cyan);

      // Panel for employee information
      JPanel infoPanel = new JPanel();
      infoPanel.setLayout(null);
      infoPanel.setBounds(10, 10, 400, 200);

      infoPanel.setBorder(BorderFactory.createTitledBorder("Employee Information"));
      JLabel empIDLabel = new JLabel("Employee ID:");
      empIDLabel.setBounds(10, 30, 100, 20);
      JTextField empIDField = new JTextField();
      empIDField.setBounds(120, 30, 150, 20);
      JLabel firstNameLabel = new JLabel("First Name:");
      firstNameLabel.setBounds(10, 60, 100, 20);
      JTextField firstNameField = new JTextField();
      firstNameField.setBounds(120, 60, 150, 20);
      JLabel lastNameLabel = new JLabel("Last Name:");
      lastNameLabel.setBounds(10, 90, 100, 20);
      JTextField lastNameField = new JTextField();
      lastNameField.setBounds(120, 90, 150, 20);
      JLabel dobLabel = new JLabel("Date of Birth:");
      dobLabel.setBounds(10, 120, 100, 20);
      JTextField dobField = new JTextField();
      dobField.setBounds(120, 120, 150, 20);
      JLabel genderLabel = new JLabel("Gender:");
      genderLabel.setBounds(10, 150, 100, 20);
      JRadioButton maleRadioButton = new JRadioButton("Male");
      maleRadioButton.setBounds(120, 150, 60, 20);
      JRadioButton femaleRadioButton = new JRadioButton("Female");
      femaleRadioButton.setBounds(200, 150, 80, 20);
      ButtonGroup genderGroup = new ButtonGroup();
      genderGroup.add(maleRadioButton);
      genderGroup.add(femaleRadioButton);
      infoPanel.add(empIDLabel);
      infoPanel.add(empIDField);
      infoPanel.add(firstNameLabel);
      infoPanel.add(firstNameField);
      infoPanel.add(lastNameLabel);
      infoPanel.add(lastNameField);
      infoPanel.add(dobLabel);
      infoPanel.add(dobField);
      infoPanel.add(genderLabel);
      infoPanel.add(maleRadioButton);
      infoPanel.add(femaleRadioButton);
      // Panel for department and job title
      JPanel deptPanel = new JPanel();
      deptPanel.setLayout(null);
      deptPanel.setBounds(10, 220, 400, 100);

      deptPanel.setBorder(BorderFactory.createTitledBorder("Department & Job Title"));
      JLabel deptLabel = new JLabel("Department:");
      deptLabel.setBounds(10, 30, 100, 20);
      JComboBox<String> deptComboBox = new JComboBox<>(new String[] { "E&D", "Pro_Management", "Marketing", "Sales",
            "Customer Support", "Human Resources", "Finance", "Legal", "Operations", "R&D" });
      deptComboBox.setBounds(120, 30, 150, 20);
      JLabel jobTitleLabel = new JLabel("Job Title:");
      jobTitleLabel.setBounds(10, 60, 100, 20);
      JTextField jobTitleField = new JTextField();
      jobTitleField.setBounds(120, 60, 150, 20);
      deptPanel.add(deptLabel);
      deptPanel.add(deptComboBox);
      deptPanel.add(jobTitleLabel);
      deptPanel.add(jobTitleField);

      // Panel for work shifts
      JPanel shiftPanel = new JPanel();
      shiftPanel.setLayout(null);
      shiftPanel.setBounds(10, 330, 400, 100);
      shiftPanel.setBorder(BorderFactory.createTitledBorder("Work Shifts"));

      JLabel shiftlabel = new JLabel("Shift : ");
      shiftlabel.setBounds(10, 30, 100, 20);
      JComboBox<String> shiftComboBox = new JComboBox<>(new String[] { "Day Shift", "Evening Shift", "Night Shift" });
      shiftComboBox.setBounds(120, 30, 150, 20);
      shiftPanel.add(shiftlabel);
      shiftPanel.add(shiftComboBox);

      // Panel for check out
      JPanel checkOutPanel = new JPanel();
      checkOutPanel.setLayout(null);
      checkOutPanel.setBounds(420, 550, 710, 100);

      checkOutPanel.setBorder(BorderFactory.createTitledBorder("Check out"));

      ImageIcon checkoutimage = new ImageIcon("shift end.png");
      JButton checkOutButton = new JButton("Check-Out ");
      checkOutButton.setBounds(550, 30, 130, 40);
      checkOutButton.setIcon(checkoutimage);
      checkOutButton.setBackground(Color.RED);
      checkOutButton.setHorizontalAlignment(JButton.RIGHT);
      checkOutButton.setHorizontalTextPosition(JButton.LEFT);
      checkOutButton.setFocusable(false);
      JTextField checkOutTextField = new JTextField();
      checkOutTextField.setBounds(20, 30, 500, 40);

      checkOutPanel.add(checkOutTextField);
      checkOutPanel.add(checkOutButton);

      // Images
      ImageIcon checkinimage = new ImageIcon("shift start.png");
      ImageIcon clearimage = new ImageIcon("brush.png");

      // Buttons
      JButton checkInButton = new JButton("Check-In ");
      checkInButton.setBounds(10, 445, 120, 40);
      checkInButton.setIcon(checkinimage);
      checkInButton.setBackground(Color.GREEN);
      checkInButton.setHorizontalAlignment(JButton.LEFT);
      checkInButton.setHorizontalTextPosition(JButton.LEFT);
      checkInButton.setFocusable(false);
      JButton updateButton = new JButton("Update ");
      updateButton.setBounds(145, 445, 120, 40);
      updateButton.setBackground(Color.white);
      updateButton.setIcon(clearimage);
      updateButton.setHorizontalAlignment(JButton.RIGHT);
      updateButton.setHorizontalTextPosition(JButton.LEFT);
      updateButton.setFocusable(false);
      JButton firstButton = new JButton("First");
      firstButton.setBounds(10, 620, 90, 30);
      firstButton.setBackground(Color.white);
      firstButton.setFocusable(false);
      JButton nextButton = new JButton("Next");
      nextButton.setBounds(105, 620, 90, 30);
      nextButton.setBackground(Color.white);
      nextButton.setFocusable(false);
      JButton previousButton = new JButton("Previous");
      previousButton.setBounds(200, 620, 90, 30);
      previousButton.setBackground(Color.white);
      previousButton.setFocusable(false);
      JButton lastButton = new JButton("Last");
      lastButton.setBounds(295, 620, 90, 30);
      lastButton.setBackground(Color.white);
      lastButton.setFocusable(false);

      // JButton memberButton = new JButton("Team Members");
      // memberButton.setBounds(10, 620, 150,20);
      // memberButton.setBackground(Color.cyan);
      // memberButton.setFocusable(false);

      // Table
      String[] columns = { "Employee ID", "First Name", "Last Name", "Date Of Birth", "Gender", "Department",
            "Job Title", "Work Shifts" };
      DefaultTableModel model = new DefaultTableModel(columns, 0);
      JTable table = new JTable(model);
      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setBounds(420, 17, 710, 530);

      // Add components to the frame
      frame.add(infoPanel);
      frame.add(deptPanel);
      frame.add(shiftPanel);
      frame.add(checkInButton);
      frame.add(updateButton);
      frame.add(firstButton);
      frame.add(nextButton);
      frame.add(previousButton);
      frame.add(lastButton);
      // frame.add(memberButton);
      frame.add(checkOutPanel);
      frame.add(scrollPane);

      // database
      try {
         con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/attendance", "root", "");
         stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         rs = stm.executeQuery("select * from Employees");
         // empIDField.setText(rs.getString(1));
         // firstNameField.setText(rs.getString(2));
         // lastNameField.setText(rs.getString(3));
         // dobField.setText(rs.getString(4));
         // String gender = rs.getString(5); //
         // if ("Male".equalsIgnoreCase(gender)) {
         // maleRadioButton.setSelected(true);
         // } else if ("Female".equalsIgnoreCase(gender)) {
         // femaleRadioButton.setSelected(true);
         // }
         // deptComboBox.setSelectedItem(rs.getString(6));
         // jobTitleField.setText(rs.getString(7));
         // shiftComboBox.setSelectedItem(rs.getString(8));
         rs.beforeFirst();
         while (rs.next()) {
            model.addRow(new Object[] {
                  rs.getString(1),
                  rs.getString(2),
                  rs.getString(3),
                  rs.getString(4),
                  rs.getString(5),
                  rs.getString(6),
                  rs.getString(7),
                  rs.getString(8)
            });
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      // Action listeners
      checkInButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            String empId = empIDField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String dob = dobField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String dept = (String) deptComboBox.getSelectedItem();
            String jobTitle = jobTitleField.getText();
            String shift = (String) shiftComboBox.getSelectedItem();
            String sql = "INSERT INTO Employees (`Employee ID`, `First Name`, `Last Name`, `Date Of Birth`, `Gender`, `Department`, `Job Title`, `Work Shifts`) VALUES ('"
                  + empId + "', '" + firstName + "', '" + lastName + "', '" + dob + "', '" + gender + "', '" + dept
                  + "', '" + jobTitle + "', '" + shift + "');";

            try {
               System.out.println(sql);
               stm.execute(sql);
            } catch (SQLException e) {
               e.printStackTrace();
            }
            try {
               rs = stm.executeQuery("select * from Employees");
               model.setRowCount(0);// Clears the table
               rs.beforeFirst();// resets cursor to the start
               while (rs.next()) {
                  model.addRow(new Object[] {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                  });
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
            // // Clear fields after adding data
            // empIDField.setText("");
            // firstNameField.setText("");
            // lastNameField.setText("");
            // dobField.setText("");
            // genderGroup.clearSelection();
            // deptComboBox.setSelectedIndex(0);
            // jobTitleField.setText("");
         }
      });
      checkOutButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            String empIDToDelete = checkOutTextField.getText();
            String sql = "Delete From Employees where `Employee ID` = " + empIDToDelete + ";";
            try {
               System.out.println(sql);
               stm.execute(sql);
            } catch (SQLException e) {
               e.printStackTrace();
            }
            try {
               rs = stm.executeQuery("select * from Employees");
               model.setRowCount(0);
               rs.beforeFirst();
               while (rs.next()) {
                  model.addRow(new Object[] {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                  });
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
            checkOutTextField.setText("");
         }
      });
      updateButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            String empId = empIDField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String dob = dobField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String dept = (String) deptComboBox.getSelectedItem();
            String jobTitle = jobTitleField.getText();
            String shift = (String) shiftComboBox.getSelectedItem();
            String sql = "update Employees set `First Name`= '" + firstName + "', `Last Name`= '" + lastName +
                  "', `Date Of Birth`= '" + dob + "', Gender= '" + gender +
                  "', Department= '" + dept + "', `Job Title`= '" + jobTitle +
                  "', `Work Shifts`= '" + shift + "' where `Employee ID`= " + empId + ";";
            try {
               System.out.println(sql);
               stm.execute(sql);
            } catch (SQLException e) {
               e.printStackTrace();
            }
            try {
               rs = stm.executeQuery("select * from Employees");
               model.setRowCount(0);
               rs.isBeforeFirst();
               while (rs.next()) {
                  model.addRow(new Object[] {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                  });
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      });
      firstButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            try {
               rs.first();
               empIDField.setText(rs.getString(1));
               firstNameField.setText(rs.getString(2));
               lastNameField.setText(rs.getString(3));
               dobField.setText(rs.getString(4));
               maleRadioButton.setSelected(true);
               femaleRadioButton.setSelected(true);
               deptComboBox.setSelectedItem(rs.getString(6));
               jobTitleField.setText(rs.getString(7));
               shiftComboBox.setSelectedItem(rs.getString(8));

            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      });
      nextButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            try {
               rs.next();
               if (rs.isAfterLast())
                  rs.last();
               else {
                  empIDField.setText(rs.getString(1));
                  firstNameField.setText(rs.getString(2));
                  lastNameField.setText(rs.getString(3));
                  dobField.setText(rs.getString(4));
                  maleRadioButton.setSelected(true);
                  femaleRadioButton.setSelected(true);
                  deptComboBox.setSelectedItem(rs.getString(6));
                  jobTitleField.setText(rs.getString(7));
                  shiftComboBox.setSelectedItem(rs.getString(8));
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      });
      previousButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            try {
               rs.previous();
               if (rs.isBeforeFirst())
                  rs.first();
               else {
                  empIDField.setText(rs.getString(1));
                  firstNameField.setText(rs.getString(2));
                  lastNameField.setText(rs.getString(3));
                  dobField.setText(rs.getString(4));
                  maleRadioButton.setSelected(true);
                  femaleRadioButton.setSelected(true);
                  deptComboBox.setSelectedItem(rs.getString(6));
                  jobTitleField.setText(rs.getString(7));
                  shiftComboBox.setSelectedItem(rs.getString(8));
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      });
      lastButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            try {
               rs.last();
               empIDField.setText(rs.getString(1));
               firstNameField.setText(rs.getString(2));
               lastNameField.setText(rs.getString(3));
               dobField.setText(rs.getString(4));
               maleRadioButton.setSelected(true);
               femaleRadioButton.setSelected(true);
               deptComboBox.setSelectedItem(rs.getString(6));
               jobTitleField.setText(rs.getString(7));
               shiftComboBox.setSelectedItem(rs.getString(8));
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      });
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent we) {
            try {
               rs.close();
               con.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      });
      // Display the frame
      frame.setVisible(true);

   }

   public static void main(String[] args) throws Exception {
      new ProjectWithLayoutWithDataBase();
   }
}
