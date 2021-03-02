/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcareapp;
import java.io.*;
import java.util.*;
/**
 *
 * @author Akash
 */
public class Advice {
    public String filepath="/home/kmrakash/college/Software engineering/healthcareApp/src/healthcareapp/Advice.csv";
    
     public String patientid;
    public String patientname;
    public String datetime;
    public String description;
    
    
     public String getpatientid(){
        return patientid;
    }
    public String getpatientname(){
        return patientname;
    }
    public String getdatetime(){
        return datetime;
    }
    public String getdescription(){
        return description;
    }
public Advice(String patientid,String patientname,String datetime,String description){
        this.patientid=patientid;
        this.patientname=patientname;
        this.datetime=datetime;
        this.description=description;
        
    }
    
    public String toString(){
        return "Patient Id: "+getpatientid()+", Patient Name: "+getpatientname()+
                ", Date Time: "+getdatetime()+", Description: "+getdescription();
        
    }
    Advice(){
        
    }
}
