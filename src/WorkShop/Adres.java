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
public class Adres {
    
    private int adresId;
    private String straatNaam;
    private String postCode;
    private String toevoeging;
    private int huisNummer;
    private String woonPlaats;
    
    public Adres(AdresBuilder adresBuilder){
        this.adresId = adresBuilder.adresId;
        this.straatNaam = adresBuilder.straatNaam;
        this.postCode = adresBuilder.postCode;
        this.toevoeging = adresBuilder.toevoeging;
        this.huisNummer = adresBuilder.huisNummer;
        this.woonPlaats = adresBuilder.woonPlaats;
    }
    
    public Adres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getStraatNaam() {
        return straatNaam;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getToevoeging() {
        return toevoeging;
    }

    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    public int getHuisNummer() {
        return huisNummer;
    }
    
    public String getWoonPlaats() {
        return woonPlaats;
    }

    
    public static class AdresBuilder {
        private int adresId;
        private String straatNaam;
        private String postCode;
        private String toevoeging;
        private int huisNummer;
        private String woonPlaats;       
    
        public AdresBuilder(){
        }
        
        public AdresBuilder adresId(int adresId){
            this.adresId = adresId;
                return this;
        }
        
        public AdresBuilder straatNaam(String straatNaam){
           this.straatNaam = straatNaam;
            return this; 
        }
        
        public AdresBuilder postCode (String postCode){
            this.postCode = postCode;
                return this;        
        }
        
        public AdresBuilder toevoeging (String toevoeging){
            this.toevoeging = toevoeging; 
                return this; 
        }
        
        public AdresBuilder huisnummer (int huisNummer){
            this.huisNummer = huisNummer;
                return this;
        }
        
        public AdresBuilder woonPlaats (String woonPlaats){
            this.woonPlaats = woonPlaats;
                return this;
        }
        
        public Adres build (){
            return new Adres (this);
        }
    }
}
