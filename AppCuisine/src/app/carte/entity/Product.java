package app.carte.entity;

import java.util.*;

public abstract class Product {
    private String name;
    private int price;
    private List<Ingredient> ingredientList = new ArrayList<Ingredient>();


    public Product(String name,int price){
        this.name = name;
        this.price = price;
    }

/**
 * It returns the name of the object.
 * 
 * @return The name of the object.
 */
    public String getName() {
        return this.name;
    }

/**
 * This function sets the name of the object to the name passed in as a parameter
 * 
 * @param name The name of the product.
 */
    public void setName(String name) {
        this.name = name;
    }

/**
 * It returns the price of the item.
 * 
 * @return The price of the item.
 */
    public int getPrice() {
        return this.price;
    }

/**
 * It sets the price of the item.
 * 
 * @param price The price of the item.
 */
    public void setPrice(int price) {
        this.price = price;
    }

/**
 * This function returns the ingredientList
 * 
 * @return The list of ingredients.
 */
    public List<Ingredient> getIngredientList(){
        return this.ingredientList;
    }

/**
 * This function adds a number of ingredient to the ingredient list
 * 
 * @param ingredient Ingredient object
 * @param amount the amount of the ingredient to be added
 */
    public void addIngredient(Ingredient ingredient,int amount){
        Ingredient newIngredient = new Ingredient(ingredient.getName(),amount);

        ingredientList.add(newIngredient);
    }
}