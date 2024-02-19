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

import MyEntities.Courses;

public class CourseForm implements ActionListener{
	JFrame frame;//CourseID	CourseName	Description	InstructorID
	JLabel crsid_lb=new JLabel("CourseID");
	JLabel crsname_lb=new JLabel("CourseName");
	JLabel dscrption_lb=new JLabel("Description");
	JLabel instrid_lb=new JLabel("InstructorID");
	
	JTextField crsid_txf=new JTextField();
	JTextField crsname_txf=new JTextField();
	JTextField dscrption_txf=new JTextField();
	JTextField instrid_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public CourseForm(){
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
		frame.setTitle("COURSE FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		crsid_lb.setBounds(10,10,130,30);
		crsname_lb.setBounds(10,50,150,30);
		dscrption_lb.setBounds(10,90,200,30);
		instrid_lb.setBounds(10,130,200,30);
		
		crsid_txf.setBounds(250,10,190,30);
		crsname_txf.setBounds(250,50,190,30);
		dscrption_txf.setBounds(250,90,190,30);
		instrid_txf.setBounds(250,130,190,30);

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
		crsid_lb.setFont(font);
		 crsname_lb.setFont(font);
		 dscrption_lb.setFont(font);
		 instrid_lb.setFont(font);
		
		crsid_txf.setFont(font);
		 crsname_txf.setFont(font);
		 dscrption_txf.setFont(font);
		 instrid_txf.setFont(font);

		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(crsid_lb);
		frame.add(crsname_lb);
		frame.add(dscrption_lb);
		frame.add(instrid_lb);
		
		frame.add(crsid_txf);
		frame.add(crsname_txf);
		frame.add(dscrption_txf);
		frame.add(instrid_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
        frame.add(table);
		ActionEvent ();
	
}

@Override
public void actionPerformed(ActionEvent e) {
	Courses cr=new Courses();
	if(e.getSource()==insert_btn) {
		cr.setCrsname(crsname_txf.getText());
		cr.setDscrption(dscrption_txf.getText());
		cr.setInstrid(instrid_txf.getText());
		cr.insertData();
		
	}
	
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("CourseID");
        model.addColumn("CourseName");
        model.addColumn("Description");
        model.addColumn("InstructorID");
    
       //CourseID	CourseName	Description	InstructorID
        ResultSet resultSet =Courses.viewData();
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
		int id=Integer.parseInt(crsid_txf.getText());
		cr.setCrsname(crsname_txf.getText());
		cr.setDscrption(dscrption_txf.getText());
		cr.setInstrid(instrid_txf.getText());
		cr.update(id);
    }
  else {
		int id=Integer.parseInt(crsid_txf.getText());
		cr.delete(id);}

  }	
	public static void main(String[] args) {
		CourseForm crsf= new CourseForm();
		System.out.println(crsf);

	
	}

}
