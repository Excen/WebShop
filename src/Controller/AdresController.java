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
    Adres adres = new Adres();
    AdresBuilder adresBuilder = new AdresBuilder();
    int userInput;
    KlantController klantController = new KlantController();
    KlantAdresDAOImpl klantAdresDao = new KlantAdresDAOImpl();
    HoofdMenuController hoofdMenuController = new HoofdMenuController();
    
    public void adresMenu() throws SQLException, ClassNotFoundException{
        userInput = adresView.startArtikelMenu();
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
    
    public void voegNieuwAdresToe() throws SQLException, ClassNotFoundException {
        System.out.println("U wilt een nieuw adres toevoegen. Voer hieronder de gegevens in.");
        int klantId = adresView.voerKlantIdIn();
        adres = createAdres();
        
        //voeg toe in adrestabel
        adres = adresDao.insertAdres(adres);
        int adresId = adres.getAdresId();
        
        // voeg toe in koppeltabel
        boolean toegevoegd = klantAdresDao.insertKlantAdres(klantId, adresId);
        
        System.out.println("U heeft het volgende adres toegevoegd.");
        adresView.printAdresOverzicht(adres);
        
        adresMenu();
            
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
                adresMenu();
                break;
        }
    }
    
    public void wijzigAdresGegevens(){
        
    }
    public void verwijderAdresGegevens(){
        
    }
    public void terugNaarHoofdMenu() throws SQLException, ClassNotFoundException {
        hoofdMenuController.start();
    }
}
