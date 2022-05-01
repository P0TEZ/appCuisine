package app.screen.entity;

import java.util.*;

import app.carte.entity.*;
import app.client.entity.*;
import app.Data;

public class CuisinierScreen {
    String personnelId;
    
    public CuisinierScreen() {
        this.personnelId = this.askId();
    }
    
    private String askId(){
        System.out.println("------------------------------------------");
        
        /*scanner get serveur id*/
        System.out.println("\"-1\" : quitter");
        System.out.println("Id du cuisinier : ");
        Scanner scanner = new Scanner(System.in);
        
        String personnelId = scanner.nextLine();
        
        /*convert lowercase string to huppercase string*/
        personnelId = personnelId.toUpperCase();
        if(personnelId.equals("-1")){
            Printer.displayMenu();
        }
        if(Data.cuisinierList.containsKey(personnelId)){ 
            return personnelId;
            
        }else{
            System.out.println("Le cuisinier n'est pas dans la liste.");
            this.askId();
            return null;
        }
        
    }
    
    public void openCuisinierMenu(){
        System.out.println("------------------------------------------");

        System.out.println("Bienvenue sur l'ecran cuisine");
        this.displayFoodOrders();
    }
    
    private void displayFoodOrders(){
        System.out.println("------------------------------------------");

        System.out.println("Commandes à préparer : ");    
        int nbCommande =0;
        /*print every drinklist from every commande in every table*/
        for (Table table : Data.tableList.values()) {
            if(table.getCommande().getFoodState() == 1){
                System.out.println("\n\t"+table.getId() + " : Table n°" +table.getId());
                Commande commande = table.getCommande();
                System.out.println("\t\t" + commande.getPlatMap().size() + " plats à préparer.");   
                nbCommande+=1;  
            }  
        }
        if(nbCommande == 0){
            System.out.println("\n\tAucune commande a preparer...");    
        }

        System.out.println("\nChoisissez une commande (-1 pour retour) : ");
        Scanner scanner = new Scanner(System.in);
        int choixCommande = scanner.nextInt();

        if(choixCommande == -1){
            System.out.println("Retour");
            Printer.displayMenu();
        }
        else if(Data.tableList.containsKey(choixCommande)){
            if(Data.tableList.get(choixCommande).getCommande().getFoodState() == 1){
                this.displayOrder(choixCommande);
            }
            else{
                System.out.println("Cette table n'a pas de commande en cours.");
            }
        }
        else{
            System.out.println("La commande n'existe pas.");
        }
        this.displayFoodOrders();
    }

    private void displayOrder(int tableId){
        System.out.println("------------------------------------------");

        System.out.println("Commande n°" + tableId + " : ");
        Commande commande = Data.tableList.get(tableId).getCommande();
        commande.printFoodList();
        
        System.out.println("Valider la commande (v/-1) : ");
        Scanner scanner = new Scanner(System.in);
        String validate = scanner.nextLine();

        switch (validate){
            case "-1":
                this.displayFoodOrders();
                break;
            case "v" :
                Data.tableList.get(tableId).getCommande().setFoodState(2);
                System.out.println("Votre commande est terminée");
                this.displayFoodOrders();
                break;
            default:
                System.out.println("Choix non reconnu");
                this.displayOrder(tableId);
                break;
        }


    }
    
    
    
    
}
