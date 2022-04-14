package app;
// CIR3 projet TP2 Alexandre & Jérôme
import java.util.*;
import java.io.*;
import java.math.*;

import app.personnel.entity.*;
import app.carte.entity.*;

///////////////////////////////////////

public class AppCuisine {
    public static void main(String[] args) throws Exception {
        System.out.println("Debut de service"); 

        /*
        Ingredient tomate = new Ingredient("tomate");
        Ingredient steack = new Ingredient("steack");
        Ingredient fromage = new Ingredient("fromage");
        Ingredient pain = new Ingredient("pain");

        
        Food burger = new Food("burger");
        burger.addIngredient(tomate);
        burger.addIngredient(steack);
        burger.addIngredient(fromage);
        burger.addIngredient(pain);
        */
        Builder builder = new Builder();
        Printer printer = new Printer();

        printer.displayMenu();

        Personnel Serveur = new Personnel("test","test");
        System.out.println("Fin de service"); 
    }
}
