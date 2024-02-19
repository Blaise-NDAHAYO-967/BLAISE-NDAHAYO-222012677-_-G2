package MENU.COM;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import MyForms.AssignmentForm;
import MyForms.CourseForm;
import MyForms.EnrollmentForm;
import MyForms.InstructorForm;
import MyForms.StudentForm;
import MyForms.SubmissionForm;


public class MenuForm extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Assignmentmenu;
    private JMenu Coursesmenu;
    private JMenu Enrollmentmenu;
    private JMenu Instructorsmenu;
    private JMenu Studentmenu;
    private JMenu Submissionmenu;
    private JMenu Logoutmenu;
    
    public MenuForm() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem AssignmentItem;
    private JMenuItem CoursesItem;
    private JMenuItem EnrollmentItem;
    private JMenuItem InstructorsItem;
    private JMenuItem StudentItem;
    private JMenuItem SubmissionItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public MenuForm(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Assignmentmenu = new JMenu("Assignment");
        Coursesmenu = new JMenu("Courses");
        Enrollmentmenu= new JMenu("Enrollment");
        Instructorsmenu = new JMenu("Instructors ");
        Studentmenu = new JMenu("Student");
        Submissionmenu = new JMenu("Submission");
        Logoutmenu = new JMenu("SIGNING OUT");
        		

        // Create menu items
        menuBar.add(Assignmentmenu);
        AssignmentItem = new JMenuItem("AssignmentForm");
        AssignmentItem.addActionListener(this);
        
        menuBar.add(Coursesmenu);
        CoursesItem = new JMenuItem("CoursesForm");
        CoursesItem.addActionListener(this);
        
        menuBar.add(Enrollmentmenu);
        EnrollmentItem = new JMenuItem("EnrollmentForm");
        EnrollmentItem.addActionListener(this);
        
        menuBar.add(Instructorsmenu);
        InstructorsItem = new JMenuItem("InstructorsForm");
        InstructorsItem.addActionListener(this);
        
        menuBar.add(Studentmenu);
        StudentItem = new JMenuItem("StudentForm");
        StudentItem.addActionListener(this);
        
        menuBar.add(Submissionmenu);
        SubmissionItem = new JMenuItem("SubmissionForm");
        SubmissionItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Assignmentmenu.add(AssignmentItem);
        Coursesmenu.add(CoursesItem);
        Enrollmentmenu.add(EnrollmentItem);
        Instructorsmenu.add(InstructorsItem);
        Studentmenu.add(StudentItem);
        Submissionmenu.add(SubmissionItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AssignmentItem) {
            new AssignmentForm();
        
        } else if (e.getSource() == CoursesItem) {
            new CourseForm();
        
        } else if (e.getSource() == EnrollmentItem) {
            new EnrollmentForm();
       
        } else if (e.getSource() == InstructorsItem) {
           new InstructorForm();
        

        } else if (e.getSource() == StudentItem) {
           new StudentForm();
        
        } else if (e.getSource() == SubmissionItem) {
           new SubmissionForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuForm("TO CAS MANAGEMENT SYSTEM"));
    }
}





