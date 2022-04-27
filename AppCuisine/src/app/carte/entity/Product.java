package app.carte.entity;

import java.util.*;

public abstract class Product {
    private String name;
    private int price;
    private Boolean isReeady;
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

    public Boolean getIsReeady() {
        return this.isReeady;
    }

    public void setIsReeady(Boolean isReeady) {
        this.isReeady = isReeady;
    }

    public List<Ingredient> getIngredinetList(){
        return this.ingredientList;
    }

    public int addIngredient(Ingredient ingredient,int amount){
        ingredient.setAmount(amount);
        ingredientList.add(ingredient);
        return 0;
    }
}