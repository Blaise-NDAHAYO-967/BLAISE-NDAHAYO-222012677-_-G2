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

import MyEntities.Submission;

public class SubmissionForm implements ActionListener{
	JFrame frame;//SubmissionID	AssignmentID	student_id	SubmissionDate	FilePath
	JLabel sbmid_lb=new JLabel("SubmissionID");
	JLabel assgnid_lb=new JLabel("AssignmentID");
	JLabel stid_lb=new JLabel("student_id");
	JLabel sbmdate_lb=new JLabel("SubmissionDate");
	JLabel filpath_lb=new JLabel("FilePath");
	
	JTextField sbmid_txf=new JTextField();
	JTextField assgnid_txf=new JTextField();
	JTextField stid_txf=new JTextField();
	JTextField sbmdate_txf=new JTextField();
	JTextField filpath_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public SubmissionForm(){
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
		frame.setTitle("SUBMISSION FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		sbmid_lb.setBounds(10,10,170,30);
		assgnid_lb.setBounds(10,50,150,30);
		stid_lb.setBounds(10,90,200,30);
		sbmdate_lb.setBounds(10,130,200,30);
		filpath_lb.setBounds(10,170,200,30);
		
		sbmid_txf.setBounds(250,10,190,30);
		assgnid_txf.setBounds(250,50,190,30);
		stid_txf.setBounds(250,90,190,30);
		sbmdate_txf.setBounds(250,130,190,30);
		filpath_txf.setBounds(250,170,190,30);
		
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
		sbmid_lb.setFont(font);
		assgnid_lb.setFont(font);
		stid_lb.setFont(font);
		sbmdate_lb.setFont(font);
		filpath_lb.setFont(font);
		
		 sbmid_txf.setFont(font);
		 assgnid_txf.setFont(font);
		 stid_txf.setFont(font);
		 sbmdate_txf.setFont(font);
		 filpath_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(sbmid_lb);
		frame.add(assgnid_lb);
		frame.add(stid_lb);
		frame.add(sbmdate_lb);
		frame.add(filpath_lb);
		
		frame.add(sbmid_txf);
		frame.add(assgnid_txf);
		frame.add(stid_txf);
		frame.add(sbmdate_txf);
		frame.add(filpath_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
        frame.add(table);
		ActionEvent ();
	
}

@Override
public void actionPerformed(ActionEvent e) {
	Submission sm=new Submission();
	if(e.getSource()==insert_btn) {
		sm.setAssgnid(assgnid_txf.getText());
		sm.setStid(stid_txf.getText());
		sm.setSbmdate(sbmdate_txf.getText());
		sm.setFilpath(filpath_txf.getText());
		sm.insertData();
		
	}
	
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("SubmissionID");
        model.addColumn("AssignmentID");
        model.addColumn("student_id");
        model.addColumn("SubmissionDate");
        model.addColumn("FilePath");
    
       //SubmissionID	AssignmentID	student_id	SubmissionDate	FilePath
        ResultSet resultSet =Submission.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } 

else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(sbmid_txf.getText());
		sm.setAssgnid(assgnid_txf.getText());
		sm.setStid(stid_txf.getText());
		sm.setSbmdate(sbmdate_txf.getText());
		sm.setFilpath(filpath_txf.getText());
		sm.update(id);
    }
  else {
		int id=Integer.parseInt(sbmid_txf.getText());
		sm.delete(id);}

  }	
	public static void main(String[] args) {
		SubmissionForm sbmf= new SubmissionForm();
		System.out.println(sbmf);

	
	}

}

