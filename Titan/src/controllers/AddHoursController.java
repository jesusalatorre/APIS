package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import database.DB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Empleado;
import models.Hora;


/**
 *
 * @author Jesus
 */
public class AddHoursController implements Initializable{
    
        /*public int id;
        public String nom;*/
		private String curp;
        private Empleado empleado;
        @FXML
        private TextField tf_horas;
        @FXML
        private TextField tf_descripcion;
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
		
	}
        
    public void setCurp(Empleado empleado){
    	this.empleado=empleado;
        this.curp=empleado.getCurp();
    }
    /*
    public void setLabel(){
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
*/
	public void start(Stage mainStage) {
		
		mainStage.show();
	}
        
    @FXML
    public void btGuardar() throws Exception {
    	if(tf_horas.getText().isEmpty()||tf_extra.getText().isEmpty()||dp_date.getValue()==null||tf_descripcion.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Uno o más de los campos contienen información incorrecta.\n");
    	}
    	else {
	    	Hora hora=new Hora(curp, Integer.parseInt(tf_horas.getText()),Integer.parseInt(tf_extra.getText()), dp_date.getValue().toString(),tf_descripcion.getText());
	    	DB.addHours(hora);
	    	btCancelar();
    	}    	
    }
	
    @FXML
	public void btCancelar() throws Exception {
    	FXMLLoader loader = new FXMLLoader();
		   loader.setLocation(getClass().getResource("/views/perfilEmpleado.fxml"));
		   Parent tableViewParent = null;
		   try {
			   tableViewParent = loader.load();
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		   }
		   
		   if (tableViewParent!=null) {
  		   Scene tableViewScene = new Scene(tableViewParent);
  		   
  		   PerfilEmpleadoController controller= loader.getController();
  		   controller.setData(empleado.getRfc());
  		   
  		   //Stage window=(Stage)((Node)btn_reg_cancel.getSource()).getScene().getWindow();
  		   Stage window = (Stage) btn_reg_cancel.getScene().getWindow();
  		   window.setScene(tableViewScene);
  		   window.show();
		   }
	}
    
}
