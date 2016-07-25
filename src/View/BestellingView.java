/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAOs.Impl.BestellingArtikelDAOImpl;
import POJO.Artikel;
import POJO.Bestelling;
import POJO.BestellingArtikel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Excen
 */
public class BestellingView {

BestellingArtikelDAOImpl bestellingArtikelDAO = new BestellingArtikelDAOImpl();    
    
    
    // data fields
    Scanner scanner = new Scanner(System.in);
    int userInput;
    int artikelId;
    int artikelAantal;
    
    public int startBestellingMenu(){
        try{
        System.out.println("Maak een keuze:");
        System.out.println("1 bestelling plaatsen");
        System.out.println("2 bestellingsinformatie ophalen");
        System.out.println("3 bestelling wijzigen");
        System.out.println("4 bestelling verwijderen");
        System.out.println("5 toon alle bestellingen");
        System.out.println("6 verwijder alle bestellingen");
        System.out.println("7 terug naar hoofdmenu");
        
        userInput = scanner.nextInt();
        scanner.nextLine();
        } catch (InputMismatchException ex){
            System.out.print("Foute input, kies één van de opties hierboven.");
        }    

        return userInput;
    }
    
    public int voerKlantIdIn (){
        System.out.println("U wilt een nieuwe bestelling aanmaken.");
        System.out.println("Wat is uw klant ID?");
        int klantID = scanner.nextInt();
        System.out.println(" ");
        return klantID;
    }

    public int zoekBestellingInfo(){
        System.out.println("Wat is het bestelling ID?");
        int userInputZoek = 0;
        
        try{
            
            userInputZoek = scanner.nextInt();
         
        } catch (InputMismatchException ex){
            System.out.println("Vul een integer in.");
        }
        
        System.out.println(" ");
        
        return userInputZoek;
    }
    
    public int voerArtikelIdIn(){
        System.out.println("Voer een artikel ID in:");
        artikelId = scanner.nextInt(); 
        
        return artikelId;
    }
    
    public int voerAantalIn(){
        System.out.println("Hoe vaak wil je dit artikel toevoegen?");
        artikelAantal = scanner.nextInt();
        
        return artikelAantal;
    }
    
    public int wijzigBestellingInfo(ArrayList<Artikel>x, int bestellingId) throws SQLException {
        
        int userInput2 = 0;
        
        
        System.out.println("Artikellen aanwezig in Bestelling " + bestellingId);
        for (Artikel ar: x){
        System.out.println(ar.getArtikelID() + " " + ar.getArtikelNaam() + ": " + bestellingArtikelDAO.findAantalByArtikelID(bestellingId, ar.getArtikelID()) + " keer");
    } 
        
        System.out.println("Welk Artikel ID wil je wijzigen?");
        try{
        userInput2 = scanner.nextInt();    
        } catch (InputMismatchException ex){
            System.out.println("Voer een integer in.");
        }

        return userInput2;

    }
    
    public int wijzigBestellingKeuze (){
        
        System.out.println("Wat wil je doen met dit artikel?\n1 verwijderen\n2 aantal wijzigen");
        int aanpasKeuze = 0;
        
        try{
        aanpasKeuze = scanner.nextInt();   
        } catch (InputMismatchException ex){
            System.out.println("Vul een integer in.");
        }

        return aanpasKeuze;
        
    }
    
    public int wijzigAantal() {
        System.out.println("Wat moet het nieuwe aantal worden?");
        int nieuwAantal = 0;
        
        try{
        nieuwAantal = scanner.nextInt();   
        } catch (InputMismatchException ex){
            System.out.println("Vul een integer in.");
        }

        return nieuwAantal;
        
    }
    
    public void printBestellingLijst(ArrayList<Bestelling>lijst){
        
        // TODO
        // ook koppelbestellingartikel aanspreken om aantallen bij te kunnen voegen
        
        System.out.println("Aanwezige bestellingen");
        for (Bestelling best: lijst){
            System.out.println("Bestelling ID: " + best.getBestelling_id() + " - Klant ID: " + best.getKlant_id());
        }
        
        
        
        
    }
    
}
