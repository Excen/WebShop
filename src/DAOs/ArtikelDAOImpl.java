
package DAOs;

import WorkShop.Artikel;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;



public class ArtikelDAOImpl implements ArtikelDAO {
    
    /** strusture:
    * driver;
    * connection;
    * ResultSet;
    * PreperaredStatement;
    * public Artikel[] // arraylist? findAll method() throws SQLException {
    *   Artikel[] artikel;
    *   String sqlQuery = "select * from Artikel";
    *   con = ResourceManager.getConnection();
    *   stmt = con.prepareStatement(sqlquery);
    *   rs = statement.executeQuery();
    *   while (rs.next) {
    *       // get columns and stor in array;
    *       }
    *   return artikel;
    *   }
    */
    
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
   
   
    @Override
    public ArrayList<Artikel> findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Artikel> artikelList = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost3306/winkel", "Anjewe", "Koetjes");
        String sqlQuery = "select * from artikel";
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        while (rs.next()) {
            /** get the fields from one artikel
             * and store it in an Artikel object
             */
            Artikel artikel = new Artikel();
            artikel.setArtikelID(rs.getInt("artikel_id"));
            artikel.setArtikelNaam(rs.getString("atrikel_naam"));
            artikel.setArtikelPrijs(rs.getDouble("artikel_prijs"));
            // add the artikel in the list
            artikelList.add(artikel);
            }
          con.close();
          return artikelList;  
       
       // ga morgen verder    
}
    
            
    @Override
    public Artikel findByArtikelID (int artikelID) throws SQLException, ClassNotFoundException {
        // implementation code
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/winkel", "Anjewe", "Koetjes");
        String sqlQuery = "select * from artikel where artikel_id = " + artikelID;
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        
        Artikel artikel = new Artikel();
        artikel.setArtikelID(rs.getInt("artikel_id"));
        artikel.setArtikelNaam(rs.getString("artikel_naam"));
        artikel.setArtikelPrijs(rs.getDouble("artikel_double"));
        
        return artikel;
        }
    
    @Override
    public Artikel findByArtikelNaam (String artikelNaam) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Winkel", "Anjewe", "Koetjes");
        String sqlQuery = "select * from artikel where artikel_Naam = " + artikelNaam;
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        
        Artikel artikel = new Artikel();
        artikel.setArtikelNaam(artikelNaam);
        artikel.setArtikelID(rs.getInt("artikel_id"));
        artikel.setArtikelPrijs(rs.getDouble("artikel_double"));
        
        return artikel; 
        
        }
    @Override
    public Artikel findByArtikelPrijs (double artikelPrijs) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/winkel", "Anjewe", "Koetjes");
        String sqlQuery = "select * from artikel where artikel_prijs = " + artikelPrijs;
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        
        Artikel artikel = new Artikel();
        artikel.setArtikelPrijs(artikelPrijs);
        artikel.setArtikelID(rs.getInt("artikel_id"));
        artikel.setArtikelNaam(rs.getString("artikel_naam"));
        
        return artikel;
       
        }
    @Override
   public void insertArtikel (int artikelID, String artikelNaam, double artikelPrijs) throws ClassNotFoundException {
       // of boolean return als gelukt is? 
       try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Winkel", "Anjewe", "Koetjes");
            String sqlUpdate = "insert into artikel (artikel_id, artikel_naam, artikel_prijs)"
                + "values (?, ?, ?)";
            stmt = con.prepareStatement(sqlUpdate);
        
            stmt.setInt(1, artikelID);
            stmt.setString(2, artikelNaam);
            stmt.setDouble(3, artikelPrijs);
        
            stmt.executeUpdate();
       }
       catch (SQLException ex) {
           ex.printStackTrace();
       }
       finally {
                try {
                con.close(); 
                } catch (SQLException ex) {
                }
           
       }
    }
    
    // delete methode
   @Override
    public void deleteArtikel(int artikelID) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Winkel", "Anjewe", "Koetjes");
        String sqlUpdate = "delete from artikel where artikel_id = ?";
        stmt = con.prepareStatement(sqlUpdate);
        
        stmt.setInt(1, artikelID);
        stmt.executeUpdate();
    }
    
    // update method
    @Override
    public void update(Artikel artikel) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Winkel", "Anjewe", "Koetjes");
        String sqlUpdate = "update artikel set artikel_id = ?, artikel_naam = ?, artikel_prijs = ?";
        stmt = con.prepareStatement(sqlUpdate);
        
        stmt.setInt(1, artikel.getArtikelID());
        stmt.setString(2, artikel.getArtikelNaam());
        stmt.setDouble(3, artikel.getArtikelPrijs());
        
        stmt.executeUpdate();
    }
    
}
