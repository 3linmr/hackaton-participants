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

	public class TableView2 implements Initializable {
		private Stage stage;
		private Scene scene;
		private Parent root;

		@FXML
	    private TableView<Student> Tableview;

	    @FXML
	    private TableColumn<Student, Integer> IDco;

	    @FXML
	    private TableColumn<Student, String> Nameco;

	    @FXML
	    private TableColumn<Student, String> Majorco;

	    @FXML
	    private TableColumn<Student, String> Rankco;

		

		
		ObservableList<Student> listM1;
		ObservableList<Student> dataList1;
		int index = -1;

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pst = null;

		public void UpdateTable2() {
			IDco.setCellValueFactory(new PropertyValueFactory<Student, Integer>("ID"));
			Nameco.setCellValueFactory(new PropertyValueFactory<Student, String>("Name"));
			Majorco.setCellValueFactory(new PropertyValueFactory<Student, String>("Major"));
			Rankco.setCellValueFactory(new PropertyValueFactory<Student, String>("Rank"));
			
			listM1 = sql.getStudentData();
			Tableview.setItems(listM1);

		}

		public void switchToScene1(ActionEvent event) throws IOException {
			root = FXMLLoader.load(getClass().getResource("Main.fxml"));
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
		public void switchToScene7(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("addStudent.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

		@Override
		 public void initialize(URL url, ResourceBundle rb) {
		    UpdateTable2();
		    
			
		}

	}


