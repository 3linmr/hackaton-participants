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

public class addStudentController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
    private TextField idFld;

    @FXML
    private TextField majorFld;

    @FXML
    private TextField nameFld;

    @FXML
    private TextField rankFld;
    



	    String query = null;
	    Connection connection = null;
	    ResultSet resultSet = null;
	    PreparedStatement preparedStatement;
	    Student student = null;
	    private boolean update;
	    int studentId;

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
	        String major = majorFld.getText();;
	        String rank = rankFld.getText();
	        String id = idFld.getText();
	        
	        
	        
	        if (name.isEmpty() || major.isEmpty() || id.isEmpty() || rank.isEmpty()) {
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
	        majorFld.setText(null);
	        rankFld.setText(null);
	        idFld.setText(null);
	        
	    }

	    private void getQuery() {

	        if (update == false) {
	            
	            query = "INSERT INTO `cpeople`( `student id`,  `student name`, `major`,`rank`) VALUES (?,?,?,?)";

	        }else{
	            query = "UPDATE `cpeople` SET "
	                    + "`student id`=?,"
	                    + "`student name`=?,"
	                    + "`major`=?,"
	                    + "`rank`= ? WHERE student id = '"+studentId+"'";
	        }

	    }

	    private void insert() {

	        try {

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(2, nameFld.getText());
	            preparedStatement.setString(3, majorFld.getText());;
	            preparedStatement.setString(4, rankFld.getText());
	            preparedStatement.setString(1, idFld.getText());
	            
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

}
