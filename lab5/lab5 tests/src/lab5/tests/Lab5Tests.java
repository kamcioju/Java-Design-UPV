/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.tests;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kaqq.pl
 */
public class Lab5Tests extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        // Get the default locale
        Locale locale = Locale.getDefault();
        // Load the bundle (e.g., strings_es_ES.properties)
        ResourceBundle bundle=null;
        try{    
            bundle =ResourceBundle.getBundle("lab5.tests.Resources", locale);
            
        }
        catch (MissingResourceException e) { 
            // This block is to catch divide-by-zero error
            System.out.println("ERROR! Locale not found, using default!");
            bundle =ResourceBundle.getBundle("lab5.tests.Resources_en_GB");
            
        }
        catch (Throwable  ex){
         System.out.println("Locale error");
        }
        
        Parent root =FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"), bundle);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
