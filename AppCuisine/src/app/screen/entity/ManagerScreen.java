package app.screen.entity;

import java.util.*;

import app.carte.entity.*;
import app.client.entity.*;
import app.personnel.entity.*;
import app.*;

public class ManagerScreen {
    String personnelId;
    
    public ManagerScreen() {
        this.personnelId = this.askId();
    }
    
    private String askId(){
        Printer.clearConsole();
        
        System.out.println("------------------------------------------");
        System.out.println("Connexion manager");
        System.out.println("------------------------------------------");
        
        /*scanner get serveur id*/
        System.out.println("\"-1\" : quitter");
        System.out.println("Id du manager : ");
        
        String personnelId = (String)(Scan.sc.nextLine());
        
        /*convert lowercase string to huppercase string*/
        personnelId = personnelId.toUpperCase();
        if(personnelId.equals("-1")){
            Printer.displayMenu();
            return null;
        }
        if(Data.managerList.containsKey(personnelId)){ 
            return personnelId;
            
        }else{
            System.out.println("\nLe manager n'est pas dans la liste.");
            Printer.enterToContinue();
            
            this.askId();
            return null;
        }
        
    }
    
    public void openManagerMenu(){
        this.displayManagerMenu();
    }
    
    private void displayManagerMenu(){
        Printer.clearConsole();
        
        System.out.println("------------------------------------------");
        System.out.println("Bienvenue sur l'ecran manager");
        System.out.println("------------------------------------------");
        
        System.out.println("\t1 : Gérer les stocks");
        System.out.println("\t2 : Afficher toutes les commandes en cours");
        System.out.println("\t3 : Gerer le personnel");
        System.out.println("\t4 : Ouvrir le restaurant");
        System.out.println("\t5 : Fermer le restaurant (sauvegarde)");
        System.out.println("\t-1 : Retour");
        
        int choixMenu = Scan.sc.nextInt();
        Scan.sc.nextLine(); 
        
        switch (choixMenu) {
            case 1:
            this.openStockManager();
            break;
            case 2:
            this.displayAllCommandes();
            break;
            case 3:
            this.openPersonnelManager();
            break;
            case 4:
            this.openRestaurant();
            break;
            case 5:
            Saver.saveAll();
            System.exit(0);
            break;

            case -1:
            Printer.displayMenu();
            break;
            default:
            System.out.println("Choix invalide");
            Printer.enterToContinue();
            
            this.displayManagerMenu();
            break;
        }
        
    }
    
