import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import org.apache.derby.client.am.PreparedStatement;
import org.apache.derby.client.am.Statement;

public class DatabaseConnectivity {
//	Defining necessary parameter
	public final String dbUrl="jdbc:derby://localhost:1527/student";
	public final String name="binaya";
	public final String password="binaya";
	Connection con;
	
			

	public DatabaseConnectivity() {
		try {
			con=DriverManager.getConnection(dbUrl, name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public boolean dbConnectionCheck() throws SQLException {
		if(con!=null) {
			System.out.println("Connection Seccessful");
			return true;
		}
		else {
			System.out.println("Something went wrong");
			return false;
		}
	}
//	public boolean databaseExist() {
//		 try {
//			 	con=DriverManager.getConnection(dbUrl, name, password);
//		        ResultSet resultSet = con.getMetaData().getCatalogs();
//		        System.out.println(resultSet);
//		        if(resultSet.next()==false) {
//		        	System.out.println("result set is empty");
//		        }
//		        while (resultSet.next()) {
//		          String databaseName = resultSet.getString(1);
//		            if(databaseName.equals("student")){
//		            	System.out.println("Student Database is alread created");
//		                return true;
//		            }
//		        }
//		        resultSet.close();
//
//		    }
//		    catch(Exception e){
//		        e.printStackTrace();
//		    }
//
//		    return false;
//	}
	
	public void insertData(LinkedList<Student> list) {
		
		int id=1;
		String name=list.getFirst().getStudentName();
		String yearLevel=list.getFirst().getYearLevel();
		String insertTableSQL = "INSERT INTO PERSONS"
				+ "(STUDENTID, NAME, YEARLEVEL) VALUES"
				+ "(?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, yearLevel);
			// execute insert SQL stetement
			preparedStatement .executeUpdate();
			JOptionPane.showMessageDialog(null, "Data Inserted Successfully", "Information message", 1);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public ResultSet getData() {
		String query="SELECT * FROM PERSONS";
		try {
			java.sql.Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	public boolean deleteAll() {
//		String query="DELETE * FROM PERSONS";
		 // Use TRUNCATE
	    String query = "DELETE FROM PERSONS";
		try {
			java.sql.Statement st=con.createStatement();
			int i=st.executeUpdate(query);
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
