
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
import View.KlantView;
import java.sql.SQLException;

/**
 *
 * @author Anne
 */

public class KlantController {
    KlantDAOImpl klantDAO = (KlantDAOImpl) KlantDAOFactory.createKlantDAO();
    KlantView klantView = new KlantView();
    AdresDAOImpl adresDAO = (AdresDAOImpl) AdresDAOFactory.createAdresDAO();
    AdresView adresView = new AdresView();
    AdresController adresController = new AdresController();
    KlantAdresDAOImpl klantAdresDAO = (KlantAdresDAOImpl) KlantAdresDAOFactory.createKlantAdresDAO();
   
    
    // return klantId + check: //klopppen datatypes / isValidEmailAdress();
    public int voegNieuweKlantToe() throws SQLException, ClassNotFoundException {
        
        KlantBuilder klantBuilder = new KlantBuilder();
        AdresBuilder adresBuilder = new AdresBuilder();
        Adres adres = new Adres (adresBuilder); 
        
        Klant klantNieuw = createKlant();           
        int klantId = klantDAO.insertKlant(klantNieuw);
        klantBuilder.klantId(klantId);
        klantNieuw = klantBuilder.build(); // klant bouwen om eventueel voor vervolgstappen te gebruiken
                
        //adres = adresController.createAdres();
        //int adresId = adresDAO.insertAdres(adres); // return type werkt nog niet
        
        int adresId = 12;       
        boolean toegevoegd = klantAdresDAO.insertKlantAdres(klantId, adresId); 
        // wilt u nog een andere actie: of terug naar hoofdmenu
        
        System.out.println("U heeft de klant- en adresgegevens van toegevoegd van klantId: " + klantId + " en adresId " + adresId);
        return klantId;
                
    }
    
    public void zoekKlantGegevens() throws SQLException, ClassNotFoundException{
        
        Klant klant = new Klant();
        KlantBuilder klantBuilder = new KlantBuilder(); 
        int klantId = 0;
        
        int input = klantView.isKlantIdBekend();
        if (input == 1){
            klantId = klantView.voerKlantIdIn();
            klant = klantDAO.findByKlantId(klantId);                    
        }
        else if (input == 2){
            int keuze = klantView.hoeWiltUZoeken(); 
            switch (keuze) {
                case 1:
                    String achterNaam = klantView.haalAchterNaamOp();
                    String voorNaam = klantView.haalVoorNaamOp();
                    klant = klantDAO.findByVoorNaamAchterNaam(achterNaam, voorNaam);
                    break;
                case 2:
                    String email = klantView.haalEmailOp();
                    klant = klantDAO.findByEmail(email);
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
        else {}
                   
        klantView.toonKlantGegevens(klant);
        
    }
    
    
    public Klant WijzigKlantGegevens() throws SQLException, ClassNotFoundException{
       Klant klant = new Klant(); 
       int klantId = 0;
        
       int input = klantView.isKlantIdBekend();
        
       if (input == 1){
            klantId = klantView.voerKlantIdIn();
       }
       
       else if (input == 2) {
            int keuze = klantView.hoeWiltUZoeken();
            switch (keuze) {
                case 1:
                    String achterNaam = klantView.haalAchterNaamOp();
                    String voorNaam = klantView.haalVoorNaamOp();
                    klant = klantDAO.findByVoorNaamAchterNaam(achterNaam, voorNaam);
                    break;
                case 2:
                    String email = klantView.haalEmailOp();
                    klant = klantDAO.findByEmail(email);
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            // roep methode aan om te zoeken met andere gegevens. 
            //roep methode aan om te zoeken met andere gegevens. 
            // klantView.gegevensBekend(); a. voornaam en achternaam b. achternaam c. email
       }
       
       else {}
        
       return klant; 
    }
   
    
    public boolean VerwijderKlantGegevens(){
        
        boolean deleted = false; 
        
        //klantview.watWiltUVerwijderen;  1 klant of alle klanten
        //klantDAO.delete();
        //klantDAO.deleteAll();
        
        
        return deleted; 
    }
    
    
    public Klant createKlant(){
        
        //int klantId = 0;   
        String achternaam = klantView.haalAchterNaamOp();
        String voornaam = klantView.haalVoorNaamOp();
        String tussenvoegsel = klantView.haalTussenVoegselOp();
        String email = klantView.haalEmailOp();
        
        
        KlantBuilder klantBuilder = new KlantBuilder();
        
            //klantBuilder.klantId(klantId); pas duidelijk na invoer in database
            klantBuilder.achterNaam(achternaam);
            klantBuilder.voorNaam(voornaam);
            klantBuilder.tussenVoegsel(tussenvoegsel);
            klantBuilder.email(email);
            
            // build klant
           Klant klant = klantBuilder.build();
        
        return klant;        
    }
      
}
