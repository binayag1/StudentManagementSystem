import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class StudentManagementSystem extends JFrame{
	/**
	 * Student management system
	 * Written By : Binaya Ghimire 
	 * Version: 1.0
	 * 
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
	public 	JButton saveData;
	public  JButton exit;
	
	
//	For Admin Panel
	public JLabel userlabel;
	public JLabel passwordLabel;
	public JPasswordField password;
	public  JTextField username;
	public JTextArea messageArea;
	public JButton button;
//	 Decleration end for admin panel
	
	public 	ArrayList<Student> al=new ArrayList<Student>();
	ArrayList<Subjects> subjectList=new ArrayList<Subjects>();
	private final String[] subjects= {"Biology", "Business and Communication Technologies", "English", "Maths B", "Religion and Ethics"};
	private final String[] grades= {"Very high", "High", "Sound", "Developing", "Emerging"};
	private String filename="Data.csv";
	public ArrayList<String> forSubjects=new ArrayList<String>();
	Student createdStudent=	new Student();
	
	public static void main(String args[]) {
		StudentManagementSystem sm=new StudentManagementSystem();
		sm.amdinFrame();
	}
	public  void setFrame() {
		StudentManagementSystem frame=new StudentManagementSystem();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Student Management System--(Written By Binaya Ghimire)");
		frame.setSize(1800,900);
		frame.setVisible(true);
		frame.add(setPanelTop(),new BorderLayout().NORTH);
		frame.add(setPanelMiddle(),new BorderLayout().CENTER);
		frame.add(setPanelBottom(),new BorderLayout().SOUTH);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		textarea=new JTextArea(50,700);
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
		displayAssesment.setEnabled(false);
		setGrade=new JButton("Set Grade");
		setGrade.setEnabled(false);
		displayGrade=new JButton("Display Grade");
		displayGrade.setEnabled(false);
		clearGrade=new JButton("Clear Grade");
		clearGrade.setEnabled(false);
		saveData=new JButton("Save Data");
		saveData.setEnabled(false);
		exit=new JButton("Exit");
		jp3.add(createStudent);
		jp3.add(loadAssesment);
		jp3.add(displayAssesment);
		jp3.add(setGrade);
		jp3.add(displayGrade);
		jp3.add(clearGrade);
		jp3.add(saveData);
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
		saveData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "THis is save data", "Info", 1);
			}
		});
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				JOptionPane.showMessageDialog(null, "Thank You For Using My Program","INFORMATION_MESSAGE", 1);
				System.exit(1);
			}
		});	
		
		subCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedSubject=subCombo.getSelectedItem().toString();
				selecteItem(selectedSubject);
				displayAssesment.setEnabled(true);
				
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
				String line=assesmentId+", "+assesmentType+ ","+assesmentFormat+","+assesmentTopic;
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
					displayAssesment.setEnabled(true);
				}
			}
			}
		
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("I am here second");

	}
	public void displayAssesment() {
		try {
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
				setGrade.setEnabled(true);
				displayGrade.setEnabled(true);
				clearGrade.setEnabled(true);
	
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Student is not created or Assesment is not loaded", "Warning message", 1);
		}
		
	}
	public void setGrade() {
		try {
			if(subCombo.getItemCount()>0 && assCombo.getItemCount()>0) {
				String subName=subCombo.getSelectedItem().toString();
				String assesment=assCombo.getSelectedItem().toString();
				String[] flag=assesment.split(",");
				String assesmentId=flag[0];
				String assesmentTopic=flag[1];
				Boolean indicator=false;
				System.out.println(assesmentId);
				for (int i = 0; i < subjectList.size(); i++) {
					if(subName.toUpperCase().equals(subjectList.get(i).getSubjectName().toUpperCase()) && assesmentId.equals(subjectList.get(i).getMarkedAssesment().getAssesmentId())) {
						subjectList.get(i).getMarkedAssesment().setMarGrade(gradeCombo.getSelectedItem().toString());
						subjectList.get(i).getMarkedAssesment().setGraded(true);
						indicator=true;
					}
				}
				if(indicator==true) {
					textarea.setText("Grade has been assigned!!! Thank You");
				}
				saveData.setEnabled(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Please select subject and assesment first", "Warning message", 1);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Something went wring", "Error Message", 1);
		}
			
	}
	public void displayGrade() {
		String subName=subCombo.getSelectedItem().toString();
		String assesment=assCombo.getSelectedItem().toString();
		String[] flag=assesment.split(",");
		String id=flag[0];
		for (int i = 0; i < subjectList.size(); i++) {
			if(subjectList.get(i).getSubjectName().toUpperCase().equals(subName.toUpperCase())&& subjectList.get(i).getMarkedAssesment().getAssesmentId().equals(id)) {
			if(!subjectList.get(i).getMarkedAssesment().isGraded()){
				textarea.setText("Grade has not been set Yet");
			}
			else {
				textarea.setText(subjectList.get(i).getSubjectName()+"--"+subjectList.get(i).getMarkedAssesment().getAssesmentId()+"--"+subjectList.get(i).getMarkedAssesment().getAssesmentTopic()+"--"+subjectList.get(i).getMarkedAssesment().getMarGrade());
			}
			}
		}
	}
	public void clearGrade() {
		try {
			String subName=subCombo.getSelectedItem().toString();
			String assesment=assCombo.getSelectedItem().toString();
			String[] flag=assesment.split(",");
			String id=flag[0];
			for (int i = 0; i < subjectList.size(); i++) {
				if(subjectList.get(i).getSubjectName().toUpperCase().equals(subName.toUpperCase())&& subjectList.get(i).getMarkedAssesment().getAssesmentId().equals(id)) {
				if(!subjectList.get(i).getMarkedAssesment().isGraded()){
					textarea.setText("Grade has not been set Yet");
				}
				else {
					subjectList.get(i).getMarkedAssesment().setMarGrade("");
					subjectList.get(i).getMarkedAssesment().setGraded(false);
					textarea.setText("Grade has been removed");
				}
				}
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Something went wrong", "Error Message", 1);
		}
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
//	Admin Frame
	 public void amdinFrame() {
			 try {
			 String user;
			 String pass;
			 StudentManagementSystem adminFrame=new StudentManagementSystem();
			 adminFrame.setTitle("Please Enter UserName and Password");
			 JPanel jp=new JPanel();
			 adminFrame.add(jp);
			 adminFrame.setSize(300,300);
			 adminFrame.add(adminPanel());
			 adminFrame.setResizable(false);
			 jp.setBorder(settitleBorder("Study Progress Monitor"));
			 adminFrame.setVisible(true);
			 button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(authentication()) {
						StudentManagementSystem sm=new StudentManagementSystem();
						sm.setFrame();
						adminFrame.setVisible(false);
					}
					else {
						messageArea.setVisible(true);
						messageArea.setForeground(Color.RED);
						messageArea.setText("Invalid username and password");
					}
					
				}
			});
	
			}
			 catch(Exception e) {
				 System.out.println(e.getMessage());
			 }
	 }
	 public JPanel adminPanel() {
		 JPanel panel=new JPanel();
		 userlabel=new JLabel("Enter UserName");
		 passwordLabel=new JLabel("Enter Password");
		 password=new JPasswordField(15);
		 username=new JTextField(15);
		 messageArea=new JTextArea(1,8);
		 button=new JButton("Log In");
		 panel=new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));		
		 panel.add(userlabel);
		 panel.add(username);
		 panel.add(passwordLabel);
		 panel.add(password);
		 panel.add(button);
		 panel.add(messageArea);
		 messageArea.setVisible(false);
		 return panel;
	 }
	private boolean authentication() {
		String name=username.getText();
		String pass=password.getText();
		System.out.println(name+"----"+pass);
		if(name.toUpperCase().equals("ADMIN") && pass.toUpperCase().equals("ADMIN"))
			return true;
		else
		return false;
	}
}
