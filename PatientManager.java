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
    private static  ArrayList<Patient> arr;
    public static void  getlistofpatients(Patient P){
        arr=P.getInfo();
        for(Patient p: arr){
            System.out.printf("Patient ID=%d,Name=%s,Address=%s,Email=%s,Password=%s\n",p.id,p.name,p.address,p.email,p.password);
            System.out.println();
        }
            
    }
    
    public static void main(String[] args) {
        
        int choice=0;
        Scanner sc=new Scanner(System.in);
        while(choice!=3){
            System.out.println("1.Add Patient");
            System.out.println("2.Get list of Patient");
            System.out.println("3.Exit");
            System.out.print("Enter choice-");
            choice=sc.nextInt();
            System.out.println();
            if(choice==1){
                Patient p=new Patient();
                 
                System.out.print("ID-");
                p.id=sc.nextLong();
                sc.nextLine();
                System.out.print("Name-");
                p.name=sc.nextLine();
                System.out.print("Address-");
                p.address=sc.nextLine();
                System.out.print("Email-");
                p.email=sc.nextLine();
                System.out.print("Password-");
                p.password=sc.nextLine();
                p.saveInfo();
                System.out.println();
                
            }
            else if(choice==2){
                Patient p=new Patient();
                getlistofpatients(p);
                
            }
                
            }
        }
        
}

