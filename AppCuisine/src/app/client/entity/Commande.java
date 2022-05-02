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
/**
 * This function returns the commandeId of the current object
 * 
 * @return The commandeId
 */
    public int getCommandeId() {
        return this.commandeId;
    }
/**
 * This fuction set the id of the order
 * 
 * @param commandeId the id of the order
 */
    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }
    
    /*function to add Drink to the commande*/
    /**
     * If the drink is already in the map, increment the value by 1, otherwise add the drink to the map
     * with a value of 1
     * 
     * @param drink the drink to add
     */
    public void addBoisson(Drink drink){
        if(boissonMap.containsKey(drink)){
            boissonMap.replace(drink, boissonMap.get(drink) + 1);
        }
        else{
            boissonMap.put(drink, 1);
        }    
    }
    
    /*function to add Food to the commande*/
/**
 * If the food is already in the map, increment the value by 1, otherwise add the food to the map with
 * a value of 1
 * 
 * @param food Food
 */
    public void addPlat(Food food){
        if(platMap.containsKey(food)){
            platMap.replace(food, platMap.get(food) + 1);
        }else{
            platMap.put(food, 1);
        }
    }
    
    /*function to get the total price of the commande*/
    /**
     * It returns the total price of the order
     * 
     * @return The total price of the order.
     */
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
/**
 * function to get quantity of a drink   
 * 
 * @param drink the drink to get the quantity of
 * @return The quantity of the drink.
 */
    public int getQuantity(Drink drink){
        return boissonMap.get(drink);
    }
    /*function to get quantity of a food*/
/**
 * function to get quantity of a food
 * 
 * @param food The food to be added to the plate
 * @return The quantity of the food.
 */
    public int getQuantity(Food food){
        return platMap.get(food);
    }
    
    /*function to get the list of drinks*/
/**
 * This function returns a map of drinks and their quantities
 * 
 * @return A map of drinks and their quantities.
 */
    public Map<Drink,Integer> getBoissonMap(){
        return boissonMap;
    }
    /*function to get the list of foods*/
/**
 * It returns a map of food and thier quantities
 * 
 * @return A map of food and integer.
 */
    public Map<Food,Integer> getPlatMap(){
        return platMap;
    }
    
    /*function to update the quantity of a drink*/
/**
 * It updates the quantity of a drink in the map
 * 
 * @param drink the drink to update
 * @param quantity the quantity of the drink
 */
    public void updateQuantity(Drink drink, int quantity){
        boissonMap.put(drink, quantity);
    }
    /*function to update the quantity of a food*/
/**
 * This function updates the quantity of a food in the map
 * 
 * @param food Food object
 * @param quantity the quantity of the food
 */
    public void updateQuantity(Food food, int quantity){
        platMap.put(food, quantity);
    }
    
    /*function to remove a drink from the commande*/
/**
 * This function removes a drink from the map
 * 
 * @param drink the drink to be removed
 */
    public void removeDrink(Drink drink){
        boissonMap.remove(drink);
    }
    /*function to remove a food from the commande*/
/**
 * It removes the food from the plate.
 * 
 * @param food The food to be removed from the plate
 */
    public void removeFood(Food food){
        platMap.remove(food);
    }
    
    /*function to print the Food list*/
   /**
    * It prints the food list
    */
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
    /**
     * It prints the drink list
     */
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
/**
 * This function prints the order, the food list, the drink list and the total price
 */
    public void printCommande(){
        System.out.println("Commande : ");
        printFoodList();
        printDrinkList();
        System.out.println("Total : " + getTotalPrice());
    }
    
/**
 * This function returns the foodState variable.
 * can be 0 for En attente, 1 for en peparation, 2 for prêt, 3 for est servi, -1 for not available...
 * @return The foodState variable is being returned.
 */
    public int getFoodState() {
        return this.foodState;
    }
    
/**
 * This function returns the value of the drinkState variable.
 * can be 0 for En attente, 1 for en peparation, 2 for prêt, 3 for est servi, -1 for not available...
 * 
 * @return The drinkState variable is being returned.
 */
    public int getDrinkState() {
        return this.drinkState;
    }
    
  /**
   * It returns a string that corresponds to the state name of the order
   * 
   * @param state the state of the order
   * @return The state name of the order.
   */
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
    
/**
 * This function sets the foodState variable to the value of the foodState parameter
 * 
 * @param foodState can be 0 for En attente, 1 for en peparation, 2 for prêt, 3 for est servi, -1 for not available...
 */
    public void setFoodState(int foodState) {
        this.foodState = foodState;
    }
    
/**
 * It sets the drinkState to the value of the parameter drinkState.
 * 
 * @param drinkState can be 0 for En attente, 1 for en peparation, 2 for prêt, 3 for est servi, -1 for not available...
 */
    public void setDrinkState(int drinkState) {
        this.drinkState = drinkState;
    }
    
/**
 * If the boissonMap is empty, set drinkState to 2, otherwise set it to 1. If the platMap is empty, set
 * foodState to 2, otherwise set it to 1
 */
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

/**
 * Serve the order.set the food and drink states to 3
 */
    public void serveCommande() {
        this.foodState = 3;
        this.drinkState = 3;
    }
    
 /**
  * If the food and drink states are the same, return the state. If they are not the same, return the
  * lesser of the two states
  * 
  * @return The state of the order.
  */
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

