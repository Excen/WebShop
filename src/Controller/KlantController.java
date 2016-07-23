
package Controller;

import DAOs.Factory.AdresDAOFactory;
import DAOs.Factory.KlantAdresDAOFactory;
import DAOs.Factory.KlantDAOFactory;
import DAOs.Impl.AdresDAOImpl;
import DAOs.Impl.KlantAdresDAOImpl;
import DAOs.Impl.KlantDAOImpl;
import POJO.Adres;
import POJO.Adres.AdresBuilder;
import POJO.Klant;
import POJO.Klant.KlantBuilder;
import View.AdresView;
import View.HoofdMenuView;
import View.KlantView;
import java.sql.SQLException;

/**
 *
 * @author Anne
 */

public class KlantController {
    // datafields in klantcontroller
    KlantDAOImpl klantDAO = (KlantDAOImpl) KlantDAOFactory.createKlantDAO();
    KlantView klantView = new KlantView();
    KlantAdresDAOImpl klantAdresDAO = (KlantAdresDAOImpl) KlantAdresDAOFactory.createKlantAdresDAO();
    KlantBuilder klantBuilder = new KlantBuilder();
    Klant klant;
    
    AdresDAOImpl adresDAO = (AdresDAOImpl) AdresDAOFactory.createAdresDAO();
    AdresView adresView = new AdresView();
    AdresController adresController = new AdresController();
    AdresBuilder adresBuilder = new AdresBuilder();
    
    KlantAdresDAOImpl KlantAdresDAO = (KlantAdresDAOImpl) KlantAdresDAOFactory.createKlantAdresDAO();
    
    HoofdMenuView startView = new HoofdMenuView();
    
    
    public void klantMenu() throws SQLException, ClassNotFoundException{
        
        int keuze = klantView.startMenuKlant();
        
        switch(keuze){
            case 1: 
                voegNieuweKlantToe();
                break;
            case 2: 
                zoekKlantGegevens();
                break;
            case 3: 
                wijzigKlantGegevens();
                break;
            case 4: 
                verwijderKlantGegevens();
                break;
            case 5: 
                // methode om a al start die weer opnieuw opstart, maar dan een paar vragen verder dan start();
                // startController.terugNaarHoofdMenu();
                break;
            case 6: 
                // methode om programma af te sluiten
                // startController.afsluiten();
                break;            
        }        
        // na uitvoer van de methode in case - automatisch terug naar hoofdmenu
        // startController.terugNaarHoofdMenu();
    }
    
    
    public void voegNieuweKlantToe() throws SQLException, ClassNotFoundException {
        
        klantView.printString("U gaat een klant toevoegen. Voer de gegevens in.");
        klant = creeerKlantObject();           
        klant = klantDAO.insertKlant(klant); //klant inclusief klantId
        int klantId = klant.getKlantId();                
        
        //Adres adresNieuw = adresController.createAdres();
        //adresNieuw = adresDAO.insertAdres(adres); // adres inclusief adresId
        //int adresId = adresNieuw.getAdresId();
        
        int adresId = 15;   // dit weg wanneer adres ook werkt    
        boolean toegevoegd = klantAdresDAO.insertKlantAdres(klantId, adresId); 
        
        String string = "U heeft de klant- en adresgegevens toegevoegd van klantId: " 
                + klantId + " en adresId " + adresId; 
        klantView.printString(string);
        System.out.println();
        
        klantMenu();
     
    } // eind methode voegNieuweKlantToe
    
    
    public void zoekKlantGegevens() throws SQLException, ClassNotFoundException{
        
        int klantId = 0;        
        int input = klantView.isKlantIdBekend();
        
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
        
        klantMenu();
    } // eind methode zoekKlantGegevens
    
    
    public void wijzigKlantGegevens() throws SQLException, ClassNotFoundException{
       
       Klant gewijzigdeKlant = new Klant();
       int klantId = 0;
        
       int input = klantView.isKlantIdBekend();
        // klantid is bekend:
        switch (input) {
            case 1:
                klantId = klantView.voerKlantIdIn();
                klant = klantDAO.findByKlantId(klantId);
                gewijzigdeKlant = wijzigingenInKlantGegevens(klant);
                klantView.printString("Oude klantgegevens:");
                klantView.printKlantGegevens(klant);
                klantView.printString("Nieuwe klantgegevens:");
                klantView.printKlantGegevens(gewijzigdeKlant); 
                break;
            case 2:
                int keuze = klantView.hoeWiltUZoeken();
                switch (keuze) {
                    case 1: // wijzigen op basis voor- en achternaam                        
                        String achterNaam = klantView.voerAchterNaamIn();
                        String voorNaam = klantView.voerVoorNaamIn();
                        klant = klantDAO.findByVoorNaamAchterNaam(achterNaam, voorNaam);
                        gewijzigdeKlant = wijzigingenInKlantGegevens(klant);  
                        klantView.printString("Oude klantgegevens:");
                        klantView.printKlantGegevens(klant);
                        klantView.printString("Nieuwe klantgegevens:");
                        klantView.printKlantGegevens(gewijzigdeKlant); 
                        break;
                    case 2: // wijzigen op basis van email                        
                        String email = klantView.voerEmailIn();
                        klant = klantDAO.findByEmail(email);
                        gewijzigdeKlant = wijzigingenInKlantGegevens(klant); 
                        System.out.println("Oude klantgegevens:");
                        klantView.printKlantGegevens(klant);
                        System.out.println("Nieuwe klantgegevens:");
                        klantView.printKlantGegevens(gewijzigdeKlant); 
                        break;
                    case 3: // direct door naar einde switch: methode naar inlogschermklant()
                        break;
                    default:
                        break;
                }
            default:
                break;    
        }
       
        klantMenu();
                          
    } // einde methode wijzigKlantGegevens
   
    
    public void verwijderKlantGegevens() throws SQLException, ClassNotFoundException{
       
        boolean deleted = false;
        int klantId = 0;
        int x = 0;
        
        int userInput = klantView.printVerwijderMenu();
        
        switch (userInput) {
            case 1: // één klnat verwijderen
                x = klantView.isKlantIdBekend();
                    // klantId bekend
                    if (x == 1){
                        klantId = klantView.voerKlantIdIn();
                        klant = klantDAO.findByKlantId(klantId);                    
                    }
                    // klantId niet bekend
                    else {
                        String achterNaam = klantView.voerAchterNaamIn();
                        String voorNaam = klantView.voerVoorNaamIn();
                        klant = klantDAO.findByVoorNaamAchterNaam(achterNaam, voorNaam);
                        klantId = klant.getKlantId();                    
                    }
                    
                deleted = klantDAO.deleteByKlantId(klantId);  
                int verwijderd = klantAdresDAO.deleteKlantAdresByKlantId(klantId);

                    if (deleted == true){
                        klantView.printString("De volgende klant is verwijderd uit het bestand: ");
                        System.out.println();
                        klantView.printKlantGegevens(klant);
                        klantView.printInt(verwijderd);
                        klantView.printString(" koppeling(en) van klant met een adres zijn verwijderd");                                            
                    }
                    else{
                        klantView.printString("De volgende klant is NIET verwijderd uit het bestand: ");
                        System.out.println();
                        klantView.printKlantGegevens(klant);
                    }   
                break;                    
                                    
            case 2: // alle klanten verwijderen
                x = klantView.bevestigingsVraag();
                // bevestiging is ja
                if (x == 1){
                    int rowsAffected = klantDAO.deleteAll();
                    klantAdresDAO.deleteAll();
                    klantView.printInt(rowsAffected);
                    klantView.printString(" totaal aantal klanten zijn verwijderd");                    
                    klantView.printString("alle koppelingen van klant en adres zijn verwijderd");
                }
                // bevestiging = nee
                else {
                    klantView.printString("De klantgegevens worden niet verwijderd.");
                }
                break;                
            
            case 3: // terug naar klantenmenu - dmv break direct naar inlogschermklant()
                break;
            default:
                break;
        }
        klantMenu();
    }// eind methode verwijderKlantGegevens
    
      
    
