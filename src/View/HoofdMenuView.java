/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Anne
 */
public class HoofdMenuView {
    int userInput;
    Scanner scanner = new Scanner(System.in);
    
    
    // Eerste instantie van wat de console te zien krijgt. Keuzes in dit menu bepalen welke andere controllers
    // (en dus views) aangesproken gaan worden.
    
    public int startVraag(){
        boolean checker = true;
        
        do {
        System.out.println("Welkom");
        System.out.println("Maak een keuze:");
        System.out.println("1 Webshop gebruiker.");
        System.out.println("2 Webshop eigenaar");
        System.out.println("3 EMERGENCY SHUTDOWN");
        
        try{
        userInput = scanner.nextInt(); 
        checker = false;
        
        } catch (InputMismatchException ex){
            System.out.print("Foute input, kies van de opties hierboven.");
            scanner.nextLine();
        }
         
        } while (checker);
        
        return userInput;
    }
    
    
    
    
}
