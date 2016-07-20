/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static DAOs.Impl.KlantDAOImpl.isValidEmailAddress;
import java.util.Scanner;

/**
 *
 * @author Anne
 */
public class KlantView {
    Scanner scanner = new Scanner(System.in);
    
    
    public void haalKlantGegevensOp(){
       
        String voornaam = haalVoorNaamOp();
        String tussenvoegsel = haalTussenVoegselOp();      
        String achternaam = haalAchterNaamOp();   
        String email = haalEmailOp(); 
        
    }
    
    public String haalAchterNaamOp(){
               
        System.out.print("Achternaam: ");
        String achternaam = scanner.nextLine().trim();
        
        return achternaam; 
    }
    
    public String haalVoorNaamOp(){
               
        System.out.print("Voornaam: ");
        String voornaam = scanner.nextLine().trim();
        
        return voornaam; 
    }
    
    public String haalTussenVoegselOp(){
        
        System.out.print("tussenvoegsel: ");
        String tussenvoegsel = scanner.nextLine().trim();
        
        return tussenvoegsel; 
    }
    
    public String haalEmailOp(){
        System.out.print("email: ");
        String email = scanner.nextLine().trim();
        
        //isValidEmailAddress(email);
        // doe iets als result = false 
        
        return email;
    }
    
    public int voerKlantIdIn(){
        
        System.out.println("Voer klantId in. Toets 000 als u geen klantId heeft.");
        int klantId = scanner.nextInt();
        
        return klantId;
    }
    
    
}
