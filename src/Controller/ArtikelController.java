
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
    Artikel artikel = new Artikel();
    
    public void artikelMenu() {
        int userInput = artikelView.startArtikelMenu();
        
        switch (userInput) {
            case 1: 
                artikel = createArtikel();
                voegNieuwArtikelToe(artikel); 
                break;
            case 2: 
                zoekArtikelGegevens();
                break;
            case 3:
                wijzigArtikelGegevens();
                break;
            case 4:
                verwijderArtikelGegevens();
                break;
            case 5:
                terugNaarHoofdMenu();
                break;
            case 6:
                afsluiten();
                break;
        }     
        
    }
    
     public void voegNieuwArtikelToe(Artikel artikel) {
        String artikelNaam = artikel.getArtikelNaam();
        double artikelPrijs = artikel.getArtikelPrijs();
        
        artikel = artikelDAO.insertArtikel(artikelNaam, artikelPrijs);
        
        System.out.println("U heeft de volgende gegevens ingevoerd:");
        artikelView.printArtikelOverzicht(artikel); 
    }
     
    public Artikel createArtikel() {
        System.out.println("Vul de artikel gegevens in: ");
        String artikelNaam = artikelView.voerArtikelNaamIn();
        double artikelPrijs = artikelView.voerAtrikelPrijsIn();
        
        Artikel artikel = new Artikel();
        artikel.setArtikelNaam(artikelNaam);
        artikel.setArtikelPrijs(artikelPrijs);
        return artikel;
    } 
     
    public void zoekArtikelGegevens() {
        artikel = new Artikel();
        int userInput = artikelView.hoeWiltUZoeken();
        
        switch (userInput) {
            case 1: 
                int artikelId = artikelView.voerArtikelIdIn();
                artikel = artikelDAO.findByArtikelID(artikelId);
                artikelView.printArtikelOverzicht(artikel);
                break;
            case 2:
                String artikelNaam = artikelView.voerArtikelNaamIn();
                artikel = artikelDAO.findByArtikelNaam(artikelNaam);
                artikelView.printArtikelOverzicht(artikel);
                break;
            case 3:
                double artikelPrijs = artikelView.voerAtrikelPrijsIn();
                artikel = artikelDAO.findByArtikelPrijs(artikelPrijs);
                artikelView.printArtikelOverzicht(artikel);
                break;
            case 4: 
                artikelMenu();
                break;
        }
    }
    
    
    
    public void wijzigArtikelGegevens() {
        
        int userInput = artikelView.hoeWiltUZoeken();
        switch (userInput) {
            case 1: 
                updateOpArtikelId();
                break;
            case 2:
                updateOpArtikelNaam(); 
                break;
            case 3: 
                updateOpArtikelPrijs();
                break;
            case 4:
                artikelMenu();
                break;
        }
    }
    
    public void updateOpArtikelId() {
        Artikel gewijzigdArtikel = new Artikel();
        boolean gewijzigd;
        
        int artikelId = artikelView.voerArtikelIdIn();
        artikel = artikelDAO.findByArtikelID(artikelId);
        gewijzigdArtikel = invoerNieuweArtikelGegevens(artikel);
        
        gewijzigd = artikelDAO.update(gewijzigdArtikel);
        if (gewijzigd == true) {
            System.out.println("De oude gegevens: ");
            artikelView.printArtikelOverzicht(artikel);
            System.out.println("De nieuwe gegevens: ");
            gewijzigdArtikel = artikelDAO.findByArtikelID(artikelId);
            artikelView.printArtikelOverzicht(gewijzigdArtikel);
        }
    }
    public void updateOpArtikelNaam() {
        Artikel gewijzigdArtikel = new Artikel();
        boolean gewijzigd;
    
        String artikelNaam = artikelView.voerArtikelNaamIn();
        artikel = artikelDAO.findByArtikelNaam(artikelNaam);
        gewijzigdArtikel = invoerNieuweArtikelGegevens(artikel);
        gewijzigd = artikelDAO.update(gewijzigdArtikel);
        if (gewijzigd == true) {
            System.out.println("De oude gegevens: ");
            artikelView.printArtikelOverzicht(artikel);
            System.out.println("De nieuwe gegevens: ");
            gewijzigdArtikel = artikelDAO.findByArtikelNaam(artikelNaam);
            artikelView.printArtikelOverzicht(gewijzigdArtikel);
        }
        // else opvangen als niet gelukt is                     
    }
    
    public void updateOpArtikelPrijs() {
        Artikel gewijzigdArtikel = new Artikel();
        boolean gewijzigd;
        
        double artikelPrijs = artikelView.voerAtrikelPrijsIn();
        artikel = artikelDAO.findByArtikelPrijs(artikelPrijs);
        gewijzigdArtikel = invoerNieuweArtikelGegevens(artikel);
        gewijzigd = artikelDAO.update(gewijzigdArtikel);
        if (gewijzigd == true) {
            System.out.println("De oude gegevens: ");
            artikelView.printArtikelOverzicht(artikel);
            System.out.println("De nieuwe gegevens: ");
            artikelView.printArtikelOverzicht(gewijzigdArtikel);
        }
                    // else opvangen als niet gelukt                       
            
    }
        
    public Artikel invoerNieuweArtikelGegevens(Artikel artikel) {
        int juist = 0;
        
        String artikelNaam = artikel.getArtikelNaam();
        juist = artikelView.checkInputString(artikelNaam);
        if (juist == 2) {
            artikelNaam = artikelView.voerArtikelNaamIn();
        }
        double artikelPrijs = artikel.getArtikelPrijs();
        String artikelPrijsString = artikelPrijs + "";
        juist = artikelView.checkInputString(artikelPrijsString);
        if (juist == 2) {
            artikelPrijs = artikelView.voerAtrikelPrijsIn();
        }
        
        artikel.setArtikelNaam(artikelNaam);
        artikel.setArtikelPrijs(artikelPrijs);
        
        return artikel;
        
    }
    
    
    public void verwijderArtikelGegevens() {
        
        int userInput = artikelView.printVerwijderMenu();
        if (userInput == 1) {
            int artikelId = artikelView.printDeleteArtikelView();
            boolean deleted = artikelDAO.deleteArtikel(artikelId);
            artikelView.printDeleteResultaat(deleted, artikelId);        
        }
        
    }
    
    public void terugNaarHoofdMenu() {
        HoofdMenuController hoofdMenu = new HoofdMenuController();
        hoofdMenu.start();
    }
        
    public void afsluiten() {
        
    }
    
    
        
    
    
}
