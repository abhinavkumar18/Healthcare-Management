/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.util.*;
import java.time.*;
import java.io.*;
/**
 *
 * @author Akash
 */
public class Symptoms {
    public String filepath="C:\\Users\\Akash\\Desktop\\CSV files\\Symptoms.csv";
    
    public String description;
    public String datetime;
    
    public Symptoms(String desc,String datetime){
        this.description=desc;
        this.datetime=datetime;
    }
    
    public void sendSymptoms(){
        FileWriter filewriter=null;
        try{
            filewriter= new FileWriter(filepath,true);
            filewriter.append(this.description);
            filewriter.append(",");
            filewriter.append(this.datetime);
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
    
    public void getSymptoms(){
        BufferedReader reader=null;
        ArrayList<Symptoms> Symarr=new ArrayList<Symptoms>();
        try{
            String line="";
            reader=new BufferedReader(new FileReader(filepath));
            reader.readLine();
            
            while((line=reader.readLine())!=null){
                String[] fields= line.split(",");
                
                if(fields.length>0){
                    Symptoms s= new Symptoms();
                    s.description=fields[0];
                    s.datetime=fields[1];
                    Symarr.add(s);
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
        for(Symptoms s:Symarr){
            System.out.printf("Description=%s,Date/time=%s\n",s.description,s.datetime);
            System.out.println();
        }
    }

    public static void main(String[] args){
        Symptoms s=new Symptoms();
        s.description="Fever";
        s.datetime="7/02/2020";
        s.sendSymptoms();
        s.getSymptoms();
    }
    
    Symptoms(){
        
    }
}

