/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import POJO.Artikel;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Wendy
 */
public class ArtikelView {
    int userInput;
    Scanner scanner = new Scanner(System.in);
    
    public int printStartMenu() {
        System.out.println("Werken in het artikelbestand. Wat wilt u doen?");
        System.out.println("1. Nieuw artikel toevoegen in het artikelenbestand.");
        System.out.println("2. Een artikel opzoeken.");
        System.out.println("3. Een artikel wijzigen.");
        System.out.println("4. Een artikel verwijderen uit het artikelenbestand.");
        System.out.println("5. Terug naar het hoofdmenu.");
        
        try{
            userInput = scanner.nextInt();  
        }
        catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
        
    }
    
    public String haalArtikelNaamOp() {
        System.out.print("Artikelnaam: ");
        String artikelNaam = scanner.next().trim();
        scanner.nextLine();
        return artikelNaam;   
    }
    
    public double haalArtikelPrijsOp() {
        System.out.print("ArtikelPrijs: ");
        double artikelPrijs = scanner.nextDouble();
        return artikelPrijs;
    }
    public void printArtikelOverzicht(Artikel artikel) {
        System.out.println("U heeft de volgende gegevens ingevoerd:");
        System.out.println("artikel id: " + artikel.getArtikelID());
        System.out.println("artikel naam: " + artikel.getArtikelNaam());
        System.out.println("artikel prijs: " + artikel.getArtikelPrijs() + "\n");
        
        
        /** System.out.println("Kloppen deze gegevens?");
            System.out.println("1. Ja, bevestigen.");
            System.out.println("2. Nee, gegevens wijzigen.");
        
            try{
            userInput = scanner.nextInt();  
            }
            catch(InputMismatchException ex){
                System.out.print("Foute input, kies van de opties hierboven.");
            }
        
            return userInput;
            */
    }
    
    public int isArtikelIdBekend() {
        System.out.println("Is het ariktel id bekend?");
        System.out.println("1. Ja.");
        System.out.println("2. Nee.");
        
        try{
            userInput = scanner.nextInt();  
        }
        catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;  
    }
    
    public int voerArtikelIdIn() {
        System.out.println("Voer het artikel id in.");
        userInput = scanner.nextInt();
        return userInput;
    }
    
    
    public int printVerwijderMenu() {
        System.out.println("Wat wilt u verwijderen uit het artikelenbestand?");
        System.out.println("1. één artikel.");
        System.out.println("2. alle artikelen.");
        System.out.println("3. terug naar het artikel menu.");
        
        try{
            userInput = scanner.nextInt();  
        }
        catch(InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
        }
        
        return userInput;
    }
    
    public int printDeleteArtikelView() {
        System.out.println("Voer het artikel id in van het artikel dat u wilt verwijderen.");
        
        try{
            userInput = scanner.nextInt();  
        }
        catch(InputMismatchException ex){
            System.out.print("Foute input, voer het artikel id in.");
        }
        
        return userInput;
    }
    public void printDeleteResultaat(boolean deleted, int artikelId) {
        if (deleted) 
            System.out.println("Het artikel met artikel id " + artikelId + " is verwijderd.");
        else
            System.out.println("Verwijderen mislukt.");
    }
    
}
 
