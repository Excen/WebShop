
package DAOs.Impl;

import DAOs.Interface.AdresDAOInterface;
import POJO.Adres;
import POJO.Adres.AdresBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wendy
 */
public class AdresDAOImpl implements AdresDAOInterface {

    //datafields 
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/winkel?autoReconnect=true&useSSL=false";
    //String url = "jdbc:mysql://localhost:3306/winkel";
    String user = "Anjewe"; 
    String pw = "Koetjes"; 
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    
    
    @Override //werkt
    public ArrayList <Adres> findAllAdresses() throws SQLException, 
            ClassNotFoundException {
        
        ArrayList<Adres> adressenLijst = new ArrayList<>();
        AdresBuilder adresBuilder = new AdresBuilder();
       
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected");
        
        String sqlQuery = "select * from Adres";
        
        try{
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
            while (rs.next()) {            
            
                adresBuilder.adresId(rs.getInt("adres_id"));
                adresBuilder.straatNaam(rs.getString("straatnaam"));
                adresBuilder.huisNummer(rs.getInt("huisnummer"));
                adresBuilder.toevoeging(rs.getString("toevoeging"));
                adresBuilder.postCode(rs.getString("postcode"));
                adresBuilder.woonPlaats(rs.getString("woonplaats"));
                // build adres
                Adres adres = adresBuilder.build();    
                //voeg adres toe aan lijst
                adressenLijst.add(adres);
            }        
            con.close();             
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
         }
        // arrayList van adressen 
        return adressenLijst;
    }
    

