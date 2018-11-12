package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import database.DB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Empleado;

public class AddEmployeeController  implements Initializable{
	
	@FXML private TextField tb_reg_name;
	@FXML private DatePicker cal_reg_ingreso;
	@FXML private DatePicker cal_reg_baja;
	@FXML private TextField tb_reg_rfc;
	@FXML private TextField tb_reg_telefono;
	@FXML private TextField tb_reg_imss;
	@FXML private TextField tb_reg_clinica;
	@FXML private TextField tb_reg_nacimiento;
	@FXML private TextField tb_reg_residencia;
	@FXML private TextField tb_reg_curp;
	@FXML private TextField tb_reg_telFamiliar;
	@FXML private TextField tb_reg_nameFamiliar;
	@FXML private DatePicker cal_reg_nacimiento;
	@FXML private TextField tb_reg_consulta;
	@FXML private CheckBox cb_reg_infonavit;
	@FXML private CheckBox cb_reg_fonacot;
	@FXML private CheckBox cb_reg_active;
	@FXML private Button btn_reg_cancel;
	@FXML private Button btn_reg_save;
	
	//Checks
	@FXML private ImageView chk_reg_name;
	@FXML private ImageView chk_reg_consulta;
	@FXML private ImageView chk_reg_rfc;
	@FXML private ImageView chk_reg_telefono;
	@FXML private ImageView chk_reg_imss;
	@FXML private ImageView chk_reg_clinica;
	@FXML private ImageView chk_reg_ingreso;
	@FXML private ImageView chk_reg_baja;
	@FXML private ImageView chk_reg_nacimiento1;
	@FXML private ImageView chk_reg_residencia;
	@FXML private ImageView chk_reg_nacimiento2;
	@FXML private ImageView chk_reg_curp;
	@FXML private ImageView chk_reg_familiar1;
	@FXML private ImageView chk_reg_familiar2;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public AddEmployeeController(){
		
	}

	public void start(Stage mainStage) {
		// TODO Auto-generated method stub
		mainStage.show();
	}
	
	public void btGuardar() throws Exception {		
		Empleado empleado = new Empleado();
		boolean bAdd = true;
		
		//Validar datos
		if(tb_reg_name.getText().isEmpty()) {
			chk_reg_name.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setNombre(tb_reg_name.getText());
			chk_reg_name.setVisible(false);
		}
		empleado.setActivo(cb_reg_active.isSelected());
		if(cal_reg_ingreso.getValue() == null) {
			chk_reg_ingreso.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setFecha_ingreso(cal_reg_ingreso.getValue().toString());
			chk_reg_ingreso.setVisible(false);
		}
		if(cal_reg_baja.getValue() == null) {
			empleado.setFecha_baja(null);
		}
		else {
			empleado.setFecha_baja(cal_reg_baja.getValue().toString());
		}
		if(tb_reg_consulta.getText().isEmpty()) {
			chk_reg_consulta.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setCons(Integer.parseInt(tb_reg_consulta.getText()));
			chk_reg_consulta.setVisible(false);
		}
		if(tb_reg_rfc.getText().isEmpty()) {
			chk_reg_rfc.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setRfc(tb_reg_rfc.getText());
			chk_reg_rfc.setVisible(false);
		}
		empleado.setInfonavit(cb_reg_infonavit.isSelected());
		empleado.setFonacot(cb_reg_fonacot.isSelected());
		if(tb_reg_telefono.getText().isEmpty()) {
			chk_reg_telefono.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setTel(tb_reg_telefono.getText());
			chk_reg_telefono.setVisible(false);
		}
		if(tb_reg_imss.getText().isEmpty()) {
			chk_reg_imss.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setImss(tb_reg_imss.getText());
			chk_reg_imss.setVisible(false);
		}
		if(tb_reg_clinica.getText().isEmpty()) {
			chk_reg_clinica.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setClinica(tb_reg_clinica.getText());
			chk_reg_clinica.setVisible(false);
		}
		if(tb_reg_nacimiento.getText().isEmpty()) {
			chk_reg_nacimiento1.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setLugar_nacimiento(tb_reg_nacimiento.getText());
			chk_reg_nacimiento1.setVisible(false);
		}
		if(tb_reg_residencia.getText().isEmpty()) {
			chk_reg_residencia.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setLugar_residencia(tb_reg_residencia.getText());
			chk_reg_residencia.setVisible(false);
		}
		if(cal_reg_nacimiento.getValue() == null) {
			chk_reg_nacimiento2.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setFecha_nacimiento(cal_reg_nacimiento.getValue().toString());
			chk_reg_nacimiento2.setVisible(false);
		}
		if(tb_reg_curp.getText().isEmpty()) {
			chk_reg_curp.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setRfc(tb_reg_curp.getText());
			chk_reg_curp.setVisible(false);
		}
		if(tb_reg_telFamiliar.getText().isEmpty()) {
			chk_reg_familiar1.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setTel_familiar(tb_reg_telFamiliar.getText());
			chk_reg_familiar1.setVisible(false);
		}
		if(tb_reg_nameFamiliar.getText().isEmpty()) {
			chk_reg_familiar2.setVisible(true);
			bAdd = false;
		}
		else {
			empleado.setNombre_familiar(tb_reg_nameFamiliar.getText());
			chk_reg_familiar2.setVisible(false);
		}
		
		if(bAdd) {
			DB.addEmpleadoToDB(empleado);
			
			Parent root = FXMLLoader.load(getClass().getResource("/views/mainScene.fxml"));
            Scene mainScene = new Scene(root);

            Stage mainStage = (Stage) btn_reg_save.getScene().getWindow();
            mainStage.close();
            mainStage.setScene(mainScene);
            MainSceneController MSC =  new MainSceneController();
            MSC.start(mainStage);
		}
	
	}
	
	public void btCancelar() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/views/mainScene.fxml"));
        Scene mainScene = new Scene(root);

        Stage mainStage = (Stage) btn_reg_cancel.getScene().getWindow();
        mainStage.close();
        mainStage.setScene(mainScene);
        MainSceneController MSC =  new MainSceneController();
        MSC.start(mainStage);
		
	}

}
