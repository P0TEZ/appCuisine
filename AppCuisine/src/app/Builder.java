package app;

import java.io.File;
import java.util.*;

import app.carte.entity.*;
import app.client.entity.*;
import app.personnel.entity.*;


public class Builder {
    final int MAX_TABLES = 10;
    
    Map<String, Ingredient> ingredientList = new HashMap<>();
    
    Map<String, Food> foodList = new TreeMap<>();
    
    Map<String, Drink> drinkList = new TreeMap<>();

    Map<String, Serveur> serveurList = new HashMap<>();

    Map<String, Barman> barmanList = new HashMap<>();

    Map<String, Cuisinier> cuisinierList = new HashMap<>();

    Map<String, Manager> managerList = new HashMap<>();

    Map<Integer, Table> tableList = new HashMap<>();

    Map<String, Integer> stockList = new HashMap<>();

    public Builder(){
        this.generateIngredientList();
        Data.ingredientList = this.ingredientList;

        this.generateFood();
        Data.foodList = this.foodList;

        this.generateDrink();
        Data.drinkList = this.drinkList;

        try {
            this.loadServeurList();
        } catch (Exception e) {
            System.out.println(e);
        }
        Data.serveurList = this.serveurList;
        try {
            this.loadBarmanList();
        } catch (Exception e) {
            System.out.println(e);
        }
        Data.barmanList = this.barmanList;
        try {
            this.loadCuisinierList();
        } catch (Exception e) {
            System.out.println(e);
        }
        Data.cuisinierList = this.cuisinierList;
        try {
            this.loadManagerList();
        } catch (Exception e) {
            System.out.println(e);
        }
        Data.managerList = this.managerList;

        try {
            this.loadStockList();
        } catch (Exception e) {
            System.out.println(e);
        }
        Stock.set(this.stockList);

        

        this.generateTable();
        Data.tableList = this.tableList;
    }
    
    
    private void addIngredient(String ingredientName){
        this.ingredientList.put(ingredientName,new Ingredient(ingredientName));
    }
    
    private void generateIngredientList(){
        String ingredientNames[] = {
            "salade", "tomate", "oignon",
            "champignon", "pain", "steack",
            "pateAPizza", "fromage", "chorizo",
            "galette", "poulet", "sauceFromagere"
        };
            
        for (int index = 0; index < ingredientNames.length; index++) {
            this.addIngredient(ingredientNames[index]);
        }         
    }
        
    private void generateFood(){
        Food burger_3 = new Food("burger_3",15);
        burger_3.addIngredient(ingredientList.get("pain"),1);
        burger_3.addIngredient(ingredientList.get("steack"),1);
        
        Food burger_2 = burger_3;
        burger_2.setName("burger_2");
        burger_2.addIngredient(ingredientList.get("salade"),1); 
        
        Food burger_1 = burger_2;
        burger_1.setName("burger_1");
        burger_1.addIngredient(ingredientList.get("tomate"),1);
        
        
        
        Food salade_2 = new Food("salade_2",9);
        salade_2.addIngredient(ingredientList.get("salade"),1);
        
        Food salade_1 = salade_2;
        salade_1.setName("salade_1");
        salade_1.addIngredient(ingredientList.get("tomate"),1);
        
        
        
        Food potage_1 = new Food("potage_1",8);
        potage_1.addIngredient(ingredientList.get("oignon"), 3);
        
        Food potage_2 = new Food("potage_2",8);
        potage_2.addIngredient(ingredientList.get("tomate"), 3);
        
        Food potage_3 = new Food("potage_2",8);
        potage_3.addIngredient(ingredientList.get("champignon"), 3);
        
        
        
        Food pizza_1 = new Food("pizza_1",12);
        pizza_1.addIngredient(ingredientList.get("pateAPizza"),1);
        pizza_1.addIngredient(ingredientList.get("tomate"),1);
        pizza_1.addIngredient(ingredientList.get("fromage"),1);
        
        Food pizza_2 = pizza_1;
        pizza_2.setName("pizza_2");
        pizza_2.addIngredient(ingredientList.get("champignon"),1);
        
        Food pizza_3 = pizza_1;
        pizza_3.setName("pizza_3");
        pizza_3.addIngredient(ingredientList.get("chorizo"),1);

        Food fajitas_1 = new Food("fajitas_1", 11);
        fajitas_1.addIngredient(ingredientList.get("galette"),1);
        fajitas_1.addIngredient(ingredientList.get("sauceFromagere"),1);
        fajitas_1.addIngredient(ingredientList.get("poulet"),1);

        Food fajitas_2 = new Food("fajitas_2", 11);
        fajitas_2.addIngredient(ingredientList.get("galette"),1);
        fajitas_2.addIngredient(ingredientList.get("sauceFromagere"),1);
        fajitas_2.addIngredient(ingredientList.get("steack"),1);
        
        this.foodList.put("burger_1",burger_1);
        this.foodList.put("burger_2",burger_2);
        this.foodList.put("burger_3",burger_3);
        this.foodList.put("salade_1",salade_1);
        this.foodList.put("salade_2",salade_2);
        this.foodList.put("potage_1",potage_1);
        this.foodList.put("potage_2",potage_2);
        this.foodList.put("potage_3",potage_3);
        this.foodList.put("pizza_1",pizza_1);
        this.foodList.put("pizza_2",pizza_2);
        this.foodList.put("pizza_3",pizza_3);
    }
    
