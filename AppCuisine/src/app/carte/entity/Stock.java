package app.carte.entity;

import java.util.*;

public class Stock {
    private static Map<String, Integer> stock = new HashMap<>();
    
    public static Map<String, Integer> getStock() {
        return stock;
    }

    public static void set(Map<String, Integer> stock) {
        Stock.stock = stock;
    }

    public static void addIngredient(String name, int amount) {
        if (stock.containsKey(name)) {
            stock.put(name, stock.get(name) + amount);
        } else {
            stock.put(name, amount);
        }
    }

    public static void useIngredient(String name, int amount) {
        if (stock.containsKey(name)) {
            if(stock.get(name) - amount >= 0) {
                stock.put(name, stock.get(name) - amount);
            }else{
                System.out.println("Not enough stock");
            }
        } else {
            System.out.println("Il n'y a pas cet ingredient en stock");
        }
    }

    public static int getAmount(String name) {
        if (stock.containsKey(name)) {
            return stock.get(name);
        } else {
            return 0;
        }
    }

    public static void removeIngredient(String name) {
        if (stock.containsKey(name)) {
            stock.remove(name);
        } else {
            System.out.println("Il n'y a pas cet ingredient en stock");
        }
    }

    public static void printStock() {
        System.out.println("Stock : ");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    
    public static void useFoodIngredient(Food food) {
        for(Ingredient ingredient : food.getIngredientList()) {
            useIngredient(ingredient.getName(), ingredient.getAmount());
        }
    }
}