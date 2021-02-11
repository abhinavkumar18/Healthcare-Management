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
public class Advice {
    public String filepath="C:\\Users\\Akash\\Desktop\\CSV files\\Advice.csv";
    
    public String description;
    public String datetime;
    
    public Advice(String desc,String date){
        this.description=desc;
        this.datetime=date;
    }
    
    public void sendAdvice(){
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
    
    public ArrayList<Advice> getAdvice(){
        BufferedReader reader=null;
        ArrayList<Advice> Adarr=new ArrayList<Advice>();
        try{
            String line="";
            reader=new BufferedReader(new FileReader(filepath));
            reader.readLine();
            
            while((line=reader.readLine())!=null){
                String[] fields= line.split(",");
                
                if(fields.length>0){
                    Advice a= new Advice();
                    a.description=fields[0];
                    a.datetime=fields[1];
                    Adarr.add(a);
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
        for(Advice ad:Adarr){
            System.out.printf("Description=%s,Date/time=%s\n",ad.description,ad.datetime);
            System.out.println();
        }
       return Adarr;
    }
    Advice(){
        
    }
}
