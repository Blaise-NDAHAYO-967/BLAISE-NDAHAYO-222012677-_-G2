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

import MyEntities.Assignment;

public class AssignmentForm implements ActionListener {

	JFrame frame;//AssignmentID	CourseID	AssignmentName	DueDate
	JLabel Assgnid_lb=new JLabel("AssignmentID");
	JLabel crsid_lb=new JLabel("CourseID");
	JLabel assgname_lb=new JLabel("AssignmentName");
	JLabel duedate_lb=new JLabel("DueDate");
	
	JTextField Assgnid_txf=new JTextField();
	JTextField crsid_txf=new JTextField();
	JTextField assgname_txf=new JTextField();
	JTextField duedate_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public AssignmentForm(){
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
		frame.setTitle("Assignment Form");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		 Assgnid_lb.setBounds(10,10,170,30);
		 crsid_lb.setBounds(10,50,150,30);
		 assgname_lb.setBounds(10,90,200,30);
		 duedate_lb.setBounds(10,130,200,30);
		
		 Assgnid_txf.setBounds(250,10,190,30);
		 crsid_txf.setBounds(250,50,190,30);
		 assgname_txf.setBounds(250,90,190,30);
		 duedate_txf.setBounds(250,130,190,30);
		
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
		Assgnid_lb.setFont(font);
		crsid_lb.setFont(font);
		assgname_lb.setFont(font);
		 duedate_lb.setFont(font);
		
		 Assgnid_txf.setFont(font);
		 crsid_txf.setFont(font);
		 assgname_txf.setFont(font);
		 duedate_txf.setFont(font);

		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(Assgnid_lb);
		frame.add(crsid_lb);
		frame.add(assgname_lb);
		frame.add(duedate_lb);
		
		frame.add(Assgnid_txf);
		frame.add(crsid_txf);
		frame.add(assgname_txf);
		frame.add(duedate_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
        frame.add(table);
		ActionEvent ();
	
	
}
@Override
public void actionPerformed(ActionEvent e) {
	Assignment asg=new Assignment();
	if(e.getSource()==insert_btn) {
		asg.setCrsid(crsid_txf.getText());
		asg.setAssgname(assgname_txf.getText());
		asg.setDuedate(duedate_txf.getText());
		asg.insertData();
		
	}
	
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("AssignmentID");
        model.addColumn("CourseID");
        model.addColumn("AssignmentName");
        model.addColumn("DueDate");
    
       //AssignmentID	CourseID	AssignmentName	DueDate
        ResultSet resultSet =Assignment.viewData();
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
		int id=Integer.parseInt(Assgnid_txf.getText());
		asg.setCrsid(crsid_txf.getText());
		asg.setAssgname(assgname_txf.getText());
		asg.setDuedate(duedate_txf.getText());
		asg.update(id);
    }
  else {
		int id=Integer.parseInt(Assgnid_txf.getText());
		asg.delete(id);}
	

}
public static void main(String[] args) {
	AssignmentForm assff= new AssignmentForm();
	System.out.println(assff);
}

}

