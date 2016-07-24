/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOs.Impl.ArtikelDAOImpl;
import DAOs.Impl.BestellingArtikelDAOImpl;
import DAOs.Impl.BestellingDAOImpl;
import DAOs.Interface.BestellingArtikelDAOInterface;
import DAOs.Interface.BestellingDAOInterface;
import POJO.Artikel;
import POJO.Bestelling;
import POJO.BestellingArtikel;
import View.BestellingView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Excen
 */

// Todo
// Artikel toevoegen aan bestelling
// Artikel verwijderen uit bestelling



public class BestellingController {
    
    BestellingView bestellingView = new BestellingView();
    BestellingDAOInterface bestellingDAO = new BestellingDAOImpl();
    BestellingArtikelDAOInterface bestellingArtikelDAO = new BestellingArtikelDAOImpl();
    ArtikelDAOImpl artikelDAO = new ArtikelDAOImpl();
    
    Scanner scanner = new Scanner(System.in);
    int userInput;
    
    public void bestellingMenu() throws SQLException, ClassNotFoundException{
        
        int userInput = bestellingView.startBestellingMenu();
        
        // In deze switch moeten dus weer nieuwe methodes worden geschreven, deze methodes hebben return types die vervolgens aangeven
        // wat de DAO's moeten doen. De methodes zijn methodes in de view, sout mag alleen maar daar komen te staan.
        
        // Todo
        // Check inbouwen of KlantId al bestaat.
        // Testen of methoden werken
        //
        //
        
        switch (userInput) {
            // bestelling plaatsen
            case 1:
                {
                    
                    plaatsBestelling();
                    // terugNaarHoofdMenu();
                    break;
                }
            // bestellinginfo ophalen
            case 2:
                {
                          
                    haalBestellingInfoOp();
                    // terugNaarHoofdMenu();
                    break;
                }
            // Bestelling wijzigen
            case 3:
                {
  
                    wijzigBestelling();
                    // terugNaarHoofdMenu();
                    break;
                }
                
            // Bestelling verwijderen
            case 4:
                {
            
                    verwijderBestelling();
                    // terugNaarHoofdMenu();
                    break;
                }
            
            // Terug naar bestellingmenu
            case 5:
            {
                      
                    terugNaarHoofdMenu();
                    break;
            }
            
            // Terug naar hoofd menu
            default:
                    System.out.println("Die optie is niet beschikbaar, we keren terug naar het bestelling menu.");
                    terugNaarHoofdMenu();
                    break;
        }
        
        
        
    }
    
    public void terugNaarHoofdMenu() throws SQLException, ClassNotFoundException {
        HoofdMenuController hoofdMenu = new HoofdMenuController();
        hoofdMenu.start();
    }
    
    public void plaatsBestelling() throws SQLException {
                    
                    // TODO
                    // Als er een bestelling word aangemaakt moet hij OOK in de koppelbestellingartikeltabel
                    // worden gezet.
                    
                    int klantID = bestellingView.voerKlantIdIn();
                    int bestellingID = bestellingDAO.insertBestelling(klantID);
                    int anotherOne = 0;
                    boolean checker = true;

                    // voeg artikelen toe aan bestelling
                    ArrayList<BestellingArtikel>AL = new ArrayList<>();
                    BestellingArtikel BS = new BestellingArtikel();
                    
                    // Overzicht beschikbare artikelen
                    System.out.println("Beschikbare artikelen: ");
                    ArrayList<Artikel>artikelLijst = new ArrayList<>();
                    artikelLijst = artikelDAO.findAll();
                    
                    for (Artikel ar: artikelLijst){
                        System.out.println(ar.getArtikelID() + " " + ar.getArtikelNaam());
                    }
                    
                    // begin artikel toevoeg loop
                    do {
                    BS = createBestellingArtikel();
                    BS.setBestelling_id(bestellingID);
                    bestellingArtikelDAO.createBestellingArtikel(BS);
                    AL.add(BS);
                        
                    System.out.println("Wil je nog een artikel toevoegen?\n1 ja\n2 nee");
                        
                        try{
                        anotherOne = scanner.nextInt();    
                        } catch (InputMismatchException ex){
                            System.out.println("Voer een integer in.");
                        }
                        
                        if (anotherOne == 1) {
                            checker = true;
                        }
                        
                        else {
                            checker = false;
                        }
                    } while (checker);
                    
                    System.out.println("De artikelen van Klant " + klantID + " zijn toegevoegd aan bestelling ID: " + bestellingID);
                    System.out.println("De toegevoegde artikelen zijn: ");
                    for (BestellingArtikel bar: AL){
                        System.out.println(artikelDAO.findByArtikelID(bar.getArtikel_id()).getArtikelNaam() + " " + bar.getArtikel_aantal() + " keer");
                    }

    }
    
