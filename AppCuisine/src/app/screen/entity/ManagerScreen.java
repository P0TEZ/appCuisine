package app.screen.entity;

import java.util.*;

import app.carte.entity.*;
import app.client.entity.*;
import app.*;

public class ManagerScreen {
    String personnelId;
    
    public ManagerScreen() {
        this.personnelId = this.askId();
    }
    
    private String askId(){
        System.out.println("------------------------------------------");
        
        /*scanner get serveur id*/
        System.out.println("\"-1\" : quitter");
        System.out.println("Id du manager : ");
        
        String personnelId = Scan.sc.nextLine();
        
        /*convert lowercase string to huppercase string*/
        personnelId = personnelId.toUpperCase();
        if(personnelId.equals("-1")){
            Printer.displayMenu();
        }
        if(Data.managerList.containsKey(personnelId)){ 
            return personnelId;
            
        }else{
            System.out.println("Le manager n'est pas dans la liste.");
            this.askId();
            return null;
        }
        
    }
    
    public void openManagerMenu(){
        System.out.println("------------------------------------------");
        
        System.out.println("Bienvenue sur l'ecran manager");
        this.displayManagerMenu();
    }
    
    private void displayManagerMenu(){
        System.out.println("------------------------------------------");
        System.out.println("\t1 : Gérer les stocks");
        System.out.println("\t2 : Afficher toutes les commandes en cours");
        System.out.println("\t3 : Gerer le personnel");
        System.out.println("\t-1 : Retour");
        
        int choixMenu = Scan.sc.nextInt();
        
        switch (choixMenu) {
            case 1:
            this.openStockManager();
            break;
            case 2:
            this.displayAllCommandes();
            break;
            case 3:
            //this.openPersonnelManager();
            break;
            case -1:
            Printer.displayMenu();
            break;
            default:
            System.out.println("Choix invalide");
            this.displayManagerMenu();
            break;
        }
        
    }
    
    private void openStockManager(){
        System.out.println("------------------------------------------");
        System.out.println("Stock actuel : ");
        for (Map.Entry<String, Integer> entry : Stock.getStock().entrySet()) {
            System.out.println("\t" + entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("\t-1 : Retour");
        
        
        String choixIngredient = Scan.sc.nextLine();
        
        if(choixIngredient.equals("-1")){
            this.displayManagerMenu();
        }
        else if(Stock.getStock().containsKey(choixIngredient)){
            this.ingredientMenu(choixIngredient);
        }
        else{
            this.openStockManager();
        }
        
    }
    private void ingredientMenu(String ingredientName){
        System.out.println("------------------------------------------");
        System.out.println("Ingredient : "+ingredientName+" : ");
        System.out.println("\t1 : Ajouter aux stocks");
        System.out.println("\t2 : Retirer aux stocks");
        System.out.println("\t3 : Supprimer des stocks ");
        System.out.println("\t-1 : Retour");
        
        
        int choixMenu = Scan.sc.nextInt();
        
        switch(choixMenu){
            case 1:
            this.manageStock(true, ingredientName);
            break;
            case 2:
            this.manageStock(false, ingredientName);
            break;
            case 3:
            Stock.removeIngredient(ingredientName);
            this.openManagerMenu();
            break;
            case -1:
            this.openStockManager();
            break;
            default:
            System.out.println("Choix invalide");
            this.ingredientMenu(ingredientName);
            break;
        }
        
        this.ingredientMenu(ingredientName);               
    }
    
    
    private void manageStock(Boolean type, String ingredientName){
        System.out.println("\tQuantité à " + (type ? "ajouter" : "retirer") + " : ");

        int amount = Scan.sc.nextInt();
        if(type){
            Stock.addIngredient(ingredientName,amount);
        }
        else{
            Stock.useIngredient(ingredientName, amount);
        }
        this.openStockManager();
    }
    
    
    private void displayAllCommandes(){
        System.out.println("------------------------------------------");
        System.out.println("Toutes les commandes en cours : ");
        
        
        /** for every table in tableList*/
        for (Table table : Data.tableList.values()) {
            if(table.getCommande().getFoodState() == 1){
                System.out.println("\n\tTable n°" +table.getId());
                Commande commande = table.getCommande();
                System.out.println("\t\t" + commande.getPlatMap().size() + " plats à préparer.");   
                System.out.println("\t\t" + commande.getBoissonMap().size() + " boissons à préparer.");   
            }  
        }
    }
    
    
    private void openPersonnelManager(){
    }
    
    
    
    
    
    
    
    
}
