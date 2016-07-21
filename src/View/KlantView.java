
package View;

import static DAOs.Impl.KlantDAOImpl.isValidEmailAddress;
import POJO.Klant;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Anne
 */
public class KlantView {
    Scanner scanner = new Scanner(System.in);    
    int userInput;
         
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
    
    // loop werkt niet
    public int isKlantIdBekend(){
        
        int input = 0;        
        boolean doorgaan = false; // false by default
        
        do{
            System.out.println("Is het klantId bekend?");
            System.out.println("1 ja");    
            System.out.println("2 nee");
            input = scanner.nextInt();
            doorgaan = input == 1 || input == 2; 
            
            if(!doorgaan){             
                System.out.println("Foutieve input, voer 1 of 2 in.");
            } 
            
        } while(!doorgaan);
       
        return input;         
    }
    
   
       
    
    public int voerKlantIdIn(){
        
        System.out.println("Voer klantId in: ");
        int klantId = scanner.nextInt();
        
        return klantId;
    }
    
    
    public void toonKlantGegevens(Klant klant){
        
        System.out.println("De gegevens van de klant: ");
        System.out.println(klant.getVoorNaam() + " " + klant.getTussenVoegsel() + " "
                + klant.getAchterNaam());
        System.out.println(klant.getEmail());
        
    }
    
    public int hoeWiltUZoeken(){
        
        System.out.println("Hoe wilt u zoeken?");
        System.out.println("Maak een keuze:");
        System.out.println("1 Zoek met voor- en achternaam");
        System.out.println("2 Zoek met email");
        System.out.println("3 Terug naar hoofdmenu");
        System.out.println("Keuze: ");
        
        try{
        userInput = scanner.nextInt(); 
        //checker = false;
        
        } catch (InputMismatchException ex){
            System.out.print("Foutieve input, kies uit de opties 1,2,3.");
            //scanner.nextLine();
        }
         
       // } while (checker);
        
        return userInput;
        
    }
   
    
}
