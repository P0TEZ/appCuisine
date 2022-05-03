package app;
// CIR3 projet TP2 Alexandre & Jérôme
import java.util.*;
import java.io.*;
import java.math.*;

import app.personnel.entity.*;
import app.screen.entity.*;
import app.screen.entity.ServeurScreen;
import app.carte.entity.*;
import app.client.entity.*;
import app.screen.entity.*;

///////////////////////////////////////

public class AppCuisine {
    public static void main(String[] args) throws Exception {
        System.out.println("\n------------------------------------------");
        System.out.println("Debut de service\n"); 

        Builder builder = new Builder();

        //a suprrrrrrrr
        Data.serveurList.get("ABCD").addTable(1);
        Data.tableList.get(1).getCommande().addBoisson(Data.drinkList.get("limonade"));
        Data.tableList.get(1).getCommande().addBoisson(Data.drinkList.get("cidreDoux"));
        Data.tableList.get(1).getCommande().addPlat(Data.foodList.get("salade_1"));
        Data.tableList.get(1).getCommande().addPlat(Data.foodList.get("salade_1"));
        Data.tableList.get(1).getCommande().addPlat(Data.foodList.get("burger_3"));
        Data.tableList.get(1).getCommande().sendCommande();
        //ouiiiiiii
        
        Printer.displayMenu();

        System.out.println("Fin de service"); 
    }
}
