package app;
// CIR3 projet TP2 Alexandre & Jérôme
import java.util.*;
import java.io.*;
import java.math.*;

import app.personnel.entity.*;
import app.screen.entity.*;
import app.screen.entity.ServeurScreen;
import app.carte.entity.*;
import app.screen.entity.*;

///////////////////////////////////////

public class AppCuisine {
    public static void main(String[] args) throws Exception {
        System.out.println("Debut de service"); 

        Builder builder = new Builder();
/*  
        for (Map.Entry<String, Food> entry : Data.foodList.entrySet()) {
            System.out.println("food : " + entry.getKey());
            System.out.println("Ingredient : " + entry.getValue().getIngredinetList());
        }*/

        Printer.displayMenu();


        System.out.println("Fin de service"); 
    }
}
