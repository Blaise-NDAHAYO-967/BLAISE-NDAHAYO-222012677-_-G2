package MyForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import MyEntities.Enrollment;

public class EnrollmentForm implements ActionListener{
	JFrame frame;//EnrollmentID	student_id	CourseID	EnrollmentDate
	JLabel enrllid_lb=new JLabel("EnrollmentID");
	JLabel stid_lb=new JLabel("student_id");
	JLabel crsid_lb=new JLabel("CourseID");
	JLabel enrllname_lb=new JLabel("EnrollmentDate");
	
	JTextField enrllid_txf=new JTextField();
	JTextField stid_txf=new JTextField();
	JTextField crsid_txf=new JTextField();
	JTextField enrllname_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public EnrollmentForm(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
	}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("ENROLLMENT FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		enrllid_lb.setBounds(10,10,130,30);
		stid_lb.setBounds(10,50,150,30);
		crsid_lb.setBounds(10,90,200,30);
		enrllname_lb.setBounds(10,130,200,30);
		
		enrllid_txf.setBounds(250,10,190,30);
		stid_txf.setBounds(250,50,190,30);
		crsid_txf.setBounds(250,90,190,30);
		enrllname_txf.setBounds(250,130,190,30);
		
		insert_btn.setBounds(10,220,85,30);
		read_btn.setBounds(100,220,85,30);
		update_btn.setBounds(190,220,85,30);
		delete_btn.setBounds(280,220,85,30);
		
		table.setBounds(500, 10, 600, 240);
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		 enrllid_lb.setFont(font);
		 stid_lb.setFont(font);
		 crsid_lb.setFont(font);
		 enrllname_lb.setFont(font);
		
		 enrllid_txf.setFont(font);
		 stid_txf.setFont(font);
		 crsid_txf.setFont(font);
		 enrllname_txf.setFont(font);
		 
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(enrllid_lb);
		frame.add(stid_lb);
		frame.add(crsid_lb);
		frame.add(enrllname_lb);
		
		frame.add(enrllid_txf);
		frame.add(stid_txf);
		frame.add(crsid_txf);
		frame.add(enrllname_txf);
;

		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
        frame.add(table);
		ActionEvent ();
	
	
}
@Override
public void actionPerformed(ActionEvent e) {
	Enrollment en=new Enrollment();
	if(e.getSource()==insert_btn) {
		
		en.setStid(stid_txf.getText());
		en.setCrsid(crsid_txf.getText());
		en.setEnrllname(enrllname_txf.getText());
		en.insertData();
		
	}
	
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("EnrollmentID");
        model.addColumn("student_id");
        model.addColumn("CourseID");
        model.addColumn("EnrollmentDate");
    
       //EnrollmentID	student_id	CourseID	EnrollmentDate
        ResultSet resultSet =Enrollment.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3),resultSet.getString(4)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } 

else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(enrllid_txf.getText());

		en.setStid(stid_txf.getText());
		en.setCrsid(crsid_txf.getText());
		en.setEnrllname(enrllname_txf.getText());
		en.update(id);
    }
  else {
		int id=Integer.parseInt(enrllid_txf.getText());
		en.delete(id);}
	

}
public static void main(String[] args) {
	EnrollmentForm enlf= new EnrollmentForm();
	System.out.println(enlf);


}
}