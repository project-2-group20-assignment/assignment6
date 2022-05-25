/* Byron Young
   Text File Handling With GUI Assignment 6
   218155077 
 */
package za.ac.cput.textFileHandlingAssignment6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentDataGui extends JFrame implements ActionListener {
// Declare variables

    private JFrame mainFrame;
    private JPanel panelSouth, panelCenter, panelLabel, panelNorth;
    private JButton btnSaveToFile, btnExit;
    private JLabel lblTitle, lblFirstName, lblLastName, lblStudentNo, lblEmail, lblAcademicYear, lblChangedStream, lblStream, lblHeading, lblPicture;
    private JTextField txtFirstName, txtLastName, txtStudentNo, txtEmail;
    private Font ft1, ft2;

    String[] titleArray = {"Please select title", "Mr", "Ms", "Mrs"};
    String[] academicYearArray = {"Please select academic year", "1st Year", "2nd Year", "3rd Year"};

    //FileWriter fileWriter;
    FileWriter fw;
    BufferedWriter bw;
//Declare JComboBox
    private JComboBox comboBoxTitle, comboBoxAcademicYear;

    //Declare JCheckBoxess
    private JCheckBox chkYes = new JCheckBox("Yes");
    private JCheckBox chkNo = new JCheckBox("No");

//Declare JRadioButtons
    private JRadioButton radAppDev = new JRadioButton("AppDev");
    private JRadioButton radMultimedia = new JRadioButton("Multimedia");
    private JRadioButton radComNet = new JRadioButton("ComNet");

//Instantiate all the instance variables in the constructor
    public StudentDataGui() {
        super("DPICTA Student Data Capturing System");

        panelNorth = new JPanel();

        panelSouth = new JPanel();
        panelCenter = new JPanel();
        //panelLabel = new JPanel();

        btnSaveToFile = new JButton("Save To File");

        btnExit = new JButton("Exit");

        txtFirstName = new JTextField(15);
        txtLastName = new JTextField(15);
        txtStudentNo = new JTextField(9);
        txtEmail = new JTextField(25);

        lblTitle = new JLabel("Title:");
        lblFirstName = new JLabel("First Name:");
        lblLastName = new JLabel("Last Name:");
        lblStudentNo = new JLabel("Student No:");
        lblEmail = new JLabel("Email Address:");
        lblAcademicYear = new JLabel("Academic Year:");
        lblStream = new JLabel("Academic Stream:");
        lblChangedStream = new JLabel("Did you change your stream?");

        comboBoxTitle = new JComboBox(titleArray);
        comboBoxAcademicYear = new JComboBox(academicYearArray);
        ft1 = new Font("Poppins", Font.BOLD, 18);
        ft2 = new Font("Poppins", Font.BOLD, 13);

// Panel background colors
    }

    //Settting up the GUI
    public void setGUI() {
        /*------------------North Panel-----------------------------*/
        panelNorth.setBackground(Color.white);
        panelNorth.setLayout(new BorderLayout());
        panelNorth.setPreferredSize(new Dimension(700, 100));
        this.add(panelNorth, BorderLayout.NORTH);

        ImageIcon icon = new ImageIcon("cput_logo_resized_Latest.png");
        JLabel lblHeading = new JLabel();
        panelNorth.add(lblHeading);
        lblHeading.setText("DPICTA Student Data Capturing System");
        lblHeading.setIcon(icon);
        lblHeading.setFont(ft1);
        lblHeading.setVerticalAlignment(JLabel.CENTER);
        lblHeading.setHorizontalAlignment(JLabel.CENTER);


        /*------------------End North Panel-----------------------------*/
 /*------------------Center Panel-----------------------------*/
//        panelCenter.setLayout(new FlowLayout());
//        panelCenter.setPreferredSize(new Dimension(800, 100));
//        this.add(panelCenter, BorderLayout.CENTER);
        panelCenter.setBackground(Color.lightGray);
        panelCenter.setBorder(BorderFactory.createEmptyBorder(30, 200, 30, 200));
        panelCenter.setLayout(new GridLayout(0, 1));

        panelCenter.setPreferredSize(new Dimension(700, 650));
        this.add(panelCenter, BorderLayout.CENTER);

        panelCenter.add(lblTitle);
        panelCenter.add(comboBoxTitle);
        lblTitle.setFont(ft2);

        panelCenter.add(lblFirstName);
        panelCenter.add(txtFirstName);
        lblFirstName.setFont(ft2);

        panelCenter.add(lblLastName);
        panelCenter.add(txtLastName);
        lblLastName.setFont(ft2);

        panelCenter.add(lblEmail);
        panelCenter.add(txtEmail);
        lblEmail.setFont(ft2);

        panelCenter.add(lblStudentNo);
        panelCenter.add(txtStudentNo);
        lblStudentNo.setFont(ft2);

        panelCenter.add(lblAcademicYear);
        panelCenter.add(comboBoxAcademicYear);
        lblAcademicYear.setFont(ft2);

        ButtonGroup radGroup = new ButtonGroup();
        radGroup.add(radAppDev);
        radGroup.add(radMultimedia);
        radGroup.add(radComNet);
        panelCenter.add(lblStream);
        panelCenter.add(radAppDev);
        panelCenter.add(radMultimedia);
        panelCenter.add(radComNet);
        lblStream.setFont(ft2);

        ButtonGroup chkGroup = new ButtonGroup();
        chkGroup.add(chkYes);
        chkGroup.add(chkNo);

        panelCenter.add(lblChangedStream);
        panelCenter.add(chkYes);
        panelCenter.add(chkNo);
        lblChangedStream.setFont(ft2);


        /*------------------End Center Panel-----------------------------*/

 /*------------------South Panel-----------------------------*/
        panelSouth.setBackground(Color.blue);
        panelSouth.setLayout(new GridLayout(1, 2));
        panelSouth.setPreferredSize(new Dimension(700, 40));
        this.add(panelSouth, BorderLayout.SOUTH);
        panelSouth.add(btnSaveToFile);

        panelSouth.add(btnExit);

        /*------------------End South Panel-----------------------------*/
        //Components Action Listeners
        comboBoxTitle.addActionListener(this);
        comboBoxAcademicYear.addActionListener(this);

        btnSaveToFile.addActionListener(this);

        btnExit.addActionListener(this);

        this.pack();
        //this.setSize(800, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static boolean isWord(String in) {

        return Pattern.matches("[a-zA-Z]+", in);
    }

    public static boolean isEmail(String str) {
        String[] atSeparator = str.split("@");

        if (atSeparator.length == 2 && atSeparator[1].contains(".")) {
            return true;
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSaveToFile) {

            String title = "";
            String firstName, lastName, email = "";
            String academicYear = "";
            String academicStream = "";
            String studentNo = "";
            boolean streamChanged = false;

            title = comboBoxTitle.getSelectedItem() + "";
            academicYear = comboBoxAcademicYear.getSelectedItem() + "";
            firstName = txtFirstName.getText();
            lastName = txtLastName.getText();
            email = txtEmail.getText();
            studentNo = txtStudentNo.getText();

            if (title.equals("Mr") || title.equals("Mrs") || title.equals("Ms")) {
                title = comboBoxTitle.getSelectedItem() + "";

            } else {
                JOptionPane.showMessageDialog(null, "Please select title");
            }

            if (academicYear.equals("1st Year") || academicYear.equals("2nd Year") || academicYear.equals("3rd Year")) {
                academicYear = comboBoxAcademicYear.getSelectedItem() + "";

            } else {
                JOptionPane.showMessageDialog(null, "Please select academic year");
            }

            if (radAppDev.isSelected()) {
                academicStream = radAppDev.getText();

            } else if (radMultimedia.isSelected()) {
                academicStream = radMultimedia.getText();

            } else if (radComNet.isSelected()) {
                academicStream = radComNet.getText();
            } else {
                JOptionPane.showMessageDialog(null, "Please choose your academic stream");
            }

            if (chkYes.isSelected()) {

                streamChanged = true;

            } else if (chkNo.isSelected()) {
                streamChanged = false;
            } else {
                JOptionPane.showMessageDialog(null, "Please choose whether you have changed your academic stream");

            }

            if (firstName.equals("") || lastName.equals("") || (!isWord(txtFirstName.getText()) || lastName.equals(""))
                    || !isWord(txtLastName.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid name or surname. Please check format ");

            } else if (email.equals("") || (!(isEmail(email)))) {

                JOptionPane.showMessageDialog(null, "Invalid email address. Please check format");

            } else if (studentNo.equals("") || !studentNo.matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null, "Invalid student number. Please check format");

            } else if (studentNo.length() > 9) {

                JOptionPane.showMessageDialog(null, "Invalid student number length. Please enter 9 digits");
            } else {
                Student objStudent = new Student(title, firstName, lastName, email, studentNo, academicYear, academicStream, streamChanged);
                objStudent.writeToFile();
            }

            comboBoxTitle.setSelectedIndex(0);
            comboBoxAcademicYear.setSelectedIndex(0);
            txtFirstName.setText("");
            txtLastName.setText("");
            txtEmail.setText("");
            txtStudentNo.setText("");
            chkYes.setSelected(false);
            chkNo.setSelected(false);
            radAppDev.setSelected(false);
            radMultimedia.setSelected(false);
            radComNet.setSelected(false);
            txtFirstName.requestFocus();

        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

    }
//Main Method
    public static void main(String[] args) {
        StudentDataGui objStudentData = new StudentDataGui();
        objStudentData.setGUI();

    }
}
