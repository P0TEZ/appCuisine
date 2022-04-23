package app.client.entity;

import java.util.*;
import app.carte.entity.*;

public class Commande {
    
    private Map<Drink,Integer> boissonMap = new HashMap<Drink,Integer>();
    private Map<Food,Integer> platMap = new HashMap<Food,Integer>();
    private int commandeId;
    
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
    public void addBoisson(Drink drink, int quantity){
        boissonMap.put(drink, quantity);
    }
    /*function to add Food to the commande*/
    public void addPlat(Food food, int quantity){
        platMap.put(food, quantity);
    }
    
    /*function to get the total price of the commande*/
    public double getTotalPrice(){
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
}