    //----------------- waar moeten onderstaande methoden komen?
    public Klant creeerKlantObject(){
        
        //int klantId = 0;   
        String achternaam = klantView.voerAchterNaamIn();
        String voornaam = klantView.voerVoorNaamIn();
        String tussenvoegsel = klantView.voerTussenVoegselIn();
        String email = klantView.voerEmailIn();        
                  
        //klantBuilder.klantId(klantId); pas duidelijk na invoer in database
        klantBuilder.achterNaam(achternaam);
        klantBuilder.voorNaam(voornaam);
        klantBuilder.tussenVoegsel(tussenvoegsel);
        klantBuilder.email(email);

        // build klant
        klant = klantBuilder.build();

        return klant;        
    } // eind methode creeerKlantObject
 

    public Klant wijzigingenInKlantGegevens(Klant klant) throws SQLException, ClassNotFoundException{
        int juist = 0 ;
        
	String voornaam = klant.getVoorNaam();
	juist = klantView.checkInputString(voornaam); // iets dergelijks als "is dit juist?: "+ voormaam 1/true 2/false
            if (juist == 2) { 
                voornaam = klantView.voerVoorNaamIn();
            }
                
	String achternaam = klant.getAchterNaam();
	juist = klantView.checkInputString(achternaam);  // code schrijven voor methode iets als hierboven
            if (juist == 2) {
                achternaam = klantView.voerAchterNaamIn();
            }
                
	String tussenvoegsel = klant.getTussenVoegsel();
	juist = klantView.checkInputString(tussenvoegsel); // zie hierboven
            if(juist == 2) {
                tussenvoegsel = klantView.voerTussenVoegselIn(); 
            }
                
	String email = klant.getEmail();
	juist = klantView.checkInputString(email);
            if (juist == 2){ 
                email = klantView.voerEmailIn();
            }  
        
	klantBuilder.klantId(klant.getKlantId());
        klantBuilder.voorNaam(voornaam);
        klantBuilder.achterNaam(achternaam);
        klantBuilder.tussenVoegsel(tussenvoegsel);
        klantBuilder.email(email);

        // build Klant
        klant = klantBuilder.build();  
	return klant;  
    } // eind methode wijzigingenInKlantGegevens

}  // end class KlantController
