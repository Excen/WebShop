/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import WorkShop.Adres;
import WorkShop.Klant;
import WorkShop.KlantAdres;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wendy
 */
public class KlantAdresDAOImpl implements KlantAdresDAO {
    
   @Override
   public ArrayList<KlantAdres> findAll() throws SQLException, ClassNotFoundException{
       
       ArrayList<KlantAdres> klantAdresLijst = new ArrayList<>();
       
       
       
       
       
       return klantAdresLijst;
   } 

    @Override
    public ArrayList<Klant> findByAdresId(int bestelling_id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Adres> findByKlantId(int artikel_id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createKlantAdres(KlantAdres klantAdres) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int adres_id, int klant_id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteKlantAdres(int klant_id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAdresFromKlant(int adres_id, int klant_id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteKlantFromAdres(int klant_id, int adres_id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
