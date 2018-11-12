package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import database.DB;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Empleado;

public class PerfilEmpleadoController extends Application implements Initializable{
	
	private Empleado perfilEmpleado;
	@FXML	private TextField tfNombre=new TextField();
	@FXML	private TextField tfEstatus=new TextField();
	@FXML	private DatePicker tfIngreso=new DatePicker();
	@FXML	private DatePicker tfBaja=new DatePicker();
	@FXML	private TextField tfConsulta=new TextField();
	@FXML	private TextField tfRFC=new TextField();
	@FXML	private TextField tfInfonavit=new TextField();
	@FXML	private TextField tfFonacot=new TextField();
	@FXML	private TextField tfTelefono=new TextField();
	@FXML	private TextField tfImss=new TextField();
	@FXML	private TextField tfNacimiento=new TextField();
	@FXML	private TextField tfResidencia=new TextField();
	@FXML   private Button btnEditar;
	@FXML   private Button btnRegresar;
	@FXML 	private Label lbNombre;
	
	@Override
	public void initialize (URL url, ResourceBundle rb) {
		
			
	}

	@Override
	public void start(Stage stage) throws Exception{
		stage.show();
	    }
	
	public void setData(String rfc)  {
		tfIngreso.setDisable(true);
		tfBaja.setDisable(true);
		try {
			perfilEmpleado=DB.getEmpleado(rfc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lbNombre.setText(perfilEmpleado.getNombre());
		tfNombre.setText(perfilEmpleado.getNombre());
		
		if(perfilEmpleado.getActivo()) {
			tfEstatus.setText("Activo");
		}
		else {
			tfEstatus.setText("Inactivo");
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		tfIngreso.setValue(LOCAL_DATE(perfilEmpleado.getIngreso()));
		
		if(perfilEmpleado.getBaja()==null) {
			tfBaja.setValue(null);
		}
		else {
			tfBaja.setValue(LOCAL_DATE(perfilEmpleado.getIngreso()));
		}
		
		tfConsulta.setText(Integer.toString(perfilEmpleado.getConsulta()));
		tfRFC.setText(perfilEmpleado.getRfc());
		
		if(perfilEmpleado.getInfonavit()) {
			tfInfonavit.setText("Si");
		}
		else {
			tfInfonavit.setText("No");
		}
		
		
		if(perfilEmpleado.getFonacot()) {
			tfFonacot.setText("Si");
		}
		else {
			tfFonacot.setText("No");
		}
		
		tfTelefono.setText(perfilEmpleado.getTel());
		tfImss.setText(perfilEmpleado.getImss());
		tfNacimiento.setText(perfilEmpleado.getLugarNacimiento());
		tfResidencia.setText(perfilEmpleado.getLugar_residencia());
	}
	
	public void edit(ActionEvent e) throws IOException, Exception {
		if(btnEditar.getText().equals("Editar")) {				//Edición
			btnEditar.setText("Guardar");
			tfNombre.setEditable(true);
			tfEstatus.setEditable(true);
			tfIngreso.setDisable(false);
			tfBaja.setDisable(false);
			tfConsulta.setEditable(true);
			tfRFC.setEditable(true);
			tfInfonavit.setEditable(true);
			tfFonacot.setEditable(true);
			tfTelefono.setEditable(true);
			tfImss.setEditable(true);
			tfNacimiento.setEditable(true);
			tfResidencia.setEditable(true);
			
		}
		else {			
			if(checkNoNulls()) {
				if(setNewData()) {								//Guardar
					btnEditar.setText("Editar");						
					tfNombre.setEditable(false);
					tfEstatus.setEditable(false);
					tfIngreso.setDisable(true);
					tfBaja.setDisable(true);
					tfConsulta.setEditable(false);
					tfRFC.setEditable(false);
					tfInfonavit.setEditable(false);
					tfFonacot.setEditable(false);
					tfTelefono.setEditable(false);
					tfImss.setEditable(false);
					tfNacimiento.setEditable(false);
					tfResidencia.setEditable(false);
					lbNombre.setText(perfilEmpleado.getNombre());
				}
				else {
					JOptionPane.showMessageDialog(null, "Uno o más de los campos contienen información incorrecta.\n");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios");
			}
		}
	}
	
	public Boolean checkNoNulls() {
		if(tfNombre.getText().length()==0
		||tfEstatus.getText().length()==0
				||tfIngreso.getValue() == null
								||tfConsulta.getText().length()==0
										||tfRFC.getText().length()==0
												||tfInfonavit.getText().length()==0
														||tfFonacot.getText().length()==0
																||tfTelefono.getText().length()==0
																		||tfImss.getText().length()==0
																				||tfNacimiento.getText().length()==0
																						||tfResidencia.getText().length()==0)
			return false;
		return true;
	}
	
	public Boolean setNewData() throws Exception {
		boolean bAdd = true;
		perfilEmpleado.setNombre(tfNombre.getText());
		if(tfEstatus.getText().equals("Si")||tfEstatus.getText().equals("SI")) {
			perfilEmpleado.setActivo(true);
		}
		else {
			perfilEmpleado.setActivo(false);
		}
		perfilEmpleado.setFecha_ingreso(tfIngreso.getValue().toString());
		
		if(tfBaja.getValue()!=null) {
			perfilEmpleado.setFecha_baja(tfBaja.getValue().toString());
		}
		else {
			perfilEmpleado.setFecha_baja(null);
		}
		
		perfilEmpleado.setCons(Integer.parseInt(tfConsulta.getText()));
		perfilEmpleado.setRfc(tfRFC.getText());
		
		if(tfInfonavit.getText().equals("Si")||tfInfonavit.getText().equals("SI")) {
			perfilEmpleado.setInfonavit(true);
		}
		else {
			perfilEmpleado.setInfonavit(false);
		}
		
		if(tfFonacot.getText().equals("Si")||tfFonacot.getText().equals("SI")) {
			perfilEmpleado.setFonacot(true);
		}
		else {
			perfilEmpleado.setFonacot(false);
		}
		
		perfilEmpleado.setTel(tfTelefono.getText());
		
		perfilEmpleado.setImss(tfImss.getText());
		
		perfilEmpleado.setLugar_nacimiento(tfNacimiento.getText());
		
		perfilEmpleado.setLugar_residencia(tfResidencia.getText());
		
		DB.updateEmpleado(perfilEmpleado);

		return bAdd;
	}
	
	public void borrar() throws Exception {
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar Empleado");
		alert.setHeaderText(null);
		alert.setContentText("¿Seguro que desea eliminar empleado?");
		Optional <ButtonType> action= alert.showAndWait();
		if(action.get()==ButtonType.OK) {
			DB.deleteEmpleado(perfilEmpleado);
			back();
		}
	}
	
	
	public void back()throws IOException, Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/views/mainScene.fxml"));
        Scene mainScene = new Scene(root);

        Stage mainStage = (Stage) btnRegresar.getScene().getWindow();
        mainStage.close();
        mainStage.setScene(mainScene);
        MainSceneController MSC =  new MainSceneController();
        MSC.start(mainStage);
	}
	
	public static final LocalDate LOCAL_DATE (String dateString){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.parse(dateString, formatter);
	    return localDate;
	}


}
