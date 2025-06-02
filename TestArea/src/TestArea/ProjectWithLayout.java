package TestArea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

class Employee implements Serializable {
    private String empID;
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String department;
    private String jobTitle;
    private String workShift;

    public Employee() {
        empID = "";
        firstName = "";
        lastName = "";
        dob = "";
        gender = "";
        department = "";
        jobTitle = "";
        workShift = "";
    }

    public Employee(String i, String fn, String ln, String d, String g, String de, String j, String w) {
        empID = i;
        firstName = fn;
        lastName = ln;
        dob = d;
        gender = g;
        department = de;
        jobTitle = j;
        workShift = w;
    }

    public String getEmpID() { return empID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDob() { return dob; }
    public String getGender() { return gender; }
    public String getDepartment() { return department; }
    public String getJobTitle() { return jobTitle; }
    public String getWorkShift() { return workShift; }
}

public class ProjectWithLayout {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private DefaultTableModel model;
    private JTextField empIDField, firstNameField, lastNameField, dobField, jobTitleField, checkOutTextField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup genderGroup;
    private JComboBox<String> deptComboBox, shiftComboBox;

    public ProjectWithLayout() {
        // Main frame
        JFrame frame = new JFrame("Attendance System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1150, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);

        // Panel for employee information
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBounds(10, 10, 400, 200);
        infoPanel.setBorder(BorderFactory.createTitledBorder("Employee Information"));

        empIDField = new JTextField();
        empIDField.setBounds(120, 30, 150, 20);
        JLabel empIDLabel = new JLabel("Employee ID:");
        empIDLabel.setBounds(10, 30, 100, 20);

        firstNameField = new JTextField();
        firstNameField.setBounds(120, 60, 150, 20);
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10, 60, 100, 20);

        lastNameField = new JTextField();
        lastNameField.setBounds(120, 90, 150, 20);
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(10, 90, 100, 20);

        dobField = new JTextField();
        dobField.setBounds(120, 120, 150, 20);
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(10, 120, 100, 20);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(120, 150, 60, 20);
        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(200, 150, 80, 20);
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(10, 150, 100, 20);

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
        deptComboBox = new JComboBox<>(new String[]{"E&D", "Pro_Management", "Marketing", "Sales", "Customer Support", "Human Resources", "Finance", "Legal", "Operations", "R&D"});
        deptComboBox.setBounds(120, 30, 150, 20);

        JLabel jobTitleLabel = new JLabel("Job Title:");
        jobTitleLabel.setBounds(10, 60, 100, 20);
        jobTitleField = new JTextField();
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

        JLabel shiftLabel = new JLabel("Shift:");
        shiftLabel.setBounds(10, 30, 100, 20);
        shiftComboBox = new JComboBox<>(new String[]{"Day Shift", "Evening Shift", "Night Shift"});
        shiftComboBox.setBounds(120, 30, 150, 20);

        shiftPanel.add(shiftLabel);
        shiftPanel.add(shiftComboBox);

        // Panel for check-out
        JPanel checkOutPanel = new JPanel();
        checkOutPanel.setLayout(null);
        checkOutPanel.setBounds(420, 550, 710, 100);
        checkOutPanel.setBorder(BorderFactory.createTitledBorder("Check-out"));

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
        
        //Images
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
        JButton displayButton = new JButton("Display  ");
        displayButton.setBounds(145, 445, 120, 40);
        displayButton.setBackground(Color.white);
        displayButton.setIcon(clearimage);
        displayButton.setHorizontalAlignment(JButton.RIGHT);
        displayButton.setHorizontalTextPosition(JButton.LEFT);
        displayButton.setFocusable(false);

        // Table
        String[] columns = {"Employee ID", "First Name", "Last Name", "Date Of Birth", "Gender", "Department", "Job Title", "Work Shifts"};
        model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(420, 17, 710, 530);

        // Add components to the frame
        frame.add(infoPanel);
        frame.add(deptPanel);
        frame.add(shiftPanel);
        frame.add(checkInButton);
        frame.add(displayButton);
        frame.add(checkOutPanel);
        frame.add(scrollPane);

        // Action listeners
        checkInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                writeEmployee();
            }
        });

        displayButton.addActionListener(e -> readEmployees());

        checkOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String empIDToDelete = checkOutTextField.getText();
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).equals(empIDToDelete)) {
                        model.removeRow(i);
                        break;
                    }
                }
                checkOutTextField.setText("");
                
                employeeList.removeIf(emp -> emp.getEmpID().equals(empIDToDelete));
                saveEmployees();
            }
        });


        // Display the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ProjectWithLayout();
    }

    private void writeEmployee() {
        Employee employee = new Employee(
                empIDField.getText(),
                firstNameField.getText(),
                lastNameField.getText(),
                dobField.getText(),
                maleRadioButton.isSelected() ? "Male" : "Female",
                (String) deptComboBox.getSelectedItem(),
                jobTitleField.getText(),
                (String) shiftComboBox.getSelectedItem()
        );
        employeeList.add(employee);
        saveEmployees();
        clearFields();
    }

    private void saveEmployees() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("EmployeeAttendance.dat"))) {
            out.writeObject(employeeList);
            JOptionPane.showMessageDialog(null, "Employee data saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readEmployees() {
        employeeList.clear();
        loadEmployees();
        clearTable();
        for (Employee employee : employeeList) {
            addToTable(employee);
        }
    }

    @SuppressWarnings("unchecked")
    private void loadEmployees() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("EmployeeAttendance.dat"))) {
            employeeList = (ArrayList<Employee>) in.readObject();
            JOptionPane.showMessageDialog(null, "Employee data loaded successfully");
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addToTable(Employee employee) {
        Object[] rowData = {
                employee.getEmpID(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDob(),
                employee.getGender(),
                employee.getDepartment(),
                employee.getJobTitle(),
                employee.getWorkShift()
        };
        model.addRow(rowData);
    }

    private void clearTable() {
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void clearFields() {
        empIDField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        dobField.setText("");
        genderGroup.clearSelection();
        deptComboBox.setSelectedIndex(0);
        jobTitleField.setText("");
    }

    }

