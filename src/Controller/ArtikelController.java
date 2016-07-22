/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ArtikelView;
import DAOs.Impl.ArtikelDAOImpl;
import POJO.Artikel;


public class ArtikelController {
    
    // wat wilt u doen in het klantenbestand?
    // opties geven in de view.
    // terug koppelen naar artikel controller.. if 
    // if (input == 1) { CreateArtikel}
    // if(input ==2) { ZoekArtikelGegevens}
    // if (input == 3) { WijzigArtikelGegevens}
    // if (input == 4) { VerwijderArtikelGegevens}
    
    ArtikelView artikelView = new ArtikelView();
    ArtikelDAOImpl artikelDAO = new ArtikelDAOImpl();
    
    public void startArtikelController() {
        int userInput = artikelView.printStartMenu();
        
        if (userInput == 1) {
            System.out.println("Vul de artikel gegevens in: ");
            
            Artikel artikel = createArtikel();
            voegNieuwArtikelToe(artikel);
            artikelView.printArtikelOverzicht(artikel);      
        }
        if (userInput == 2) {
            zoekArtikelGegevens();
        }
        if (userInput == 3) {
            wijzigArtikelGegevens();
            
            
        }
        if (userInput == 4) {
            verwijderArtikelGegevens();
            
        }
        if (userInput == 5) {
            terugNaarHoofdMenu();
        }
        
        
    }
    
    public void terugNaarHoofdMenu() {
        HoofdMenuController hoofdMenu = new HoofdMenuController();
        hoofdMenu.start();
}
    
    public Artikel voegNieuwArtikelToe(Artikel artikel) {
        String artikelNaam = artikel.getArtikelNaam();
        double artikelPrijs = artikel.getArtikelPrijs();
        
        artikel = artikelDAO.insertArtikel(artikelNaam, artikelPrijs);
        
        return artikel;
    }
    
    public void zoekArtikelGegevens() {
        Artikel artikel = new Artikel();
        int userInput = artikelView.isArtikelIdBekend();
        if (userInput == 1) {
            int artikelId = artikelView.voerArtikelIdIn();
            artikel = artikelDAO.findByArtikelID(artikelId);
        }
        else if (userInput == 2) {
            
        }
    }
    public void wijzigArtikelGegevens() {
        
    }
    public void verwijderArtikelGegevens() {
        
        int userInput = artikelView.printVerwijderMenu();
        if (userInput == 1) {
            int artikelId = artikelView.printDeleteArtikelView();
            boolean deleted = artikelDAO.deleteArtikel(artikelId);
            artikelView.printDeleteResultaat(deleted, artikelId);
            
                
        }
        
    }
    public Artikel createArtikel() {
        String artikelNaam = artikelView.haalArtikelNaamOp();
        double artikelPrijs = artikelView.haalArtikelPrijsOp();
        Artikel artikel = new Artikel();
        artikel.setArtikelNaam(artikelNaam);
        artikel.setArtikelPrijs(artikelPrijs);
        return artikel;
    }
        
    
    
    
        
    
    
}
