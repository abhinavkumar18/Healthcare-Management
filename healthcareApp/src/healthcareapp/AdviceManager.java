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
 * @author Akash
 */
public class AdviceManager {
    public String filepath="/home/kmrakash/Healthcare-Management/healthcareApp/src/healthcareapp/Advice.csv";

    private List<Advice> descriptionList;
    private List<Advice> result;
    private Scanner x;
    
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
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          
        }
        finally{
            try{
                reader.close();
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
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
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            
        }
        finally{
            try{
                filewriter.flush();
                filewriter.close();
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            }
        }
        
        
        result=true;
        return result;
    }
    
    // get Advice of Particular By Name & ID
    
    public Advice getAdvice(String name,String id){
        boolean found=false;
        String ID=""; 
        String Name="";
        String date="";
        String desc="";
        int index = 0;
        String line = null;
        BufferedReader reader=null;
         
        
        try {
            reader = new BufferedReader(new FileReader(filepath));
            reader.readLine();
            while ((line = reader.readLine()) != null)  {
               x=new Scanner(line);
               x.useDelimiter(","); 
            
           
           
           while(x.hasNext() && !found){
               String Data = x.next();
               if(index == 0) ID = Data;
               else if(index == 1) Name = Data;
               else if(index == 2) date = Data;
               else if(index == 3) desc = Data;
               index++;
               // System.out.println( "Debugging:->" + " ID= "+ID+", Name= "+Name+", Date= "+date+", Advice= "+desc);
               if(ID.equals(id) && Name.equals(name)){
                  found=true; 
                  
                  break;
               }
           } 
           index = 0;
           if(found){
               date = x.next();
               desc = x.next();
              // System.out.println("Found:-> " + " ID= "+ID+", Name= "+Name+", Date= "+date+", Advice= "+desc);
               Advice ad = new Advice(ID, Name, date, desc);
               return ad;
           }
           
            }
          
               //System.out.println("No records found");
               JOptionPane.showMessageDialog(null, "No records found", "ERROR", JOptionPane.ERROR_MESSAGE);
            
               return null;
           
        }
        catch(Exception e){
            //System.out.println(e);
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return null;
    }
    
    public boolean dohousekeeping(){
        return true;
    }
    
    
    public static void main(String[] args) {
        
        AdviceManager mgr= new AdviceManager();
        mgr.giveadvice(new Advice("107","Rajat Malhotra","24-02-2021","Paracetamol , Take Rest"));
        mgr.giveadvice(new Advice("108","Raja Roy","24-02-2021","PAN-40,Drink boiled Water"));
        System.out.println(mgr.viewadvice());
        
        // Initialise
        mgr.init("Patientlist.csv");
        
        //Unit Test
//        assert(mgr.getlistofpatients().size()==2);
//        assert(mgr.getlistofpatients().get(1).getpatientid().equals("108"));
        
        mgr.getAdvice("Alex Panda", "103");
        
        
        // JFrame UI
        JFrame ViewAdvicesUI = new ViewAdviceUI();
        JFrame GiveAdvicesUI = new GiveAdviceUI();
        
        ViewAdvicesUI.setVisible(true);
        GiveAdvicesUI.setVisible(true);
        
        }
    
}
   
