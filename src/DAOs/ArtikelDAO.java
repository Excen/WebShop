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
    public ArrayList<Artikel> findAll() throws SQLException, ClassNotFoundException;
    public Artikel findByArtikelID(int artikelID) throws SQLException, ClassNotFoundException;
    public Artikel findByArtikelNaam(String artikelNaam) throws SQLException, ClassNotFoundException;
    public Artikel findByArtikelPrijs (double artikelPrijs) throws SQLException, ClassNotFoundException;
    public void insertArtikel (int artikelID, String artikelNaam, double artikelPrijs) throws ClassNotFoundException;
    public void deleteArtikel(int artikelID) throws SQLException, ClassNotFoundException;
    public void update(Artikel artikel) throws SQLException, ClassNotFoundException;
    
}
