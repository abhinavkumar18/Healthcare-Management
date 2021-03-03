/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcareapp;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Akash
 */
public class Doctor {
    public String ID;
    public String Name;
    public String Gender;
    public String Dob;
    public String Hospital;
    public String Qualification;
    public String Specialization;
    public String Address;
    public String Phnno;
    public String Email;
    public String Password;
    public String filepath="/home/kmrakash/Healthcare-Management/healthcareApp/src/healthcareapp/RegisteredDoctors.csv";
    private Scanner x;
    public void Register(String id,String name,String gender,String dob,String hospital,String qual,String spec,String add,String phn,String email,String pass){
        
        FileWriter fileWriter=null;
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
        }
        
        
        return found;
    }
    
}
