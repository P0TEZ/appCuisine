package app.carte.entity;

import java.util.*;

public class Stock {
    private static Map<String, Integer> stock = new HashMap<>();
    
/**
 * It returns a map of the stock
 * 
 * @return The stock map.
 */
    public static Map<String, Integer> getStock() {
        return stock;
    }

/**
 * It takes a map of strings to integers, and sets the static variable stock to that map
 * 
 * @param stock The stock map
 */
    public static void set(Map<String, Integer> stock) {
        Stock.stock = stock;
    }

/**
 * If the stock contains the ingredient, add the amount to the stock, otherwise add the ingredient to
 * the stock
 * 
 * @param name the name of the ingredient to add to the stock
 * @param amount the amount of the ingredient to be added
 */
    public static void addIngredient(String name, int amount) {
        if (stock.containsKey(name)) {
            stock.put(name, stock.get(name) + amount);
        } else {
            stock.put(name, amount);
        }
    }

/**
 * If the stock contains the ingredient, and there's enough of it, then subtract the amount from the
 * stock
 * 
 * @param name the name of the ingredient
 * @param amount the amount of the ingredient to use
 */
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

/**
 * If the stock contains the name, return the stock's amount, otherwise return 0
 * 
 * @param name The name of the item
 * @return The amount of the item in the stock.
 */
    public static int getAmount(String name) {
        if (stock.containsKey(name)) {
            return stock.get(name);
        } else {
            return 0;
        }
    }

/**
 * If the stock contains the ingredient, remove it. Otherwise, print an error message
 * 
 * @param name the name of the ingredient
 */
    public static void removeIngredient(String name) {
        if (stock.containsKey(name)) {
            stock.remove(name);
        } else {
            System.out.println("Il n'y a pas cet ingredient en stock");
        }
    }

/**
 * It prints the stock.
 */
    public static void printStock() {
        System.out.println("Stock : ");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    
/**
 * "For each ingredient in the food's ingredient list, use the ingredient."
 * 
 * @param food The food object that you want to use the ingredients from.
 */
    public static void useFoodIngredient(Food food) {
        for(Ingredient ingredient : food.getIngredientList()) {
            useIngredient(ingredient.getName(), ingredient.getAmount());
            //System.out.println("Used " + ingredient.getAmount() + " " + ingredient.getName());
        }
    }
}