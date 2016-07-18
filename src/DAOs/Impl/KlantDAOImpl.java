/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Impl;

import DAOs.Interface.KlantDAOInterface;
import POJO.Klant;
import POJO.Klant.KlantBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
//import java.util.Set;
//import java.util.HashSet;
//import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.routines.EmailValidator;


/**
 *
 * @author Wendy
 */
public class KlantDAOImpl implements KlantDAOInterface {

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/winkel?autoReconnect=true&useSSL=false";
    //String url = "jdbc:mysql://localhost3306/winkel";
    String user = "Anjewe"; 
    String pw = "Koetjes"; 
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    
    ArrayList <String> voornaamLijst = new ArrayList<>();
    ArrayList <String> achternaamLijst = new ArrayList<>();
    ArrayList <String> tussenvoegselLijst = new ArrayList<>();
    /*
    private void connectToDB () {
    
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, uer, pw);
            System.out.print("You are connected to " + url);
        }
        catch(java.lang.Exception ex){
            ex.printStackTrace();
        }
*/
public static boolean isValidEmailAddress(String email) {
   boolean result = true;
   try {
      // Get an EmailValidator
            EmailValidator validator = EmailValidator.getInstance();
            
            // Validate an email address
            boolean isAddressValid = validator.isValid(email);

            // Validate a variable containing an email address
                 
    } catch (Exception ex) {
        System.out.println(email + " is not a valid E-mail address. Probeer opnieuw: ");   
        result = false;
    }
        return result;
}
       
