/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;
page 

import DAOs.Impl.ArtikelDAOImpl;

/**
 *
 * @author Anne
 */
public class ArtikelView {
    public String zoekOpArtikelNaam(){
        Scanner scan = new Scanner();
        String artikelNaam = scan.next();
        return artikelNaam;

    }
    
    publc void printArtikel(Artikel artikellen){
        
    }
}


public class ArtikelController{
    public void vindbestellingenmetaritkel(){
        ArtikelView view = new ArtikelView();
        String ArtikelNaam = view.zoekOpArtikelNaam();
        
        
        KoppeltabalDAO Kdao = new kopelakfjalfj()
        ArrayList<besetling> =        kdao findByArtikelID(artikel.getID());
        
        ArtikelDAOImpl dao = new ArtikelDAOImpl();
        Artikel artikel =  dao.findByArtikelNaam(ArtikelNaam);
        
        
        view.printBestellingMetArtikel()
        
    }
    
    
}
