package MAIN;

import DAOs.Impl.AdresDAOImpl;
import DAOs.Impl.KlantAdresDAOImpl;
import DAOs.Impl.KlantDAOImpl;
import POJO.Adres;
import POJO.Klant;
import POJO.KlantAdres;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Excen
 */
public class Main {        
        /*
        
        Statement stat = connectie.prepareStatement(Select search from *);
        ResultSet result = stat.executeQuery();
        
    }
    // connection to Database
    private void connectToDB () {
    
        try{
            Class.forName(driver);
            Connection connectie = DriverManager.getConnection(Url, User, Pw);
            System.out.print("You are connected to " + Url);
        }
        catch(java.lang.Exception ex){
            ex.printStackTrace();
        }
        
    //  execute SQL commands
        private void executeSQL(){
        if (connection == null){
            System.out.print ("Please first connect to a database")
            return; 
        }
        else {       
        
        }
        
        }        
        */
        
    public static void main (String [] args) throws SQLException, ClassNotFoundException, Exception{
   
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/winkel?autoReconnect=true&useSSL=false";
    //String url = "jdbc:mysql://localhost3306/winkel";
    String user = "Anjewe"; 
    String pw = "Koetjes"; 
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
       
    
    
        try {
        
        Class.forName(driver);
        con = DriverManager.getConnection(url,user,pw);

        System.out.println("connected with "+ con.toString());

       KlantAdresDAOImpl klantAdres = new KlantAdresDAOImpl();
       
       boolean created = klantAdres.createKlantAdres(2,8);
       System.out.println(created);
       System.out.println("-----");
       
       ArrayList<KlantAdres> lijst = klantAdres.findAll();
        for (int i = 0; i< lijst.size(); i++){
        System.out.println ((lijst.get(i)).getKlantId() + "  " +
                    (lijst.get(i)).getAdresId());
        }
        System.out.println("-----");
       
        
        /*
        KlantDAOImpl klantDAO = new KlantDAOImpl();
       Klant klant = klantDAO.insertKlant();
       System.out.println(klant.getKlantId());
       System.out.println("-----");
        
        ArrayList<Klant> klanten = klantDAO.findByAdresId(3);
        for (int i = 0; i< klanten.size(); i++){
        System.out.println ((klanten.get(i)).getKlantId() + "  " +
                    (klanten.get(i)).getAchterNaam() + "  " +
                (klanten.get(i)).getTussenVoegsel());
            
        }
        System.out.println("-----");
       
        
        int [] y = klantDAO.addBatchKlanten();
        for (int i = 0; i< y.length; i++){
            System.out.println (y[i]);
        } 
       
       
       
        AdresDAOImpl adresDAO = new AdresDAOImpl();
        boolean update = adresDAO.deleteAll();
        System.out.println(update);
        
        */
        
        /*        
        //adresDAO.insertAdres();
       
        Adres adres = adresDAO.findByAdresID(7);
        System.out.println(adres.getPostCode());
        
        ArrayList<Adres> adressen = adresDAO.findAllAdresses();
        for (int i = 0; i< adressen.size(); i++){
            System.out.println ((adressen.get(i)).getAdresId() + "  " +
                    (adressen.get(i)).getStraatNaam() + "  " +(adressen.get(i)).getHuisNummer() +
                    "  " + (adressen.get(i)).getToevoeging() +
                    "  " + (adressen.get(i)).getPostCode() +
                    "  " + (adressen.get(i)).getWoonPlaats());
        } 
        
                   
    */}    
        catch(SQLException | HeadlessException e) {
        System.out.print("not connect to server and message is: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
}}
        
    
    


