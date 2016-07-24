/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Interface;

import POJO.Artikel; // anders doet die niet?
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Anne
 */
public interface ArtikelDAOInterface {
    public ArrayList<Artikel> findAll();
    public Artikel findByArtikelID(int artikelID);
    public Artikel findByArtikelNaam(String artikelNaam);
    public Artikel findByArtikelPrijs (double artikelPrijs);
    public Artikel insertArtikel (String artikelNaam, double artikelPrijs);
    public boolean deleteArtikel(int artikelID);
    public boolean update(Artikel artikel) throws SQLException, ClassNotFoundException;
    
}
