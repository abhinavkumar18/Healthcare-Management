/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcareapp;
import java.util.*;
import javax.swing.*;

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
        
       PatientManager ptnMgr = new PatientManager();
       AdviceManager advMgr = new AdviceManager();
       SymptomManager symMgr = new SymptomManager();
       
       JFrame WelcomeUI = new Welcome(ptnMgr, advMgr, symMgr);
       
       WelcomeUI.setVisible(true);
       
    }
    
}
