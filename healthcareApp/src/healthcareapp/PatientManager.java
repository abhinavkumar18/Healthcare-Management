/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcareapp;

import java.util.*;
import java.io.*;
import javax.swing.JFrame;
/**
 *
 * @author Akash
 */
public class PatientManager{
    public String filepath="/home/kmrakash/college/Software engineering/healthcareApp/src/healthcareapp/Patientlist.csv";
    private  List<Patient> patientList;
    private List<Patient> result;
//    public boolean init(String filename){
//        boolean result=false;
//        this.patientList.add(new Patient("107","Rajat Malhotra","Orissa","raj123@gmail.com","raj345"));
//        this.patientList.add(new Patient("108","Raja Roy","uttar Pradesh","raj3@gmail.com","raj215"));
//        result=true;
//        return result;   
//    }
    public PatientManager(){
        this.patientList=new ArrayList<Patient>();
    }
    public List<Patient>getlistofpatients(){
        
    result=Collections.unmodifiableList(this.patientList);
        result=new ArrayList<Patient>(result);
        result.clear();
       
        
        
        // Reading from csv file
        BufferedReader reader=null;
        
        try{
            String line="";
            reader=new BufferedReader(new FileReader(filepath));
            reader.readLine();
            
            while((line=reader.readLine())!=null){
                String[] fields=line.split(",");
                
                if(fields.length>0){
                    //System.out.println(fields);
                    Patient a= new Patient();
                    a.id=fields[0];
                    a.name=fields[1];
                    a.address =fields[2];
                    a.email =fields[3];
                    a.password = fields[4];
                    
                    result.add(a);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
          
        }
        finally{
            try{
                reader.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return result;
    }
    public boolean addpatient(Patient newPatient){
        boolean result=false;
        this.patientList.add(newPatient);
        System.out.println("Added "+newPatient.toString());
        
        // Adding NewPatient into CSV File
        FileWriter filewriter=null;
        try{
            filewriter= new FileWriter(filepath,true);
            filewriter.append(newPatient.getpatientid());
            filewriter.append(",");
            filewriter.append(newPatient.getpatientname());
            filewriter.append(",");
            filewriter.append(newPatient.getpatientaddress());
            filewriter.append(",");
            filewriter.append(newPatient.getpatientemail());
            filewriter.append(",");
            filewriter.append(newPatient.getpatientpassword());
            filewriter.append("\n");
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        finally{
            try{
                filewriter.flush();
                filewriter.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
        result=true;
        return result;
    }
    public boolean dohousekeeping(){
        return true;
    }
    
    
    public static void main(String[] args) {
        
        PatientManager mgr= new PatientManager();
       // mgr.init("C:\\Users\\DELL\\OneDrive\\Desktop\\CSV files\\Patientlist.csv");
//        assert(mgr.getlistofpatients().size()==2);
//        assert(mgr.getlistofpatients().get(1).getpatientid().equals("108"));
        
    JFrame PatientsUI = new PatientUI(mgr);
    PatientsUI.setVisible(true);
        
        
        }
        
}
    
    

