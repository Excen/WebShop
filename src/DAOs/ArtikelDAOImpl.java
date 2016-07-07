
package DAOs;

import java.sql.*;
import java.sql.SQLException;


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
   
    
    public Artikel [] findAll() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql:// ....");
        String sqlQuery = "select * from Artikel";
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();   
       // ga morgen verder    
}
    
            
    @Override
    public Artikel findbyArtikelID (int artikelID) throws SQLException {
        // implementation code
        // String sqlQuery = "select * from Artikel where artikel_id = " + artikelID;
        return Artikel;
        
        }
    public Artikel findbyArtikelNaam (String artikelNaam) throws SQLException {
        // implementation code
        // String sqlQuery = "select * from Artikel where artikel_Naam = " + artikelNaam;
        return Artikel;
        }
    public Artikel findbyArtikelPrijs (double artikelPrijs) throws SQLException {
        // implementation code
        // String sqlQuery = "select * from Artikel where artikel_prijs = " + artikelPrijs;
        return Artikel;
        }
    
}
