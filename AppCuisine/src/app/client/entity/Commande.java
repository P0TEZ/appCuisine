package app.client.entity;

import java.util.*;

import app.carte.entity.*;

public class Commande {
    
    private Map<Drink,Integer> boissonMap = new HashMap<Drink,Integer>();
    private Map<Food,Integer> platMap = new HashMap<Food,Integer>();
    private int commandeId;
    private int foodState = 0;//can be 0 for En attente, 1 for en peparation, 2 for prêt, 3 for est servi, -1 for not available...
    private int drinkState = 0;//can be 0 for En attente, 1 for en peparation, 2 for prêt, 3 for est servi, -1 for not available...
    
    
    public Commande (){
        
    }
    
    /* getters and setters for commandeId */
    public int getCommandeId() {
        return this.commandeId;
    }
    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }
    
    /*function to add Drink to the commande*/
    public void addBoisson(Drink drink){
        if(boissonMap.containsKey(drink)){
            boissonMap.replace(drink, boissonMap.get(drink) + 1);
        }
        else{
            boissonMap.put(drink, 1);
        }    
    }
    
    /*function to add Food to the commande*/
    public void addPlat(Food food){
        if(platMap.containsKey(food)){
            platMap.replace(food, platMap.get(food) + 1);
        }else{
            platMap.put(food, 1);
        }
    }
    
    /*function to get the total price of the commande*/
    public double getTotalPrice(){
        if(boissonMap.isEmpty() && platMap.isEmpty()){
            return 0;
        }
        double totalPrice = 0;
        for (Map.Entry<Drink, Integer> entry : boissonMap.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        for (Map.Entry<Food, Integer> entry : platMap.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }
    
    /*function to get quantity of a drink*/
    public int getQuantity(Drink drink){
        return boissonMap.get(drink);
    }
    /*function to get quantity of a food*/
    public int getQuantity(Food food){
        return platMap.get(food);
    }
    
    /*function to get the list of drinks*/
    public Map<Drink,Integer> getBoissonMap(){
        return boissonMap;
    }
    /*function to get the list of foods*/
    public Map<Food,Integer> getPlatMap(){
        return platMap;
    }
    
    /*function to update the quantity of a drink*/
    public void updateQuantity(Drink drink, int quantity){
        boissonMap.put(drink, quantity);
    }
    /*function to update the quantity of a food*/
    public void updateQuantity(Food food, int quantity){
        platMap.put(food, quantity);
    }
    
    /*function to remove a drink from the commande*/
    public void removeDrink(Drink drink){
        boissonMap.remove(drink);
    }
    /*function to remove a food from the commande*/
    public void removeFood(Food food){
        platMap.remove(food);
    }
    
    /*function to print the Food list*/
    public void printFoodList(){
        System.out.println("Plats : " + getStateName(foodState));
        if(platMap.isEmpty()){
            System.out.println("\tAucun plat");
        }else{
            for (Map.Entry<Food, Integer> entry : platMap.entrySet()) {
                System.out.println("\t" + entry.getKey().getName() + " x" + entry.getValue());
            }
        }
    }
    
    /*function to print the Drink list*/
    public void printDrinkList(){
        System.out.println("Boissons : " + getStateName(drinkState));
        if(boissonMap.isEmpty()){
            System.out.println("\tAucune boisson");
        }else{
            for (Map.Entry<Drink, Integer> entry : boissonMap.entrySet()) {
                System.out.println("\t" + entry.getKey().getName() + " x" + entry.getValue());
            }
        }
    }
    
    /*function to print the commande*/
    public void printCommande(){
        System.out.println("Commande : ");
        printFoodList();
        printDrinkList();
        System.out.println("Total : " + getTotalPrice());
    }
    
    public int getFoodState() {
        return this.foodState;
    }
    
    public int getDrinkState() {
        return this.drinkState;
    }
    
    public String getStateName(int state) {
        switch (state) {
            case 0:
            return "En attente";
            case 1:
            return "En préparation";
            case 2:
            return "Prêt";
            case 3:
            return "Servi";
            default:
            return "Indisponible";
        }
    }
    
    public void setFoodState(int foodState) {
        this.foodState = foodState;
    }
    
    public void setDrinkState(int drinkState) {
        this.drinkState = drinkState;
    }
    
    public void sendCommande() {
        if(this.boissonMap.isEmpty()) {
            this.drinkState = 2;
        }else{
            this.drinkState = 1;
        } 
        if(this.platMap.isEmpty()){
            this.foodState = 2;            
        }else{
            this.foodState = 1;
        }
    }

    public void serveCommande() {
        this.foodState = 3;
        this.drinkState = 3;
    }
    
    public int getCommandeState() {
        if(this.foodState == this.drinkState){
            if (this.foodState == 3 && this.drinkState == 3) {
                return 3;
            } else if (this.foodState == 2 && this.drinkState == 2) {
                return 2;
            } else if (this.foodState == 1 && this.drinkState == 1) {
                return 1;
            } else if (this.foodState == 0 && this.drinkState == 0) {
                return 0;
            } else{
                return -1;
            }
        }
        else {
            return this.getDrinkState()<this.getFoodState()?this.getDrinkState():this.getFoodState();
        }
        
    }
}