   @Override //werkt
    public Adres findByAdresID(int adresId) throws SQLException, ClassNotFoundException  {
        AdresBuilder adresBuilder = new AdresBuilder();
        Adres adres = new Adres(adresBuilder);
        
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected");
        
        
           try{
               String sqlQuery = "select adres_id,straatnaam,huisnummer,toevoeging,postcode, " + 
                    "woonplaats from Adres where adres_id = ? ";
                    
                    stmt = con.prepareStatement(sqlQuery);                  
            
                    stmt.setInt(1, adresId);      
                    rs = stmt.executeQuery();   
            
                        while (rs.next()) {   
                        
                        adresBuilder.adresId(rs.getInt("adres_id"));
                        adresBuilder.straatNaam(rs.getString("straatnaam"));
                        adresBuilder.huisNummer(rs.getInt("huisnummer"));
                        adresBuilder.toevoeging(rs.getString("toevoeging"));
                        adresBuilder.postCode(rs.getString("postcode"));
                        adresBuilder.woonPlaats(rs.getString("woonplaats"));
            
                        // build Klant
                        adres = adresBuilder.build();
                                   
                        } 
                             
                    con.close();  
            
                   }// end try
                  catch(SQLException ex){
                  System.out.println(ex.getMessage());
                  }
             
    return adres;        
}
      
    
    @Override //werkt
    public Adres findByStraatNaam(String straatNaam) throws SQLException, ClassNotFoundException {
        AdresBuilder adresBuilder = new AdresBuilder();
        Adres adres = new Adres(adresBuilder);
        
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected");
        
        String sqlQuery = "select adres_id,straatnaam,huisnummer,toevoeging,postcode, " + 
                "woonplaats from Adres where straatnaam = ? ";
        stmt = con.prepareStatement(sqlQuery);
        
        try{
            stmt.setString(1, straatNaam);      
            rs = stmt.executeQuery();          
            
        while (rs.next()) {              
            
            adresBuilder.adresId(rs.getInt("adres_id"));
            adresBuilder.straatNaam(rs.getString("straatnaam"));
            adresBuilder.huisNummer(rs.getInt("huisnummer"));
            adresBuilder.toevoeging(rs.getString("toevoeging"));
            adresBuilder.postCode(rs.getString("postcode"));
            adresBuilder.woonPlaats(rs.getString("woonplaats"));
            
            // build Klant
            adres = adresBuilder.build();
            con.close();            
        }        
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
                
        return adres;
    }
    
    
    @Override //werkt
    public Adres findByWoonplaats(String woonPlaats) throws SQLException, ClassNotFoundException {
                
        AdresBuilder adresBuilder = new AdresBuilder();
        Adres adres = new Adres(adresBuilder); 
        
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected");
        
        String sqlQuery = "select adres_id,straatnaam,huisnummer,toevoeging,postcode, " + 
                "woonplaats from Adres where woonplaats = ? ";
        stmt = con.prepareStatement(sqlQuery);
        
        try{
            stmt.setString(1, woonPlaats);      
            rs = stmt.executeQuery();          
            
            while (rs.next()) {    
            
                adresBuilder.adresId(rs.getInt("adres_id"));
                adresBuilder.straatNaam(rs.getString("straatnaam"));
                adresBuilder.huisNummer(rs.getInt("huisnummer"));
                adresBuilder.toevoeging(rs.getString("toevoeging"));
                adresBuilder.postCode(rs.getString("postcode"));
                adresBuilder.woonPlaats(rs.getString("woonplaats"));
            
                // build Klant
                adres = adresBuilder.build();
                           
        }    
            con.close();     
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
                
        return adres;
    }

    
    @Override //werkt
    public Adres findByPostcodeHuisNummer(String postCode, int huisNummer) 
            throws SQLException, ClassNotFoundException {
                
        AdresBuilder adresBuilder = new AdresBuilder();
        Adres adres = new Adres(adresBuilder); 
        
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected");
                
        String sqlQuery = "select adres_id,straatnaam,huisnummer,toevoeging,postcode, " + 
                "woonplaats from Adres where postcode = ? and huisnummer = ?";
        stmt = con.prepareStatement(sqlQuery);
        
        try{
            stmt.setString(1, postCode);    
            stmt.setInt(2, huisNummer);
            rs = stmt.executeQuery();          
            
            while (rs.next()) {   
            
                adresBuilder.adresId(rs.getInt("adres_id"));
                adresBuilder.straatNaam(rs.getString("straatnaam"));
                adresBuilder.huisNummer(rs.getInt("huisnummer"));
                adresBuilder.toevoeging(rs.getString("toevoeging"));
                adresBuilder.postCode(rs.getString("postcode"));
                adresBuilder.woonPlaats(rs.getString("woonplaats"));
            
                // build Klant
                adres = adresBuilder.build();
                           
            }  
            con.close();       
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }                
        return adres;
    }
    
   
    @Override // werkt
        public int insertAdres(Adres adres) throws SQLException, ClassNotFoundException {
        
        int adresId = 0; 
                
        String straatnaam = adres.getStraatNaam();
        int huisnummer = adres.getHuisNummer();
        String toevoeging = adres.getToevoeging();
        String postcode = adres.getPostCode();
        String woonplaats = adres.getWoonPlaats();
         // the mysql update statement
                
        String sqlQuery = "insert into adres (straatnaam, huisnummer," +
                         " toevoeging, postcode, woonplaats) values (?, ?, ?, ?,?)";
       
        // create a mysql database connection
            Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
            try (Connection conn = DriverManager.getConnection(url, user, pw);                
                // create the mysql insert preparedstatement               
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery,
                         Statement.RETURN_GENERATED_KEYS) ){
                
                 preparedStmt.setString (1, straatnaam);
                 preparedStmt.setInt (2, huisnummer);
                 preparedStmt.setString (3, toevoeging);
                 preparedStmt.setString (4, postcode);
                 preparedStmt.setString (5, woonplaats);
                
                 int affectedRows = preparedStmt.executeUpdate();
                 if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                 } 
                
                rs = preparedStmt.getGeneratedKeys();
                if (rs.isBeforeFirst()){ 
                   if (rs.next())                    
                         adresId = rs.getInt(1);                               
                }     
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }                    
            }
            catch (SQLException e){
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
            
    return adresId;
}       
    
