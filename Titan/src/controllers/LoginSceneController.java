package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginSceneController implements Initializable{

	@FXML
	private TextField tfUsername;
	@FXML
	private PasswordField pfPassword;
	@FXML
	private Button btLogin;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void goToMain(ActionEvent e) throws Exception {
		
		if(tfUsername.getText().equals("admin") && pfPassword.getText().equals("admin")) {
			Parent root = FXMLLoader.load(getClass().getResource("/views/mainScene.fxml"));
	        Scene mainScene = new Scene(root);
	        mainScene.setRoot(root);
	        
			Stage mainStage = (Stage) btLogin.getScene().getWindow();
			mainStage.setScene(mainScene);
		}

	}

}
