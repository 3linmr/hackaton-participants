package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class sql {
	Connection conn = null;

	public static Connection ConnectDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/compinfo", "root", "Qq290917");
			
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}

	}
	public static ObservableList<Student>getStudentData(){
	     Connection con =ConnectDb();
	     ObservableList<Student>list1 =FXCollections.observableArrayList();       
	     try {
	         PreparedStatement ps1 =  con.prepareStatement("select * from compinfo.`cpeople`");
	         ResultSet rs1 = ps1.executeQuery();
	         
	         while(rs1.next()){
	             list1.add(new Student(Integer.parseInt(rs1.getString("Student ID")), rs1.getString("Student Name"), rs1.getString("Major"), rs1.getString("Rank")));
	         }
	     } catch (Exception e) {
	     }finally{
	     
	         try {
	             
	         } catch (Exception e) {
	         }
	     }
	     return list1;
	 }}

