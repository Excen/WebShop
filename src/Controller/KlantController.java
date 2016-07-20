/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOs.Impl.KlantDAOImpl;
import POJO.Klant;
import POJO.Klant.KlantBuilder;
import View.KlantView;

/**
 *
 * @author Anne
 */

public class KlantController {
    KlantDAOImpl klantDAO = new KlantDAOImpl();
    KlantView klantView = new KlantView();
    
   
    // return klnatId en adresId
    public int VoegNieuweKlantToe(){
        int klantId; 
        int adresId;
        /*
        klantView.haalKlantGegevensOp();
        isValidEmailAdress();
        Klant klant = createKlant();
                    
        Adres adres = createAdres();
        klantDAO.insert(klant);
        adresDAO.insert(adres);
        klantId = klant.getKlantId();
        adresId = adres.getAdresId();
        klantAdresDAO.insert(klant_id, adres_id); 
        
*/
        return "U heeft klant met klantId " + klantId + "en adresId " + adresId + " toegevoegd."; 
    }
    
    public Klant ZoekKlantGegevens(){
        
        Klant klant = new Klant();
        
        int klantId = klantView.voerKlantIdIn();
            if (klantId!= 000){ 
                // klantDAO.findByKlantId(); return klant.
            }
            else{
            //roep methode aan om te zoeken met andere gegevens. 
            // klantView.gegevensBekend(); a. voornaam en achternaam b. achternaam c. email
            // klantDOA.findBy...() bv voor en achternaam, email
           
            }            
        
        return klant;
    }
    
    
    public Klant WijzigKlantGegevens(){
        Klant klant = new Klant(); 
        
        int klantId = klantView.voerKlantIdIn();
            if (klantId!= 000){ 
                // klantView.invoerWijzigGegevens();
                //klantDAO.update()
            }
            else{
            // roep methode aan om te zoeken met andere gegevens. 
            //roep methode aan om te zoeken met andere gegevens. 
            // klantView.gegevensBekend(); a. voornaam en achternaam b. achternaam c. email
            }            
        
        return klant; 
    }
   
    
    public boolean VerwijderKlantGegevens(){
        
        boolean deleted = false; 
        
        //klantview.watWiltUWijzigen();  1 klant of alle klanten
        //klantDAO.delete();
        //klantDAO.deleteAll();
        
        
        return deleted; 
    }
    
  
    
    
    // waar moet deze methde worden geplaatst?
    public Klant createKlant(){
        
        int klantId = 0;  // 
        String achternaam = null; // klantView.haalAchterNaamOp();
        String voornaam = null; // klantView.haalVoorNaamOp();
        String tussenvoegsel = null; //  klantView.haalTussenVoegsel();
        String email = null; // klantView.haalEmailOp();
        
        // of klantView.haalKlantGegevensOp();
        
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
