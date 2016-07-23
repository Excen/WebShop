/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
import java.util.Scanner;

/**
 *
 * @author Excen
 */

// Eisen
// create bestelling
/*
create (toevoegen); 
read; (bijv. opties met zoeken, per id, naam, etc)
update; (wat te updaten; code schrijven om alleen één ding te updaten)
delete; (bijv delete all, of één item)
terug naar het hoofdmenu;
*/


public class BestellingController {
    Scanner scanner = new Scanner(System.in);
    int userInput;
    
    public void bestellingStart() throws SQLException{
        BestellingView bestellingView = new BestellingView();
        BestellingDAOInterface BDAO = new BestellingDAOImpl();
        BestellingArtikelDAOInterface BADAO = new BestellingArtikelDAOImpl();
        
        int userInput = bestellingView.bestellingVraag();
        
        // In deze switch moeten dus weer nieuwe methodes worden geschreven, deze methodes hebben return types die vervolgens aangeven
        // wat de DAO's moeten doen. De methodes zijn methodes in de view, sout mag alleen maar daar komen te staan.
        
        switch (userInput) {
            // bestelling plaatsen
            case 1:
                {
                    int klantID = bestellingView.createBestellingView();
                    int bestellingID = BDAO.insertBestelling(klantID);
                    int anotherOne;
                    boolean checker = true;

                    // voeg artikelen toe aan bestelling
                    ArrayList<BestellingArtikel>AL = new ArrayList<>();
                    BestellingArtikel BS = new BestellingArtikel();
                    
                    do {
                    BS = bestellingView.createBestellingAddArtikelView();
                    BS.setBestelling_id(bestellingID);
                    AL.add(BS);
                        System.out.println("Wil je nog een artikel toevoegen?\n1 - ja\n2 - nee");
                        anotherOne = scanner.nextInt();
                        if (anotherOne == 1){
                            checker = true;
                        }
                        else{
                            checker = false;
                        }
                    } while (checker);
                    
                    System.out.println("De artikelen van Klant " + klantID + " zijn toegevoegd aan bestelling ID: " + bestellingID);

                    break;
                }
            // bestellinginfo ophalen
            case 2:
                {
                    int bestellingID = bestellingView.zoekBestellingInfo();
                    Bestelling bestelling = BDAO.findById(bestellingID);
                    System.out.println("Bestelling ID: " + bestelling.getBestelling_id());
                    System.out.println("Klant ID: " + bestelling.getKlant_id());
                    System.out.println("Bestelling Datum: " + bestelling.getDatum());
                    
                    ArrayList<Artikel>artikellijst = new ArrayList<>();
                    artikellijst = BADAO.findByBestellingId(bestellingID);
                    System.out.println("Artikellen in bestelling: ");
                    for (Artikel ar: artikellijst){
                        System.out.println(ar.getArtikelNaam() + ": " + BADAO.findAantalByArtikelID(bestellingID, ar.getArtikelID()) + " keer");
                        
                    }       
                    
                    break;
                }
            // Bestelling wijzigen
            case 3:
                break;
            // Bestelling verwijderen
            case 4:
            {
                int bestellingID = bestellingView.zoekBestellingInfo();
                BDAO.deleteBestelling(bestellingID);
                
                // Als je een bestelling verwijderd zul je die altijd ook willen verwijderen uit de koppeltabel
                // het zou dus elegant zijn als de hierboven aangeroepen deleteBestelling zelf ook 
                // deleteBestellingArtikel zou aanroepen.
                
                BADAO.deleteBestellingArtikel(bestellingID);
                System.out.println(bestellingID + " is verwijderd.");

            }
                break;
            default:
                System.out.println("That option is not available.");
                break;
        }
        
        
        
    }
    
    
    
    
}