    @Override  // werkt - niet met foreach loop
    public ArrayList<Klant> findAllKlanten() throws SQLException, ClassNotFoundException {
       
        KlantBuilder klantBuilder = new KlantBuilder();     
        ArrayList<Klant> klantenLijst = new ArrayList<>();
        
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
            Logger.getLogger(KlantDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sqlQuery = "select * from Klant";
        
        try{
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
            
            while (rs.next()) {
            
                klantBuilder.klantId(rs.getInt("klant_id"));
                klantBuilder.voorNaam(rs.getString("voornaam"));
                klantBuilder.achterNaam(rs.getString("achternaam"));
                klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
                klantBuilder.email(rs.getString("email"));
            
                // build Klant
                Klant klant = klantBuilder.build();    
                //voeg klant toe aan lijst
                klantenLijst.add(klant);             
            }
            con.close();
        }
        catch( SQLException ex){
            System.out.println(ex.getMessage());
        }                               
        return klantenLijst; 
    }
    
    @Override  // werkt
    public Klant findKlantByKlantId(int klantId) throws SQLException, ClassNotFoundException {
        
       KlantBuilder klantBuilder = new KlantBuilder();
       Klant klant = new Klant(klantBuilder);
       
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected");
        
          
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where klant_id = ? ";
        stmt = con.prepareStatement(sqlQuery);
        try{
            stmt.setInt(1, klantId);      
            rs = stmt.executeQuery();          
            
        while (rs.next()) {  
            
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();
                        
        }  
        con.close();      
        }
        catch(SQLException ex){}
                
        return klant; 
    }
    
    @Override    // werkt
    public Klant findByVoorNaam(String voorNaam) throws SQLException, ClassNotFoundException {
        
        KlantBuilder klantBuilder = new KlantBuilder();
        Klant klant = new Klant(klantBuilder);
       
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected"); 
        
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where voornaam = ? ";
        stmt = con.prepareStatement(sqlQuery);
        
        try{
            stmt.setString(1, voorNaam);      
            rs = stmt.executeQuery();          
            
            while (rs.next()) {
            
                klantBuilder.klantId(rs.getInt("klant_id"));
                klantBuilder.voorNaam(rs.getString("voornaam"));
                klantBuilder.achterNaam(rs.getString("achternaam"));
                klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
                klantBuilder.email(rs.getString("email"));
            
                // build Klant
                klant = klantBuilder.build();
                        
            }   
            con.close();     
        } 
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
                
        return klant;
    }

    @Override // werkt
    public Klant findByAchterNaam(String achterNaam) throws SQLException, ClassNotFoundException {
        
        KlantBuilder klantBuilder = new KlantBuilder();
        Klant klant = new Klant(klantBuilder);
       
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected"); 
        
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where achternaam = ? ";
        stmt = con.prepareStatement(sqlQuery);
        
        try{
            stmt.setString(1, achterNaam);      
            rs = stmt.executeQuery();          
            
        while (rs.next()) {               
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();                       
        }  
        con.close();       
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
                
        return klant;
    }

    @Override // werkt
    public Klant findByEmail(String email) throws SQLException, ClassNotFoundException {
        
        KlantBuilder klantBuilder = new KlantBuilder();
        Klant klant = new Klant(klantBuilder);
       
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected"); 
        
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where email = ? ";
        stmt = con.prepareStatement(sqlQuery);
        
        try{
            stmt.setString(1, email);      
            rs = stmt.executeQuery();          
            
        while (rs.next()) {       
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();                        
        } 
        con.close();       
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
                
        return klant;
    }

    @Override // werkt
    public Klant findByVoorNaamAchterNaam(String voorNaam, String achterNaam) 
            throws SQLException, ClassNotFoundException {
       
        KlantBuilder klantBuilder = new KlantBuilder();
        Klant klant = new Klant(klantBuilder);
       
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected"); 
        
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where voorNaam = ? and achterNaam = ? ";
        stmt = con.prepareStatement(sqlQuery);
        try{
            stmt.setString(1, voorNaam);
            stmt.setString(2, achterNaam);
            rs = stmt.executeQuery();          
            
        while (rs.next()) {       
            
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();
                        
        } 
        con.close();       
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
                
        return klant;
    }
    
   @Override // werkt
    public Klant insertKlant() throws SQLException {
        
        KlantBuilder klantBuilder = new KlantBuilder();
        Klant klant = new Klant(klantBuilder);
        
        Scanner input = new Scanner(System.in);
        System.out.print("Voornaam: ");
        String voornaam = input.next().trim();
        
        System.out.print("Achternaam: ");
        String achternaam = input.next().trim();
        
        System.out.print("tussenvoegsel: ");
        String tussenvoegsel = input.next().trim();
        
        System.out.print("email: ");
        String email = input.next().trim();
        
        isValidEmailAddress(email);
        // doe iets als result = false
                   
  
        try {
      // create a mysql database connection      
        Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 
                 // the mysql insert statement
                 String sqlQuery = "insert into Klant (voornaam, achternaam, tussenvoegsel, email)"
                         + " values (?, ?, ?, ?)";
                 
                 // create the mysql insert preparedstatement
                stmt = conn.prepareStatement(sqlQuery,
                         PreparedStatement.RETURN_GENERATED_KEYS);
                 stmt.setString (1, voornaam);
                 stmt.setString (2, achternaam);
                 stmt.setString (3, tussenvoegsel);
                 stmt.setString (4, email);
                 // execute the preparedstatement
                 
                 rs = stmt.getGeneratedKeys();
                 if (rs.isBeforeFirst()){
                     
                     rs.next(); 
                     klantBuilder.klantId(rs.getInt(1));
                     klantBuilder.voorNaam(rs.getString("voornaam"));
                     klantBuilder.achterNaam(rs.getString("achternaam"));
                     klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
                     klantBuilder.email(rs.getString("email"));
            
            // build Klant
                    klant = klantBuilder.build();
                 }
                 
                 int affectedRows = stmt.executeUpdate();
                 if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                 }
                 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
         return klant;
  }  
    
    @Override // werkt
    public void updateVoorNaam() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Klant ID: ");
        int klantId = input.nextInt();
        System.out.print("Voornaam: ");
        String voornaam = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "Update Klant set voornaam = ? where klant_id = ? "; 
                        
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, voornaam);
                 preparedStmt.setInt(2, klantId);
                                
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

    @Override //werkt
    public void updateAchterNaam() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Klant ID: ");
        int klantId = input.nextInt();
        System.out.print("Achternaam: ");
        String achternaam = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "Update Klant set achternaam = ? where klant_id = ?" ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, achternaam);
                 preparedStmt.setInt(2, klantId);
                                
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
    
    @Override// werkt
    public void updateTussenVoegsel() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Klant ID: ");
        int klantId = input.nextInt();
        System.out.print("TussenVoegsel: ");
        String tussenvoegsel = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                
                 String sqlQuery = "Update Klant set tussenvoegsel = ? where klant_id = ?"; 
    
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, tussenvoegsel);
                 preparedStmt.setInt(2, klantId);
                 
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
    
    @Override // werkt
    public void updateEmail() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Klant ID: ");
        int klantId = input.nextInt();
        System.out.print("Email: ");
        String email = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 
                 String sqlQuery = "Update Klant set email = ? where klant_id = ?"; 

                  // create the mysql update preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, email);
                 preparedStmt.setInt(2, klantId);
                                
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
    
    @Override  //werkt
    public void deleteByKlantId() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Klant ID: ");
        int klantId = input.nextInt();
       
        
      try{  
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement.first parent, than child
                 String sqlQuery = "delete from klant where klant_id =  ? " ;                 
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);                
                   preparedStmt.setInt(1, klantId);
                 // execute the preparedstatement
                 int rowsAffected = preparedStmt.executeUpdate(); 
                 //System.out.println(rowsAffected);
             }
      }
    
            catch (ClassNotFoundException | SQLException e)
            {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            }
    }   
        
    @Override // werkt
    public void deleteByKlantNaam() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Voornaam: ");
        String voornaam = input.next();
        System.out.print("Achternaam: ");
        String achternaam = input.next();
        System.out.print("Tussenvoegsel: ");
        String tussenvoegsel = input.next();       
        
      try{  
        Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement.first parent, than child
                 String sqlQuery = "delete from klant where (voornaam, achternaam, " 
                         + "tussenvoegsel) = (?,?,? )";                 
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);                
                 preparedStmt.setString(1,voornaam);
                 preparedStmt.setString(2,achternaam);
                 preparedStmt.setString(3,tussenvoegsel);
                 
                 // execute the preparedstatement
                 int rowsAffected = preparedStmt.executeUpdate();   
                 System.out.println("rows affected: " + rowsAffected);
             }
      }    
      catch (ClassNotFoundException | SQLException e) {
        System.err.println("Got an exception!");
        System.err.println(e.getMessage());
       }
    } 
    
    @Override
    public void deleteAll() throws SQLException {
        
        try{  
            
        Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "delete from klant";                         
                 
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
    }  // delete klnat_id ook uit koppelklantadres tabel

    /*
     @Override // gebruik methode insert van hier boven. 
    gebruik maken van gevulde lijsten werkt nog niet. methode an sich wel.
    
    public int[] addBatchKlanten() throws Exception {    
	KlantDAOImpl klantDAO = new KlantDAOImpl();
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected"); 
	// Create statement object 
	
        String sqlQuery = "insert into Klant (voornaam, achternaam, tussenvoegsel)"
                         + " values (?, ?, ?)";  
						 
	stmt = con.prepareStatement(sqlQuery);
	
        con.setAutoCommit(false);					 
	
        klantDAO.vulVoornaamLijst();
        klantDAO.vulAchternaamLijst();
        klantDAO.vulTussenvoegselLijst();
        
        
	int x = (int)(Math.random()* voornaamLijst.size());
        System.out.println(voornaamLijst.size());
	
	for (int i = 0; i < x; i++){
            String voornaam = 
               voornaamLijst.get((int)(Math.random())*(voornaamLijst.size() + 1));
            String achternaam = 
               achternaamLijst.get((int)(Math.random())*(achternaamLijst.size() + 1));
            String tussenvoegsel = 
               tussenvoegselLijst.get ((int)(Math.random())*(tussenvoegselLijst.size() + 1));
	
	// Add above SQL statement in the batch.	
	stmt.setString (1, voornaam);
        stmt.setString (2, achternaam);
        stmt.setString (3, tussenvoegsel);
        
        stmt.addBatch(sqlQuery);
	}               
    
    // Create an int[] to hold returned values
    int[] count = stmt.executeBatch();
    //Explicitly commit statements to apply changes
    con.commit();
        

    return count;  
    }  

    @Override //werkt
    public void vulVoornaamLijst (){
	Scanner input = new Scanner(System.in);
        
        for (int i = 0; i< 20; i++){
        
        boolean continueInput = true; 
        
        
       do{
        try{	
	System.out.print("Voeg nieuwe voornaam toe: ");
	String voornaamNieuw = input.nextLine(); 
        
            if(!voornaamLijst.contains(voornaamNieuw)){
                voornaamLijst.add(voornaamNieuw);  
                continueInput = false;
            }
            else {
                System.out.print("Naam bestaat al, probeer opnieuw");
                input.nextLine();            
            }  		       
        
        }
        catch (InputMismatchException ex){
            System.out.println("Probeer opnieuw: foutieve input");
           input.nextLine();
        }
       }while(continueInput);
        }
    }
	
    @Override // werkt
    public void vulAchternaamLijst (){		
		
	Scanner input = new Scanner(System.in);
        for (int i = 0; i< 20; i++){
        boolean continueInput = true; 
        
       do{
        try{	
	System.out.print("Voeg nieuwe achternaam toe: ");
	String achternaamNieuw = input.nextLine(); 
        
            if(!achternaamLijst.contains(achternaamNieuw)){
                achternaamLijst.add(achternaamNieuw);  
                continueInput = false;
            }
            else {
                System.out.print("Naam bestaat al, probeer opnieuw");
                input.nextLine();            
            }  		       
        
        }
        catch (InputMismatchException ex){
            System.out.println("Probeer opnieuw: foutieve input");
           input.nextLine();
        }
       }while(continueInput);
        }
    }
	
    @Override // werkt
    public void vulTussenvoegselLijst (){		
	Scanner input = new Scanner(System.in);
        
        for (int i = 0; i< 10; i++){
        boolean continueInput = true; 
        
       do{
        try{	
	System.out.print("Voeg nieuwe voornaam toe: ");
	String tussenvoegselNieuw = input.nextLine(); 
        
            if(!tussenvoegselLijst.contains(tussenvoegselNieuw)){
                tussenvoegselLijst.add(tussenvoegselNieuw);  
                continueInput = false;
            }
            else {
                System.out.print("Tussenvoegsel bestaat al in de lijst, probeer opnieuw");
                input.nextLine();            
            }  		       
        
        }
        catch (InputMismatchException ex){
            System.out.println("Probeer opnieuw: foutieve input");
           input.nextLine();
        }
       }while(continueInput);
        }
    }

    /*
    @Override
    public void updateAdresKlant(int adresId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Klant> findByAdresId(int adresId) throws Exception {
    
        ArrayList<Klant> klantenByAdres = new ArrayList<>();
                
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from klant where koppelklantadres.adres_id = ? " +
                "and klant.klant_id = koppelklantadres.klant_id";
        
        stmt = con.prepareStatement(sqlQuery);
        try{
            Class.forName(driver);
            try (Connection conn = DriverManager.getConnection(url, user, pw)) {
            stmt.setInt(1, adresId);      
            rs = stmt.executeQuery();          
            
                while (rs.next()) {       
            
                    KlantBuilder klantBuilder = new KlantBuilder();
                    klantBuilder.klantId(rs.getInt("klant_id"));
                    klantBuilder.voorNaam(rs.getString("voornaam"));
                    klantBuilder.achterNaam(rs.getString("achternaam"));
                    klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
                    klantBuilder.email(rs.getString("email"));
            
                    // build Klant
                    Klant klant = klantBuilder.build();                        
                }        
            }
        }
        catch(SQLException | ClassNotFoundException ex){}
                
        return klantenByAdres;        
    }
*/

		
} 


