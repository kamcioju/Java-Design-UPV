/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;


/**
 *
 * @author kaqq.pl
 */
public class FXMLDocumentController implements Initializable {

    
    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private PieChart pieChart;
    
    ObservableList<PieChart.Data> pieChartData;
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();   
   
       
        
        pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("0", 1),
                new PieChart.Data("1", 1),
                new PieChart.Data("2", 1),
                new PieChart.Data("3", 1),
                new PieChart.Data("4", 1),
                new PieChart.Data("5", 1),
                new PieChart.Data("6", 1),
                new PieChart.Data("7", 1),
                new PieChart.Data("8", 1),
                new PieChart.Data("9", 1)) 
                ;
        
        pieChart.setData(pieChartData); 
    } 
    
    

    @FXML
    private void GenerateRandom(ActionEvent event) {
         Random generator = new Random();
         
        for(int i =0;i<10000;i++)
        {
            int rand =generator.nextInt(10);
            int count=(int) pieChartData.get(rand).getPieValue();
           pieChartData.get(rand).setPieValue(count+1);
        }
    }
    
}
