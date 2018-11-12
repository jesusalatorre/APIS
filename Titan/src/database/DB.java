/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Cuenta;
import models.Empleado;

/**
 *
 * @author Jesus
 */

public class DB {

    public static void Startup() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Statement st = conn.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS EMPLEADO(" + 
                " ID INT AUTO_INCREMENT PRIMARY KEY," +
                " NOMBRE VARCHAR(255)," +
                " ACTIVO BOOL," +
                " FECHAINGRESO DATE," +
                " FECHABAJA DATE," +
                " CONS INT,"+
                " RFC VARCHAR(255)," +
                " INFONAVIT BOOL," +
                " FONACOT BOOL," +
                " TEL VARCHAR(255)," +
                " IMSS VARCHAR(255)," +
                " CLINICA VARCHAR(255)," +
                " LUGARNACIMIENTO VARCHAR(255)," +
                " LUGARRESIDENCIA VARCHAR(255)," +
                " FECHANACIMIENTO DATE," +
                " CURP VARCHAR(255)," +
                " TELFAMILIAR VARCHAR(255)," +
                " NOMBREFAMILIAR VARCHAR(255));";
        st.execute(query);
        
        
        query = "CREATE TABLE IF NOT EXISTS CUENTA(" + 
                " ID INT AUTO_INCREMENT PRIMARY KEY," +
                " USUARIO VARCHAR(255),"+
                " CONTRA VARCHAR(255));"; 
        st.execute(query);
        
        
        query = "CREATE TABLE IF NOT EXISTS TIEMPOS(" + 
                " ID INT AUTO_INCREMENT PRIMARY KEY," +
                " FECHA DATE,"+
                " HORAS INT," +
                " EXTRAS INT," +
                " EMPLEADO INT);"; 
        st.execute(query);
        
    }
    
        public static void ExamplePopulate() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Statement st = conn.createStatement();
        String query = "SELECT * FROM EMPLEADO";
        ResultSet rset = st.executeQuery(query);
        if(!rset.next()) {
        		query = "INSERT INTO EMPLEADO VALUES ( DEFAULT," +
                                                      " 'Carlos Vela'," +
                                                      " 'TRUE',"+
                                                      " '2010-10-19'," +
                                                      " NULL," +
                                                      " 5," +
                                                      " 'KAJHFKLJA19827'," +
                                                      " FALSE," +
                                                      " FALSE," +
                                                      " '04481199919191'," +
                                                      " 'ABCDEFG222'," +
                                                      " '10'," +
                                                      " 'Monterrey, N.L'," +
                                                      " 'Col. Mangos 789 Rio Guada'," +
                                                      " '1992-2-23'," +
                                                      " 'HUGHUGLLL123123'," +
                                                      " '83776655'," +
                                                      " 'Poncho Vela');";
        
        st.execute(query);
        
                 query = "INSERT INTO EMPLEADO VALUES ( DEFAULT," +
                                                      " 'Rodolfo Jimenez'," +
                                                      " 'TRUE',"+
                                                      " '2010-1-10'," +
                                                      " NULL," +
                                                      " 5," +
                                                      " 'ABCDEFGHI1234'," +
                                                      " FALSE," +
                                                      " FALSE," +
                                                      " '04481123452345'," +
                                                      " 'ABCDEFG111'," +
                                                      " '19'," +
                                                      " 'Monterrey, N.L'," +
                                                      " 'Col. Manjares 111 Rio Balsas'," +
                                                      " '1995-9-11'," +
                                                      " 'HNNL95ABCDEFGHNNL11'," +
                                                      " '83848586'," +
                                                      " 'Poncho Jimenez');";
        
        st.execute(query);
        }
        
        query = "SELECT * FROM CUENTA";
        rset = st.executeQuery(query);
        if(!rset.next()) {
        		query = "INSERT INTO CUENTA VALUES ( DEFAULT,"+
        											"'JOscar',"+
        											"'admin123');";
        }
        st.execute(query);
        											
    }
        
      public static ResultSet getEmpleados() throws Exception{
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Statement st = conn.createStatement();
        String query = "SELECT * FROM EMPLEADO";
        ResultSet rset = st.executeQuery(query);
        return rset;
      }
      
      public static ArrayList<Cuenta> getCuenta() throws Exception{
          Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
          Statement st = conn.createStatement();
          String query = "SELECT * FROM CUENTA";
          ResultSet rset = st.executeQuery(query);
          ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
          Cuenta cuenta;
          while(rset.next()){
        	  String usuario = rset.getString(2);
        	  String contra = rset.getString(3);
        	  cuenta= new Cuenta(usuario, contra);
        	  cuentas.add(cuenta);
          }
          return cuentas;
        }
      
      public static Boolean addEmpleadoToDB(Empleado empleado) throws SQLException {
    	  Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
          Statement st = conn.createStatement();
          String query = "INSERT INTO EMPLEADO VALUES (DEFAULT,";
          query = query.concat("'" + empleado.getNombre() + "',");
          
          if(empleado.isActivo())
        	  query = query.concat("TRUE,");
          else query = query.concat("FALSE,");
          
          query = query.concat("'" + empleado.getFecha_ingreso() + "',");
          
          if(empleado.getFecha_baja() != null)
        	  query = query.concat("'" + empleado.getFecha_baja() + "',");
          else query = query.concat(" NULL, ");
          
          query = query.concat(empleado.getCons() + ",");
          query = query.concat("'" + empleado.getRfc() + "',");
          
          if(empleado.isInfonavit())
        	  query = query.concat(" TRUE, ");
          else query = query.concat("FALSE, ");
          
          if(empleado.isFonacot())
        	  query = query.concat(" TRUE, ");
          else query = query.concat("FALSE, ");
          
          query = query.concat("'" + empleado.getTel() + "',");
          query = query.concat("'" + empleado.getImss() + "',");
          query = query.concat("'" + empleado.getClinica() + "',");
          query = query.concat("'" + empleado.getLugar_nacimiento() + "',");
          query = query.concat("'" + empleado.getLugar_residencia() + "',");
          query = query.concat("'" + empleado.getFecha_nacimiento() + "',");
          query = query.concat("'" + empleado.getCurp() + "',");
          query = query.concat("'" + empleado.getTel_familiar() + "',");
          query = query.concat("'" + empleado.getNombre_familiar() + "');");
          
          Boolean rset = st.execute(query);
    	  return rset;
      }
}