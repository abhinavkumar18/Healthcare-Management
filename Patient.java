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
public class Patient {
    public String filepath="C:\\Users\\DELL\\OneDrive\\Desktop\\CSV files\\Patientlist.csv";
    
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
        
    public Patient(String id,String name,String address,String email,String password){
        this.id=id;
        this.name=name;
        this.address=address;
        this.email=email;
        this.password=password;
    }
    
    public String toString(){
        return "Patient Id:"+getpatientid()+"Patient Name:"+getpatientname()+
                "Patient Address:"+getpatientaddress()+"Patient Email:"+getpatientemail()+
                "Patient Password:"+getpatientpassword();
        
    }
}