    private void generateDrink(){
        Drink limonade = new Drink("limonade",4);
        
        Drink cidreDoux = new Drink("cidreDoux",5);
        
        Drink biereSansAlcool = new Drink("biereSansAlcool",5);
        
        Drink eau = new Drink("eau",0);
        
        Drink jusDeFruit = new Drink("jusDeFruit",1);
        
        this.drinkList.put("limonade",limonade);
        this.drinkList.put("cidreDoux",cidreDoux);
        this.drinkList.put("biereSansAlcool",biereSansAlcool);
        this.drinkList.put("eau",eau);
        this.drinkList.put("jusDeFruit",jusDeFruit);
    }
        
    private void loadServeurList() throws Exception{

        System.out.println("Loading serveur list...");
        File file = new File("src/app/_data/serveurList.txt");

        Scanner sc = new Scanner(file);
    
        while (sc.hasNextLine()){
            String tmpLine = sc.nextLine();
            int i = 0, begin=0, end=0;
            List<String> infos = new ArrayList<String>();

            while(i<tmpLine.length() && tmpLine.charAt(i) != '\n'){
                if(tmpLine.charAt(i) == '_'){
                    end = i;
                    infos.add(tmpLine.substring(begin, end));
                    begin = i+1;
                }
                i++;
            }

            Serveur tmpServeur = new Serveur(infos.get(0).toUpperCase(),
                                             infos.get(1).toUpperCase(),
                                             infos.get(2).toUpperCase(),
                                             Integer.parseInt(infos.get(3)),
                                             Integer.parseInt(infos.get(4)));
            serveurList.put(infos.get(0).toUpperCase(),tmpServeur);
        }
        sc.close();
    }

    private void loadBarmanList() throws Exception{

        System.out.println("Loading barman list...");
        File file = new File("src/app/_data/barmanList.txt");

        Scanner sc = new Scanner(file);
    
        while (sc.hasNextLine()){
            String tmpLine = sc.nextLine();
            int i = 0, begin=0, end=0;
            List<String> infos = new ArrayList<String>();

            while(i<tmpLine.length() && tmpLine.charAt(i) != '\n'){
                if(tmpLine.charAt(i) == '_'){
                    end = i;
                    infos.add(tmpLine.substring(begin, end));
                    begin = i+1;
                }
                i++;
            }

            Barman tmpBarman = new Barman(infos.get(0).toUpperCase(),
                                          infos.get(1).toUpperCase(),
                                          infos.get(2).toUpperCase(),
                                          Integer.parseInt(infos.get(3)),
                                          Integer.parseInt(infos.get(4)));
            barmanList.put(infos.get(0).toUpperCase(),tmpBarman);
        }
        sc.close();
    }


    private void loadCuisinierList() throws Exception{

        System.out.println("Loading cuisinier list...");
        File file = new File("src/app/_data/cuisinierList.txt");

        Scanner sc = new Scanner(file);
    
        while (sc.hasNextLine()){
            String tmpLine = sc.nextLine();
            int i = 0, begin=0, end=0;
            List<String> infos = new ArrayList<String>();

            while(i<tmpLine.length() && tmpLine.charAt(i) != '\n'){
                if(tmpLine.charAt(i) == '_'){
                    end = i;
                    infos.add(tmpLine.substring(begin, end));
                    begin = i+1;
                }
                i++;
            }

            Cuisinier tmpCuisinier = new Cuisinier(infos.get(0).toUpperCase(),
                                                   infos.get(1).toUpperCase(),
                                                   infos.get(2).toUpperCase(),
                                                   Integer.parseInt(infos.get(3)),
                                                   Integer.parseInt(infos.get(4)));
            cuisinierList.put(infos.get(0).toUpperCase(),tmpCuisinier);
        }
        sc.close();
    }

    private void loadManagerList() throws Exception{

        System.out.println("Loading manager list...");
        File file = new File("src/app/_data/managerList.txt");

        Scanner sc = new Scanner(file);
    
        while (sc.hasNextLine()){
            String tmpLine = sc.nextLine();
            int i = 0, begin=0, end=0;
            List<String> infos = new ArrayList<String>();

            while(i<tmpLine.length() && tmpLine.charAt(i) != '\n'){
                if(tmpLine.charAt(i) == '_'){
                    end = i;
                    infos.add(tmpLine.substring(begin, end));
                    begin = i+1;
                }
                i++;
            }

            Manager tmpManager = new Manager(infos.get(0).toUpperCase(),
                                             infos.get(1).toUpperCase(),
                                             infos.get(2).toUpperCase(),
                                             Integer.parseInt(infos.get(3)),
                                             Integer.parseInt(infos.get(4)));
            managerList.put(infos.get(0).toUpperCase(),tmpManager);
        }
        sc.close();
    }


    private void loadStockList() throws Exception{

        System.out.println("Loading stock list...");
        File file = new File("src/app/_data/stock.txt");

        Scanner sc = new Scanner(file);
    
        while (sc.hasNextLine()){
            String tmpLine = sc.nextLine();
            int i = 0, begin=0, end=0;
            List<String> infos = new ArrayList<String>();

            while(i<tmpLine.length() && tmpLine.charAt(i) != '\n'){
                if(tmpLine.charAt(i) == '_'){
                    end = i;
                    infos.add(tmpLine.substring(begin, end));
                    begin = i+1;
                }
                i++;
            }
            stockList.put(infos.get(0),Integer.parseInt(infos.get(1)));
        }
        sc.close();
    }

    private void generateTable(){
        for(int i = 1; i <= this.MAX_TABLES; i++){
            tableList.put(i,new Table(i));
        }
    }
}




