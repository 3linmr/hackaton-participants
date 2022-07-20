package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class mysqlconncet {
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
    
 public static ObservableList<CompData>getDataPerson(){
     Connection con =ConnectDb();
     ObservableList<CompData>list =FXCollections.observableArrayList();       
     try {
         PreparedStatement ps =  con.prepareStatement("select * from compinfo.`stc&nokia`");
         ResultSet rs = ps.executeQuery();
         
         while(rs.next()){
             list.add(new CompData(rs.getString("Competition Name"), rs.getString("Competition Link"), rs.getString("competition date")));
         }
     } catch (Exception e) {
     }finally{
     
         try {
             
         } catch (Exception e) {
         }
     }
     return list;
 }
}