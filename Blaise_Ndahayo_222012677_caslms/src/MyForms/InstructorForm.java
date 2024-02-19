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

import MyEntities.Instructors;

public class InstructorForm  implements ActionListener{
	JFrame frame;//InstructorID	InstructorName	ContactInfo
	JLabel instrctid_lb=new JLabel("InstructorID");
	JLabel instrctname_lb=new JLabel("InstructorName");
	JLabel cntctinfo_lb=new JLabel("ContactInfo");
	
	JTextField  instrctid_txf=new JTextField();
	JTextField instrctname_txf=new JTextField();
	JTextField cntctinfo_txf=new JTextField();

	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public InstructorForm(){
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
		frame.setTitle("INSTRUCTOR FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		instrctid_lb.setBounds(10,10,130,30);
		instrctname_lb.setBounds(10,50,150,30);
		cntctinfo_lb.setBounds(10,90,200,30);
	
		instrctid_txf.setBounds(250,10,190,30);
		instrctname_txf.setBounds(250,50,190,30);
		cntctinfo_txf.setBounds(250,90,190,30);
	
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
		instrctid_lb.setFont(font);
		instrctname_lb.setFont(font);
		cntctinfo_lb.setFont(font);

		instrctid_txf.setFont(font);
		instrctname_txf.setFont(font);
		cntctinfo_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(instrctid_lb);
		frame.add(instrctname_lb);
		frame.add( cntctinfo_lb);
		
		frame.add(instrctid_txf);
		frame.add(instrctname_txf);
		frame.add( cntctinfo_txf);
		
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
        frame.add(table);
		ActionEvent ();
	}
@Override
public void actionPerformed(ActionEvent e) {
	Instructors in=new Instructors();
	if(e.getSource()==insert_btn) {
		in.setInstrctname(instrctname_txf.getText());
		in.setCntctinfo(cntctinfo_txf.getText());
		in.insertData();
		
	}
	
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("InstructorID");
        model.addColumn("InstructorName");
        model.addColumn("ContactInfo");
       //InstructorID	InstructorName	ContactInfo
        ResultSet resultSet =Instructors.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } 

else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(instrctid_txf.getText());
		in.setInstrctname(instrctname_txf.getText());
		in.setCntctinfo(cntctinfo_txf.getText());
		in.update(id);
    }
  else {
		int id=Integer.parseInt(instrctid_txf.getText());
		in.delete(id);}

  }	

public static void main(String[] args) {
	InstructorForm insf= new InstructorForm();
	System.out.println(insf);

}

}  