import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class StudentManagementSystem extends JFrame{
	/**
	 * Student management system
	 */
	private static final long serialVersionUID = 1L;
	public  JTextField stnameTextfield;
	public 	JTextField yearTextfield;
	public  JLabel yearLabel;
	public  JLabel studentLabel;
	public  JLabel subLabel;
	public  JLabel assLabel;
	public  JLabel achievmentLabel;
	public  JComboBox<String> subCombo;
	public  JComboBox<String> assCombo;
	public  JComboBox<String> gradeCombo;
	public  JTextArea textarea;
	public  JPanel jp1;
	public  JPanel jp2;
	public  JPanel jp3;
	public  JButton createStudent;
	public  JButton loadAssesment;
	public  JButton displayAssesment;
	public  JButton setGrade;
	public  JButton displayGrade;
	public  JButton clearGrade;
	public  JButton exit;

	
	public static void main(String args[]) {
		StudentManagementSystem sm=new StudentManagementSystem();
		sm.setFrame();
	}
	public  void setFrame() {
		StudentManagementSystem frame=new StudentManagementSystem();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Student Management System");
		frame.setSize(1300,900);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(setPanelTop(),new BorderLayout().NORTH);
		frame.add(setPanelMiddle(),new BorderLayout().CENTER);
		frame.add(setPanelBottom(),new BorderLayout().SOUTH);
		frame.pack();
	}
	public  JPanel setPanelTop() {
		stnameTextfield = new JTextField(25);
		yearTextfield = new JTextField(6);
		yearLabel = new JLabel("Year Level:");
		studentLabel = new JLabel("Student Name:");
		subLabel = new JLabel("Subjects:");
		assLabel = new JLabel("Assements:");
		achievmentLabel = new JLabel("Achievements");
		subCombo = new JComboBox<String>();
		assCombo = new JComboBox<String>();
		gradeCombo = new JComboBox<String>();
		jp1 = new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
		jp1.add(studentLabel);
		jp1.add(stnameTextfield);
		jp1.add(yearLabel);
		jp1.add(yearTextfield);
		jp1.add(subLabel);
		jp1.add(subCombo);
		jp1.add(assLabel);
		jp1.add(assCombo);
		jp1.add(achievmentLabel);
		jp1.add(gradeCombo);
		jp1.setBorder(settitleBorder("Study Progress Monitor"));
		return jp1;
		
	}
	public  JPanel setPanelMiddle() {
		jp2=new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
		textarea=new JTextArea(15,50);
		textarea.setLineWrap(true);
		textarea.setText("Hello welcome!!! \n You can now add students by clicking create student");
		jp2.setBorder(settitleBorder("Student Performances"));
		jp2.add(textarea);
		return jp2;
		
		
	}
	public  JPanel setPanelBottom() {
		jp3=new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
		createStudent=new JButton("Create Student");
		loadAssesment=new JButton("Load Assesment");
		loadAssesment.setEnabled(false);
		displayAssesment=new JButton("Display Assesment");
		setGrade=new JButton("Set Grade");
		displayGrade=new JButton("Display Grade");
		clearGrade=new JButton("Clear Grade");
		exit=new JButton("Exit");
		jp3.add(createStudent);
		jp3.add(loadAssesment);
		jp3.add(displayAssesment);
		jp3.add(setGrade);
		jp3.add(displayGrade);
		jp3.add(clearGrade);
		jp3.add(exit);
		jp3.setBorder(settitleBorder("Command Buttons"));
		createStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createStudent();
			}
		});	
		loadAssesment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				LoadAssesment();
			}
		});	
		displayAssesment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				displayAssesment();
			}
		});	
		setGrade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				setGrade();
			}
		});	
		displayGrade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				displayGrade();
			}
		});	
		clearGrade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearGrade();
			}
		});	
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				System.exit(1);
			}
		});	
		
		return jp3;
	}
	public  TitledBorder settitleBorder(String title) {
		TitledBorder setTitle=BorderFactory.createTitledBorder(title);
		return setTitle;
	}
	public void createStudent() {
		JOptionPane.showMessageDialog(null, "This is amazing", "Discription", 1);
	}
	public void LoadAssesment() {
		JOptionPane.showMessageDialog(null, "This is LoadAssesment", "Discription", 1);

	}
	public void displayAssesment() {
		JOptionPane.showMessageDialog(null, "This is displayAssesment", "Discription", 1);

	}
	public void setGrade() {
		JOptionPane.showMessageDialog(null, "This is setGrade", "Discription", 1);

	}
	public void displayGrade() {
		JOptionPane.showMessageDialog(null, "This is displayGrade", "Discription", 1);

	}
	public void clearGrade() {
		JOptionPane.showMessageDialog(null, "This is clearGrade", "Discription", 1);

	}
	
}
