package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import database.DB;
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
import models.Cuenta;

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
	
	public void goToMain(ActionEvent e) throws IOException, Exception {
		
		ArrayList<Cuenta> cuentas = DB.getCuenta();
		 
		if(tfUsername.getText().equals(cuentas.get(0).getUsuario()) && pfPassword.getText().equals(cuentas.get(0).getContra())) {
			Parent root = FXMLLoader.load(getClass().getResource("/views/mainScene.fxml"));
                        Scene mainScene = new Scene(root);
	        
			Stage mainStage = (Stage) btLogin.getScene().getWindow();
                        mainStage.close();
			mainStage.setScene(mainScene);
                        MainSceneController MSC =  new MainSceneController();
                        MSC.start(mainStage);
                         
		}
		else {
			 JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrectos");
		}
	}
}
