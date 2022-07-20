package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewCon2 implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;

	
	@FXML
	private WebView WebView2;
	private WebEngine engine2;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		engine2 = WebView2.getEngine();
		loadPage2();
	}

	public void loadPage2() {
		engine2.load("https://google.com/");
	}

	public void switchToScene2(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CompList.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}