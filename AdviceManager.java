/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.lang.*;
/**
 *
 * @author Abhinav
 */
public class AdviceManager {
    private String filepath="C:\\Users\\DELL\\OneDrive\\Desktop\\CSV files\\Advice.csv";
    private List<Advice> descriptionList;
    private List<Advice> result;
    public boolean init(String filename){
        boolean result=false;
        this.descriptionList.add(new Advice("107","Rajat Malhotra","24-02-2021","Paracetamol , Take Rest"));
        this.descriptionList.add(new Advice("108","Raja Roy","24-02-2021","PAN-40,Drink boiled Water"));
        result=true;
        return result;   
    }
    public AdviceManager(){
        this.descriptionList=new ArrayList<Advice>();
    }
    public List<Advice>viewadvice(){
        
        result=Collections.unmodifiableList(this.descriptionList);
        result=new ArrayList(result);
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
                    
                    Advice a= new Advice();
                    a.patientid=fields[0];
                    a.patientname=fields[1];
                    a.datetime =fields[2];
                    a.description =fields[3];
                    
                    
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
    public boolean giveadvice(Advice newAdvice){
        boolean result=false;
        this.descriptionList.add(newAdvice);
        System.out.println("Given "+newAdvice.toString());
        
        // Adding NewPatient into CSV File
        FileWriter filewriter=null;
        try{
            filewriter= new FileWriter(filepath,true);
            filewriter.append(newAdvice.getpatientid());
            filewriter.append(",");
            filewriter.append(newAdvice.getpatientname());
            filewriter.append(",");
            filewriter.append(newAdvice.getdatetime());
            filewriter.append(",");
            filewriter.append(newAdvice.getdescription());
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
        
        AdviceManager mgr= new AdviceManager();
        mgr.giveadvice(new Advice("107","Rajat Malhotra","24-02-2021","Paracetamol , Take Rest"));
        mgr.giveadvice(new Advice("108","Raja Roy","24-02-2021","PAN-40,Drink boiled Water"));
        System.out.println(mgr.viewadvice());
        //mgr.init("C:\\Users\\DELL\\OneDrive\\Desktop\\CSV files\\Patientlist.csv");
        //assert(mgr.getlistofpatients().size()==2);
        //assert(mgr.getlistofpatients().get(1).getpatientid().equals("108"));
        
        
        
        }
        
}