    @Override // werkt
    public boolean updateStraatNaam() throws SQLException {
        
        boolean updated = false; 
                
        Scanner input = new Scanner(System.in);
        System.out.print("Adres ID: ");
        int adresId = input.nextInt();
        System.out.print("Straatnaam: ");
        String straatnaam = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // the mysql update statement
                 String sqlQuery = "Update Adres set straatnaam = ? where adres_id = ? ";
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, straatnaam);
                 preparedStmt.setInt(2, adresId);                 
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 updated = true;                  
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
         return updated; 
    }


    @Override // werkt
    public boolean updatePostCode() throws SQLException {
        boolean updated = false; 
        
        Scanner input = new Scanner(System.in);
        System.out.print("Adres ID: ");
        int adresId = input.nextInt();
        System.out.print("Postcode: ");
        String postcode = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // the mysql update statement
                 String sqlQuery = "Update Adres set postcode = ? where adres_id = ";
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, postcode);
                 preparedStmt.setInt(2, adresId);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 updated = true;
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
         return updated; 
    }


    @Override // werkt
    public boolean updateHuisNummer() throws SQLException {
        boolean updated = false; 
        
        Scanner input = new Scanner(System.in);
        System.out.print("Adres ID: ");
        int adresId = input.nextInt();
        System.out.print("Huisnummer: ");
        int huisnummer = input.nextInt();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // the mysql insert statement
                 String sqlQuery = "Update Adres set huisnummer = ? where adres_id = ? "; 
                
                 // create the mysql update preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setInt (1, huisnummer);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
                 updated = true;                  
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
         return updated; 
    }


    @Override // werkt
    public boolean updateToevoeging() throws SQLException {
        boolean updated = false; 
        
        Scanner input = new Scanner(System.in);
        System.out.print("Adres ID: ");
        int adresId = input.nextInt();
        System.out.print("Toevoeging: ");
        String toevoeging = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                // the mysql update statement
                 String sqlQuery = "Update Adres set toevoeging = ? where adres_id = ?";
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, toevoeging);
                 preparedStmt.setInt(2, adresId);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
                 updated = true; 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
         return updated; 
    }


    @Override // werkt
    public boolean updateWoonplaats() throws SQLException {
        boolean updated = false;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Adres ID: ");
        int adresId = input.nextInt();
        System.out.print("Woonplaats: ");
        String woonplaats = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // the mysql update statement
                 String sqlQuery = "Update Adres set woonplaats = ? where adres_id = ?"; 
                 
                 // create the mysql update preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, woonplaats);
                 preparedStmt.setInt(2, adresId);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
                 updated = true; 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
         return updated; 
    }
    
    

    @Override // werkt
    // delete adres_id ook uit koppelklantadres tabel
    public boolean deleteAdres() throws SQLException {
    
    boolean deleted = false; 
        
    Scanner input = new Scanner(System.in);
    System.out.print("Adres ID: ");
    int adresId = input.nextInt();
       
        
      try{  
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 
                 String sqlQuery = "delete from adres where adres_id = ? " ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                           preparedStmt.setInt(1, adresId);                      
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
    //Got an exception!
//Cannot delete or update a parent row: a foreign key constraint fails (`winkel`.`koppelklantadres`, CONSTRAINT `koppelklantadres_ibfk_2` FOREIGN KEY (`adres_id`) REFERENCES `adres` (`adres_id`))
    public boolean  deleteAll() throws SQLException {
        boolean deleted = false;
        
        try{  
            
        Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "delete * from adres";                         
                 
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
    }// delete adres_id ook uit koppelklantadres tabel
    
    
    /* @Override
    public ArrayList<Adres> findByKlantId(int klantId) throws Exception{
        
        ArrayList<Adres> adressenByKlant = new ArrayList<>();
        
         
        String sqlQuery = "select adres_id,straatnaam,huisnummer,toevoeging,postcode, " + 
                "woonplaats from adres where koppelklantadres.klant_id = ? " +
                "and adres.adres_id = koppelklantadres.adres_id";
        stmt = con.prepareStatement(sqlQuery);        
        
        try{
            Class.forName(driver);
            try (Connection conn = DriverManager.getConnection(url, user, pw)) {
            stmt.setInt(1, klantId);      
            rs = stmt.executeQuery();          
            
                while (rs.next()) {       
             
                    AdresBuilder adresBuilder = new AdresBuilder();
                    adresBuilder.adresId(rs.getInt("adres_id"));
                    adresBuilder.straatNaam(rs.getString("straatnaam"));
                    adresBuilder.huisNummer(rs.getInt("huisnummer"));
                    adresBuilder.toevoeging(rs.getString("toevoeging"));
                    adresBuilder.postCode(rs.getString("postcode"));
                    adresBuilder.woonPlaats(rs.getString("woonplaats"));
            
                     // build Klant
                    Adres adres = adresBuilder.build();
                    adressenByKlant.add(adres);
                     
                } 
            }
        }
        catch(SQLException  | ClassNotFoundException ex) {
            Logger.getLogger(AdresDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
         return adressenByKlant;
    }
*/
    
}
