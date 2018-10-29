/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.DB;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import models.Empleado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Jesus
 */
public class MainSceneController extends Application implements Initializable {
     
    ObservableList<Empleado> employees;
    
    @FXML
    private TableView<Empleado> empleados;
    @FXML
    private TableColumn<Empleado,String> nombre_col;
    @FXML
    private TableColumn<Empleado,String> telefono_col;
    @FXML
    private TableColumn<Empleado,String> rfc_col;
    @FXML
    private TableColumn<Empleado,String> nom_familiar_col;
    @FXML
    private TableColumn<Empleado,String> tel_familiar_col;

    public MainSceneController() throws Exception {
        this.employees = BuildData();
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Ahoy!");
        nombre_col.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        telefono_col.setCellValueFactory(new PropertyValueFactory<>("Telefonoy"));
        rfc_col.setCellValueFactory(new PropertyValueFactory<>("RFC"));
        nom_familiar_col.setCellValueFactory(new PropertyValueFactory<>("Familiar"));
        tel_familiar_col.setCellValueFactory(new PropertyValueFactory<>("Tel. Familiar"));
        
        empleados.setItems(employees);
        
    }

   public ObservableList<Empleado> BuildData() throws Exception{
        ResultSet rset = DB.getEmpleados();
        List<Empleado> E = new ArrayList<>();
        
        String name;
        String phone;
        String rfc;
        String fam_name;
        String fam_phone;
        
        while(rset.next()){
            name = rset.getString(2);
            phone = rset.getString(10);
            rfc = rset.getString(7);
            fam_phone = rset.getString(17);
            fam_name = rset.getString(18);
            
            Empleado emp = new Empleado(name, phone, rfc, fam_phone, fam_name);
            
            System.out.println(emp.nombre);
            System.out.println(emp.tel);
            System.out.println(emp.rfc);
            System.out.println(emp.nombre_familiar);
            System.out.println(emp.tel_familiar);
            
            E.add(emp);
        } 
        ObservableList<Empleado> OL = FXCollections.observableArrayList(E);
        return OL;
    }
   
   @Override
   public void start(Stage stage) throws Exception{
        stage.show();
    }
   
   
    
}
