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
    public ArrayList<Klant> findByAdresId(int bestelling_id) throws SQLException, ClassNotFoundException;
    public ArrayList<Adres> findByKlantId(int artikel_id) throws SQLException, ClassNotFoundException;
    
    public void createKlantAdres(KlantAdres klantAdres) throws SQLException, ClassNotFoundException;
    
    public void update (int adres_id, int klant_id ) throws SQLException, ClassNotFoundException;
    
    public void deleteAll() throws SQLException, ClassNotFoundException;
    public void deleteKlantAdres(int klant_id) throws SQLException, ClassNotFoundException;
    public void deleteAdresFromKlant(int adres_id, int klant_id) throws SQLException, ClassNotFoundException;  
    public void deleteKlantFromAdres(int klant_id, int adres_id) throws SQLException, ClassNotFoundException; 
}
