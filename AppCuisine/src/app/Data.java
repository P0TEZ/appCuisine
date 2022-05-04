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

    public static void setIsRestaurantOpen(boolean isRestaurantOpen) {
        Data.isRetaurantOpen = isRestaurantOpen;
    }
    public static boolean getIsRestaurantOpen() {
        return isRetaurantOpen;
    }
}