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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Ingredient> getIngredientList(){
        return this.ingredientList;
    }

    public int addIngredient(Ingredient ingredient,int amount){
        ingredient.setAmount(amount);
        ingredientList.add(ingredient);
        return 0;
    }
}