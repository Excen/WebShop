/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOs.Impl.AdresDAOImpl;
import DAOs.Impl.KlantAdresDAOImpl;
import POJO.Adres;
import POJO.Adres.AdresBuilder;
import View.AdresView;
import java.sql.SQLException;

/**
 *
 * @author Anne
 */
public class AdresController {
            
    AdresView adresView = new AdresView();
    AdresDAOImpl adresDao = new AdresDAOImpl();
    Adres adres;
    AdresBuilder adresBuilder = new AdresBuilder();
    
    KlantController klantController = new KlantController();
    KlantAdresDAOImpl klantAdresDao = new KlantAdresDAOImpl();
    
    HoofdMenuController hoofdMenuController;
    
    int userInput;
    
    public void adresMenu() throws SQLException, ClassNotFoundException{
        userInput = adresView.startAdresMenu();
        switch (userInput) {
            case 1:
                userInput = adresView.bentUNieuweKlant();
                if (userInput == 1) {
                    System.out.println("Vul eerst de klantgegevens in.");
                    System.out.println();
                    klantController.voegNieuweKlantToe();
                }
                else if (userInput == 2) {
                    voegNieuwAdresToe();
                }
            case 2:
                zoekAdresGegevens();
            case 3:
                wijzigAdresGegevens();
            case 4:
                verwijderAdresGegevens();
            case 5: 
                terugNaarHoofdMenu();   
        } 
        
    }
    
    public int voegNieuwAdresToe() throws SQLException, ClassNotFoundException {
        System.out.println("U wilt een nieuw adres toevoegen. Voer hieronder de gegevens in.");
        int klantId = adresView.voerKlantIdIn();
        adres = createAdres();
        
        //voeg toe in adrestabel
        adres = adresDao.insertAdres(adres);
        int adresId = adres.getAdresId();
        System.out.println(adresId);
        // voeg toe in koppeltabel
        boolean toegevoegd = klantAdresDao.insertKlantAdres(klantId, adresId);
        
        System.out.println("U heeft het volgende adres toegevoegd.");
        adresView.printAdresOverzicht(adres);
        
        return adresId;
            
    }
    
    public Adres createAdres() {
        
        String straatnaam = adresView.voerStraatnaamIn();
        int huisnummer = adresView.voerHuisnummerIn();
        String toevoeging = adresView.voerToevoegingIn();
        String postcode = adresView.voerPostcodeIn();
        String woonplaats = adresView.voerWoonplaatsIn();
        
        adresBuilder.straatNaam(straatnaam);
        adresBuilder.huisNummer(huisnummer);
        adresBuilder.toevoeging(toevoeging);
        adresBuilder.postCode(postcode);
        adresBuilder.woonPlaats(woonplaats);
        
        adres = adresBuilder.build();
        
        return adres;
    }
    
    public void zoekAdresGegevens() throws SQLException, ClassNotFoundException {
        userInput = adresView.hoeWiltUZoeken();
        switch (userInput) {
            case 1:
                int adresId = adresView.voerAdresIdIn();
                adres = adresDao.findByAdresID(adresId);
                adresView.printAdresOverzicht(adres);
                break;
            case 2:
                String straatnaam = adresView.voerStraatnaamIn();
                adres = adresDao.findByStraatNaam(straatnaam);
                adresView.printAdresOverzicht(adres);
                break;
            case 3:
                String postcode = adresView.voerPostcodeIn();
                int huisnummer = adresView.voerHuisnummerIn();
                adres = adresDao.findByPostcodeHuisNummer(postcode, huisnummer);
                adresView.printAdresOverzicht(adres);
                break;
            case 4:
                String woonplaats = adresView.voerWoonplaatsIn();
                adres = adresDao.findByWoonplaats(woonplaats);
                adresView.printAdresOverzicht(adres);
                break;
            case 5:
                break; // doorsturen einde switch; terug naar adres menu
            default: 
                break;
        }
        adresMenu();
    }
    
    public void wijzigAdresGegevens() throws SQLException, ClassNotFoundException{
                
        userInput = adresView.hoeWiltUZoeken();
        switch (userInput) {
            case 1: 
                updateOpAdresId();
                break;
            case 2:
                updateOpStraatnaam();
                break;
            case 3:
                updateOpPostcodeHuisnummer();
                break;
            case 4:
                updateOpWoonplaats();
                break;
            case 5:
                break; // doorsturen einde switch; terug naar adres menu
            default:
                break;
        }
        adresMenu();
    }
    public void updateOpAdresId() {
        adres = new Adres();
        Adres gewijzigdAdres = new Adres();
        int adresId = adresView.voerAdresIdIn();
        
        adres = adresDao.findByAdresID(adresId);
        gewijzigdAdres = invoerNieuweAdresGegevens(adres);
        gewijzigdAdres = adresDao.updateGegevens(gewijzigdAdres);
        
        System.out.println("Oude adresgegevens: ");
        adresView.printAdresOverzicht(adres);
        System.out.println("Nieuwe adresgegevens: ");                  
        adresView.printAdresOverzicht(gewijzigdAdres);
    }
    
