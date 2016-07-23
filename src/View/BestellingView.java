/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import POJO.Artikel;
import POJO.BestellingArtikel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Anne
 */
public class BestellingView {
        
    // data fields
    Scanner scanner = new Scanner(System.in);
    int userInput;
    
    public int bestellingVraag(){
        try{
        System.out.println("Maak een keuze:");
        System.out.println("1 bestelling plaatsen");
        System.out.println("2 bestellingsinformatie ophalen");
        System.out.println("3 bestelling wijzigen");
        System.out.println("4 bestelling verwijderen");
        
        userInput = scanner.nextInt();
        scanner.nextLine();
        } catch (InputMismatchException ex){
            System.out.print("Foute input, kies één van de opties hierboven.");
        }    

        return userInput;
    }
    
    public int createBestellingView (){
        System.out.println("U wilt een nieuwe bestelling aanmaken.");
        System.out.println("Wat is uw klant ID?");
        int klantID = scanner.nextInt();
        return klantID;
    }
    
    public BestellingArtikel createBestellingAddArtikelView(){
        int artikelID;
        int artikelAantal;
 
            System.out.println("Voer een artikel ID in:");
            artikelID = scanner.nextInt();
            System.out.println("Hoe vaak wil je dit artikel toevoegen?");
            artikelAantal = scanner.nextInt();
            
            BestellingArtikel BS = new BestellingArtikel();
            BS.setArtikel_id(artikelID);
            BS.setArtikel_aantal(artikelAantal);
            
        return BS;
    }
    
    
    
    
    public int zoekBestellingInfo(){
        System.out.println("Wat is het bestelling ID?");
        int userInputZoek = 0;
        
        try{
            
            userInputZoek = scanner.nextInt();
         
        } catch (InputMismatchException ex){
            System.out.println("Vul een integer in.");
        }
        
        return userInputZoek;
    }
    
    
    
}
