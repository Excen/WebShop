/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Interface;


import POJO.Bestelling;
import POJO.Klant;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Excen
 */
public interface BestellingDAOInterface {
    
    public ArrayList<Bestelling> findAll() throws SQLException;
    public Bestelling findById(int bestelling_id) throws SQLException;
    public Klant findKlantByBestellingId (int bestelling_id) throws SQLException;
    public void createBestelling(Bestelling bestelling) throws SQLException;
    public void updateKlantId(int bestelling_id, int klant_id) throws SQLException;
    public void deleteBestelling(int bestelling_id) throws SQLException;
    public void deleteAll() throws SQLException;  
}

