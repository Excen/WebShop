
package DAOs;

import WorkShop.Adres;
import WorkShop.Adres.AdresBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wendy
 */
public class AdresDAOImpl implements AdresDAO {

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
        
        String sqlQuery = "select adres_id,straatnaam,huisnummer,toevoeging,postcode, " + 
                "woonplaats from Adres where adres_id = ? ";
        stmt = con.prepareStatement(sqlQuery);
        
        try{
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
        }
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

    
    @Override //werkt

    // verwerk de constraint voornaam, achternaam, email
    public boolean insertAdres() throws SQLException, ClassNotFoundException {
        
        boolean inserted = false; 
        
        Scanner input = new Scanner(System.in);
        System.out.print("Straatnaam: ");
        String straatnaam = input.next();
               
        System.out.print("Huisnummer: ");
        int huisnummer = input.nextInt();
        
        System.out.print("Toevoeging: ");
        String toevoeging = input.next().trim();
        
        System.out.print("Postcode: ");
        String postcode = input.next().trim();
        
        System.out.print("Woonplaats: ");
        String woonplaats = input.next();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "insert into adres (straatnaam, huisnummer," +
                         " toevoeging, postcode, woonplaats) values (?, ?, ?, ?,?)";
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, straatnaam);
                 preparedStmt.setInt (2, huisnummer);
                 preparedStmt.setString (3, toevoeging);
                 preparedStmt.setString (4, postcode);
                 preparedStmt.setString (5, woonplaats);
                 
                 // execute the preparedstatement
                 preparedStmt.execute();
                                 
                 inserted = true; 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
         return inserted;
  }    // insert adres_id ook in koppelklantadres tabel

    @Override
    public void updateStraatNaam() throws SQLException {
        
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
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "Update Adres set straatnaam = ? where adres_id = " 
                         + adresId ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, straatnaam);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
    }


    @Override
    public void updatePostCode() throws SQLException {
        
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
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "Update Adres set postcode = ? where adres_id = " 
                         + adresId ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, postcode);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
    }


    @Override
    public void updateHuisNummer() throws SQLException {
        
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
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "Update Adres set huisnummer = ? where adres_id = " 
                         + adresId ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setInt (1, huisnummer);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
    }


    @Override
    public void updateToevoeging() throws SQLException {
        
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
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "Update Adres set toevoeging = ? where adres_id = " 
                         + adresId ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, toevoeging);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
    }


    @Override
    public void updateWoonplaats() throws SQLException {
        
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
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "Update Adres set woonplaats = ? where adres_id = " 
                         + adresId ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, woonplaats);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
    }
    
    

    @Override
    public void delete() throws SQLException {
        
    Scanner input = new Scanner(System.in);
    System.out.print("Adres ID: ");
    int adresId = input.nextInt();
       
        
      try{  
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "delete from adres where adres_id = " 
                         + adresId ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                                                 
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
      }
    
            catch (ClassNotFoundException | SQLException e)
            {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            }
    }
// delete adres_id ook uit koppelklantadres tabel

    @Override
    public void deleteAll() throws SQLException {
        
        try{  
            
        Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "delete from adres";                         
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                                                 
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
      }
    
            catch (ClassNotFoundException | SQLException e)
            {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            }
    }// delete adres_id ook uit koppelklantadres tabel

    @Override
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
                
       
    }

    

