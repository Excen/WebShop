
package View;

import static DAOs.Impl.KlantDAOImpl.isValidEmailAddress;
import POJO.Klant;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Anne
 */
public class KlantView {
    Scanner scanner = new Scanner(System.in);    
    int userInput;
         
    
    public int startMenuKlant(){
        System.out.println();
        System.out.println("Werken in klantenbestand");
        System.out.println("Keuzes in het klantenbestand. Wat wilt u doen?");
        System.out.println("1. Nieuw klant toevoegen in het klantenbestand.");
        System.out.println("2. Klantgegevens opzoeken.");
        System.out.println("3. Klantgegevens wijzigen.");
        System.out.println("4. Klantgegevens verwijderen uit het klantenbestand.");
        System.out.println("5. Terug naar het hoofdmenu.");
        System.out.println("6. Afsluiten.");
        System.out.println();
        
        try{
            userInput = Integer.parseInt(scanner.nextLine());            
            
        }
        catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;        
    }
    
    public String voerAchterNaamIn(){
               
        System.out.print("Achternaam: ");
        String achternaam = scanner.nextLine().trim();
        
        return achternaam; 
    }
    
    
    public String voerVoorNaamIn(){
               
        System.out.print("Voornaam: ");
        String voornaam = scanner.nextLine().trim();
        
        return voornaam; 
    }
    
    
    public String voerTussenVoegselIn(){
        
        System.out.print("tussenvoegsel: ");
        String tussenvoegsel = scanner.nextLine().trim();
        
        return tussenvoegsel; 
    }
    
    
    public String voerEmailIn(){
        System.out.println("email: ");
        String email = scanner.nextLine();
        
        //isValidEmailAddress(email);
        // doe iets als result = false 
        
        return email.trim();
    }
    
    public int voerKlantIdIn(){
        
        System.out.println("Voer klantId in: ");
        int klantId = Integer.parseInt(scanner.nextLine()); 
        
        return klantId;
    }

    
    // loop werkt niet
    public int isKlantIdBekend(){        
              
        boolean doorgaan = false; // false by default        
        
        do{
            try{
                System.out.println("Is het klantId bekend?");
                System.out.println("1. ja");    
                System.out.println("2. nee");
                System.out.println("3. Terug naar hoofdmenu klant");
                userInput = Integer.parseInt(scanner.nextLine());            

                
                if (userInput == 1 || userInput == 2 || userInput == 3){
                    doorgaan = true;
                } 

                if(doorgaan == false){             
                    System.out.println("Foutieve input, voer 1, 2, 3 in.");
                } 
                // foutafhandeling werkt niet
            }catch(InputMismatchException ex){
                System.out.println("Error. Voer het  cijfer 1, 2, 3 in. ");
                scanner.nextLine();
            }
            
        } while(doorgaan == false);
       
        return userInput;         
    }
    
    
    public void printKlantGegevens(Klant klant){
        
        System.out.println("De huidige gegevens van de klant met klantId: " + klant.getKlantId());
        System.out.println(klant.getVoorNaam() + " " + klant.getTussenVoegsel() + " "
                + klant.getAchterNaam());
        System.out.println(klant.getEmail());
        
    }
    
    
    public int hoeWiltUZoeken(){
        
        System.out.println("Hoe wilt u zoeken?");
        System.out.println("1. Zoek met voor- en achternaam");
        System.out.println("2. Zoek met email");  
        System.out.println("3. Terug naar klanthoofdmenu");
        System.out.println("Maak een keuze:");
        
        try{
            userInput = Integer.parseInt(scanner.nextLine());    
        //scanner.nextLine();

        //checker = false;
        
        } catch (InputMismatchException ex){
            System.out.print("Foutieve input, kies uit de opties 1,2,3.");
            //scanner.nextLine();
        }
         
       // } while (checker);
        
        return userInput;
        
    }
    
    public int checkInputString(String string){
                
        System.out.println(string + ". Is dit juist? : " );
        System.out.println("1. ja");
        System.out.println("2. nee");
        
        // make do while loop
        try{
            userInput = Integer.parseInt(scanner.nextLine());            


            if (userInput == 1 || userInput == 2){
                //scanner.nextLine();
            }
            else {
                System.out.println("Foutieve input, voer 1 of 2 in.");
            } 
        }
        catch(InputMismatchException ex){
                //code
        }
        
        return userInput; 
        
    }
    
    public int vraagDoorgaan(){
        
        System.out.println("Hoe wilt u verder?");
        System.out.println("1. Werken in klantbestand");
        System.out.println("2. Werken in artikelbestand");
        System.out.println("3. Werken in bestellingbestand");
        System.out.println("4. Werken in adresbestand");
        System.out.println("5. Terug naar hoofdmenu");
        System.out.println("6. Programma afsluiten");
        
        
        try{
            userInput = Integer.parseInt(scanner.nextLine());            

            if (userInput <= 1 && userInput >= 6){
                System.out.println("Foutieve input, voer 1 of 2 in.");
                // code om opnieuw keuze in te voeren    
                // scanner.nextLine();
            }                        
            
        }catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
    }
    
    public int menuKlantVerwijderen() {
        System.out.println("Wat wilt u verwijderen uit het klantenbestand?");
        System.out.println("1. één klant.");
        System.out.println("2. alle klanten.");
        System.out.println("3. terug naar het klanten menu.");
        
        try{
            userInput = Integer.parseInt(scanner.nextLine());            

        }
        catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
    }
    
    public int menuKlantZoeken(){
        
        System.out.println("Wat wilt u zoeken in het klantenbestand?");
        System.out.println("1. naar één klant.");
        System.out.println("2. naar alle klanten.");
        System.out.println("3. terug naar het menu Klant.");
        
        try{
            userInput = Integer.parseInt(scanner.nextLine());            

        }
        catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
    }
        
    
   
    public int bevestigingsVraag(){
        
        System.out.println("Weet u zeker dat u alle klantgegevens definitief verwijderen wil?");
        System.out.println("1. ja");
        System.out.println("2. nee");
        
        try{
            userInput = Integer.parseInt(scanner.nextLine());        
        }
        catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
        
    }
    
    public void printKlantenLijst(ArrayList<Klant> lijst){
        System.out.println();
        System.out.println("KlantId\t\tVoornaam\t\tTussenvoegsel\t\tAchternaam\t\tEmail");
            for (int i = 0; i< lijst.size(); i++){

            System.out.println ((lijst.get(i)).getKlantId() + "\t" +
            (lijst.get(i)).getVoorNaam() + "\t" +(lijst.get(i)).getTussenVoegsel() +
            "\t" + (lijst.get(i)).getAchterNaam() + "\t" + (lijst.get(i)).getEmail());
        }        
    }
    
    
    public void printString(String string ){
        
        System.out.println(string);
    }
    
    public void printInt(int getal){
    
       System.out.println(getal);
    }
    
    
    
}
