package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author Jesus
 */
public class AddHoursController implements Initializable{
    
        public int id;
        public String nom;
        
        @FXML
	private TextField tf_horas;
        @FXML
        private DatePicker dp_date;
        @FXML
	private Label l_name;
        @FXML
        private TextField tf_extra;
        @FXML
        private Button btn_reg_cancel;
        @FXML
        private Button btn_reg_save;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
        
        public void setName(String name){
            nom=name;
        }
        
        public void setLabel(){
                System.out.println(this.nom);
                l_name.setText(this.nom);
        }
	
        public void setId(int num){
            id=num;
        }
        
        public AddHoursController(){
        }
        
        
	public AddHoursController(int num, String nombre){
            this.nom = nombre;
            this.id=num;
	}

	public void start(Stage mainStage) {
		// TODO Auto-generated method stub
		mainStage.show();
	}
        
    @FXML
        public void btGuardar() throws Exception {
	
	}
	
    @FXML
	public void btCancelar() throws Exception {
		
	}
    
}
