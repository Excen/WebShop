/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Anne
 */
public class HoofdMenuView {
    int userInput;
    Scanner scanner = new Scanner(System.in);
    boolean checker;
    
    // Eerste instantie van wat de console te zien krijgt. Keuzes in dit menu bepalen welke andere controllers
    // (en dus views) aangesproken gaan worden.
        
            
    public int hoofdMenu(){
        
        System.out.println("Wat wilt u doen? ");
        System.out.println("1. Werken in klantbestand");
        System.out.println("2. Werken in artikelbestand");
        System.out.println("3. Werken in bestellingbestand");
        System.out.println("4. Werken in adresbestand");
        System.out.println("5. Programma afsluiten");
        
        try{
            userInput = Integer.parseInt(scanner.nextLine()); 
            
        }catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
    }
    
    public int bevestigingsVraag(){
        
        boolean doorgaan = true; 
        
        System.out.println("Weet u zeker dat u af wilt sluiten?");
        System.out.println("1. ja");
        System.out.println("2. nee");       
        
        do{              
            try{
                userInput = Integer.parseInt(scanner.nextLine());  
                //userInput = scanner.nextInt();
                if (userInput == 1 || userInput == 2){
                    doorgaan = false;
                }
                else {   
                    System.out.println("Foute input, kies van de opties hierboven.");
                    System.out.println();
                    scanner.nextLine();
                }                
            }
            catch(InputMismatchException ex){
                System.out.println("Foute input, kies van de opties hierboven.");
                System.out.println();
                scanner.nextLine();
            }
        
        } while(doorgaan == true);
        
       return userInput;        
    }
    
}// eind  hoofdmenucontroller klasse   
    
       
    
/*   
    // doen we nu niks mee   
    }// eind public int optiesEigenaarKlantBestand(){
        
        System.out.println("U wilt werken in het klantenbestand:  ");
        System.out.println("1. Nieuwe klant toevoegen");
        System.out.println("2. Gegevens inzien");
        System.out.println("3. Gegevens bijwerken");
        System.out.println("4. Gegevens verwijderen");
        System.out.println("5. Terug naar hoofdmenu");
        
        try{
            userInput = scanner.nextInt();
            
        }catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
    }
    
    // doen we nu niks mee
    public int optiesEigenaarArtikelBestand(){
        System.out.println("U wilt werken in het artikelbestand:  ");
        System.out.println("1. Nieuw artikel toevoegen");
        System.out.println("2. Gegevens inzien");
        System.out.println("3. Gegevens bijwerken");
        System.out.println("4. Gegevens verwijderen");
        System.out.println("5. Terug naar hoofdmenu");
        
        try{
            userInput = scanner.nextInt();
            
        }catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
    }
    
    // doen we nu niks mee
    public int optiesEigenaarBestellingBestand(){
        System.out.println("U wilt werken in het bestellingbestand:  ");
        System.out.println("1. Nieuwe bestelling toevoegen");
        System.out.println("2. Gegevens inzien");
        System.out.println("3. Gegevens bijwerken");
        System.out.println("4. Gegevens verwijderen");
        System.out.println("5. Terug naar hoofdmenu");
        
        try{
            userInput = scanner.nextInt();
            
        }catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
    }
    
    
    // doen we nu niets mee
    public int optiesEigenaarAdresBestand(){
        System.out.println("U wilt werken in het adresbestand:  ");
        System.out.println("1. Nieuw adres toevoegen");
        System.out.println("2. Gegevens inzien");
        System.out.println("3. Gegevens bijwerken");
        System.out.println("4. Gegevens verwijderen");
        System.out.println("5. Terug naar hoofdmenu");
        
        try{
            userInput = scanner.nextInt();
            
        }catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
    }
    
// doen we nu niets mee
    public int startVraag(){ // checker werkt nog niet
        
        
        //checker = true;
        //do {
        System.out.println("Welkom");
        System.out.println("Maak een keuze:");
        System.out.println("1 Webshop gebruiker.");
        System.out.println("2 Webshop eigenaar");
        System.out.println("3 EMERGENCY SHUTDOWN");
        
        try{
        userInput = scanner.nextInt(); 
        //checker = false;
        
        } catch (InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
            //scanner.nextLine();
        }
         
       // } while (checker);
        
        return userInput;
    }
    
    // doen we nu niets mee
    public int bestaandeKlant(){
        
        System.out.println("Bent u een bestaande klant?");
        System.out.println("1. Ja");
        System.out.println("2. Nee");
        System.out.println("3. Terug naar hoofdmenu");
        
        try{
            userInput = scanner.nextInt();
            
        }catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
    }
    
   

*/
