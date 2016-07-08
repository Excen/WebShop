/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import WorkShop.Bestelling;
import java.sql.SQLException;
/**
 *
 * @author Excen
 */
public interface BestellingDAO {
    
    public Bestelling[] findAll() throws SQLException;
    public Bestelling FindById(int bestelling_id);
    public boolean instert (Bestelling bestelling) throws SQLException;
    public boolean update (Bestelling bestelling) throws SQLException;
    public boolean delete (Bestelling bestelling) throws SQLException;
    
    
    
}

