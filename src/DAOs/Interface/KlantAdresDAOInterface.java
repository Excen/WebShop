/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Interface;

import POJO.Adres;
import POJO.Klant;
import POJO.KlantAdres;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wendy
 */
public interface KlantAdresDAOInterface {
    public ArrayList<KlantAdres> findAll() throws SQLException, ClassNotFoundException;
    public ArrayList<Klant> findKlantByAdresId(int bestelling_id) throws SQLException, ClassNotFoundException;
    public ArrayList<Adres> findAdresByKlantId(int artikel_id) throws SQLException, ClassNotFoundException;
    
    public boolean insertKlantAdres(int klantId, int adresId);
        
    public boolean deleteAll();
    public boolean deleteKlantAdresByAdresId(int adresId);
    
}

//public boolean update (int adres_id, int klant_id ) throws SQLException, ClassNotFoundException;
    // deleted methode update -> zijn maar twee datafields. dus update  == createKlantADres

//verwijderd: zie hier boven
//public void deleteAdresFromKlant(int adres_id, int klant_id) throws SQLException, ClassNotFoundException;  
 // public void deleteKlantFromAdres(int klant_id, int adres_id) throws SQLException, ClassNotFoundException; 