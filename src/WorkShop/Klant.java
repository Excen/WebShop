package WorkShop;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Excen
 */
public class Klant {
    private int klantId;
    private String voorNaam;
    private String achterNaam;
    private String tussenVoegsel;
    private String email;
    private Adres adres;
    



public Klant (int klantId, String voorNaam, String achterNaam, 
        String tussenVoegsel, String email, Adres adres){
     this.klantId = klantId;
     this.voorNaam = voorNaam;
     this.achterNaam = achterNaam; 
     this.tussenVoegsel = tussenVoegsel;
     this.email = email;
     // adres = new Adres();

}
}