    public void haalBestellingInfoOp() throws SQLException {
        
        int bestellingID = bestellingView.zoekBestellingInfo();
                    Bestelling bestelling = bestellingDAO.findById(bestellingID);
                    System.out.println("Bestelling ID: " + bestelling.getBestelling_id());
                    System.out.println("Klant ID: " + bestelling.getKlant_id());
                    System.out.println("Bestelling Datum: " + bestelling.getDatum());
                    
                    ArrayList<Artikel>artikellijst = new ArrayList<>();
                    artikellijst = bestellingArtikelDAO.findByBestellingId(bestellingID);
                    System.out.println("Artikellen in bestelling: ");
                    for (Artikel ar: artikellijst){
                        System.out.println(ar.getArtikelNaam() + ": " + bestellingArtikelDAO.findAantalByArtikelID(bestellingID, ar.getArtikelID()) + " keer");
                        
                    }     
 
    }
    
    public void wijzigBestelling() throws SQLException {
        
        ArrayList<Artikel>artikelLijst = new ArrayList<>();
        
        int bestellingId = bestellingView.zoekBestellingInfo();
        
        artikelLijst = bestellingArtikelDAO.findByBestellingId(bestellingId);
        
        
        
        int welkArtikel = bestellingView.wijzigBestellingInfo(artikelLijst, bestellingId);
        int watTeDoenMetArtikel = bestellingView.wijzigBestellingKeuze();
        
        if (watTeDoenMetArtikel == 1){
            // verwijder artikel uit bestellingArtikel. Gebruik dit alleen als er meerdere artikelen
            // in de bestelling staan. Gebruik anders verwijderBestelling.
            bestellingArtikelDAO.deleteArtikel(bestellingId, welkArtikel);
            System.out.println("Het artikel: " + artikelDAO.findByArtikelID(welkArtikel) + " is verwijderd uit Bestelling " + bestellingId);
        }
        else if (watTeDoenMetArtikel == 2){
            // pas aantal van artikel aan.
            int nieuwAantal = bestellingView.wijzigAantal();
            bestellingArtikelDAO.updateBestellingArtikelAantal(bestellingId, welkArtikel, nieuwAantal);
            System.out.println("Bestelling: " + bestellingId + " heeft een update gehad.");
            System.out.println("Het artikel " + artikelDAO.findByArtikelID(welkArtikel).getArtikelNaam() + " staat nu " + nieuwAantal + " keer in de bestelling.");
        }

    }
    
    
    public void verwijderBestelling() throws SQLException {
        
    int bestellingID = bestellingView.zoekBestellingInfo();
                bestellingDAO.deleteBestelling(bestellingID);
                
                // Als je een bestelling verwijderd zul je die altijd ook willen verwijderen uit de koppeltabel
                // het zou dus elegant zijn als de hierboven aangeroepen deleteBestelling zelf ook 
                // deleteBestellingArtikel zou aanroepen.
                
                bestellingArtikelDAO.deleteBestellingArtikel(bestellingID);
                System.out.println(bestellingID + " is verwijderd.");    
  
    }
    
    
    public BestellingArtikel createBestellingArtikel(){
        
        int artikelId = bestellingView.voerArtikelIdIn();
        int artikelAantal = bestellingView.voerAantalIn();
                
        BestellingArtikel BS = new BestellingArtikel();
        BS.setArtikel_id(artikelId);
        BS.setArtikel_aantal(artikelAantal);        
        
        return BS;
        
    }
    
    
    
    
    
    
    
}

/*

// klantId is bekend:
        switch (input) {
            case 1:
                klantId = klantView.voerKlantIdIn();
                klant = klantDAO.findByKlantId(klantId);
                klantView.printKlantGegevens(klant);
                break;
            case 2:
                int keuze = klantView.hoeWiltUZoeken();
                switch (keuze) {
                    case 1: // zoeken op voor-/achternaam
                        String achterNaam = klantView.voerAchterNaamIn();
                        String voorNaam = klantView.voerVoorNaamIn();
                        klant = klantDAO.findByVoorNaamAchterNaam(achterNaam, voorNaam);
                        klantView.printKlantGegevens(klant);
                        break;
                    case 2: //zoeken op email
                        String email = klantView.voerEmailIn();
                        klant = klantDAO.findByEmail(email);
                        klantView.printKlantGegevens(klant);
                        break;
                    case 3: // direct door naar einde switch: methode naar inlogschermklant()
                        break;
                    default:
                        break;
                }   
            default:
                break;
        }

*/