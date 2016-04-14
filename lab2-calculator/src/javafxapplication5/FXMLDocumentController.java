/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author kaqq
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField res;
    CalculatorLogic calc;
    private double Foperand;
    private double Soperand;
    @FXML
    private Button dot;
    
    @FXML
//        private void handleButtonAction(ActionEvent event) {
//            System.out.println("You clicked me!");
//            label.setText("Hello World!");
//        }
    private void DigitAction(ActionEvent event) {
        Button btn = (Button) event.getSource();
       calc.AddDigit(btn.getText());
    }
     @FXML
   private void DotAction(ActionEvent event) {
        Button btn = (Button) event.getSource();
       calc.AddDigit(btn.getText());
       dot.setDisable(true);
    }
    @FXML
    private void SetAction(ActionEvent event) {
      Button btn = (Button) event.getSource();
       calc.SetAction(btn.getText());
       dot.setDisable(false);
    }
    @FXML
    private void PerformAction(ActionEvent event) {
       calc.Calculate();
       dot.setDisable(false);
    }
    @FXML
    private void Clear(ActionEvent event) {
       calc.Clear();
       dot.setDisable(false);
    }
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert res != null : "fx:id=\"res\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert dot != null : "fx:id=\"dot\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        calc= new CalculatorLogic(res);
    }
    
}
