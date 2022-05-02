package app.carte.entity;

public class Food extends Product {

    public Food(String name, int price){
        super(name,price);    
    }
/**
 * If the amount of each ingredient in the recipe is less than the amount of the ingredient in the
 * stock, return false. Otherwise, return true
 * 
 * @return A boolean value.
 */
    public Boolean isAvailable(){
        for(Ingredient ingredient : this.getIngredientList()){
            if(ingredient.getAmount() > Stock.getAmount(ingredient.getName())){
                return false;
            }
        }
        return true;
    }
}