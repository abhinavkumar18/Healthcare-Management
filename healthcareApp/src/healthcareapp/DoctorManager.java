/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcareapp;
import java.util.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author kmrakash
 */
public class DoctorManager {
    public String filepath="/home/kmrakash/Healthcare-Management/healthcareApp/src/healthcareapp/RegisteredDoctors.csv";
    private Scanner x;
    private List<Doctor> doctorList;
    
    public boolean init(String filename){
        boolean result=false;
        this.doctorList.add(new Doctor("doc@1", "Doctor1", "male","01/02/03","Ruby","M.B.B.S", "Cardiologist", "Kolkata","123456789", "doctor1@gmail.com", "123456" ));
        this.doctorList.add(new Doctor("doc@2", "Doctor2", "Female","01/02/03","Ruby","M.B.B.S", "Cardiologist", "Kolkata","123456789", "doctor2@gmail.com", "123456" ));
        result=true;
        return result;   
    }
    
    public DoctorManager(){
        this.doctorList=new ArrayList<Doctor>();
    }
    
    public void Register(String id,String name,String gender,String dob,String hospital,String qual,String spec,String add,String phn,String email,String pass){
        
        FileWriter fileWriter=null;
        try{
            fileWriter=new FileWriter(new File(filepath),true);
            fileWriter.append(id);
            fileWriter.append(",");
            fileWriter.append(name);
            fileWriter.append(",");
            fileWriter.append(gender);
            fileWriter.append(",");
            fileWriter.append(dob);
            fileWriter.append(",");
            fileWriter.append(hospital);
            fileWriter.append(",");
            fileWriter.append(qual);
            fileWriter.append(",");
            fileWriter.append(spec);
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
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            }
        }
        
    }
    
    public boolean login(String Email,String Pass){
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
                    for(int i=0;i<=6;i++){
                        x.next();
                    }
                    email=x.next();
                    pass=x.next();
                    
                    if(email.equals(Email) && pass.equals(Pass)){
                        found=true;
                    }
                }
                return found;
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
        
        
        return found;
    }
    
    
    public Doctor getDoctor(String Email) {
        
        
        boolean found = false;
         String id="";
     String name="";
     String address="";
     String email="";
    String pass="";
    String gender="";
     String dob="";
    String phnno="";
    String hospital="";
String qual = "";
String spec = "";


    
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
                    hospital = x.next();
                    
                    qual = x.next();
                    
                    spec = x.next();
                    
                    address= x.next();
                    //System.out.println(address);
                    
                    phnno= x.next();
                    //System.out.println(phnno);
                    
                    email=x.next();
                    //System.out.println(email);
                    
                    pass=x.next();
                    //System.out.println(pass);
                    
                    if(email.equals(Email)){
                       //    String id,String name,String gender,String dob,String hospital,String qual,String spec,String add,String phn,String email,String pass
                        
                        return new Doctor(id, name, gender,dob,hospital,qual,spec, address,phnno, email, pass );
                    }
                }
                
                
                
        } catch(Exception e){
           // System.out.println(e);
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    return new Doctor();
    }
}
