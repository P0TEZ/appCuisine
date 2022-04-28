package app.screen.entity;

import java.util.*;

import app.carte.entity.*;
import app.Data;

public class BarmanScreen {
    String personnelId;
    
    public BarmanScreen() {
        this.personnelId = this.askId();
    }

    private String askId(){
        
        /*scanner get serveur id*/
        System.out.println("\"-1\" : quitter");
        System.out.println("Id du barman : ");
        Scanner scanner = new Scanner(System.in);
        
        String personnelId = scanner.nextLine();
        
        /*convert lowercase string to huppercase string*/
        personnelId = personnelId.toUpperCase();
        if(personnelId.equals("-1")){
            scanner.close();
            Printer.displayMenu();
        }
        if(Data.barmanList.containsKey(personnelId)){ 
            return personnelId;
            
        }else{
            System.out.println("Le barman n'est pas dans la liste.");
            this.askId();
            return null;
        }
        
    }

    public void openBarmanMenu(){
        System.out.println("Bienvenue sur l'ecran barman");
        this.displayDrinkOrders();
    }

    private void displayDrinkOrders(){
        System.out.println("A prepare : ");    

    }

{
        
    }
}
