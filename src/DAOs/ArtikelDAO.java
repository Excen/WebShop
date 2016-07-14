/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import WorkShop.Artikel; // anders doet die niet?
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anne
 */
public interface ArtikelDAO {
    public ArrayList<Artikel> findAll();
    public Artikel findByArtikelID(int artikelID);
    public Artikel findByArtikelNaam(String artikelNaam);
    public Artikel findByArtikelPrijs (double artikelPrijs);
    public boolean insertArtikel (int artikelID, String artikelNaam, double artikelPrijs);
    public void deleteArtikel(int artikelID);
    public void update(Artikel artikel) throws SQLException, ClassNotFoundException;
    
}
