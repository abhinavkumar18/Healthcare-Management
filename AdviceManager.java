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
public class AdviceManager {
    private static ArrayList<Advice> adarr;
    
    public static void giveadvice(Advice a){
        a.sendAdvice();
    }
    
}
    /*public static void main(String[] args){
        Advice a=new Advice();
        a.description="Paracetamol";
        a.datetime="8/2/2020";
        giveadvice(a);
        a.getAdvice();
        
    }
    
}
