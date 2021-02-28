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
 * @author kmrakash
 */
public class SymptomManager {
    public String filepath="/home/kmrakash/college/Software engineering/healthcareApp/src/healthcareapp/Symptoms.csv";
    private List<Symptom> symptomsList;
    private List<Symptom> result;
    public boolean init(String filename){
        boolean result=false;
        this.symptomsList.add(new Symptom("107","Rajat Malhotra","24-02-2021","Fever,Headache,coughing"));
        this.symptomsList.add(new Symptom("108","Raja Roy","24-02-2021","loose motions,weakness"));
        result=true;
        return result;   
    }
    public SymptomManager(){
        this.symptomsList=new ArrayList<Symptom>();
    }
    public List<Symptom>getinfo(){
        
        result=Collections.unmodifiableList(this.symptomsList);
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
                    
                    Symptom a= new Symptom();
                    a.patientid=fields[0];
                    a.patientname=fields[1];
                    a.datetime =fields[2];
                    a.symptoms =fields[3];
                    
                    
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
    public boolean uploadsymptoms(Symptom newSymptom){
        boolean result=false;
        this.symptomsList.add(newSymptom);
        System.out.println("uploaded "+newSymptom.toString());
        
        // Adding NewPatient into CSV File
        FileWriter filewriter=null;
        try{
            filewriter= new FileWriter(filepath,true);
            filewriter.append(newSymptom.getpatientid());
            filewriter.append(",");
            filewriter.append(newSymptom.getpatientname());
            filewriter.append(",");
            filewriter.append(newSymptom.getdatetime());
            filewriter.append(",");
            filewriter.append(newSymptom.getsymptoms());
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
        
        SymptomManager mgr= new SymptomManager();
        mgr.uploadsymptoms(new Symptom("107","Rajat Malhotra","24-02-2021","Fever,Headache,coughing"));
        mgr.uploadsymptoms(new Symptom("108","Raja Roy","24-02-2021","loose motions,weakness"));
        System.out.println(mgr.getinfo());
        //mgr.init("C:\\Users\\DELL\\OneDrive\\Desktop\\CSV files\\Patientlist.csv");
        //assert(mgr.getlistofpatients().size()==2);
        //assert(mgr.getlistofpatients().get(1).getpatientid().equals("108"));
        
        
        
        }
    
}