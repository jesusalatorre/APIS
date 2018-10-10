/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
    }
    
        public static void ExamplePopulate() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Statement st = conn.createStatement();
        String query = "INSERT INTO EMPLEADO VALUES ( DEFAULT," +
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
        
        
        ResultSet rset = st.executeQuery("select * from EMPLEADO");
        while (rset.next()) {
            String name = rset.getString(2);
            System.out.println(name);
        }
    }
}