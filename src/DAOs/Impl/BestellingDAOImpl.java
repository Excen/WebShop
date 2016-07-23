/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Impl;

import DAOs.Interface.KlantDAOInterface;
import DAOs.Interface.BestellingDAOInterface;
import POJO.Bestelling;
import POJO.Klant;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Excen
 */
public class BestellingDAOImpl implements BestellingDAOInterface {
    
    // Info inlog SQL
    String url = "jdbc:mysql://localhost:3306/winkel?autoReconnect=true&useSSL=false";
    String user = "Anjewe";
    String pw = "Koetjes";
    
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    
    @Override
    public int insertBestelling(int klantId) throws SQLException {
        
        java.util.Date datum = new java.util.Date();
        int bestellingId = 0;
        
        // Schrijf waarden weg in SQL tabel.
        String sqlQuery = "insert into bestelling (klant_id, datum_aangemaakt)"
        + " values (?, ?)";
        
        // Maak connectie 
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, klantId);
        stmt.setDate(2, new java.sql.Date(datum.getTime()));
        int affectedRows = stmt.executeUpdate();
                 
                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                } 
        
                rs = stmt.getGeneratedKeys();
                 if (rs.isBeforeFirst()){
                    if (rs.next()) 
                        bestellingId = rs.getInt(1);                         
                } 
                return bestellingId;
    }
    
    @Override
    public ArrayList<Bestelling> findAll() throws SQLException {
        
        ArrayList<Bestelling>bestellinglijst = new ArrayList<>();
        
        String sqlQuery = "select * from Bestelling";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BestellingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
            
        while (rs.next()) {
            
            Bestelling bestelling = new Bestelling();
            bestelling.setBestelling_id(rs.getInt("bestelling_id"));
            bestelling.setKlant_id(rs.getInt("klant_id"));
            // Timestamp?
            java.sql.Date sqlDate = rs.getDate("datum");
            
            bestelling.setDatum(new java.util.Date(sqlDate.getTime()));

            // add bestelling in de list
            bestellinglijst.add(bestelling);
            }
          
          return bestellinglijst;  
          }
    
    @Override
    public Klant findKlantByBestellingId (int bestelling_id) throws SQLException {
        
        int klant_id;
        Klant klantje = new Klant();
        
        String sqlQuery = "select klant_id from bestelling where bestelling_id = " + bestelling_id;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BestellingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        
        while (rs.next()){
        klant_id = rs.getInt("klant_id"); 
        KlantDAOInterface klantDAO = new KlantDAOImpl();
            try {    
                klantje = klantDAO.findByKlantId(klant_id);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BestellingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return klantje;
    }
    
    @Override
    public Bestelling findById(int bestelling_id) throws SQLException {
        
        // String sqlQuery = "select * from bestelling where bestelling_id = " + bestelling_id;
        String sqlQuery = "select bestelling_id, klant_id from bestelling where bestelling_id = " + bestelling_id;
        Bestelling bestelling = new Bestelling();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BestellingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        
        
        
        while (rs.next()) {
            
            
            bestelling.setBestelling_id(rs.getInt("bestelling_id"));
            bestelling.setKlant_id(rs.getInt("klant_id"));
            // bestelling.setDatum(rs.getDate("datum_aangemaakt"));
            
            }    
            return bestelling;
        }
    
    /*
    Create a Java Connection to our MySQL database.
    Create a SQL UPDATE statement, using the Java PreparedStatement syntax.
    Set the fields on our Java PreparedStatement object.
    Execute a Java PreparedStatement.
    Close our Java database connection.
    Catch any exceptions that may come up during the process.
    */
    
    @Override
    public void updateKlantId(int bestelling_id, int klant_id) throws SQLException {
 
        String sqlQuery = "update bestelling set klant_id = " + klant_id + " where bestelling_id = ?";

        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        stmt.setInt(1, bestelling_id);        
        stmt.executeUpdate();

    }
    
    /*
    Create a Java Connection to our MySQL database.
    Create a SQL DELETE query statement.
    Create a Java PreparedStatement for our SQL DELETE query.
    Set the fields on our Java PreparedStatement object.
    Execute our Java PreparedStatement.
    Close our Java MySQL database connection.
    Catch any SQL exceptions that may come up during the process.
    */
    
    @Override
    public void deleteBestelling(int bestelling_id) throws SQLException {
        
        String sqlQuery = "delete * from bestelling where bestelling_id = " + bestelling_id;
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        stmt.executeUpdate();
        
    }
    
    @Override
    public void deleteAll() throws SQLException{
        
        String sqlQuery = "delete from bestelling";
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        stmt.executeUpdate();
        
    }
    
    
    }
    
    

    

    
    

    

