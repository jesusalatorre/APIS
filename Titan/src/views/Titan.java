/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.sql.*;

import database.DB;

/**
 *
 * @author Jesus
 */
public class Titan extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        
        DB.Startup();
        DB.ExamplePopulate();
        
        Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);
        stage.show();
        
        conn.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
