/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import WorkShop.Klant;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wendy
 */
public interface KlantDAO {
    public ArrayList <Klant> findAllKlanten() throws Exception;
    public Klant findByKlantId(int klantID) throws SQLException;
    public Klant findByVoorNaam(String voorNaam) throws SQLException;
    public Klant findByAchterNaam(String achterNaam) throws SQLException;
    public Klant findByVoorNaamAchterNaam(String voorNaam, String achterNaam) throws SQLException;
    public Klant findByEmail(String email) throws SQLException;
    public void insert() throws SQLException;
    public void updateVoorNaam() throws SQLException;
    public void updateAchterNaam() throws SQLException; 
    public void updateTussenVoegsel() throws SQLException; 
    public void updateEmail() throws SQLException; 
    public void delete() throws SQLException; 
    public void deleteAll() throws SQLException;
}
