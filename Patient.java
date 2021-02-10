/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.io.*;
import java.util.*;  

/**
 *
 * @author Akash
 */
public class Patient {
    public String filepath="C:\\Users\\DELL\\OneDrive\\Desktop\\CSV files\\Patientlist.csv";
    
    public long id;
    public String name;
    public String address;
    public String email;
    public String password;
    
    public Patient(long id,String name,String address,String email,String password){
        this.id=id;
        this.name=name;
        this.address=address;
        this.email=email;
        this.password=password;
    }
    
    public void saveInfo(){
        FileWriter filewriter=null;
        try{
            filewriter= new FileWriter(filepath,true);
            filewriter.append(String.valueOf(this.id));
            filewriter.append(",");
            filewriter.append(this.name);
            filewriter.append(",");
            filewriter.append(this.address);
            filewriter.append(",");
            filewriter.append(this.email);
            filewriter.append(",");
            filewriter.append(this.password);
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
  
    }
    
    public ArrayList<Patient> getInfo(){
        BufferedReader reader=null;
        ArrayList<Patient> Patientarr=new ArrayList<Patient>();
        try{
            String line="";
            reader=new BufferedReader(new FileReader(filepath));
            reader.readLine();
            
            while((line=reader.readLine())!=null){
                String[] fields= line.split(",");
                
                if(fields.length>0){
                    Patient p= new Patient();
                    p.id=(Long.parseLong(fields[0]));
                    p.name=fields[1];
                    p.address=fields[2];
                    p.email=fields[3];
                    p.password=fields[4];
                    Patientarr.add(p);
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
        return Patientarr;
    }

    Patient(){
        
    }
         
}

    /**
     * @param args the command line arguments
     */
    

