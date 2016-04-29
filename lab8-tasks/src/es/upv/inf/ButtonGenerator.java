/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.upv.inf;

import static es.upv.inf.FXMLDocumentController.NUM_BUTTONS;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;

/**
 *
 * @author kaqq.pl
 */
public class ButtonGenerator extends Thread { 
   public static List<BooleanProperty> state=new ArrayList<>();
   public int winnerButton;
     private Thread t;
     private final BooleanProperty val;
     ButtonGenerator(BooleanProperty p){
     val=p;
     }
   @Override
  public void run(){
  
       try {
           sleep((long) (Math.random() * 5000 + 1.0));
           val.set(!val.getValue());
//       try {
//           sleep((long) (Math.random() * 5000 + 1.0));
//           winnerButton = (int) (Math.floor(Math.random() * NUM_BUTTONS));
//           state.get(winnerButton).set(false);
//       } catch (InterruptedException ex) {
//           Logger.getLogger(ButtonGenerator.class.getName()).log(Level.SEVERE, null, ex);
//       }
       } catch (InterruptedException ex) {
           Logger.getLogger(ButtonGenerator.class.getName()).log(Level.SEVERE, null, ex);
       }
       
  }
   @Override
  public void start ()
   {
     
      if (t == null)
      {
         t = new Thread (this);
         t.start ();
      }
   }
    
    void ResetLast(){
        state.get(winnerButton).set(true);
    }
   
}
