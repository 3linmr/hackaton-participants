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

	public class TableView3 implements Initializable {
		private Stage stage;
		private Scene scene;
		private Parent root;

		 	@FXML
		    private TableView<Team> Tableview1;

		    @FXML
		    private TableColumn<Team, Integer> IDco;

		    @FXML
		    private TableColumn<Team, String> Nameco;

		    @FXML
		    private TableColumn<Team, String> Majorco;

		    @FXML
		    private TableColumn<Team, String> Memco;

		    @FXML
		    private TableColumn<Team, String> TNco;

		    @FXML
		    private TableColumn<Team, String> Trank;

		

		
		ObservableList<Team> listM2;
		ObservableList<Team> dataList2;
		int index = -1;

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pst = null;

		public void UpdateTable3() {
			IDco.setCellValueFactory(new PropertyValueFactory<Team, Integer>("ID"));
			Nameco.setCellValueFactory(new PropertyValueFactory<Team, String>("Name"));
			Majorco.setCellValueFactory(new PropertyValueFactory<Team, String>("Major"));
			Memco.setCellValueFactory(new PropertyValueFactory<Team, String>("Team"));
			TNco.setCellValueFactory(new PropertyValueFactory<Team, String>("TeamName"));
			Trank.setCellValueFactory(new PropertyValueFactory<Team, String>("Rank"));
			
			listM2 = sql2.getStudentData2();
			Tableview1.setItems(listM2);

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
		public void switchToScene2(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("CompList.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		public void switchToScene8(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("addStudent2.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

		@Override
		 public void initialize(URL url, ResourceBundle rb) {
		    UpdateTable3();
		    
			
		}

	}





