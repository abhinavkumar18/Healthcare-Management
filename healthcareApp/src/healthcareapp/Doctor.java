/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcareapp;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Akash
 */
public class Doctor {
    public String ID;
    public String Name;
    public String Gender;
    public String Dob;
    public String Hospital;
    public String Qualification;
    public String Specialization;
    public String Address;
    public String Phnno;
    public String Email;
    public String Password;
    public String filepath="/home/kmrakash/Healthcare-Management/healthcareApp/src/healthcareapp/RegisteredDoctors.csv";
    
    
    public String getdoctorid() {
        return ID;
    }
    
    public String getdoctorname() {
        return Name;
    }
    
    public String getdoctorgender() {
        return Gender;
    }
    
    public String getdoctordob() {
        return Dob;
    }
    
    public String getdoctorhospital() {
        return Hospital;
    }
    
    public String getdoctorqualification() {
        return Qualification;
    }
    
    public String getdoctorspecialisation() {
        return Specialization;
    }
    
    public String getdoctoraddress() {
        return Address;
    }
    
    public String getdoctorphonno() {
        return Phnno;
    }
    
    public String getdoctoremail() {
        return Email;
    }
    
    public String getdoctorpass() {
        return Password;
    }
    
   Doctor() {};
   
   public Doctor(String id,String name,String gender,String dob,String hospital,String qual,String spec,String add,String phn,String email,String pass){
        this.ID = id;
        this.Name = name;
        this.Gender = gender;
        this.Dob = dob;
        this.Hospital = hospital;
        this.Qualification = qual;
        this.Specialization = spec;
        this.Address = add;
        this.Phnno = phn;
        this.Email = email;
        this.Password = pass;
    }
    
    
    public String toString() {
        return "Doctor ID: " + getdoctorid() 
                + "\n Doctor Name: " + getdoctorname()
                + "\n Gender: " + getdoctorgender()
                + "\n D.O.B: " + getdoctordob()
                +"\n Hospital: " + getdoctorhospital()
                +"\n Qualification: " + getdoctorqualification()
                +"\n Specialisation: " + getdoctorspecialisation()
                + "\n Address: " + getdoctoraddress()
                + "\nPhone Number;  " + getdoctorphonno()
                + "\nEmail: " + getdoctoremail()
                +"\nPassword: " + getdoctorpass();
                
    }
    
}
