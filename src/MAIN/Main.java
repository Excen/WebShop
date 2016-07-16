package MAIN;

import DAOs.Impl.AdresDAOImpl;
import DAOs.Impl.KlantDAOImpl;
import POJO.Adres;
import POJO.Klant;
import java.awt.HeadlessException;
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

        KlantDAOImpl klantDAO = new KlantDAOImpl();
         
        Klant klant = klantDAO.findByVoorNaam("Jens");
        System.out.println(klant.getEmail());
         System.out.println("-----");
         
        klant = klantDAO.findByAchterNaam("vries");
        System.out.println(klant.getEmail());
        System.out.println("-----");
        
        klant = klantDAO.findKlantByKlantId(3);
        System.out.println(klant.getEmail());
        System.out.println("-----");
        
        klant = klantDAO.findByEmail("astrid@huge.com");
        System.out.println(klant.getKlantId());
        System.out.println("-----");
       
        klant = klantDAO.findByVoorNaamAchterNaam("astrid", "groot");
        System.out.println(klant.getKlantId());
        System.out.println("-----");
       
        /*klantDAO.deleteByKlantId();
        
       
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
        } */
        AdresDAOImpl adresDAO = new AdresDAOImpl();
       boolean update = adresDAO.deleteAdres();
        System.out.println(update);
        }    
        catch(SQLException | HeadlessException e) {
        System.out.print("not connect to server and message is: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /*
        
        klant = klantDAO.insertKlant();
       System.out.println(klant.getKlantId());
       System.out.println("-----");
        
        
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
        
                   
    */
}}
        
    
    


