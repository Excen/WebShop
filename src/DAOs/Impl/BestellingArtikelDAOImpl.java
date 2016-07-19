/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Impl;

import DAOs.Interface.BestellingDAOInterface;
import DAOs.Interface.BestellingArtikelDAOInterface;
import DAOs.Interface.ArtikelDAOInterface;
import POJO.Artikel;
import POJO.Bestelling;
import POJO.BestellingArtikel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Excen
 */
public class BestellingArtikelDAOImpl implements BestellingArtikelDAOInterface {
   
    /*
    Haalt gegevens uit de koppeltabel BestellingArtikel.
    Deze gegevens zijn:
    bestelling_id
    artikel_id
    artikel_aantal
    */
    
    // Info inlog SQL
    private String url = "jdbc:mysql://localhost:3306/winkel?autoReconnect=true&useSSL=false";
    private String user = "Anjewe";
    private String pw = "Koetjes";
    
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    
    @Override
    public void createBestellingArtikel(BestellingArtikel bestellingArtikel) throws SQLException{
        
        // haal waardes uit BestellingArtikel object.
        int bestelling_id = bestellingArtikel.getBestelling_id();
        int artikel_id = bestellingArtikel.getArtikel_id();
        int artikel_aantal = bestellingArtikel.getArtikel_aantal();
        
        // schrijf ze weg in SQL tabel. 
        String sqlQuery = "insert into koppelbestellingartikel (bestelling_id, artikel_id, aantal)"
        + " values (?, ?, ?)";
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        stmt.setInt(1, bestelling_id);
        stmt.setInt(2, artikel_id);
        stmt.setInt(3, artikel_aantal);
        stmt.execute();
  
    }
    
    @Override
    public ArrayList<BestellingArtikel> findAll() throws SQLException {
        
        ArrayList<BestellingArtikel>bestellingArtikellijst = new ArrayList<>();
        
        String sqlQuery = "select * from koppelbestellingartikel";
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BestellingArtikelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
            
        while (rs.next()) {

            BestellingArtikel bestelling = new BestellingArtikel();
            bestelling.setBestelling_id(rs.getInt("bestelling_id"));
            bestelling.setArtikel_id(rs.getInt("artikel_id"));
            bestelling.setArtikel_aantal(rs.getInt("aantal"));

            // add bestelling in de list
            bestellingArtikellijst.add(bestelling);
            }
          
          return bestellingArtikellijst;  
          }
    
          // find info about ID - refactor - webshop.bestelingartikel
    
    
    @Override
    public ArrayList<Integer> findByBestellingId2 (int bestelling_id) throws SQLException {
        
        ArrayList<Integer>artikelLijst = new ArrayList<>();
        
        String sqlQuery = "select * from koppelbestellingartikel where bestelling_id = " + bestelling_id;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BestellingArtikelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            int b = rs.getInt("bestelling_id");
            int a = rs.getInt("artikel_id");
            int aa = rs.getInt("aantal");
            
            artikelLijst.add(a);
        }
        
        return artikelLijst;
        
    }
    
    
    @Override
    public ArrayList<Artikel> findByBestellingId(int bestelling_id) throws SQLException {
        
        ArrayList<Artikel>artikelLijst = new ArrayList<>();
        
        String sqlQuery = "select artikel_id, aantal from koppelbestellingartikel where bestelling_id = " + bestelling_id;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BestellingArtikelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        
        ArtikelDAOInterface artikelDao = new ArtikelDAOImpl();
            
        while (rs.next()) {
       
            int artikel_idtje = rs.getInt("artikel_id");
            int aantal = rs.getInt("aantal");
            
            Artikel artikeltje = artikelDao.findByArtikelID(artikel_idtje);
            for (int i = 0; i < aantal; i++){
                artikelLijst.add(artikeltje);
            }
            
            }    
            return artikelLijst;
        
    }   
    
    @Override
    public ArrayList<Bestelling> findBestellingByArtikelId(int artikel_id) throws SQLException {
        
        ArrayList<Bestelling>bestellingLijst = new ArrayList<>();
        
        String sqlQuery = "select bestelling_id from koppelbestellingartikel where artikel_id = " + artikel_id;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BestellingArtikelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        
        BestellingDAOInterface bestellingDao = new BestellingDAOImpl();
        
        
        while (rs.next()) {
            
            Bestelling bestelling = new Bestelling();
            
            bestelling = bestellingDao.findById(rs.getInt("bestelling_id"));

            // zet in arraylist
            bestellingLijst.add(bestelling);
  
        }
        
        return bestellingLijst;
    }

    @Override
    public void updateBestellingArtikelAantal(int bestelling_id, int artikel_id, int newArtikel_aantal) throws SQLException {
        
        String sqlQuery = "update koppelbestellingartikel set aantal = " + newArtikel_aantal + "where bestelling_id = ? and artikel_id = ?";

        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        stmt.setInt(1, bestelling_id);
        stmt.setInt(2, artikel_id);        
        stmt.executeUpdate();
      
    }
    
    @Override
    public void deleteAll() throws SQLException{
        
        String sqlQuery = "delete from koppelbestellingartikel";
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        stmt.executeUpdate();
        
    }
    
    @Override
    public void deleteArtikel(int bestelling_id, int artikel_id) throws SQLException{
        
        String sqlQuery = "delete artikel_id from koppelbestellingartikel where bestelling_id = " + bestelling_id + " and artikel_id = " + artikel_id ;
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        stmt.executeUpdate();
        
    }
    
    @Override
    public void deleteBestellingArtikel(int bestelling_id) throws SQLException {

        String sqlQuery = "delete from koppelbestellingartikel where bestelling_id = " + bestelling_id;
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        stmt.executeUpdate();

    }

    

    
    
}
