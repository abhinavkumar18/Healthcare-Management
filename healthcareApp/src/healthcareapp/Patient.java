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
    
    Patient(){};
        
    public Patient(String id,String name,String address,String email,String password){
        this.id=id;
        this.name=name;
        this.address=address;
        this.email=email;
        this.password=password;
    }
    
    public String toString(){
        return "Patient Id: "+getpatientid()+" Patient Name: "+getpatientname()+
                " Patient Address: "+getpatientaddress()+" Patient Email: "+getpatientemail()+
                " Patient Password: "+getpatientpassword();
        
    }
}

    /**
     * @param args the command line arguments
     */
    

