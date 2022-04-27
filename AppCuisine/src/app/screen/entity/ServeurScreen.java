package app.screen.entity;

import java.util.*;

import app.client.entity.*;
import app.carte.entity.*;
import app.Data;

public class ServeurScreen {
    
    String serveurId;
    
    public ServeurScreen() {
        this.serveurId = this.askId();
    }
    
    private String askId(){
        
        /*scanner get serveur id*/
        System.out.println("Id du serveur : ");
        Scanner scanner = new Scanner(System.in);
        
        String serveurId = scanner.nextLine();
        
        /*convert lowercase string to huppercase string*/
        serveurId = serveurId.toUpperCase();
        
        if(Data.serveurList.containsKey(serveurId)){ 
            return serveurId;
            
        }else{
            System.out.println("Le serveur n'est pas dans la liste.");
            askId();
            return null;
        }
        
    }
    
    public void openServeurMenu(){
        System.out.println("Bienvenue sur l'ecran serveur");
        this.displayTables();
    }
    
    private void displayTables(){
        System.out.println("0 : Ouvrir une nouvelle Table");    
        
        Map<Integer, Table> serveurTableMap = Data.serveurList.get(this.serveurId).getTableMap();
        
        if(serveurTableMap.size() != 0){
            System.out.println("Vos tables ouvertes : ");
            for (Table table : serveurTableMap.values()) {
                System.out.println(table.getId() + " : Table n°" + table.getId());
            }
        }
        
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        //int choix = 0;
        
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
        System.out.println("Veuillez entrer le numero de la table : ");
        Scanner scanner = new Scanner(System.in);
        int idTable = scanner.nextInt();
        
        //scanner.close();
        
        /*verif if table id already exist*/
        if(Data.tableList.containsKey(idTable)){
            if(Data.tableList.get(idTable).getStatus() == 0){
                
                Data.tableList.get(idTable).setStatus(1);
                Table table = Data.tableList.get(idTable);
                
                Data.serveurList.get(this.serveurId).addTable(table);
                
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
        System.out.println("Vous avez choisi la table n°" + tableId);
        System.out.println("1 : Ouvrir une nouvelle commande");
        System.out.println("2 : Fermer la table");
        System.out.println("3 : Retour");
        
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        
        switch (choix) {
            case 1:
            this.newCommandeMenu(tableId);
            break;
            case 2:
            this.closeTable(tableId);
            break;
            case 3:
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
        System.out.println("1 : Nourriture");
        System.out.println("2 : Boissons");
        System.out.println("3 : Retour");
        
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        
        switch (choix) {
            case 1:
            this.foodMenu(tableId);
            break;
            case 2:
            this.drinkMenu(tableId);
            break;
            case 3:
            this.tableMenu(tableId);
            break;
            default:
            System.out.println("Choix non reconnu");
            newCommandeMenu(tableId);
            break;
        }
    }
    private void foodMenu(int tableId){
        System.out.print("\033[H\033[2J");

        System.out.println("Plats :");
        for (Map.Entry<String, Food> entry : Data.foodList.entrySet()) {
            System.out.println("\t"+entry.getKey()+" a "+entry.getValue().getPrice()+" euros");
        }

        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();

        if(Data.foodList.containsKey(choix)){
            Food foodChoice = Data.foodList.get(choix);
            Data.serveurList.get(serveurId).getTableMap().get(tableId).getCommande().addPlat(foodChoice);
        }
    }

    private void drinkMenu(int tableId){
        System.out.println("Boissons :");
        for (Map.Entry<String, Drink> entry : Data.drinkList.entrySet()) {
            System.out.println("\t"+entry.getKey()+" a "+entry.getValue().getPrice()+" euros");
        }
        
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();

        if(Data.drinkList.containsKey(choix)){
            Drink drinkChoice = Data.drinkList.get(choix);
            Data.serveurList.get(serveurId).getTableMap().get(tableId).getCommande().addBoisson(drinkChoice);
        }
    }    
    
    private void closeTable(int tableId){
        if(Data.tableList.containsKey(tableId)){
            if(Data.tableList.get(tableId).getStatus() == 1){
                if(Data.serveurList.get(this.serveurId).getTableMap().containsKey(tableId)){
                
                    System.out.println("L'addition est de:" + Data.tableList.get(tableId).getCommande().getTotalPrice());
                    Data.tableList.get(tableId).setStatus(0);
                    Data.serveurList.get(this.serveurId).removeTable(tableId);
                    System.out.println("La table a ete fermee.");
                }
                else{
                    System.out.println("La table n'est pas ouverte par le serveur.");
                }
                
            }
        }
    }
}
        