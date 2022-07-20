package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class sql2 {
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
	public static ObservableList<Team>getStudentData2(){
	     Connection con =ConnectDb();
	     ObservableList<Team>list1 =FXCollections.observableArrayList();       
	     try {
	         PreparedStatement ps1 =  con.prepareStatement("select * from compinfo.`speople`");
	         ResultSet rs1 = ps1.executeQuery();
	         
	         while(rs1.next()){
	             list1.add(new Team(Integer.parseInt(rs1.getString("Student ID")), rs1.getString("Student Name"), rs1.getString("Major"),Integer.parseInt(rs1.getString("team")) ,rs1.getString("Team Name"),rs1.getString("Rank")));
	         }
	     } catch (Exception e) {
	     }finally{
	     
	         try {
	             
	         } catch (Exception e) {
	         }
	     }
	     return list1;
	 }}

