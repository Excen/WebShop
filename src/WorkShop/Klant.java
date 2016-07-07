package WorkShop;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wendy
 */
public class Klant {
    private final int klantId;
    private final String voorNaam;
    private final String achterNaam;
    private final String tussenVoegsel;
    private final String email;
    private final Adres adres;
    
    public Klant (KlantBuilder builder){
        this.klantId = builder.klantId;
        this.voorNaam = builder.voorNaam;
        this.achterNaam = builder.achterNaam; 
        this.tussenVoegsel = builder.tussenVoegsel;
        this.email = builder.email;
        this.adres = new Adres();
    }

    public int getKlantId() {
        return klantId;
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public String getTussenVoegsel() {
        return tussenVoegsel;
    }

    public String getEmail() {
        return email;
    }

    public Adres getAdres() {
        return adres;
    }

    public static class KlantBuilder {
        private int klantId;
        private String voorNaam;
        private String achterNaam;
        private String tussenVoegsel;
        private String email;
        private Adres adres;
    
        public KlantBuilder(){
        }
        
        public KlantBuilder klantId(int klantId){
            this.klantId = klantId;
                return this;
        }
    
        public KlantBuilder voorNaam(String voorNaam){
            this.voorNaam = voorNaam;
                return this;
        }
        
        public KlantBuilder achterNaam(String achterNaam){
            this.achterNaam = achterNaam;
                return this;
        }
        
        public KlantBuilder tussenVoegsel(String tussenVoegsel){
            this.tussenVoegsel = tussenVoegsel;
                return this;
        }
        
        public KlantBuilder email(String email){
            this.email = email;
                return this;
        }
        public KlantBuilder adres(Adres adres){
            // adres = new Adres();
            this.adres = adres;
                return this;
        }
        
        public Klant build(){
            return new Klant(this);
        }
        
        //setters
        public void setKlantId(int klantId) {
            this.klantId = klantId;
        }

        public void setVoorNaam(String voorNaam) {
            this.voorNaam = voorNaam;
        }

        public void setAchterNaam(String achterNaam) {
            this.achterNaam = achterNaam;
        }

        public void setTussenVoegsel(String tussenVoegsel) {
            this.tussenVoegsel = tussenVoegsel;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAdres(Adres adres) {
            this.adres = adres;
        }

}
}