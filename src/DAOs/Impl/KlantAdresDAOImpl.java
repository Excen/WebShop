/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Impl;

import DAOs.Interface.AdresDAOInterface;
import DAOs.Interface.KlantAdresDAOInterface;
import POJO.Adres;
import POJO.Klant;
import POJO.KlantAdres;
import DAOs.Interface.KlantDAOInterface;
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
 * @author Wendy
 */
public class KlantAdresDAOImpl implements KlantAdresDAOInterface {
    
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/winkel?autoReconnect=true&useSSL=false";
    //String url = "jdbc:mysql://localhost3306/winkel";
    String user = "Anjewe"; 
    String pw = "Koetjes"; 
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    
    
    
   @Override
   public ArrayList<KlantAdres> findAll() throws SQLException, ClassNotFoundException{
        
        ArrayList<KlantAdres>KlantAdreslijst = new ArrayList<>();
        
        try{
            //load driver
            Class.forName(driver);
            System.out.println("Driver loaded");
            //establish a connection
            con = DriverManager.getConnection(url,
                user, pw);
            System.out.println("Database Connected");
        } 
        catch(ClassNotFoundException ex){
            Logger.getLogger(KlantAdresDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sqlQuery = "SELECT * FROM Koppelklantadres";
                      
        while (rs.next()) {

            KlantAdres klantAdres = new KlantAdres();
            klantAdres.setKlantId(rs.getInt("klant_id"));
            klantAdres.setAdresId(rs.getInt("adres_id"));
            

            // add bestelling in de list
            KlantAdreslijst.add(klantAdres);
            }
          
          return KlantAdreslijst;  
          }
    

    @Override
    public ArrayList<Klant> findKlantByAdresId(int adresId) throws SQLException, ClassNotFoundException {
        
        ArrayList<Klant> klantenlijst = new ArrayList<>();
        KlantDAOInterface klantDao = new KlantDAOImpl();
        
        try{
            //load driver
            Class.forName(driver);
            System.out.println("Driver loaded");
            //establish a connection
            con = DriverManager.getConnection(url,
                user, pw);
            System.out.println("Database Connected");
        } 
        catch(ClassNotFoundException ex){
            Logger.getLogger(KlantAdresDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sqlQuery = "SELECT klant_id FROM Koppelklantadres WHERE adres_id = ?";
        
        stmt = con.prepareStatement(sqlQuery);
        
        
        try{
            stmt.setInt(1, adresId);      
            rs = stmt.executeQuery();          
            
                while (rs.next()) {  
                    
                    int klantId = rs.getInt("klant_id");
                    Klant klant = klantDao.findKlantByKlantId(klantId);
                    klantenlijst.add(klant);
            
                    // voeg Klant klant toe aan lijst : klantenlijst.add(findByKlantId(int klantId));
                    // of Klant klant = findByKlantId(int klantId); klantenlijst.add(klant);
                       
        }  
        con.close();      
        }
        catch(SQLException ex){}
        
        
        
        return klantenlijst;
    }

    @Override
    public ArrayList<Adres> findAdresByKlantId(int klantId) throws SQLException, ClassNotFoundException {
        ArrayList<Adres> adressenLijst = new ArrayList<>();
        AdresDAOInterface adresDao = new AdresDAOImpl();
        
        try{
            //load driver
            Class.forName(driver);
            System.out.println("Driver loaded");
            //establish a connection
            con = DriverManager.getConnection(url,
                user, pw);
            System.out.println("Database Connected");
        } 
        catch(ClassNotFoundException ex){
            Logger.getLogger(KlantAdresDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sqlQuery = "SELECT adres_id FROM Koppelklantadres WHERE klant_id = ?";
        
        stmt = con.prepareStatement(sqlQuery);
        
        
        try{
            stmt.setInt(1, klantId);      
            rs = stmt.executeQuery();          
            
                while (rs.next()) {  
                    
                    int adresId = rs.getInt("adres_id");
                    Adres adres = adresDao.findByAdresID(adresId);
                    adressenLijst.add(adres);
             
        }  
        con.close();      
        }
        catch(SQLException ex){}        
        
        return adressenLijst;
    }

    @Override
    public boolean createKlantAdres(int klantId, int adresId) throws SQLException, ClassNotFoundException {
         
        /* of via scanner , niet via parameters in methode.
        
        Scanner input = new Scanner(System.in);
        System.out.print("Voer klantId in: ");
        int klantId = input.nextInt();
               
        System.out.print("Voer adresId in: ");
        int adresId = input.nextInt();
        */
        
        boolean created = false; 
        try{
            //load driver
            Class.forName(driver);
            System.out.println("Driver loaded");
            //establish a connection
            con = DriverManager.getConnection(url,
                user, pw);
            System.out.println("Database Connected");
        
        
            // schrijf ze weg in SQL tabel. 
            String sqlQuery = "INSERT INTO koppelklantadres (klant_id, adres_id)"
            + " values (?, ?)";
        
            stmt = con.prepareStatement(sqlQuery);
           
            stmt.setInt(1, klantId);
            stmt.setInt(2, adresId);
       
            stmt.executeUpdate();
        
            created = true; 
        } 
        catch(ClassNotFoundException | SQLException ex ){
            Logger.getLogger(KlantAdresDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return created; 
    }    

    @Override
    public boolean deleteAll() throws SQLException, ClassNotFoundException {
        
        boolean deleted = false;
        
        try{  
            
        Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "delete from koppelklantadres";                         
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                                                 
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
                 deleted = true; 
             }
      }
    
            catch (ClassNotFoundException | SQLException e)
            {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            }
        return deleted; 
    }
        
    
    

    @Override
    public boolean deleteKlantAdres(int klantId, int adresId) throws SQLException, ClassNotFoundException {

    boolean deleted = false; 
    
      try{  
        Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "delete from adres where klant_id = ? AND adres_id = ?" 
                         ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                    
                 preparedStmt.setInt(1, klantId);
                 preparedStmt.setInt(2, adresId);
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
                 deleted = true; 
                 
             }
      }
    
      catch (ClassNotFoundException | SQLException e){
        System.err.println("Got an exception!");
        System.err.println(e.getMessage());
      }
      
      return deleted; 

    }
  
}
