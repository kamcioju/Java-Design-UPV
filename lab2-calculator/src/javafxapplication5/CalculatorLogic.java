/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
/**
 *
 * @author kaqq
 */

public class CalculatorLogic {
    private String Foperand;
    private String Soperand;
    private String Result;
    private String act;
    private final TextField ResultLine;
    public CalculatorLogic(TextField res)
    {
        ResultLine=res;
    }
    public void SetAction(String act)
    {
        
        if(Foperand!=null)
        {
            if(Soperand!=null)
                Calculate();
            this.act=act;
            ResultLine.setText( Foperand+act);
       
        
        
        }
        
    }
   
    
    public void AddDigit(String op)
    {
        if((Result==Foperand)&(act==null))
         Clear();
        
        if(act==null)
        {
            if(Foperand!=null)
                Foperand+=op;
            else 
            {
                if(!".".equals(op))
                Foperand=op;
            }
            ResultLine.setText(Foperand);
        }
        else
        {
            if(Soperand!=null)
                Soperand+=op;
            else 
            {
                 if(!".".equals(op))
                Soperand=op;
            }
             ResultLine.setText( ResultLine.getText()+op);
        }
        
        }
    
    public void refresh()
    {
        ResultLine.setText(Result.toString());
    }

    void Calculate() {
       if((Foperand!=null)&(Soperand!=null)&(act!=null))
       {   
        double val1=Double.parseDouble(Foperand);
        double val2=Double.parseDouble(Soperand);
       switch (act)
       {
           case "+": val1+=val2; break;
           case "-": val1-=val2; break;
           case "*": val1*=val2; break;
           case "/": val1/=val2; break;
        }
       Foperand=String.valueOf(val1);
       Result=Foperand;
       ResultLine.setText(Foperand);
       Soperand=null;
       act=null;
       }
    }
    void Clear()
    {
       Soperand=null;
       act=null;
       Foperand=null;
       Result=null;
       ResultLine.clear();
    }
    
            
}
