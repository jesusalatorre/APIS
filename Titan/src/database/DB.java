/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        
       /* query = "CREATE TABLE IF NOT EXISTS TEMP(" + 
                " ID INT AUTO_INCREMENT PRIMARY KEY," +
                " RFC VARCHAR(255));" ;
        st.execute(query);*/
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
      
      public static ResultSet getEmpleadosFiltrados(String nombre) throws Exception{
          Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
          PreparedStatement st = conn.prepareStatement(
        		    "SELECT * FROM EMPLEADO WHERE NOMBRE like ?");
          st.setString(1, nombre + "%");
          
          ResultSet rset = st.executeQuery();
          return rset;
          
        }
      
      public static Empleado getEmpleado(String rfc) throws Exception{
    	  Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    	  
          
    	  PreparedStatement st = conn.prepareStatement(
    	        		    " SELECT * FROM EMPLEADO WHERE RFC =  ?");
    	  st.setString(1, rfc);
    	  
    	  ResultSet rset = st.executeQuery();
    	  Empleado E=null;
    	  while(rset.next()){
    	  E = new Empleado(rset.getString(2), rset.getBoolean(3), rset.getString(4), rset.getString(5),
    			  rset.getInt(6), rset.getString(7), rset.getBoolean(8), rset.getBoolean(9),
    			  rset.getString(10), rset.getString(11), rset.getString(12), rset.getString(13),
    			  rset.getString(14), rset.getString(15), rset.getString(16),
    			  rset.getString(17),rset.getString(18));
    	  }
    	  
    	  return E;
    	          
      }
      
      
      
}