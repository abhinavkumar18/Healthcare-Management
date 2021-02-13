/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.util.*;

/**
 *
 * @author Abhinav
 */
public class PatientManager{
    private  List<Patient> patientList;
    
    public boolean init(String filename){
        boolean result=false;
        this.patientList.add(new Patient("107","Rajat Malhotra","Orissa","raj123@gmail.com","raj345"));
        this.patientList.add(new Patient("108","Raja Roy","uttar Pradesh","raj3@gmail.com","raj215"));
        result=true;
        return result;   
    }
    public PatientManager(){
        this.patientList=new ArrayList<Patient>();
    }
    public List<Patient>getlistofpatients(){
        List<Patient> result=null;
        result=Collections.unmodifiableList(this.patientList);
        return result;
    }
    public boolean addpatient(Patient newPatient){
        boolean result=false;
        this.patientList.add(newPatient);
        System.out.println("added"+newPatient.toString());
        result=true;
        return result;
    }
    public boolean dohousekeeping(){
        return true;
    }
    
    
    public static void main(String[] args) {
        
        PatientManager mgr= new PatientManager();
        mgr.init("C:\\Users\\DELL\\OneDrive\\Desktop\\CSV files\\Patientlist.csv");
        assert(mgr.getlistofpatients().size()==2);
        assert(mgr.getlistofpatients().get(1).getpatientid().equals("108"));
        
        
        
        }
        
}

