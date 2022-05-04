package app.screen.entity;

import java.util.*;

import app.carte.entity.*;
import app.client.entity.*;
import app.*;

public class BarmanScreen {
    String personnelId;
    
    public BarmanScreen() {
        if(!Data.getIsRestaurantOpen()) {
            System.out.println("En attente de l'ouverture du restaurant...");
            Printer.enterToContinue();
            Printer.displayMenu();
        }else{
            this.personnelId = this.askId();
        }
    }
    
    private String askId(){
        Printer.clearConsole();

        System.out.println("------------------------------------------");
        System.out.println("Connexion barman");
        System.out.println("------------------------------------------");    
            
        /*scanner get serveur id*/
        System.out.println("\"-1\" : quitter");
        System.out.println("Id du barman : ");
        
        String personnelId = Scan.sc.nextLine();
        
        /*convert lowercase string to huppercase string*/
        personnelId = personnelId.toUpperCase();
        if(personnelId.equals("-1")){
            Printer.displayMenu();
            return null;
        }
        if(Data.barmanList.containsKey(personnelId)){ 
            if(Data.barmanList.get(personnelId).getIsEnService()){
                return personnelId;
            }else{
                System.out.println("\nLe serveur n'est pas en service.");
                Printer.enterToContinue();

                this.askId();
                return null;
            }
            
        }else{
            System.out.println("\nLe barman n'est pas dans la liste.");
            Printer.enterToContinue();

            this.askId();
            return null;
        }
        
    }
    
    public void openBarmanMenu(){
        this.displayDrinkOrders();
    }
    
    private void displayDrinkOrders(){
        Printer.clearConsole();
        
        System.out.println("------------------------------------------");
        System.out.println("Bienvenue sur l'ecran barman");
        System.out.println("------------------------------------------");

        System.out.println("Commandes à préparer : ");    
        int nbCommande =0;
        /*print every drinklist from every commande in every table*/
        for (Table table : Data.tableList.values()) {
            if(table.getCommande().getDrinkState() == 1){
                System.out.println("\n\t"+table.getId() + " : Table n°" +table.getId());
                Commande commande = table.getCommande();
                System.out.println("\t\t" + commande.getBoissonMap().size() + " boissons à préparer.");   
                nbCommande+=1;  
            }  
        }
        if(nbCommande == 0){
            System.out.println("\n\tAucune commande a preparer...");    
        }

        System.out.println("\nChoisissez une commande (-1 pour retour) : ");
        int choixCommande = Scan.sc.nextInt();
Scan.sc.nextLine(); 

        if(choixCommande == -1){
            System.out.println("Retour");
            Printer.displayMenu();
        }
        else if(Data.tableList.containsKey(choixCommande)){
            if(Data.tableList.get(choixCommande).getCommande().getDrinkState() == 1){
                this.displayOrder(choixCommande);
            }
            else{
                System.out.println("Cette table n'a pas de commande en cours.");
            }
        }
        else{
            System.out.println("La commande n'existe pas.");
        }
        Printer.enterToContinue();

        this.displayDrinkOrders();
    }

    private void displayOrder(int tableId){
        Printer.clearConsole();

        System.out.println("------------------------------------------");
        System.out.println("Commande n°" + tableId + " : ");
        System.out.println("------------------------------------------");

        Commande commande = Data.tableList.get(tableId).getCommande();
        commande.printDrinkList();
        
        System.out.println("Valider la commande (v/-1) : ");
        String validate = Scan.sc.nextLine();

        switch (validate){
            case "-1":
                this.displayDrinkOrders();
                break;
            case "v" :
                Data.tableList.get(tableId).getCommande().setDrinkState(2);
                System.out.println("Votre commande est terminée");
                Printer.enterToContinue();

                this.displayDrinkOrders();
                break;
            default:
                System.out.println("Choix non reconnu");
                Printer.enterToContinue();

                this.displayOrder(tableId);
                break;
        }


    }
    
}