    public void updateOpStraatnaam() {
        adres = new Adres();
        Adres gewijzigdAdres = new Adres();
        String straatnaam = adresView.voerStraatnaamIn();
        
        adres = adresDao.findByStraatNaam(straatnaam);
        gewijzigdAdres = invoerNieuweAdresGegevens(adres);
        gewijzigdAdres = adresDao.updateGegevens(gewijzigdAdres);
        
        System.out.println("Oude adresgegevens: ");
        adresView.printAdresOverzicht(adres);
        System.out.println("Nieuwe adresgegevens: ");                  
        adresView.printAdresOverzicht(gewijzigdAdres);
        
    }
    
    public void updateOpPostcodeHuisnummer() {
        adres = new Adres();
        Adres gewijzigdAdres = new Adres();
        int huisnummer = adresView.voerHuisnummerIn();
        String postcode = adresView.voerPostcodeIn();
        
        adres = adresDao.findByPostcodeHuisNummer(postcode, huisnummer);
        gewijzigdAdres = invoerNieuweAdresGegevens(adres);
        gewijzigdAdres = adresDao.updateGegevens(gewijzigdAdres);
        
        System.out.println("Oude adresgegevens: ");
        adresView.printAdresOverzicht(adres);
        System.out.println("Nieuwe adresgegevens: ");                  
        adresView.printAdresOverzicht(gewijzigdAdres);
    }
    
    public void updateOpWoonplaats() {
        adres = new Adres();
        Adres gewijzigdAdres = new Adres();
        String woonplaats = adresView.voerWoonplaatsIn();
        
        adres = adresDao.findByWoonplaats(woonplaats);
        gewijzigdAdres = invoerNieuweAdresGegevens(adres);
        gewijzigdAdres = adresDao.updateGegevens(gewijzigdAdres);
        
        System.out.println("Oude adresgegevens: ");
        adresView.printAdresOverzicht(adres);
        System.out.println("Nieuwe adresgegevens: ");                  
        adresView.printAdresOverzicht(gewijzigdAdres);
    }
    
    
    public Adres invoerNieuweAdresGegevens(Adres adres) {
       int juist = 0;
        
        String straatnaam = adres.getStraatNaam();
        juist = adresView.checkInputString(straatnaam);
        if (juist == 2) {
            straatnaam = adresView.voerStraatnaamIn();
        } 
        
        int huisnummer = adres.getHuisNummer();
        String huisnummerString = huisnummer + "";
        juist = adresView.checkInputString(huisnummerString);
        if (juist == 2) {
            huisnummer = adresView.voerHuisnummerIn();
        } 
        
        String toevoeging = adres.getToevoeging();
        juist = adresView.checkInputString(toevoeging);
        if (juist == 2) {
            toevoeging = adresView.voerToevoegingIn();
        } 
        
        String postcode = adres.getPostCode();
        juist = adresView.checkInputString(postcode);
        if (juist == 2) {
            postcode = adresView.voerPostcodeIn();
        } 
        
        String woonplaats = adres.getWoonPlaats();
        juist = adresView.checkInputString(woonplaats);
        if (juist == 2) {
            woonplaats = adresView.voerWoonplaatsIn();
        } 
        
        adresBuilder.straatNaam(straatnaam);
        adresBuilder.huisNummer(huisnummer);
        adresBuilder.toevoeging(toevoeging);
        adresBuilder.postCode(postcode);
        adresBuilder.woonPlaats(woonplaats);
        
        adres = adresBuilder.build();
        
        return adres;
    }
    
    public void verwijderAdresGegevens(){
        boolean isDeleted = false;
        
        userInput = adresView.printVerwijderAdresMenu();
        switch (userInput) {
            case 1:
                System.out.println("Voer het bestelling id in: ");
                int adresId = adresView.voerAdresIdIn();
                isDeleted = adresDao.deleteAdres(adresId);
            case 2:
        }
        
        
        
    }
    public void terugNaarHoofdMenu() throws SQLException, ClassNotFoundException {
        hoofdMenuController.start();
    }
}
