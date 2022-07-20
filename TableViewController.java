package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TableViewController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private TableView<CompData> TableC;

	@FXML
	private TableColumn<CompData, String> NameC;

	@FXML
	private TableColumn<CompData, String> WebsiteC;

	@FXML
	private TableColumn<CompData, String> DateC;

	

	
	ObservableList<CompData> listM;
	ObservableList<CompData> dataList;
	int index = -1;

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	public void UpdateTable() {
		NameC.setCellValueFactory(new PropertyValueFactory<CompData, String>("cName"));
		WebsiteC.setCellValueFactory(new PropertyValueFactory<CompData, String>("cWebsite"));
		DateC.setCellValueFactory(new PropertyValueFactory<CompData, String>("cDate"));
		
		listM = mysqlconncet.getDataPerson();
		TableC.setItems(listM);

	}

	public void switchToScene1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToScene3(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("firstComp.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToScene4(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("secondComp.fxml"));
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
	public void switchToScene5(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Web1.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToScene6(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Web2.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToScene9(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("addComp.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	 public void initialize(URL url, ResourceBundle rb) {
	    UpdateTable();
	    
		
	}

}
