/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.ex2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javax.swing.AbstractButton;

/**
 *
 * @author kaqq
 */
public class FXMLDocumentController implements Initializable {
    
    ChangeListener<String> Listener = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            PerformConvert();
        }
    };
    @FXML
    private Label c_rate;
    @FXML
    private Slider rate_slider;
    @FXML
    private TextField Input_val;
    @FXML
    private TextField Output_val;
    @FXML
    private Button convert;
    @FXML
    private void Convert(ActionEvent event) {
      PerformConvert();
    }
    @FXML
    private void Clear(ActionEvent event) {
         Output_val.clear();
         Input_val.clear();
    }
    @FXML
    private void check_box_onclick(ActionEvent event) {
         CheckBox box = (CheckBox) event.getSource();
         boolean selected = box.isSelected();
        if(selected)
        {
        Input_val.textProperty().addListener(Listener);
        c_rate.textProperty().addListener(Listener);
        convert.setDisable(true);
        }
        else
        {
         Input_val.textProperty().removeListener(Listener);
        c_rate.textProperty().removeListener(Listener);  
        convert.setDisable(false);
        }
            
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         assert c_rate != null : "fx:id=\"c_rate\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
         assert rate_slider != null : "fx:id=\"rate_slider\" was not injected: check your FXML file 'FXMLDocument.fxml'.";

         c_rate.textProperty().bind(Bindings.format("%.2f",rate_slider.valueProperty()));
    }    
    
    void PerformConvert()
    {
      double result=Double.parseDouble(Input_val.getText())*rate_slider.getValue();
      Output_val.setText(String.format("%.3f", result));
    }
    
   
}
