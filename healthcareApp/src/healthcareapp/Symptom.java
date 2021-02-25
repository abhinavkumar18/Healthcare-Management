/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcareapp;
import java.util.*;
import java.time.*;
import java.io.*;
/**
 *
 * @author kmrakash
 */
public class Symptom {
    public String filepath="/home/kmrakash/college/Software engineering/healthcareApp/src/healthcareapp/Symptoms.csv";
    
    public String patientid;
    public String patientname;
    public String datetime;
    public String symptoms;
    
    
     public String getpatientid(){
        return patientid;
    }
    public String getpatientname(){
        return patientname;
    }
    public String getdatetime(){
        return datetime;
    }
    public String getsymptoms(){
        return symptoms;
    }
public Symptom(String patientid,String patientname,String datetime,String symptoms){
        this.patientid=patientid;
        this.patientname=patientname;
        this.datetime=datetime;
        this.symptoms=symptoms;
        
    }
    
    public String toString(){
        return "Patient Id:"+getpatientid()+"Patient Name:"+getpatientname()+
                "Date Time:"+getdatetime()+"Description:"+getsymptoms();
        
    }
    
    Symptom(){
        
    }
}
