package app;

import java.util.*;
import app.carte.entity.*;
import app.personnel.entity.*;

public class Data {
   
    public static Map<String, Ingredient> ingredientList = new HashMap<>();
    
    public static Map<String, Food> foodList = new HashMap<>();
    
    public static Map<String, Drink> drinkList = new HashMap<>();
    
    public static Map<String, Serveur> serveurList = new HashMap<>();

    public Data() {
        System.err.println("can not create an instance of Data");
    }
}