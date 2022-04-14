package app;

import java.util.*;

import app.carte.entity.*;

public class Builder {
    
    Map<String, Ingredient> ingredientList = new HashMap<>();
    
    Map<String, Food> foodList = new HashMap<>();
    
    Map<String, Drink> drinkList = new HashMap<>();
    
    public Builder(){
        this.generateIngredientList();
        this.generateFood();
        this.generateDrink();
    }
    

    public void addIngredient(String ingredientName){
        this.ingredientList.put(ingredientName,new Ingredient(ingredientName));
    }
    
    public void generateIngredientList(){
        String ingredientNames[] = {
        "salade", "tomate", "oignon",
        "champignon", "pain", "steack",
        "pateAPizza", "fromage", "chorizo"};
        
        for (int index = 0; index < ingredientNames.length; index++) {
            this.addIngredient(ingredientNames[index]);
            System.out.println(ingredientNames[index]);
        }         
    }
    
    public void generateFood(){
        Food burger_3 = new Food("burger_3",15);
        burger_3.addIngredient(ingredientList.get("pain"),1);
        burger_3.addIngredient(ingredientList.get("steack"),1);
        
        Food burger_2 = burger_3;
        burger_2.setName("burger_2");
        burger_2.addIngredient(ingredientList.get("salade"),1); 
        
        Food burger_1 = burger_2;
        burger_1.setName("burger_1");
        burger_1.addIngredient(ingredientList.get("tomate"),1);
        
        
        
        Food salade_2 = new Food("salade_2",9);
        salade_2.addIngredient(ingredientList.get("salade"),1);
        
        Food salade_1 = salade_2;
        salade_1.setName("salade_1");
        salade_1.addIngredient(ingredientList.get("tomate"),1);
        
        

        Food potage_1 = new Food("potage_1",8);
        potage_1.addIngredient(ingredientList.get("oignon"), 3);
        
        Food potage_2 = new Food("potage_2",8);
        potage_2.addIngredient(ingredientList.get("tomate"), 3);
        
        Food potage_3 = new Food("potage_2",8);
        potage_3.addIngredient(ingredientList.get("champignon"), 3);
        
        
        
        Food pizza_1 = new Food("pizza_1",12);
        pizza_1.addIngredient(ingredientList.get("pateAPizza"),1);
        pizza_1.addIngredient(ingredientList.get("tomate"),1);
        pizza_1.addIngredient(ingredientList.get("fromage"),1);
        
        Food pizza_2 = pizza_1;
        pizza_2.setName("pizza_2");
        pizza_2.addIngredient(ingredientList.get("champignon"),1);
        
        Food pizza_3 = pizza_1;
        pizza_3.setName("pizza_3");
        pizza_3.addIngredient(ingredientList.get("chorizo"),1);

        this.foodList.put("burger_1",burger_1);
        this.foodList.put("burger_2",burger_2);
        this.foodList.put("burger_3",burger_3);
        this.foodList.put("salade_1",salade_1);
        this.foodList.put("salade_2",salade_2);
        this.foodList.put("potage_1",potage_1);
        this.foodList.put("potage_2",potage_2);
        this.foodList.put("potage_3",potage_3);
        this.foodList.put("pizza_1",pizza_1);
        this.foodList.put("pizza_2",pizza_2);
        this.foodList.put("pizza_3",pizza_3);
    }
    
    public void generateDrink(){
        Drink limonade = new Drink("limonade",4);
        
        Drink cidreDoux = new Drink("cidreDoux",5);
        
        Drink biereSansAlcool = new Drink("biereSansAlcool",5);
        
        Drink eau = new Drink("eau",0);
        
        Drink jusDeFruit = new Drink("jusDeFruit",1);
        
        this.drinkList.put("limonade",limonade);
        this.drinkList.put("cidreDoux",cidreDoux);
        this.drinkList.put("biereSansAlcool",biereSansAlcool);
        this.drinkList.put("eau",eau);
        this.drinkList.put("jusDeFruit",jusDeFruit);
    }
}