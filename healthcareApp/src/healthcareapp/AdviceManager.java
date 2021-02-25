/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcareapp;
import java.util.*;
import java.io.*;
/**
 *
 * @author Akash
 */
public class AdviceManager {
    public String filepath="/home/kmrakash/college/Software engineering/healthcareApp/src/healthcareapp/Advice.csv";

    private List<Advice> descriptionList;
    private List<Advice> result;
    
    // init
    public boolean init(String filename){
        boolean result=false;
        this.descriptionList.add(new Advice("107","Rajat Malhotra","24-02-2021","Paracetamol , Take Rest"));
        this.descriptionList.add(new Advice("108","Raja Roy","24-02-2021","PAN-40,Drink boiled Water"));
        result=true;
        return result;   
    }
    
    // Constructor
    public AdviceManager(){
        this.descriptionList=new ArrayList<Advice>();
    }
    
    // view Advice Method
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
    
    // get Advice of Particular By Name
    public Advice getAdvice(String name){
        
        for(int i=0; i<descriptionList.size();i++){
            if(descriptionList.get(i).getpatientname().equals(name)){
               Advice d1;
                d1 = new Advice();
                d1 = descriptionList.get(i);
                return d1;
            }
        }
//        Donation d1 = new Donation();
        return null;
    }
    
    public boolean dohousekeeping(){
        return true;
    }
    
    
    public static void main(String[] args) {
        
//        AdviceManager mgr= new AdviceManager();
//        mgr.giveadvice(new Advice("107","Rajat Malhotra","24-02-2021","Paracetamol , Take Rest"));
//        mgr.giveadvice(new Advice("108","Raja Roy","24-02-2021","PAN-40,Drink boiled Water"));
//        System.out.println(mgr.viewadvice());
        //mgr.init("C:\\Users\\DELL\\OneDrive\\Desktop\\CSV files\\Patientlist.csv");
        //assert(mgr.getlistofpatients().size()==2);
        //assert(mgr.getlistofpatients().get(1).getpatientid().equals("108"));
        
        
        
        }
    
}
   