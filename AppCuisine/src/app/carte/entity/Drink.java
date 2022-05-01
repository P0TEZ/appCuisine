package app.carte.entity;

public class Drink extends Product {

    public Drink(String name,int price){
        super(name,price);    
    }
    
    public Boolean isAvailable(){
        if(Stock.getAmount(this.getName()) > 0){
            return true;
        }
        return true;
    }
}