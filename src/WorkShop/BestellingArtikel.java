/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkShop;

/**
 *
 * @author Excen
 */
public class BestellingArtikel {
    private int bestelling_id;
    private int artikel_id;
    private int artikel_aantal;
    
    // Constructor
    public BestellingArtikel(int bestelling_id, int artikel_id, int artikel_aantal){
        this.bestelling_id = bestelling_id;
        this.artikel_id = artikel_id;
        this.artikel_aantal = artikel_aantal;
    }
    
    public BestellingArtikel(){
        
    }
    
    
    /**
     * @return the bestelling_id
     */
    public int getBestelling_id() {
        return bestelling_id;
    }

    /**
     * @param bestelling_id the bestelling_id to set
     */
    public void setBestelling_id(int bestelling_id) {
        this.bestelling_id = bestelling_id;
    }

    /**
     * @return the artikel_id
     */
    public int getArtikel_id() {
        return artikel_id;
    }

    /**
     * @param artikel_id the artikel_id to set
     */
    public void setArtikel_id(int artikel_id) {
        this.artikel_id = artikel_id;
    }

    /**
     * @return the artikel_aantal
     */
    public int getArtikel_aantal() {
        return artikel_aantal;
    }

    /**
     * @param artikel_aantal the artikel_aantal to set
     */
    public void setArtikel_aantal(int artikel_aantal) {
        this.artikel_aantal = artikel_aantal;
    }
    
    
    
    
    
    
}
