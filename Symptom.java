/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author Abhinav
 */
public class Symptom {
    public String filepath="C:\\Users\\DELL\\OneDrive\\Desktop\\CSV files";
    
    private String patientid;
    private String patientname;
    private String datetime;
    private String symptoms;
    
    public:
      String getpatientid(){
        return patientid;
    }
     String getpatientname(){
        return patientname;
    }
     String getdatetime(){
        return datetime;
    }
     String getsymptoms(){
        return symptoms;
    }
 Symptom(String patientid,String patientname,String datetime,String symptoms){
        this.patientid=patientid;
        this.patientname=patientname;
        this.datetime=datetime;
        this.symptoms=symptoms;
        
    }
    
     String toString(){
        return "Patient Id:"+getpatientid()+"Patient Name:"+getpatientname()+
                "Date Time:"+getdatetime()+"Description:"+getsymptoms();
        
    }
    Symptom(){
}
}
    
    

