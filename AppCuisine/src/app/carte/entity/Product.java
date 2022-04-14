package app.carte.entity;

import java.util.*;

public class Product {
    private String name;
    private List<Ingredient> ingredientList = new ArrayList<Ingredient>();

    public Product(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int addIngredient(Ingredient ingredient){
        ingredientList.add(ingredient);

        return 0;
    }
}