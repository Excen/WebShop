
package DAOs;

import WorkShop.Artikel;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;



public class ArtikelDAOImpl implements ArtikelDAO {
    
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/winkel?autoReconnect=true&useSSL=false";
    String gebruikersNaam = "Anjewe";
    String wachtwoord = "Koetjes";
   
   
    @Override
    public ArrayList<Artikel> findAll() {
        ArrayList<Artikel> artikelList = new ArrayList<>();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord); 
            String sqlQuery = "select * from artikel";
            stmt = con.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
        
        while (rs.next()) {
            // get the fields from one artikel and store it in an Artikel object
            Artikel artikel = new Artikel();
            artikel.setArtikelID(rs.getInt("artikel_id"));
            artikel.setArtikelNaam(rs.getString("atrikel_naam"));
            artikel.setArtikelPrijs(rs.getDouble("artikel_prijs"));
                     
            // add the artikel in the list
            artikelList.add(artikel);
            }
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Data search failed");
            ex.printStackTrace();
            }  
        
        return artikelList;  
        }
           

            
    @Override
    public Artikel findByArtikelID (int artikelID) {
        Artikel artikel = new Artikel();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String sqlQuery = "select * from artikel where artikel_id = " + artikelID;
            stmt = con.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                artikel.setArtikelID(rs.getInt("artikel_id"));
                artikel.setArtikelNaam(rs.getString("artikel_naam"));
                artikel.setArtikelPrijs(rs.getDouble("artikel_prijs"));
            }
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Data search failed");
            ex.printStackTrace();
            }  
        return artikel;
        }
    
    @Override
    public Artikel findByArtikelNaam (String artikelNaam) {
        Artikel artikel = new Artikel();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String sqlQuery = "select * from artikel where artikel_naam = " + artikelNaam;
            stmt = con.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                artikel.setArtikelID(rs.getInt("artikel_id"));
                artikel.setArtikelNaam(rs.getString("artikel_naam"));
                artikel.setArtikelPrijs(rs.getDouble("artikel_prijs"));
            }
            
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Data search failed");
            ex.printStackTrace();
            }  
        return artikel; 
        }
    
    @Override
    public Artikel findByArtikelPrijs (double artikelPrijs) {
        Artikel artikel = new Artikel();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String sqlQuery = "select * from artikel where artikel_prijs = " + artikelPrijs;
            stmt = con.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                artikel.setArtikelID(rs.getInt("artikel_id"));
                artikel.setArtikelNaam(rs.getString("artikel_naam"));
                artikel.setArtikelPrijs(rs.getDouble("artikel_prijs"));
            }
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Data search failed");
            ex.printStackTrace();
            }        
        return artikel;
       
        }
   @Override
   public boolean insertArtikel (int artikelID, String artikelNaam, double artikelPrijs) {
       //boolean return als gelukt is? 
            boolean isAdded = true;
        try {    
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String sqlUpdate = "insert into artikel (artikel_id, artikel_naam, artikel_prijs)"
                + "values (?, ?, ?)";
            stmt = con.prepareStatement(sqlUpdate);
        
            stmt.setInt(1, artikelID);
            stmt.setString(2, artikelNaam);
            stmt.setDouble(3, artikelPrijs);
        
            stmt.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Data entry failed.");
            ex.printStackTrace();
            isAdded = false;
        }
            return isAdded;
    }

    
    // delete methode
   @Override
    public void deleteArtikel(int artikelID) {
        try { 
            Class.forName(driver);
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String sqlUpdate = "delete from artikel where artikel_id = ?";
            stmt = con.prepareStatement(sqlUpdate);
                    
            stmt.setInt(1, artikelID);
            stmt.executeUpdate();
            }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Deleting failed.");
            ex.printStackTrace();
        }
    }
    
    // update method
    @Override
    public void update(Artikel artikel) {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String sqlUpdate = "update artikel set artikel_id = ?, artikel_naam = ?, artikel_prijs = ?";
            stmt = con.prepareStatement(sqlUpdate);
        
            stmt.setInt(1, artikel.getArtikelID());
            stmt.setString(2, artikel.getArtikelNaam());
            stmt.setDouble(3, artikel.getArtikelPrijs());
        
            stmt.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Update failed.");
            ex.printStackTrace();
        }
      
    }
    
}
