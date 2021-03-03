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
public class Patient {
    
    
    public String id;
    public String name;
    public String address;
    public String email;
    public String password;
    public String gender;
    public String dob;
    public String phnno;
    
    public String getpatientid(){
        return id;
    }
    public String getpatientname(){
        return name;
    }
    public String getpatientaddress(){
        return address;
    }
    public String getpatientemail(){
        return email;
    }
    public String getpatientpassword(){
        return password;
    }
    public String getpatientgender(){
        return gender;
    }
    public String getpatientdob(){
        return dob;
    }
    public String getpatientphnno(){
        return phnno;
    }
    
    Patient(){};
        
    public Patient(String id,String name,String address,String email,String password,String gender,String dob,String phnno){
        this.id=id;
        this.name=name;
        this.address=address;
        this.email=email;
        this.password=password;
        this.gender=gender;
        this.dob=dob;
        this.phnno=phnno;
    }
    
    public String toString(){
        return "Patient Id: "+getpatientid()+"\nPatient Name: "+getpatientname()+
                "\nPatient Address: "+getpatientaddress()+"\nPatient Email: "+getpatientemail()+
                "\nPatient Password: "+getpatientpassword();
        
    }
    
    
}

    /**
     * @param args the command line arguments
     */
    

