/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.HoofdMenuView;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Excen
 */
public class HoofdMenuController implements ControllerInterface {
    Scanner scanner = new Scanner(System.in);
    int userInput;
    
    // beginpunt
    public void start(){
        HoofdMenuView startView = new HoofdMenuView();
        int userInput = startView.startVraag();
        if (userInput == 1){
            System.out.println("Optie 1, u bent gebruiker");
            userInput = startView.bestaandeKlant();
            
            if (userInput == 1){
                System.out.println("Optie 1, u bent een nieuwe klant");
                // create klant - 
            }
            else if (userInput == 2){
                System.out.println("Optie 2, u bent een bestaande klant");
                // ga naar opties voor bestaande klant --
            }
            else if (userInput == 3){
                System.out.println("Optie 3, terug naar hoofdmenu");
                userInput = startView.startVraag();
                // 
            }
            else {
            
            }
             
            
        }
        else if (userInput == 2){
            System.out.println("Optie 2");
            
            userInput = startView.eigenaar();
            
            if (userInput == 1){
                System.out.println("Werken in klantenbestand");
                startView.optiesEigenaarKlantBestand();
                // 
            }
            else if (userInput == 2){
                
                startView.optiesEigenaarArtikelBestand();
                // artikell
            }
            else if (userInput == 3){
                
                startView.optiesEigenaarBestellingBestand();
                // bestelling
            }
            else if (userInput == 4){
                
                startView.optiesEigenaarAdresBestand();
                //adres
            }
            else if (userInput == 5){
                //hoofdmenu
            }
            
            
        }
        else if (userInput == 3){
            System.out.println("Optie 3, terug naar hoofdmenu");
            userInput = startView.startVraag();
        }
        
        else {
            System.out.println("Foutieve optie. Probeer opnieuw: ");
            userInput = startView.startVraag();
        }
    }
    
    
    
    
    @Override
    public boolean doesKlantExist(int klant_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
