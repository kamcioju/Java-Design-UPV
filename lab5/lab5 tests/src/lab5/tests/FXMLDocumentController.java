/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.tests;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author kaqq.pl
 */
public class FXMLDocumentController implements Initializable {

    @FXML private CheckMenuItem AmazonSelected;
    @FXML private CheckMenuItem EbaySelected;
    @FXML private Label label;
    
    private ResourceBundle bundle;
    
    @FXML
    private void exitButtonAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        // or AlertType.WARNING or AlertType.ERROR or AlertType.CONFIRMATION
        alert.setTitle(bundle.getString("Confirmation"));
        alert.setHeaderText(bundle.getString("LeaveProgram"));
        // or null if we do not want a header
        alert.setContentText(bundle.getString("LeaveConfirmation"));
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    @FXML
    public void PerformBlogger(ActionEvent event) {
        Optional<String> BlogName = BlogNameMonit();
        if (BlogName.isPresent()) {
            label.setText(bundle.getString("Visiting")+ BlogName.get());
        }
    }

    @FXML
    public void PerformAmazon(ActionEvent event) {
        if (AmazonSelected.isSelected()) {
            DisplayConfirm("Amazon");
        } else {
            DisplayError("Amazon");
        }
    }

    @FXML
    public void PerformEbay(ActionEvent event) {
        if (EbaySelected.isSelected()) {
            DisplayConfirm("Ebay");
        } else {
            DisplayError("Ebay");
        }
    }

    @FXML
    public void PerformSocial(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String SocialService = btn.getId();
        Optional<String> User = SocialLoginMonit(SocialService);
        if (User.isPresent()) {
            label.setText(bundle.getString("SendAs") + User.get());
        }

    }
     


 private void DisplayError(String ShopName){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(bundle.getString("Selection_Error"));
        alert.setHeaderText(bundle.getString("CanNotBuy")+ShopName);
        alert.setContentText(bundle.getString("SelectionChangeNeeded"));
        alert.showAndWait();
     }
 private void DisplayConfirm(String ShopName){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(bundle.getString("Confirmation"));
        alert.setHeaderText(bundle.getString("PurchaseCompleted"));
        alert.setContentText(bundle.getString("BoughtIn") + ShopName);
        alert.showAndWait();
     }
 private Optional<String> BlogNameMonit(){
        List<String> choices = new ArrayList<>();
        choices.add("Althos' blog");
        choices.add("Porthos' blog");
        choices.add("Aramis' blog");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Althos' blog", choices);
        dialog.setTitle(bundle.getString("BlogSelect"));
        dialog.setHeaderText(bundle.getString("WhitchBlogToVisit"));
        dialog.setContentText(bundle.getString("Choose"));
        Optional<String> result = dialog.showAndWait();
        return result;
     }
 private Optional<String> SocialLoginMonit(String SocialService){
        TextInputDialog dialog = new TextInputDialog("John"); 
        dialog.setTitle(bundle.getString("IntroduceName"));
        dialog.setHeaderText(bundle.getString("ChooseUsername")+SocialService);
        dialog.setContentText(bundle.getString("EnterName"));
        Optional<String> result = dialog.showAndWait();
        return result;
     }
 
     @Override
     public void initialize(URL url, ResourceBundle resources) {
       bundle = resources; 
    } 
     
     //totaly wrong! it isn't necessary!
   /*  private void updateLabel(String key) {
    label.setText(bundle.getString(key));
    }
    */
}