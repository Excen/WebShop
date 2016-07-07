/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import WorkShop.Artikel; // anders doet die niet?
import java.sql.SQLException;

/**
 *
 * @author Anne
 */
public interface ArtikelDAO {
    public Artikel[] findAll() throws Exception;
    public Artikel findbyArtikelID(int artikelID) throws SQLException;
    public Artikel findbyArtikelNaam(String artikelNaam) throws SQLException;
    public Artikel findbyArtikelPrijs (double artikelPrijs) throws SQLException;
    
}
