package app.carte.entity;

public class Drink extends Product {

    public Drink(String name,int price){
        super(name,price);    
    }
    
/**
 * If the amount of the product in stock is greater than 0, return true. Otherwise, return false
 * 
 * @return A Boolean Value.
 */
    public Boolean isAvailable(){
        if(Stock.getAmount(this.getName()) > 0){
            return true;
        }
        return true;
    }
}