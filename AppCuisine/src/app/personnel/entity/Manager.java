package app.personnel.entity;

import app.carte.entity.*;
import app.client.entity.*;

import java.util.*;

import app.Data;

public  class Manager extends Personnel {


    public Manager(String id, String nom, String prenom, int salaire, int nbJourDeTravailDeSuite){
        super(id,nom,prenom,salaire,nbJourDeTravailDeSuite);
    }

/**
 * It takes a list of orders, and returns a list of ingredients and the quantity of each ingredient
 * needed to fulfill the orders
 * 
 * @return A map of the ingredients needed for the day.
 */
    public static Map<String, Integer> generateListDeCourse(){

        Map<String, Integer> courseList = new HashMap<>();

        for (Commande commande : Data.commandeList) {
            for (Map.Entry<Food, Integer> entry : commande.getPlatMap().entrySet()) {
                String foodName = entry.getKey().getName();
                // save the ingredients of food
                List<Ingredient> ingredientList = entry.getKey().getIngredientList();
                //for all ingredients
                for (Ingredient ingredient : ingredientList) {
                    // if the ingredient is already in the list
                    String ingredientName = ingredient.getName();
                    if(!courseList.containsKey(ingredientName)){
                        courseList.put(ingredientName, ingredient.getAmount());
                    }else{
                        courseList.put(ingredientName, courseList.get(ingredientName) + ingredient.getAmount());
                    }
                }
            }

            for (Map.Entry<Drink, Integer> entry : commande.getBoissonMap().entrySet()) {
                String ingredientName = entry.getKey().getName();

                if(!courseList.containsKey(ingredientName)){
                    courseList.put(ingredientName, entry.getValue());
                }else{
                    courseList.put(ingredientName, courseList.get(ingredientName) + entry.getValue());
                }
            }

        }

        return courseList;
    }
}
