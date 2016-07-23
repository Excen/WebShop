/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Interface;
import POJO.Adres;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Wendy
 */
public interface AdresDAOInterface {
    
    public ArrayList <Adres> findAllAdresses() throws Exception;
    public Adres findByAdresID(int adresId) throws SQLException, ClassNotFoundException;
    public Adres findByStraatNaam(String straatNaam) throws SQLException,ClassNotFoundException ;
    public Adres findByPostcodeHuisNummer(String postCode, int huisNummer) throws SQLException, ClassNotFoundException;
    public Adres findByWoonplaats(String woonPlaats) throws SQLException, ClassNotFoundException;
    
    public Adres insertAdres(Adres adres) throws SQLException, ClassNotFoundException ;
    public boolean updateStraatNaam() throws SQLException;
    public boolean updatePostCode() throws SQLException;
    public boolean updateHuisNummer() throws SQLException;
    public boolean updateToevoeging() throws SQLException;
    public boolean updateWoonplaats() throws SQLException;
    public boolean deleteAdres() throws SQLException;
    public boolean deleteAll() throws SQLException;
    
    //public ArrayList<Adres> findByKlantId (int klantId) throws Exception;
}
