package app;

import java.util.*;
import app.carte.entity.*;
import app.personnel.entity.*;
import app.client.entity.*;

public class Data {
   
    public static Map<String, Ingredient> ingredientList = new HashMap<>();
    
    public static Map<String, Food> foodList = new TreeMap<>();
    
    public static Map<String, Drink> drinkList = new TreeMap<>();
    
    public static Map<String, Serveur> serveurList = new HashMap<>();

    public static Map<String, Barman> barmanList = new HashMap<>();

    public static Map<String, Cuisinier> cuisinierList = new HashMap<>();

    public static Map<String, Manager> managerList = new HashMap<>();

    public static Map<Integer, Table> tableList = new HashMap<>();

    private static boolean isRetaurantOpen = false;

    public Data() {
        System.err.println("can not create an instance of Data");
    }


   /**
    * This function sets the value of the isRestaurantOpen variable to the value of the
    * isRestaurantOpen parameter
    * 
    * @param isRestaurantOpen This is a boolean value that is set to true if the restaurant is open,
    * and false if it is closed.
    */
    public static void setIsRestaurantOpen(boolean isRestaurantOpen) {
        Data.isRetaurantOpen = isRestaurantOpen;
    }
/**
 * This function returns the value of the variable isRestaurantOpen.
 * 
 * @return isRetaurantOpen. This is a boolean value that is set to true if the restaurant is open,
 * and false if it is closed.
 */
    public static boolean getIsRestaurantOpen() {
        return isRetaurantOpen;
    }
}