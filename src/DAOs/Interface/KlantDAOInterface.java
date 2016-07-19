/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Interface;

import POJO.Klant;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wendy
 */
public interface KlantDAOInterface {
    public ArrayList <Klant> findAllKlanten() throws Exception;
    public Klant findByKlantId(int klantId) throws SQLException, ClassNotFoundException;
    public Klant findByVoorNaam(String voorNaam) throws SQLException, ClassNotFoundException;
    public Klant findByAchterNaam(String achterNaam) throws SQLException, ClassNotFoundException;
    public Klant findByVoorNaamAchterNaam(String voorNaam, String achterNaam) 
            throws SQLException, ClassNotFoundException;
    public Klant findByEmail(String email) throws SQLException, ClassNotFoundException;
    
    public Klant insertKlant() throws SQLException;
    public void updateVoorNaam() throws SQLException;
    public void updateAchterNaam() throws SQLException; 
    public void updateTussenVoegsel() throws SQLException; 
    public void updateEmail() throws SQLException; 
    
    public void deleteByKlantId() throws SQLException; 
    public void deleteByKlantNaam() throws SQLException;
    public void deleteAll() throws SQLException;    
    
    
    

    /*public int[] addBatchKlanten() throws Exception; >> later bij tijd over
    public void vulVoornaamLijst ();
    public void vulAchternaamLijst ();
    public void vulTussenvoegselLijst ();*/
    
    //public ArrayList<Klant> findByAdresId (int adresId) throws Exception;  
    //public void updateAdresKlant (int adresId) throws Exception;
}
