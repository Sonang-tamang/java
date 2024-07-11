import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;

public class Gui implements ActionListener {

    private JFrame frame;
    private JButton addTutorButton, addLecturerButton, gradeAssignmentButton, setTutorSalaryButton, removeTutorButton, clearButton, displayButton;
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13;
    private JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10, textField11, textField12, textField13;
    private ArrayList<Teacher> teachers;

    public static void main(String[] args) {
        Gui guiInstance = new Gui();
        guiInstance.createGUI();
    }

    public void createGUI() {
        frame = new JFrame();
        frame.setTitle("Teacher GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(139, 196, 217));

        initializeComponents();

        frame.setVisible(true);
        
    }

    private void initializeComponents() {
        teachers = new ArrayList<>();

        addTutorButton = createButton("Add Tutor", 30, 500, 150, 40);
        addLecturerButton = createButton("Add Lecturer", 580, 410, 150, 40);
        gradeAssignmentButton = createButton("Grade Assignment", 580, 290, 150, 40);
        setTutorSalaryButton = createButton("Set Tutor Salary", 580, 530, 150, 40);
        removeTutorButton = createButton("Remove Tutor", 30, 670, 150, 40);
        clearButton = createButton("Clear", 310, 670, 150, 40);
        displayButton = createButton("Display", 580, 670, 150, 40);

        label1 = createLabel("Teacher ID", 30, 50);
        label2 = createLabel("Teacher Name", 30, 110);
        label3 = createLabel("Address", 30, 170);
        label4 = createLabel("Working Type", 30, 230);
        label5 = createLabel("Employment Status", 30, 290);
        label6 = createLabel("Years of Experience", 30, 350);
        label7 = createLabel("Department", 30, 410);
        label8 = createLabel("Working Hours", 400, 50);
        label9 = createLabel("Academic Qualifications", 400, 110);
        label10 = createLabel("Specialization", 400, 170);
        label11 = createLabel("Performance Index", 400, 230);
        label12 = createLabel("Graded Score", 400, 350);
        label13 = createLabel("Salary", 400, 470);

        textField1 = createTextField(180, 50);
        textField2 = createTextField(180, 110);
        textField3 = createTextField(180, 170);
        textField4 = createTextField(180, 230);
        textField5 = createTextField(180, 290);
        textField6 = createTextField(180, 350);
        textField7 = createTextField(180, 410);
        textField8 = createTextField(580, 50);
        textField9 = createTextField(580, 110);
        textField10 = createTextField(580, 170);
        textField11 = createTextField(580, 230);
        textField12 = createTextField(580, 350);
        textField13 = createTextField(580, 470);
        
         ImageIcon image = new ImageIcon("ING.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(139, 196, 217));

        frame.setVisible(true);

        
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.addActionListener(this);
        button.setBackground(Color.lightGray);
        button.setFocusable(false);
        frame.add(button);
        return button;
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 200, 30);
        frame.add(label);
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(170, 25));
        textField.setBounds(x, y, 170, 25);
        frame.add(textField);
        return textField;
    }

    
    

@Override


public void actionPerformed(ActionEvent e) {
    
    
    if (e.getSource() == addTutorButton) {
        addTutor();
    } else if (e.getSource() == addLecturerButton) {
        addLecturer();
    } else if (e.getSource() == gradeAssignmentButton) {
        try {
            // Parse input values needed for grading assignment
            int teacherId = Integer.parseInt(textField1.getText());
            int gradedScore = Integer.parseInt(textField12.getText());
            String department = textField7.getText();
            int yearsOfExperience = Integer.parseInt(textField6.getText());

            // Find the lecturer with the given ID from the teachers list
            for (Teacher teacher : teachers) {
                if (teacher instanceof Lecturer && teacher.getTeacherId() == teacherId) {
                    // Cast to Lecturer and call gradeAssignment method
                    Lecturer lecturer = (Lecturer) teacher;
                    lecturer.gradeAssignment(gradedScore, department, yearsOfExperience);
                    JOptionPane.showMessageDialog(null, "Assignment graded successfully!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Invalid Teacher ID.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
        }
    } else if (e.getSource() == setTutorSalaryButton) {
    // Check if teachers ArrayList is empty
    if (teachers.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No teachers available to set salary.");
        return;
    }

    try {
        // Print out the values of input fields for debugging
        System.out.println("Teacher ID: " + textField1.getText());
        System.out.println("New Salary: " + textField13.getText());
        System.out.println("New Performance Index: " + textField11.getText());

        // Parse input values
        int teacherId = Integer.parseInt(textField1.getText());
        int newSalary = Integer.parseInt(textField13.getText());
        int newPerformanceIndex = Integer.parseInt(textField11.getText());

        // Find the tutor with the given ID and set the salary
        for (Teacher teacher : teachers) {
            if (teacher instanceof Tutor && teacher.getTeacherId() == teacherId) {
                ((Tutor) teacher).setTutorSalary(newSalary, newPerformanceIndex);
                JOptionPane.showMessageDialog(null, "Tutor salary updated successfully!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Invalid Teacher ID.");
    } catch (NumberFormatException ex) {
        ex.printStackTrace(); // Print the stack trace for detailed error information
        
        // Print out the input fields again for further debugging
        System.out.println("Unexpected input values:");
        System.out.println("Teacher ID: " + textField1.getText());
        System.out.println("New Salary: " + textField13.getText());
        System.out.println("New Performance Index: " + textField11.getText());
        
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
    }
}
else if (e.getSource() == removeTutorButton) {
        removeTutor();
    } else if (e.getSource() == clearButton) {
        clearFields();
    } else if (e.getSource() == displayButton) {
        // Flag to check if any details are added
        boolean detailsAdded = false;
        // Loop through the teachers list
        for (Teacher teacher : teachers) {
            // Check if the teacher is a Lecturer
            if (teacher instanceof Lecturer) {
                // Call display method of Lecturer
                ((Lecturer) teacher).displayLecturerInfo();
                // Set flag to true
                detailsAdded = true;
                // Show message indicating details added
                JOptionPane.showMessageDialog(null, "Lecturer details displayed");
            } else if (teacher instanceof Tutor) {
                // Call display method of Tutor
                ((Tutor) teacher).displayTutorInfo();
                // Set flag to true
                detailsAdded = true;
                // Show message indicating details added
                JOptionPane.showMessageDialog(null, "Tutor details displayed");
            }
        }
        // If no details are added, show message
        if (!detailsAdded) {
            JOptionPane.showMessageDialog(null, "No teacher details available");
        }
    }
    
}
    private void displayAllTeacherInfo() {
        displayTeacherInfo();
        displayTutorInfo();
        displayLecturerInfo();
    }

    private void displayTeacherInfo() {
        StringBuilder teacherInfo = new StringBuilder();
        // Iterate through the teachers list and append info for each teacher
        for (Teacher teacher : teachers) {
            teacherInfo.append(teacher.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, teacherInfo.toString(), "Teacher Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void displayTutorInfo() {
        StringBuilder tutorInfo = new StringBuilder();
        // Iterate through the teachers list and append info for each tutor
        for (Teacher teacher : teachers) {
            if (teacher instanceof Tutor) {
                tutorInfo.append(teacher.toString()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, tutorInfo.toString(), "Tutor Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void displayLecturerInfo() {
        StringBuilder lecturerInfo = new StringBuilder();
        // Iterate through the teachers list and append info for each lecturer
        for (Teacher teacher : teachers) {
            if (teacher instanceof Lecturer) {
                lecturerInfo.append(teacher.toString()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, lecturerInfo.toString(), "Lecturer Information", JOptionPane.INFORMATION_MESSAGE);
    }





    





    private void addTutor() {
    try {
        // Check if any text field is empty
        if (isEmptyTextFields()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return;
        }
        
        // Parse input values
        int teacherId = Integer.parseInt(textField1.getText());
        String teacherName = textField2.getText();
        String address = textField3.getText();
        String workingType = textField4.getText();
        String employmentStatus = textField5.getText();
        int workingHours = Integer.parseInt(textField8.getText());
        double salary = Double.parseDouble(textField13.getText());
        String specialization = textField10.getText();
        String academicQualifications = textField9.getText();
        int performanceIndex = Integer.parseInt(textField11.getText());

        // Check for duplicate teacher ID
        if (isDuplicateTeacherId(teacherId)) {
            JOptionPane.showMessageDialog(null, "Teacher ID already exists.");
            return;
        }

        // Create new Tutor object
        Tutor newTutor = new Tutor(teacherId, teacherName, address, workingType, employmentStatus,
                workingHours, salary, specialization, academicQualifications, performanceIndex);
        
        // Add to ArrayList
        teachers.add(newTutor);
        JOptionPane.showMessageDialog(null, "Tutor added successfully!");
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
    }
}

private boolean isEmptyTextFields() {
    // Check if any text field is empty
    for (Component component : frame.getContentPane().getComponents()) {
        if (component instanceof JTextField) {
            if (((JTextField) component).getText().trim().isEmpty()) {
                return true;
            }
        }
    }
    return false;
}

private boolean isDuplicateTeacherId(int teacherId) {
    // Check for duplicate teacher ID
    for (Teacher teacher : teachers) {
        if (teacher.getTeacherId() == teacherId) {
            return true;
        }
    }
    return false;
}






// Implement similar checks for other methods...

   private void addLecturer() {
    try {
        // Check if any text field is empty
        if (isEmptyTextFields()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return;
        }

        // Parse input values
        int teacherId = Integer.parseInt(textField1.getText());
        String teacherName = textField2.getText();
        String address = textField3.getText();
        String workingType = textField4.getText();
        String employmentStatus = textField5.getText();
        String yearsOfExperience = textField6.getText(); // Use String instead of int
        int gradedScore = Integer.parseInt(textField12.getText());

        // Check for duplicate teacher ID
        if (isDuplicateTeacherId(teacherId)) {
            JOptionPane.showMessageDialog(null, "Teacher ID already exists.");
            return;
        }

        // Create new Lecturer object
        Lecturer newLecturer = new Lecturer(teacherId, teacherName, address, workingType, employmentStatus,
               yearsOfExperience, gradedScore);
               
        // Add to ArrayList
        teachers.add(newLecturer);

        JOptionPane.showMessageDialog(null, "Lecturer added successfully!");
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
    }
}





private void removeTutor() {
    // Check if teachers ArrayList is empty
    if (teachers.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No teachers available to remove.");
        return;
    }

    try {
        // Parse input values
        int teacherId = Integer.parseInt(textField1.getText());

        // Find the tutor with the given ID and remove it
        for (Teacher teacher : teachers) {
            if (teacher instanceof Tutor && teacher.getTeacherId() == teacherId) {
                teachers.remove(teacher);
                JOptionPane.showMessageDialog(null, "Tutor removed successfully!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Invalid Teacher ID.");
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
    }
}
private void displayInfo() {
    // Check if teachers ArrayList is empty
    if (teachers.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No teachers available to display information.");
        return;
    }

    // Display information about each teacher
    StringBuilder info = new StringBuilder();
    for (Teacher teacher : teachers) {
        info.append(teacher.toString()).append("\n");
    }
    displayButton.addActionListener(this);

    // Show the information in a dialog
    JOptionPane.showMessageDialog(null, info.toString());
}

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
        textField8.setText("");
        textField9.setText("");
        textField10.setText("");
        textField11.setText("");
        textField12.setText("");
        textField13.setText("");
    }
    
    

   
    
}

