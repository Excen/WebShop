package MAIN;

import Controller.HoofdMenuController;
import java.sql.SQLException;
/*
import DAOs.Impl.AdresDAOImpl;
import DAOs.Impl.ArtikelDAOImpl;
import DAOs.Impl.BestellingArtikelDAOImpl;
import DAOs.Impl.BestellingDAOImpl;
import DAOs.Interface.ArtikelDAOInterface;
import DAOs.Interface.BestellingArtikelDAOInterface;
import DAOs.Interface.BestellingDAOInterface;
import POJO.Adres;
import POJO.Artikel;
import POJO.Bestelling;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
*/

/**
 *
 * @author Excen
 */
public class Main {        
    public static void main (String[]args) throws SQLException{
        
    
        
        
    HoofdMenuController start = new HoofdMenuController();
    start.start();
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
     /*   
        
        
        BestellingArtikelDAOInterface dao = new BestellingArtikelDAOImpl();
    ArrayList<Artikel>artikellijst = new ArrayList<>();
    artikellijst = dao.findByBestellingId(2);
    
    ArtikelDAOInterface dao2 = new ArtikelDAOImpl();
    
    Artikel arre = dao2.findByArtikelID(1);
    
        System.out.println(arre.getArtikelID());
        System.out.println(arre.getArtikelNaam());
        System.out.println(arre.getArtikelPrijs());
    
    
    
        System.out.println("Artikelen:");
    for (int i = 0; i < artikellijst.size(); i++){
        System.out.println(artikellijst.get(i).getArtikelID());
    }
    

    ArtikelDAOInterface ada = new ArtikelDAOImpl();
    Artikel artikeltje = ada.findByArtikelID(1);
        System.out.println(artikeltje.getArtikelID());
        
        Bestelling best = new Bestelling(2, 4);
        
        
        System.out.println("Bestellingopvraagtest:");
        
        BestellingDAOInterface dao3 = new BestellingDAOImpl();
        dao3.createBestelling(best);
        
        
        
        Bestelling bestelling = dao3.findById(2);
        
        
        
        System.out.println(bestelling.getBestelling_id());
        System.out.println(bestelling.getKlant_id());
        
    
        System.out.println("Bestellingen die terug worden gegeven aan de hand van artikelID:");
        
        ArrayList<Bestelling>bestellinglijst = new ArrayList<>();
        bestellinglijst = dao.findBestellingByArtikelId(4);
        for (Bestelling bes: bestellinglijst){
            System.out.println(bes.getBestelling_id());
        }
        
       */ 
        
    
        
    }    
    
    
    
    

    
    
    
    
    
    
    
    
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
    /*    
    public static void main (String [] args) throws SQLException, ClassNotFoundException{
   
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

        AdresDAOImpl adresDAO = new AdresDAOImpl();
        //adresDAO.insertAdres();
       
        
        Adres adres = adresDAO.findByAdresID(15);
        System.out.println(adres);
        
        boolean updateGelukt = adresDAO.updatePostCode();
        //System.out.println(adres.getAdresId() + " " + adres.getWoonPlaats() );
        System.out.println("adres updaten is gelukt: " + updateGelukt);
        
        
        
        ArrayList<Adres> adressen = adresDAO.findAllAdresses();
        for (int i = 0; i< adressen.size(); i++){
            System.out.println ((adressen.get(i)).getAdresId() + "  " +
                    (adressen.get(i)).getStraatNaam() + "  " +(adressen.get(i)).getHuisNummer() +
                    "  " + (adressen.get(i)).getToevoeging() +
                    "  " + (adressen.get(i)).getPostCode() +
                    "  " + (adressen.get(i)).getWoonPlaats());
        } 
        }    
        catch(SQLException | HeadlessException e) {
        System.out.print("not connect to server and message is: " + e.getMessage());
        }
                   
    }
}
        
    
    


*/
}