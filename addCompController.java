package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;

public class addCompController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;
	  @FXML
	    private TextField nameFld;

	    @FXML
	    private TextField LinkFld;

	    @FXML
	    private TextField dateFld;
    



	    String query = null;
	    Connection connection = null;
	    ResultSet resultSet = null;
	    PreparedStatement preparedStatement;
	    Student student = null;
	    private boolean update;
	    String compName;

	    /**
	     * Initializes the controller class.
	     */
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        // TODO
	    }

	    @FXML
	    private void save(MouseEvent event) {

	        connection = mysqlconncet.ConnectDb();
	        String name = nameFld.getText();
	        String link = LinkFld.getText();;
	        String date = dateFld.getText();
	      
	        
	        
	        
	        if (name.isEmpty() || link.isEmpty() || date.isEmpty() ) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setContentText("Please Fill All DATA");
	            alert.showAndWait();

	        } else {
	            getQuery();
	            insert();
	            clean();

	        }

	    }

	    @FXML
	    void clean(MouseEvent event) {
	    	clean();
	    }
	    
	    private void clean() {
	        nameFld.setText(null);
	        LinkFld.setText(null);
	        dateFld.setText(null);
	        
	        
	    }

	    private void getQuery() {

	        if (update == false) {
	            
	            query = "INSERT INTO `stc&nokia`( `Competition Name`,  `Competition Link`, `competition date`) VALUES (?,?,?)";

	        }else{
	            query = "UPDATE `stc&nokia` SET "
	                    + "`Competition Name`=?,"
	                    + "`Competition Link`=?,"                    
	                    + "`competition date`=? WHERE Comptetion Name = '"+compName+"'";
	        }

	    }

	    private void insert() {

	        try {

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, nameFld.getText());
	            preparedStatement.setString(2, LinkFld.getText());;
	            preparedStatement.setString(3, dateFld.getText());
	         
	            
	            preparedStatement.execute();

	        } catch (SQLException ex) {
	            Logger.getLogger(addStudentController.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    
	    void setUpdate(boolean b) {
	        this.update = b;

	    }
	    public void switchToScene3(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("firstComp.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	    public void switchToScene2(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("CompList.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

}
