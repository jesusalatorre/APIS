package controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import database.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Empleado;
import models.Hora;

public class DisplayTimesController implements Initializable{
	
	private Empleado empleado;
	ObservableList<Hora> hours = BuildData();
	
	@FXML private TableView<Hora> horas;
	@FXML TableColumn<Hora, String> col_Fecha;
	@FXML TableColumn<Hora, Integer> col_Horas; 
	@FXML TableColumn<Hora, Integer> col_Extras;
	@FXML TableColumn<Hora, String> col_Descripcion;
	@FXML Button btn_addTiempo_save;
	@FXML Label lbl_addTiempo_nombre;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		col_Fecha.setCellValueFactory(new PropertyValueFactory<Hora, String>("Fecha"));
		col_Fecha.setMinWidth(250);
		col_Horas.setCellValueFactory(new PropertyValueFactory<Hora, Integer>("Horas"));
		col_Horas.setMinWidth(150);
		col_Extras.setCellValueFactory(new PropertyValueFactory<Hora, Integer>("Horas Extra"));
		col_Extras.setMinWidth(150);
		col_Descripcion.setCellValueFactory(new PropertyValueFactory<Hora, String>("Descripcion"));
		col_Descripcion.setMinWidth(150);
        
        horas.setItems(hours);
	}
	/*
	public DisplayTimesController(Empleado emp) {
		empleado = emp;
	}
	*/
	public void start(Stage mainStage) {
		
		mainStage.show();
	}
	
	//Cargar informacion de equis empleado
	public ObservableList<Hora> BuildData() {
		ResultSet rset = null;
		try {
			rset = DB.getHoras(empleado.getCURP());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Hora> Hrs = new ArrayList<>();
		
		String fecha;
		Integer hora;
		Integer extra;
		String descripcion;
		String curp;
		if (rset!=null) {
		try {
			while(rset.next()) {
				curp = rset.getString(2);
			    hora = rset.getInt(3);
			    extra = rset.getInt(4);
			    fecha = rset.getString(5);
			    descripcion = rset.getString(6);
			    
			    Hora h = new Hora(curp, hora,extra, fecha, descripcion);
			    
			    Hrs.add(h);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		ObservableList<Hora> OL = FXCollections.observableList(Hrs);
        return OL;
	}

	public void setData(Empleado perfilEmpleado) {
		// TODO Auto-generated method stub
		empleado=perfilEmpleado;
	}

}
