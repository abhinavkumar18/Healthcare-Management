/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcareapp;
import java.util.*;

/**
 *
 * @author kmrakash
 */
public class HealthcareApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Advice Control Class
//        AdviceManager advMgr = new AdviceManager();
//        Advice adv = new Advice("123", "remo", "25/02/2021", "Take care");
//        advMgr.giveadvice(adv);
//        advMgr.viewadvice();

          // give Advice UI 
          
          //giveAdvUI;
          
          // Patient Ui
          new PatientUI().setVisible(true);
          

            new ViewAdviceUI().setVisible(true);
            new GiveAdviceUI().setVisible(true);
    }
    
}
