package app.screen.entity;

import java.util.*;

import app.client.entity.*;
import app.carte.entity.*;
import app.*;

public class ServeurScreen{
    
    String personnelId;
    
    public ServeurScreen() {
        this.personnelId = this.askId();
    }
    
    private String askId(){
        System.out.println("------------------------------------------");
        
        /*scanner get serveur id*/
        System.out.println("\"-1\" : quitter");
        System.out.println("Id du serveur : ");
        
        String personnelId = Scan.sc.nextLine();
        
        /*convert lowercase string to huppercase string*/
        personnelId = personnelId.toUpperCase();
        if(personnelId.equals("-1")){
            Printer.displayMenu();
            return null;
        }
        else if(Data.serveurList.containsKey(personnelId)){ 
            if(Data.serveurList.get(personnelId).getIsEnService()){
                return personnelId;
            }else{
                System.out.println("\nLe serveur n'est pas en service.");
                this.askId();
                return null;
            }
            
        }else{
            System.out.println("\nLe serveur n'est pas dans la liste.");
            askId();
            return null;
        }
        
    }
    
    public void openServeurMenu(){
        System.out.println("------------------------------------------");
        
        System.out.println("Bienvenue sur l'ecran serveur");
        this.displayTables();
    }
    
    private void displayTables(){
        System.out.println("------------------------------------------");
        
        System.out.println("Vos tables : ");
        
        Map<Integer, Table> serveurTableMap = Data.serveurList.get(this.personnelId)
                                                              .getTableMap();
        
        if(serveurTableMap.size() != 0){
            for (Table table : serveurTableMap.values()) {
                System.out.println("\t" + table.getId() + " : Table n°" + table.getId());
            }
        }
        System.out.println("\t" + "0 : Ouvrir une nouvelle Table");    
        
        System.out.println("\t" + "-1 : Retour"); 
        
        int choix = Scan.sc.nextInt();
        //int choix = 0;
        if(choix == -1){
            System.out.println("Retour");
            Printer.displayMenu();
        }else 
        if(choix == 0){
            this.openNewTable();
        }else{
            if(serveurTableMap.containsKey(choix)){
                this.tableMenu(choix);
            }else{
                this.displayTables();
            }
        }
        
    }
    
    private void openNewTable(){
        System.out.println("------------------------------------------");
        
        System.out.println("Veuillez entrer le numero de la table ou \"-1\" pour annuler : ");
        int idTable = Scan.sc.nextInt();
        
        //scanner.close();
        if(idTable == -1){
            this.displayTables();
        }
        /*verif if table id already exist*/
        if(Data.tableList.containsKey(idTable)){
            if(Data.tableList.get(idTable).getStatus() == 0){
                
                Data.serveurList.get(this.personnelId)
                                .addTable(idTable);
                
                this.tableMenu(idTable);
            }
            else{
                System.out.println("La table est deja occupee.");
            }
        }
        else{
            System.out.println("La table n'existe pas.");
        }
        this.openNewTable();       
        
    }
    
    private void tableMenu(int tableId){
        System.out.println("------------------------------------------");
        
        System.out.println("Vous avez choisi la table n°" + tableId);
        System.out.println("\t" + "1 : Ajouter/modifier la commande");
        System.out.println("\t" + "2 : Fermer la table");
        System.out.println("\t" + "3 : Afficher la commande acutelle");
        System.out.println("\t" + "-1 : Retour");
        
        int choix = Scan.sc.nextInt();
        
        switch (choix) {
            case 1:
            this.newCommandeMenu(tableId);
            break;
            case 2:
            this.closeTable(tableId);
            break;
            case 3:
            this.showCommande(tableId);
            break;
            case -1:
            this.displayTables();
            break;
            default:
            System.out.println("Choix non reconnu");
            tableMenu(tableId);
            break;
        }
        //scanner.close();
    }
    
