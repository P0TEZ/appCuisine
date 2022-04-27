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

    public static Map<Integer, Table> tableList = new HashMap<>();


    public Data() {
        System.err.println("can not create an instance of Data");
    }
}