    private void openStockManager(){
        Printer.clearConsole();
        
        System.out.println("------------------------------------------");
        System.out.println("Stock actuel : ");
        System.out.println("------------------------------------------");
        
        for (Map.Entry<String, Integer> entry : Stock.getStock().entrySet()) {
            System.out.println("\t" + entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("\t-1 : Retour ou ecrivez le nom d'un ingredient");
        
        
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
        Printer.clearConsole();
        
        System.out.println("------------------------------------------");
        System.out.println("Ingredient : "+ingredientName+" : ");
        System.out.println("------------------------------------------");
        
        System.out.println("\t1 : Ajouter aux stocks");
        System.out.println("\t2 : Retirer aux stocks");
        System.out.println("\t3 : Supprimer des stocks ");
        System.out.println("\t-1 : Retour");
        
        
        int choixMenu = Scan.sc.nextInt();
        Scan.sc.nextLine(); 
        
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
        Scan.sc.nextLine(); 
        if(type){
            Stock.addIngredient(ingredientName,amount);
        }
        else{
            Stock.useIngredient(ingredientName, amount);
        }
        this.openStockManager();
    }
    
    private void displayAllCommandes(){
        Printer.clearConsole();
        
        System.out.println("------------------------------------------");
        System.out.println("Toutes les commandes en cours : ");
        System.out.println("------------------------------------------");
        
        int totalFood = 0;
        int totalDrink = 0;
        
        /** for every table in tableList*/
        for (Table table : Data.tableList.values()) {
            if(table.getCommande().getFoodState() == 1){
                System.out.println("\n\tTable n°" +table.getId());
                Commande commande = table.getCommande();
                System.out.println("\t\t" + commande.getPlatMap().size() + " plats à préparer.");   
                System.out.println("\t\t" + commande.getBoissonMap().size() + " boissons à préparer.");   
                totalFood += commande.getPlatMap().size();
                totalDrink += commande.getBoissonMap().size();
            }  
        }
        System.out.println("\n" + totalFood + " plats à préparer au total.");   
        System.out.println(totalDrink + " boissons à préparer au total.\n(-1) Pour retour : "); 
        int choix = Scan.sc.nextInt();
        Scan.sc.nextLine(); 
        if(choix == -1){
            this.displayManagerMenu();
        }
        else{
            displayAllCommandes();
        }
        displayAllCommandes();
    }
    
    private void openPersonnelManager(){
        Printer.clearConsole();
        
        System.out.println("------------------------------------------");
        System.out.println("Liste de tout les personnels : ");
        System.out.println("------------------------------------------");
        
        
        System.out.println("\tServeurs : (id) : (nom prenom) : (salaire) : (en service)");
        for (Map.Entry<String, Serveur> entry : Data.serveurList.entrySet()) {
            System.out.println("\t\t" + entry.getValue().getId() + " : " + entry.getValue().getNom() + " " + entry.getValue().getPrenom()+ "\t: " + entry.getValue().getSalaire() + "\t: " + (entry.getValue().getIsEnService()?"Oui":"Non"));
        }
        
        System.out.println("\n\tCuisinier : (id) : (nom prenom) : (salaire) : (en service)");
        for (Map.Entry<String, Cuisinier> entry : Data.cuisinierList.entrySet()) {
            System.out.println("\t\t" + entry.getValue().getId() + " : " + entry.getValue().getNom() + " " + entry.getValue().getPrenom()+ "\t: " + entry.getValue().getSalaire() + "\t: " + (entry.getValue().getIsEnService()?"Oui":"Non"));
        }
        
        System.out.println("\n\tBarman : (id) : (nom prenom) : (salaire) : (en service)");
        for (Map.Entry<String, Barman> entry : Data.barmanList.entrySet()) {
            System.out.println("\t\t" + entry.getValue().getId() + " : " + entry.getValue().getNom() + " " + entry.getValue().getPrenom()+ "\t: " + entry.getValue().getSalaire() + "\t: " + (entry.getValue().getIsEnService()?"Oui":"Non"));
        }
        
        System.out.println("Entrer l'id d'un personnel ou tapez 'ajout' pour créer un personnel (-1 pour retour): ");
        String choixPers = Scan.sc.nextLine();
        
        if(choixPers.equals("-1")){
            this.displayManagerMenu();
        }
        else if (choixPers.equals("ajout")){
            this.createNewPersonnel();
        }
        else if(Data.serveurList.containsKey(choixPers.toUpperCase())){
            this.personnelMenu(choixPers, "serveur");
        }
        else if(Data.cuisinierList.containsKey(choixPers.toUpperCase())){
            this.personnelMenu(choixPers, "cuisinier");
        }
        else if(Data.barmanList.containsKey(choixPers.toUpperCase())){
            this.personnelMenu(choixPers, "barman");
        }
        else{
            this.openPersonnelManager();
        } 
        this.openPersonnelManager();
        
    }
    
    private void personnelMenu(String personnel, String type){
        Printer.clearConsole();
        
        System.out.println("------------------------------------------");
        personnel = personnel.toUpperCase();
        String tmpNom="";
        String tmpPrenom="";
        if(type.equals("serveur")){
            tmpNom = Data.serveurList.get(personnel).getNom();
            tmpPrenom = Data.serveurList.get(personnel).getPrenom();
            
        }else if(type.equals("cuisinier")){
            tmpNom = Data.cuisinierList.get(personnel).getNom();
            tmpPrenom = Data.cuisinierList.get(personnel).getPrenom();
        }else if(type.equals("barman")){
            tmpNom = Data.barmanList.get(personnel).getNom();
            tmpPrenom = Data.barmanList.get(personnel).getPrenom();
        }
        System.out.println(type + " : " + tmpNom + " " + tmpPrenom);
        System.out.println("------------------------------------------");
        
        System.out.println("\t1 : Ajouter au planning");
        System.out.println("\t2 : Retirer du planning");
        System.out.println("\t3 : Modifier le salaire");
        System.out.println("\t4 : Supprimer le personnel");
        System.out.println("\t-1 : Retour");
        int choixMenu = Scan.sc.nextInt();
        Scan.sc.nextLine(); 
        
        switch(choixMenu){
            case 1:
            this.addToPlanning(personnel, type);
            break;
            case 2:
            this.removeFromPlanning(personnel, type);
            break;
            case 3:
            this.modifySalaire(personnel, type);
            break;
            case 4:
            this.deletePersonnel(personnel, type);
            break;
            case -1:
            this.openPersonnelManager();
            break;
            default:
            System.out.println("Choix invalide");
            Printer.enterToContinue();
            
            this.personnelMenu(personnel, type);
            break;
        }
        
        this.personnelMenu(personnel, type);               
        
    }
    
    private void addToPlanning(String personnelId,String type)   { 
        System.out.println("------------------------------------------");
        personnelId = personnelId.toUpperCase();
        if(type.equals("serveur")){
            if(Data.serveurList.get(personnelId)
            .getNbJourDeTravailDeSuite()>=2)
            {
                System.out.println("Ce personnel a deja travaille les deux derniers jours, vous ne pouvez pas l'ajouter au planning.");
                System.out.println("------------------------------------------");
                
                Printer.enterToContinue();
                
                this.personnelMenu(personnelId, type);
            }
            Data.serveurList.get(personnelId)
            .setIsEnService(true);
            Data.serveurList.get(personnelId)
            .addNbJourDeTravailDeSuite();
            
            Serveur serveur = Data.serveurList.get(personnelId);            
            System.out.println("Le serveur " + serveur.getNom() + " " + serveur.getPrenom() + " est maintenant en service.");
            
        }
        
        
        else if(type.equals("cuisinier")){
            if(Data.cuisinierList.get(personnelId)
            .getNbJourDeTravailDeSuite()>=2)
            {
                System.out.println("Ce personnel a deja travaille les deux derniers jours, vous ne pouvez pas l'ajouter au planning.");
                System.out.println("------------------------------------------");
                
                Printer.enterToContinue();
                
                this.personnelMenu(personnelId, type);
            }
            Data.cuisinierList.get(personnelId)
            .setIsEnService(true);
            Data.cuisinierList.get(personnelId)
            .addNbJourDeTravailDeSuite();
            
            Cuisinier cuisinier = Data.cuisinierList.get(personnelId);            
            System.out.println("Le cuisinier " + cuisinier.getNom() + " " + cuisinier.getPrenom() + " est maintenant en service.");
            
        }
        
        
        else if(type.equals("barman")){
            if(Data.barmanList.get(personnelId)
            .getNbJourDeTravailDeSuite()>=2)
            {
                System.out.println("Ce personnel a deja travaille les deux derniers jours, vous ne pouvez pas l'ajouter au planning.");
                System.out.println("------------------------------------------");
                
                Printer.enterToContinue();
                
                this.personnelMenu(personnelId, type);
            }
            Data.barmanList.get(personnelId)
            .setIsEnService(true);
            Data.barmanList.get(personnelId)
            .addNbJourDeTravailDeSuite();
            
            
            Barman barman = Data.barmanList.get(personnelId);
            System.out.println("Le barman " + barman.getNom() + " " + barman.getPrenom() + " est maintenant en service.");
            
        }
        
        
        this.openPersonnelManager();
    }
    
    private void removeFromPlanning(String personnelId,String type){
        personnelId = personnelId.toUpperCase();
        
        System.out.println("------------------------------------------");
        
        if(type.equals("serveur")){
            Data.serveurList.get(personnelId).setIsEnService(false);
            
            Serveur serveur = Data.serveurList.get(personnelId);
            System.out.println("Le serveur " + serveur.getNom() + " " + serveur.getPrenom() + " n'est maintenant plus en service.");
            
        }
        else if(type.equals("cuisinier")){
            Data.cuisinierList.get(personnelId).setIsEnService(false);
            
            Cuisinier cuisinier = Data.cuisinierList.get(personnelId);
            System.out.println("Le cuisinier " + cuisinier.getNom() + " " + cuisinier.getPrenom() + " n'est plus maintenant en service.");
            
        }
        else if(type.equals("barman")){
            Data.barmanList.get(personnelId).setIsEnService(false);
            
            Barman barman = Data.barmanList.get(personnelId);
            System.out.println("Le barman " + barman.getNom() + " " + barman.getPrenom() + " n'est maintenant plus en service.");
            
        }       
        
        this.openPersonnelManager();
    }
    
    private void modifySalaire(String personnelId, String type){
        personnelId = personnelId.toUpperCase();
        System.out.println("------------------------------------------");
        System.out.println("Entrer le nouveau salaire : ");
        System.out.println("------------------------------------------");
        
        int salaire = Scan.sc.nextInt();
        Scan.sc.nextLine(); 
        System.out.println("------------------------------------------");
        
        if(type.equals("serveur")){
            Data.serveurList.get(personnelId).setSalaire(salaire);
            Serveur serveur = Data.serveurList.get(personnelId);
            System.out.println("Le salaire du serveur " + serveur.getNom() + " " + serveur.getPrenom() + " a été modifié.");
            Printer.enterToContinue();
            
        }
        else if(type.equals("cuisinier")){
            Data.cuisinierList.get(personnelId).setSalaire(salaire);
            Cuisinier cuisinier = Data.cuisinierList.get(personnelId);
            System.out.println("Le salaire du cuisinier " + cuisinier.getNom() + " " + cuisinier.getPrenom() + " a été modifié.");
            Printer.enterToContinue();
            
        }
        else if(type.equals("barman")){
            Data.barmanList.get(personnelId).setSalaire(salaire);
            Barman barman = Data.barmanList.get(personnelId);
            System.out.println("Le salaire du barman " + barman.getNom() + " " + barman.getPrenom() + " a été modifié.");
            Printer.enterToContinue();
            
        }
        
        this.openPersonnelManager();
        
    }
    
    private void createNewPersonnel(){
        Printer.clearConsole();
        
        System.out.println("------------------------------------------");
        System.out.println("Création de personnel : ");
        System.out.println("------------------------------------------");
        
        System.out.println("Entrer le nom : ");
        String choixNom = Scan.sc.nextLine();
        
        System.out.println("Entrer le prenom : ");
        String choixPrenom = Scan.sc.nextLine();
        
        System.out.println("Entrer le salaire : ");
        Integer choixSal = Scan.sc.nextInt();
        Scan.sc.nextLine(); 
        
        String id = Personnel.generateId();
        
        /*ask for personnel type*/
        System.out.println("------------------------------------------");
        System.out.println("Entrer le type de personnel : \n");
        System.out.println("\t1 : Serveur");
        System.out.println("\t2 : Cuisinier");
        System.out.println("\t3 : Barman");
        int choixType = Scan.sc.nextInt();
        Scan.sc.nextLine(); 
        
        /*ask to valide the new personnel*/
        System.out.println("------------------------------------------");
        System.out.println("Voulez-vous créer le personnel suivant : \n");
        System.out.println("\tNom : " + choixNom);
        System.out.println("\tPrenom : " + choixPrenom);
        System.out.println("\tSalaire : " + choixSal);
        System.out.println("\tType : " + choixType);
        System.out.println("\tID : " + id);
        System.out.println("\n\t1 : Oui");
        System.out.println("\t2 : Non");
        int choixValide = Scan.sc.nextInt();
        Scan.sc.nextLine(); 
        
        if(choixValide == 2){
            this.createNewPersonnel();
        }
        
        switch(choixType){
            case 1:
            Serveur serveur = new Serveur(id.toUpperCase(), choixNom, choixPrenom, choixSal,0);
            Data.serveurList.put(id.toUpperCase(), serveur);
            System.out.println("Le serveur " + serveur.getNom() + " " + serveur.getPrenom() + " a été créé.");
            break;
            case 2:
            Cuisinier cuisinier = new Cuisinier(id.toUpperCase(), choixNom, choixPrenom, choixSal,0);
            Data.cuisinierList.put(id.toUpperCase(), cuisinier);
            System.out.println("Le cuisinier " + cuisinier.getNom() + " " + cuisinier.getPrenom() + " a été créé.");
            break;
            case 3:
            Barman barman = new Barman(id.toUpperCase(), choixNom, choixPrenom, choixSal,0);
            Data.barmanList.put(id.toUpperCase(), barman);
            System.out.println("Le barman " + barman.getNom() + " " + barman.getPrenom() + " a été créé.");
            break;
            default:
            System.out.println("Choix invalide");
            Printer.enterToContinue();
            
            this.createNewPersonnel();
            break;
        }
        
    }
    
    private void deletePersonnel(String personnelId, String type){
        Printer.clearConsole();
        
        personnelId = personnelId.toUpperCase();
        
        System.out.println("------------------------------------------");
        System.out.println("Voulez-vous supprimer le personnel suivant : \n");
        System.out.println("------------------------------------------");
        
        if(type.equals("serveur")){
            System.out.println("\tNom : " + Data.serveurList.get(personnelId).getNom());
            System.out.println("\tPrenom : " + Data.serveurList.get(personnelId).getPrenom());
            System.out.println("\tSalaire : " + Data.serveurList.get(personnelId).getSalaire());
            
        }else if(type.equals("cuisinier")){
            System.out.println("\tNom : " + Data.cuisinierList.get(personnelId).getNom());
            System.out.println("\tPrenom : " + Data.cuisinierList.get(personnelId).getPrenom());
            System.out.println("\tSalaire : " + Data.cuisinierList.get(personnelId).getSalaire());
        }else if(type.equals("barman")){
            System.out.println("\tNom : " + Data.barmanList.get(personnelId).getNom());
            System.out.println("\tPrenom : " + Data.barmanList.get(personnelId).getPrenom());
            System.out.println("\tSalaire : " + Data.barmanList.get(personnelId).getSalaire());
        }
        System.out.println("\tType : " + type);
        System.out.println("\tID : " + personnelId);
        System.out.println("\n\t1 : Oui");
        System.out.println("\t2 : Non");
        int choixValide = Scan.sc.nextInt();
        Scan.sc.nextLine(); 
        
        if(choixValide == 2){
            this.personnelMenu(personnelId, type);
        }
        System.out.println("------------------------------------------");
        switch(type){
            case "serveur":
            System.out.println("Le serveur " + Data.serveurList.get(personnelId).getNom() + " " + Data.serveurList.get(personnelId).getPrenom() + " a été supprimé.");
            Data.serveurList.remove(personnelId);
            break;
            case "cuisinier":
            System.out.println("Le cuisinier " + Data.cuisinierList.get(personnelId).getNom() + " " + Data.cuisinierList.get(personnelId).getPrenom() + " a été supprimé.");
            Data.cuisinierList.remove(personnelId);
            break;
            case "barman":
            System.out.println("Le barman " + Data.barmanList.get(personnelId).getNom() + " " + Data.barmanList.get(personnelId).getPrenom() + " a été supprimé.");
            Data.barmanList.remove(personnelId);
            break;
            default :
            this.personnelMenu(personnelId, type);;
            break; 
        }
        this.openPersonnelManager();
    }
    
    public void openRestaurant(){
        /*function that get number of serveur who are 'en service'*/
        int nbServeur = 0;
        for (Map.Entry<String, Serveur> entry : Data.serveurList.entrySet()) {
            if(entry.getValue().getIsEnService() == true){
                nbServeur++;
            }
        }
        
        /*function that get number of cuisinier who are 'en service'*/
        int nbCuisinier = 0;
        for (Map.Entry<String, Cuisinier> entry : Data.cuisinierList.entrySet()) {
            if(entry.getValue().getIsEnService() == true){
                nbCuisinier++;
            }
        }
        
        /*function that get number of barman who are 'en service'*/
        int nbBarman = 0;
        for (Map.Entry<String, Barman> entry : Data.barmanList.entrySet()) {
            if(entry.getValue().getIsEnService() == true){
                nbBarman++;
            }
        }
        
        Printer.clearConsole();
        
        System.out.println("------------------------------------------");
        System.out.println("Nombre de serveur en service : " + nbServeur);
        System.out.println("Nombre de cuisinier en service : " + nbCuisinier);
        System.out.println("Nombre de barman en service : " + nbBarman);
        System.out.println("------------------------------------------");
        
        if(nbServeur >= 2 && nbCuisinier >= 4 && nbBarman >= 1){
            System.out.println("Le restaurant ouvre !");
            System.out.println("------------------------------------------");
            
            Data.setIsRestaurantOpen(true);            
        }else{
            System.out.println("Le restaurant ne peut pas ouvrir, il manque du personnel.");
            System.out.println("\n");
            System.out.println("Rappel, il faut :");
            System.out.println("\t2 serveurs en service");
            System.out.println("\t4 cuisiniers en service");
            System.out.println("\t1 barman en service");         
            System.out.println("------------------------------------------");
        }   
        Printer.enterToContinue();
        this.openManagerMenu();     
    }
    
}
