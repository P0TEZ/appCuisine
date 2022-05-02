package app;

import java.io.*;
import java.util.*;
import app.carte.entity.*;
import app.personnel.entity.*;

public class Saver {

    public static void saveAll(){
        saveStock();
        savePersonnel();
    }


    /*function that save StockList in a file*/
    /**
     * It takes the stock from the Stock class and saves it to a text file
     */
    public static void saveStock() {
        System.out.println("Saving stock...");
        try {
            // Create file 
            FileWriter fstream = new FileWriter("./src/app/_data/stock.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            
            for (Map.Entry<String, Integer> entry : Stock.getStock().entrySet()) {
                out.write(entry.getKey() + "_" + entry.getValue() + "_\n");
            }
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void savePersonnel(){
        saveCuisinier();
        saveBarman();
        saveServeur();
        System.out.println("Les fichiers personnels ont été actualise avec succes");
    }
    
    /**
     * It writes the data of the cuisinierList HashMap into a text file
     */
    private static void saveCuisinier(){
        System.out.println("Saving database cuisinier...");
        try {
            // Create file 
            FileWriter fstream = new FileWriter("./src/app/_data/cuisinierList.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            
            for (Map.Entry<String, Cuisinier> entry : Data.cuisinierList.entrySet()) {
                out.write(entry.getKey() + "_" + 
                          entry.getValue().getNom() + "_" + 
                          entry.getValue().getPrenom() + "_" + 
                          entry.getValue().getSalaire() + "_" + 
                          (entry.getValue().getIsEnService()?0:entry.getValue().getNbJourDeTravailDeSuite())
                          + "_\n");
            }
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    /**
     * It writes the data of the barmanList HashMap into a text file
     */
    private static void saveBarman(){
        System.out.println("Saving database barman...");

        try {
            // Create file 
            FileWriter fstream = new FileWriter("./src/app/_data/barmanList.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            
            for (Map.Entry<String, Barman> entry : Data.barmanList.entrySet()) {
                out.write(entry.getKey() + "_" + 
                          entry.getValue().getNom() + "_" + 
                          entry.getValue().getPrenom() + "_" + 
                          entry.getValue().getSalaire() + "_" + 
                          (entry.getValue().getIsEnService()?0:entry.getValue().getNbJourDeTravailDeSuite() )
                          + "_\n");
            }
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    /**
     * It writes the data of the server in a file
     */
    private static void saveServeur(){
        System.out.println("Saving database serveur...");

        try {
            // Create file 
            FileWriter fstream = new FileWriter("./src/app/_data/serveurList.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            
            for (Map.Entry<String, Serveur> entry : Data.serveurList.entrySet()) {
                out.write(entry.getKey() + "_" + 
                          entry.getValue().getNom() + "_" + 
                          entry.getValue().getPrenom() + "_" + 
                          entry.getValue().getSalaire() + "_" + 
                          (entry.getValue().getIsEnService()?0:entry.getValue().getNbJourDeTravailDeSuite() )
                          + "_\n");
            }
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
