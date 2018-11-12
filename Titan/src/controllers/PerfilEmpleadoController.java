package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import database.DB;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Empleado;

public class PerfilEmpleadoController extends Application implements Initializable{
	
	private Empleado perfilEmpleado;
	@FXML	private TextField tfNombre=new TextField();
	@FXML	private TextField tfEstatus=new TextField();
	@FXML	private TextField tfIngreso=new TextField();
	@FXML	private TextField tfBaja=new TextField();
	@FXML	private TextField tfConsulta=new TextField();
	@FXML	private TextField tfRFC=new TextField();
	@FXML	private TextField tfInfonavit=new TextField();
	@FXML	private TextField tfFonacot=new TextField();
	@FXML	private TextField tfTelefono=new TextField();
	@FXML	private TextField tfImss=new TextField();
	@FXML	private TextField tfNacimiento=new TextField();
	@FXML	private TextField tfResidencia=new TextField();
	@FXML   private Button btnEditar;
	
	@Override
	public void initialize (URL url, ResourceBundle rb) {
		
			
	}

	@Override
	public void start(Stage stage) throws Exception{
		stage.show();
	    }
	
	public void setData(String rfc)  {
		try {
			perfilEmpleado=DB.getEmpleado(rfc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfNombre.setText(perfilEmpleado.getNombre());
		
		if(perfilEmpleado.getActivo()) {
			tfEstatus.setText("Activo");
		}
		else {
			tfEstatus.setText("Inactivo");
		}
		tfIngreso.setText(perfilEmpleado.getIngreso());
		
		if(perfilEmpleado.getBaja()==null) {
			tfBaja.setText("No Aplica");
		}
		else {
			tfBaja.setText(perfilEmpleado.getBaja());
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
			tfIngreso.setEditable(true);
			tfBaja.setEditable(true);
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
					tfIngreso.setEditable(false);
					tfBaja.setEditable(false);
					tfConsulta.setEditable(false);
					tfRFC.setEditable(false);
					tfInfonavit.setEditable(false);
					tfFonacot.setEditable(false);
					tfTelefono.setEditable(false);
					tfImss.setEditable(false);
					tfNacimiento.setEditable(false);
					tfResidencia.setEditable(false);
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
				||tfIngreso.getText().length()==0
						||tfBaja.getText().length()==0
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
	
	public Boolean setNewData() {
		return true;
	}

}
