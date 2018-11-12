/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.DB;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import models.Empleado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Jesus
 */
public class MainSceneController extends Application implements Initializable {
   
    ObservableList<Empleado> employees = BuildData();
    @FXML private TableView<Empleado> empleados;
    @FXML TableColumn<Empleado, Integer> id_col;
    @FXML TableColumn<Empleado, String> nombre_col;
    @FXML TableColumn<Empleado, String> telefono_col;
    @FXML TableColumn<Empleado, String> rfc_col;
    @FXML TableColumn<Empleado, String> nom_familiar_col;
    @FXML TableColumn<Empleado, String> tel_familiar_col;
    @FXML TableColumn<Empleado, String> lugar_residencia_col;
    @FXML Button btNuevo;
    @FXML Button btHoras;
    
    Empleado selected;
   

    public MainSceneController() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainScene.fxml"));
        
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Ahoy!"); 
        
        id_col.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("id"));
        id_col.setMinWidth(20);
        nombre_col.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
        nombre_col.setMinWidth(250);
        telefono_col.setCellValueFactory(new PropertyValueFactory<Empleado, String>("tel"));
        telefono_col.setMinWidth(150);
        rfc_col.setCellValueFactory(new PropertyValueFactory<Empleado, String>("rfc"));
        rfc_col.setMinWidth(150);
        nom_familiar_col.setCellValueFactory(new PropertyValueFactory<Empleado, String>("tel_familiar"));
        nom_familiar_col.setMinWidth(150);
        tel_familiar_col.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre_familiar"));
        tel_familiar_col.setMinWidth(100);
        lugar_residencia_col.setCellValueFactory(new PropertyValueFactory<Empleado, String>("lugar_residencia"));
        lugar_residencia_col.setMinWidth(300);
        
        empleados.setItems(employees);
        
    }

   public ObservableList<Empleado> BuildData() throws Exception{
        ResultSet rset = DB.getEmpleados();
        List<Empleado> E = new ArrayList<>();
           
        int id;
        String name;
        String phone;
        String rfc;
        String fam_name;
        String fam_phone;
        String lugar_residencia;
        
        while(rset.next()){
            id = rset.getInt(1);
            name = rset.getString(2);
            phone = rset.getString(10);
            rfc = rset.getString(7);
            fam_phone = rset.getString(17);
            fam_name = rset.getString(18);
            lugar_residencia = rset.getString(14);
            
            Empleado emp = new Empleado(id ,name, phone, rfc, fam_phone, fam_name, lugar_residencia);
            
            E.add(emp);
        } 
        ObservableList<Empleado> OL = FXCollections.observableList(E);
        return OL;
    }
   
   @Override
   public void start(Stage stage) throws Exception{
        
        stage.show();
    }
   
   public void btAddEmpleado(ActionEvent e) throws Exception {
	   Parent root = FXMLLoader.load(getClass().getResource("/views/addEmployee.fxml"));
		Scene mainScene = new Scene(root);
       
		Stage mainStage = (Stage) btNuevo.getScene().getWindow();           
		mainStage.close();
		mainStage.setScene(mainScene);
		AddEmployeeController AEC =  new AddEmployeeController();
		AEC.start(mainStage);
   }
   
   public void btAgregarHoras(ActionEvent e) throws Exception {
       if(empleados.getSelectionModel().getSelectedItem() != null){
        Empleado selection = empleados.getSelectionModel().getSelectedItem();   
        int id = selection.getId();
        String nom = selection.getNombre(); 
        
        Parent root = FXMLLoader.load(getClass().getResource("/views/addHours.fxml"));
        AddHoursController AHC =  new AddHoursController(id, nom);

                 Scene mainScene = new Scene(root);
                 Stage mainStage = (Stage) btHoras.getScene().getWindow();           
                 mainStage.close();
                 mainStage.setScene(mainScene);
                 AHC.start(mainStage);
       }
   }
    
}
