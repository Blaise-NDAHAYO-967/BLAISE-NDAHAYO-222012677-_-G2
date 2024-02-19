package SinUpAdmin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Admin.Admin;
import LogInAdmin.AdminLogin;

public class AdminSignup extends JFrame{
	
    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fnametext;
	private JTextField lnametext;
	private JTextField phonetext;
	private JTextField martialStatustext;
	
	private JTextField emailtext;
	private JPasswordField passwordtext;
	private JComboBox gendertxt;
	private JComboBox dobtxt;

	/**
	 * Launch the application.
	 */

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			AdminSignup frame = new AdminSignup();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});
}

/**
* Create the frame.
*/

public AdminSignup() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 633, 505);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setTitle("REGISTRATION FORM");
contentPane.setBackground(Color.LIGHT_GRAY);
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblfnmae = new JLabel("First_Name:");
lblfnmae.setBounds(10, 25, 77, 23);
contentPane.add(lblfnmae);

JLabel lbllname = new JLabel("Last_Name:");
lbllname.setBounds(10, 72, 77, 23);
contentPane.add(lbllname);

fnametext = new JTextField();
fnametext.setBounds(97, 20, 180, 33);
contentPane.add(fnametext);
fnametext.setColumns(10);

lnametext = new JTextField();
lnametext.setBounds(97, 74, 180, 33);
lnametext.setColumns(10);
contentPane.add(lnametext);

JLabel lblPhone = new JLabel("Phone:");
lblPhone.setBounds(10, 130, 77, 23);
contentPane.add(lblPhone);

phonetext = new JTextField();
phonetext.setBounds(97, 130, 180, 33);
phonetext.setColumns(10);
contentPane.add(phonetext);

JLabel lblGender = new JLabel(" Gender :");
lblGender.setBounds(10, 190, 77, 23);
contentPane.add(lblGender);

JLabel lblMartialStatus = new JLabel("Martial status:");
lblMartialStatus.setBounds(348, 25, 150, 23);
contentPane.add(lblMartialStatus);

martialStatustext = new JTextField();
martialStatustext.setBounds(430, 20, 180, 33);
martialStatustext.setColumns(10);
contentPane.add(martialStatustext);

JLabel lblDateOfBirth = new JLabel("Date of Birth:");
lblDateOfBirth.setBounds(348, 72, 77, 23);
contentPane.add(lblDateOfBirth);


JLabel lblEmail = new JLabel("Email:");
lblEmail.setBounds(348, 130, 77, 23);
contentPane.add(lblEmail);

emailtext = new JTextField();
emailtext.setBounds(430, 130, 180, 33);
emailtext.setColumns(10);
contentPane.add(emailtext);

JLabel lblPhone_1_1 = new JLabel("Password:");
lblPhone_1_1.setBounds(348, 183, 77, 23);
contentPane.add(lblPhone_1_1);

passwordtext = new JPasswordField();
passwordtext.setBounds(430, 179, 182, 33);
contentPane.add(passwordtext);

JButton btnNewButton = new JButton("CANCEL");
btnNewButton.setBounds(209, 285, 126, 33);
contentPane.add(btnNewButton);

JButton signUp = new JButton("SIGN UP");
signUp.setBounds(380, 285, 132, 33);
signUp.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		AdminLogin frame = new AdminLogin();
		frame.setVisible(true);
		Admin ad = new Admin();
		if(e.getSource()==signUp) {
			ad.setFname(fnametext.getText());
			ad.setLname(lnametext.getText());
			ad.setPhone(phonetext.getText());
			ad.setMartialStatus(martialStatustext.getText());
			String selectedOption = gendertxt.getSelectedItem().toString();
			ad.setGender(selectedOption);
			
			String selectedOption2 = dobtxt.getSelectedItem().toString();
			ad.setDoB(selectedOption2);
			ad.setEmail(emailtext.getText());
			char[] passwordChars = passwordtext.getPassword();
			String passwordString = new String(passwordChars);
			ad.setPassword(passwordString);
			ad.insertData();
			System.out.print(ad.getFname() + " " + ad.getLname() + " " + ad.getGender() + " " + ad.getPhone() + " " + ad.getMartialStatus() + " " + ad.getDoB() + " " + ad.getEmail() + " " + ad.getPassword() );
		}
	}
});
contentPane.add(signUp);
String[] gender = {"Male", "Female"};
gendertxt = new JComboBox(gender);
gendertxt.setBounds(97, 190, 180, 23);
contentPane.add(gendertxt);

String[] Date_of_Birth= {"1988","1989","1990","1991", "1992","1993", "1994","1995", "1996","1997", "1998","1999", "2000",
		                 "2001", "2002","2003", "2004","2005"};
dobtxt = new JComboBox(Date_of_Birth);

dobtxt.setBounds(430, 73, 180, 33);

contentPane.add(dobtxt);
}


}




