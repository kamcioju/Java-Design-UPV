/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.ex1;

/**
 *
 * @author kaqq
 */
import javafx.scene.control.Label;

/**
 * Created by kaqq on 25.02.2016.
 */
public class Counter {
    private Double count=0.0;
    private Label _res;

    public void Add(double value){

        count+=value;
        Update();
    }
    public Counter(Label res){
        _res=res;

    }
    private void Update(){
        _res.setText(String.valueOf(count));
    }
}

