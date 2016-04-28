/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.ex1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kaqq
 */
public class FXMLDocumentController implements Initializable {
    
    Counter CNT;
    int positive=1;
    @FXML
    Label res;
    @FXML
    TextField addon;
    @FXML
    Label Lstatus;

    @FXML
    private void Button_add_onclick(ActionEvent event) {

        CNT.Add(positive*Double.valueOf(addon.getText()));
      
    }
    @FXML
    private void Button_addval_onclick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        CNT.Add(positive*Double.valueOf(btn.getText()));
    }
    @FXML
    private void check_box_onclick(ActionEvent event) {
        positive*=-1;
        Lstatus.setVisible(!Lstatus.isVisible());
    }

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert res != null : "fx:id=\"res\" was not injected: check your FXML file 'FXMLDocument.fxml'.";

        CNT = new Counter(res);
    } 
    
}
