/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.util.*;
/**
 *
 * @author Akash
 */
public class PatientManager{
    private static ArrayList<Patient> arr;
    
    public static void getlistofpatients(Patient P){
        arr=P.getInfo();
        for(Patient p: arr){
            System.out.printf("Patient ID=%d,Name=%s,Address=%s,Email=%s,Password=%s\n",p.id,p.name,p.address,p.email,p.password);
            System.out.println();
        }
        
    }
}
    
    /*public static void main(String[] args) {
        
                Patient p=new Patient();
                p.id=10;
                p.name="Test";
                p.address="Ram";
                p.email="memory@gmail.com";
                p.password="aex123";
                p.saveInfo();
                getlistofpatients(p);
        }
        
}

