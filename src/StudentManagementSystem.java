import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.Subject;
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
import javax.xml.crypto.Data;

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
	public 	ArrayList<Student> al=new ArrayList<Student>();
	ArrayList<Subjects> subjectList=new ArrayList<Subjects>();
	private final String[] subjects= {"Biology", "Business and Communication Technologies", "English", "Maths B", "Religion and Ethics"};
	private final String[] grades= {"Very high", "High", "Sound", "Developing", "Emerging"};
	private String filename="Data.csv";
	public ArrayList<String> forSubjects=new ArrayList<String>();
	Student createdStudent=	new Student();
	
	public static void main(String args[]) {
		StudentManagementSystem sm=new StudentManagementSystem();
		sm.setFrame();
	}
	public  void setFrame() {
		StudentManagementSystem frame=new StudentManagementSystem();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Student Management System");
		frame.setSize(1300,900);
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
				String subjectName=subCombo.getSelectedItem().toString();
				displayAssesment();
				System.out.println("I am here");
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
		
		subCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedSubject=subCombo.getSelectedItem().toString();
				selecteItem(selectedSubject);
				
			}
		});
		
		return jp3;
	}
	protected void selecteItem(String selectedSubject) {
		if(assCombo.getItemCount()>0) {
			assCombo.removeAllItems();
		}
		for (int i = 0; i < subjectList.size(); i++) {
			if(selectedSubject.toUpperCase().equals(subjectList.get(i).subjectName.toUpperCase())) {
				String assesmentId=subjectList.get(i).getMarkedAssesment().getAssesmentId();
				String assesmentType=subjectList.get(i).getMarkedAssesment().getTypeOfAssesment();
				String assesmentFormat=subjectList.get(i).getMarkedAssesment().getAssesmentFormat();
				String assesmentTopic=subjectList.get(i).getMarkedAssesment().getAssesmentTopic();
				String line=assesmentId+"  "+assesmentType+ " "+assesmentFormat+"  "+assesmentTopic;
				assCombo.addItem(line);
			}
		}
		
	}
	public  TitledBorder settitleBorder(String title) {
		TitledBorder setTitle=BorderFactory.createTitledBorder(title);
		return setTitle;
	}
	public void createStudent() {
		try {
			String name=stnameTextfield.getText();
			String yearLevel=yearTextfield.getText();
			if(name.equals("") || yearLevel.equals("")) {
				JOptionPane.showMessageDialog(null, "Both Name and date are mandatory", "Error Message", 1);
			}
		
			else if(validateData(name)&& validateYear(yearLevel)) {
			createdStudent.setStudentName(name);
			createdStudent.setYearLevel(yearLevel);
			createdStudent.setSub(subjects);
			loadAssesment.setEnabled(true);
			textarea.setText("New Student has been created"+"Student Name: "+name+" Student YearLevel: "+yearLevel);
			}
			else {
				JOptionPane.showMessageDialog(null, "Please enter name only alphabet and Year should be only 11 or 12", "Warning message", 1);
				
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void LoadAssesment() {
		try {
			if(assCombo.getItemCount()>0) {
				textarea.setText("Assesments are already loaded");
			}
			else {
				
				Scanner scanner =new Scanner(new File(filename));
				while(scanner.hasNextLine()) {
					Subjects subject1=new Subjects();
					MarkedAssesment markedAssment=new MarkedAssesment();
					String[] col=scanner.nextLine().split(",");
					subject1.setSubjectName(col[0]);
					markedAssment.setMarGrade("Still not graded");
					markedAssment.setAssesmentId(col[1]);
					markedAssment.setTypeOfAssesment(col[2]);
					markedAssment.setAssesmentTopic(col[3]);
					markedAssment.setAssesmentFormat(col[4]);
					markedAssment.setAssesmentLastDate(col[5]);
					markedAssment.setGraded(false);
					subject1.setMarkedAssesment(markedAssment);
					subjectList.add(subject1);
					System.out.println(markedAssment);
				}
				createdStudent.getStudentName();
				String[] column=createdStudent.getSub();
				subCombo.addItem("Select Subject");
				for(String item: column) {
					subCombo.addItem(item);
				}
				for (int i = 0; i < grades.length; i++) {
					gradeCombo.addItem(grades[i]);
				}
			}
			}
		
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("I am here second");

	}
	public void displayAssesment() {
		String subjectName=subCombo.getSelectedItem().toString();
		if(subCombo.getSelectedIndex()==0) {
			textarea.setText("Please select subjects");
		}
		else if(assCombo.getItemCount()==0){
			textarea.setText("Assesments are not loaded properly. Please load assesment first and display assesment.");
		}
		else {
			String subject=subjectName;
			for (int i = 0; i < subjectList.size(); i++) {
				String name=subjectList.get(i).getSubjectName();
				String id=subjectList.get(i).getMarkedAssesment().getAssesmentId();
				String assesmentType=subjectList.get(i).getMarkedAssesment().getTypeOfAssesment();
				String assesmentTopic=subjectList.get(i).getMarkedAssesment().getAssesmentTopic();
				String dueDate=subjectList.get(i).getMarkedAssesment().getAssesmentLastDate();
				boolean getGraded=subjectList.get(i).getMarkedAssesment().isGraded();
				String graded="Not Graded";
				if(getGraded) {
					graded="Graded";
				}
				String displayText=name+""+id+""+assesmentType+""+assesmentTopic+""+dueDate+""+graded;
				if(name.toUpperCase().equals(subjectName.toUpperCase())) {
					subject+="\n" +displayText;
				}
				name="";
			}
			textarea.setText(subject);

		}
		
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
	public boolean validateData(String name) {
		char c='a';
		for (int i = 0; i < name.length(); i++) {
			if(Character.isDigit(c)==true) {
				return false;
			}
		}
		return true;
	}
	public boolean validateYear(String year) {
		int yearLevel=Integer.parseInt(year);
		if(yearLevel<11 || yearLevel>12)
			return false;
		else
			return true;
	}
	
}
