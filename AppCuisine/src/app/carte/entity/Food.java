package app.carte.entity;

public class Food extends Product {

    public Food(String name, int price){
        super(name,price);    
    }
    public Boolean isAvailable(){
        for(Ingredient ingredient : this.getIngredientList()){
            if(ingredient.getAmount() > Stock.getAmount(ingredient.getName())){
                return false;
            }
        }
        return true;
    }
}