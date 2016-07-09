/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;
import POJO_Workshop.*;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Wendy
 */
public interface AdresDAO {
    
    public List <Adres> findAll();
    public Adres findByAdresID(int adresID) throws SQLException;
    public Adres findByStraatNaam(String straatNaam) throws SQLException;
    public Adres findByPostcode (String postCode) throws SQLException;
    public Adres findByWoonplaats (String woonPlaats) throws SQLException;
    
    
}
