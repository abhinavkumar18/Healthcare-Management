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
    public String filepath="/home/kmrakash/Healthcare-Management/healthcareApp/src/healthcareapp/RegisteredPatients.csv";
    private List<Patient> patientList;
    private List<Patient> result;
    private Scanner x;
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
                    
                    a.email =fields[6];
                    a.password = fields[7];
                    
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
//    public boolean addpatient(Patient newPatient){
//        boolean result=false;
//        this.patientList.add(newPatient);
//        System.out.println("Added "+newPatient.toString());
//        
//        // Adding NewPatient into CSV File
//        FileWriter filewriter=null;
//        try{
//            filewriter= new FileWriter(filepath,true);
//            filewriter.append(newPatient.getpatientid());
//            filewriter.append(",");
//            filewriter.append(newPatient.getpatientname());
//            filewriter.append(",");
//            filewriter.append(newPatient.getpatientaddress());
//            filewriter.append(",");
//            filewriter.append(newPatient.getpatientemail());
//            filewriter.append(",");
//            filewriter.append(newPatient.getpatientpassword());
//            filewriter.append("\n");
//            
//        }catch(Exception ex){
//            ex.printStackTrace();
//            
//        }
//        finally{
//            try{
//                filewriter.flush();
//                filewriter.close();
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        }
//        
//        
//        result=true;
//        return result;
//    }
    
    public void Register(String id,String name,String gender,String dob,String add,String phn,String email,String pass){
        FileWriter fileWriter=null;
       // String filepath="C:\\Users\\Akash\\Documents\\NetBeansProjects\\healthcareApp\\src\\healthcareapp\\RegisteredPatients.csv";
       String filepath="/home/kmrakash/Healthcare-Management/healthcareApp/src/healthcareapp/RegisteredPatients.csv";
       
       
        try{
            fileWriter=new FileWriter(filepath,true);
            fileWriter.append(id);
            fileWriter.append(",");
            fileWriter.append(name);
            fileWriter.append(",");
            fileWriter.append(gender);
            fileWriter.append(",");
            fileWriter.append(dob);
            fileWriter.append(",");
            fileWriter.append(add);
            fileWriter.append(",");
            fileWriter.append(phn);
            fileWriter.append(",");
            fileWriter.append(email);
            fileWriter.append(",");
            fileWriter.append(pass);
            fileWriter.append("\n");
            
            
            System.out.println("Successfully , Registered");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public boolean Login(String Email,String Pass){
      //  String filepath="C:\\Users\\Akash\\Documents\\NetBeansProjects\\healthcareApp\\src\\healthcareapp\\RegisteredPatients.csv";
      String filepath="/home/kmrakash/Healthcare-Management/healthcareApp/src/healthcareapp/RegisteredPatients.csv";
      
      
        boolean found=false;
        String email="";
        String pass="";
        String name="";
        String id="";
        try{
            x=new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
                
                while(x.hasNext() && !found){
                    id=x.next();
                    name=x.next();
                    x.next();
                    x.next();
                    x.next();
                    x.next();
                    email=x.next();
                    pass=x.next();
                    
                    if(email.equals(Email) && pass.equals(Pass)){
                        found=true;
                    }
                }
                
                return found;
                
        }catch(Exception e){
            System.out.println(e);
        }
        return found;
    }
    
    public Patient getPatient(String Email) {
        String filepath="/home/kmrakash/Healthcare-Management/healthcareApp/src/healthcareapp/RegisteredPatients.csv";
        
        boolean found = false;
         String id="";
     String name="";
     String address="";
     String email="";
    String pass="";
    String gender="";
     String dob="";
    String phnno="";
    
    // ID, Name, Gender, DOB, Add, Phn, Email, Pass
    
    try{
            x=new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
                
                while(x.hasNext() && !found){
                    id=x.next();
                    //System.out.println(id);
                    
                    name=x.next();
                    //System.out.println(name);
                    
                    gender =x.next();
                    //System.out.println(gender);
                    
                    dob = x.next();
                    //System.out.println(dob);
                    
                    address= x.next();
                    //System.out.println(address);
                    
                    phnno= x.next();
                    //System.out.println(phnno);
                    
                    email=x.next();
                    //System.out.println(email);
                    
                    pass=x.next();
                    //System.out.println(pass);
                    
                    if(email.equals(Email)){
                        //String id,String name,String address,String email,String password,String gender,String dob,String phnno
                        
                        return new Patient(id, name, address, email, pass, gender, dob, phnno);
                    }
                }
                
                
                
        } catch(Exception e){
            System.out.println(e);
        }
    return new Patient();
    }
    
    
    public boolean dohousekeeping(){
        return true;
    }
    
    
    public static void main(String[] args) {
        
        PatientManager mgr= new PatientManager();
       // mgr.init("C:\\Users\\DELL\\OneDrive\\Desktop\\CSV files\\Patientlist.csv");
//        assert(mgr.getlistofpatients().size()==2);
//        assert(mgr.getlistofpatients().get(1).getpatientid().equals("108"));

//    mgr.Register("pat125", "PatientName3", "Male", "01/01/2021", "Kolkata", "1234567890", "pat3@gmail.com", "123456");
//    Patient p = mgr.getPatient("pat3@gmail.com");
//    
//    System.out.println(p.toString());

        List<Patient> p = mgr.getlistofpatients();
        for(Patient P: p) {
            System.out.println(P.email);
        }
        
//    JFrame PatientsUI = new PatientUI(mgr);
//    PatientsUI.setVisible(true);
        
        
        }
        
}
    
    

