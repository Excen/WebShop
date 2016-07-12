/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;
import WorkShop.Adres;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Wendy
 */
public interface AdresDAO {
    
    public ArrayList <Adres> findAllAdresses() throws Exception;
    public Adres findByAdresID(int adresId) throws SQLException, ClassNotFoundException;
    public Adres findByStraatNaam(String straatNaam) throws SQLException,ClassNotFoundException ;
    public Adres findByPostcodeHuisNummer(String postCode, int huisNummer) throws SQLException, ClassNotFoundException;
    public Adres findByWoonplaats(String woonPlaats) throws SQLException, ClassNotFoundException;
    public ArrayList<Adres> findByKlantId (int klantId) throws Exception;
    public boolean insertAdres() throws SQLException, ClassNotFoundException;
    public void updateStraatNaam() throws SQLException;
    public void updatePostCode() throws SQLException;
    public void updateHuisNummer() throws SQLException;
    public void updateToevoeging() throws SQLException;
    public void updateWoonplaats() throws SQLException;
    public void delete() throws SQLException;
    public void deleteAll() throws SQLException;
    
    
}