    private void newCommandeMenu(int tableId){
        System.out.println("------------------------------------------");
        
        System.out.println("\t1 : Nourriture");
        System.out.println("\t2 : Boissons");
        System.out.println("\t-1 : Retour");
        
        int choix = Scan.sc.nextInt();
        
        switch (choix) {
            case 1:
            this.foodMenu(tableId);
            break;
            case 2:
            this.drinkMenu(tableId);
            break;
            case -1:
            this.tableMenu(tableId);
            break;
            default:
            System.out.println("Choix non reconnu");
            newCommandeMenu(tableId);
            break;
        }
    }
    private void foodMenu(int tableId){
        System.out.println("------------------------------------------");
        
        System.out.print("\033[H\033[2J");
        
        System.out.println("Plats :");
        for (Map.Entry<String, Food> entry : Data.foodList.entrySet()) {
            if(entry.getValue().isAvailable()){
                System.out.println("\t"+entry.getKey()+" a "+entry.getValue().getPrice()+" euros");
            }
        }
        System.out.println("tapez \"-1\" pour arreter la prise de commande et retourner au menu");
        
        String choix = Scan.sc.nextLine();
        if(choix.equals("-1")){
            this.newCommandeMenu(tableId);
        }else{
            if(Data.foodList.containsKey(choix) && Data.foodList.get(choix).isAvailable()){
                Food foodChoice = Data.foodList.get(choix);
                Data.tableList.get(tableId)
                              .getCommande()
                              .addPlat(foodChoice);

                Stock.useFoodIngredient(foodChoice);
                
                System.out.println("Vous avez ajouté : "+foodChoice.getName());
            }
            else{
                System.out.println("Plat non reconnu");
            }
            this.foodMenu(tableId);
        }
    }
    
    private void drinkMenu(int tableId){
        System.out.println("------------------------------------------");
        
        System.out.println("Boissons :");
        for (Map.Entry<String, Drink> entry : Data.drinkList.entrySet()) {
            System.out.println("\t"+entry.getKey()+" a "+entry.getValue().getPrice()+" euros");
        }
        System.out.println("tapez \"-1\" pour arreter la prise de commande et retourner au menu");
        
        String choix = Scan.sc.nextLine();
        if(choix.equals("-1")){
            this.newCommandeMenu(tableId);
        }else{
            if(Data.drinkList.containsKey(choix) && Data.drinkList.get(choix).isAvailable()){
                Drink drinkChoice = Data.drinkList.get(choix);
                
                Data.tableList.get(tableId)
                              .getCommande()
                              .addBoisson(drinkChoice);
                
                Stock.useIngredient(drinkChoice.getName(), 1);

                System.out.println("Vous avez ajouté : "+drinkChoice.getName());
            }
            else{
                System.out.println("Boisson non reconnu");
            }
            this.drinkMenu(tableId);
        }
    }    
    
    private void closeTable(int tableId){
        System.out.println("------------------------------------------");
        
        if(Data.tableList.containsKey(tableId)){
            if(Data.tableList.get(tableId)
                             .getStatus() == 1){
                if(Data.serveurList.get(this.personnelId)
                                   .getTableMap()
                                   .containsKey(tableId)){
                    
                    System.out.println("L'addition est de: " + Data.tableList.get(tableId).getCommande().getTotalPrice() + " euros");
                    Data.tableList.get(tableId).resetTable();
                    
                    Data.serveurList.get(this.personnelId).removeTable(tableId);
                    System.out.println("La table a ete fermee.");
                    
                    this.displayTables();
                }
                else{
                    System.out.println("La table n'est pas ouverte par le serveur.");
                    this.displayTables();
                }
                
            }
        }
    }
    
    private void showCommande(int tableId){
        System.out.println("------------------------------------------");
        
        Data.serveurList.get(this.personnelId)
                        .getTableMap()
                        .get(tableId)
                        .getCommande()
                        .printCommande();
        
        int tmpCommandeState = Data.serveurList.get(this.personnelId)
                                               .getTableMap()
                                               .get(tableId)
                                               .getCommande()
                                               .getCommandeState();
        
        if(tmpCommandeState == 0){
            System.out.println("\t" + "0 : Valider/envoyer la commande");
        }
        
        if(tmpCommandeState == 1){
            System.out.println("Cette commande est en cours de préparation...");
        }
        
        if(tmpCommandeState == 2){
            System.out.println("\t" + "0 : Valider le service de la commande");
        }
        
        if(tmpCommandeState == 3){
            System.out.println("\t" + "0 : Fermer la table");
        }
        
        System.out.println("\t" + "-1 : Retour");
        
        String choix = Scan.sc.nextLine();
        
        switch (choix) {
            case "0" : 
            switch(tmpCommandeState){
                case 0:
                Data.tableList.get(tableId).getCommande().sendCommande();
                this.showCommande(tableId);
                break;
                case 2:
                Data.tableList.get(tableId).getCommande().serveCommande();
                this.showCommande(tableId);
                
                break;
                case 3:
                this.closeTable(tableId);
                break;
                default:
                this.showCommande(tableId);
                break;
                
            }
            this.tableMenu(tableId);
            break;
            case "-1":
            this.tableMenu(tableId);
            break;
            default:
            this.showCommande(tableId);
            break;
        }
    }
}
