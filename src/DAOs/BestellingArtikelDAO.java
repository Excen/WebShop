/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import WorkShop.Artikel;
import WorkShop.Bestelling;
import WorkShop.BestellingArtikel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Excen
 */

public interface BestellingArtikelDAO {
    
    public ArrayList<BestellingArtikel> findAll() throws SQLException;
    public ArrayList<Artikel> findByBestellingId(int bestelling_id) throws SQLException;
    public ArrayList<Bestelling> findByArtikelId(int artikel_id) throws SQLException;
    public void createBestellingArtikel(BestellingArtikel bestellingArtikel) throws SQLException;
    public void updateBestellingArtikelAantal(int bestelling_id, int artikel_id, int newArtikel_aantal) throws SQLException;
    public void deleteAll() throws SQLException;
    public void deleteArtikel(int bestelling_id, int artikel_id) throws SQLException;
    public void deleteBestellingArtikel(int bestelling_id) throws SQLException;
    
}