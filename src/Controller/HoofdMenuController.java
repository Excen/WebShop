/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.HoofdMenuView;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Excen
 */
public class HoofdMenuController implements ControllerInterface {
    Scanner scanner = new Scanner(System.in);
    int userInput;
    
    // beginpunt
    public void start(){
        HoofdMenuView startView = new HoofdMenuView();
        int userInput = startView.startVraag();
        if (userInput == 1){
            System.out.println("Optie 1");
        }
        else if (userInput == 2){
            System.out.println("Optie 2");
        }
        else if (userInput == 3){
            System.out.println("EMEEERGEENNNCCYYYY");
        }
    }
    
    
    
    
    @Override
    public boolean doesKlantExist(int klant_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
