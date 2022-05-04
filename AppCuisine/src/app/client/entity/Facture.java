package app.client.entity;

import java.util.*;
import java.io.*;

import app.carte.entity.*;
import app.personnel.entity.*;

public class Facture {
    private Table table;
    private Serveur serveur;
    private int id;
    private Commande commande;
    private Map<Drink,Integer> boissonMap;
    private Map<Food,Integer> platMap;
    private double totalPrice;

    public Facture(Table table, Serveur serveur){
        this.table = table;
        this.serveur = serveur;
        this.getFactureInfo();
    }

/**
 * It gets the information from the table and the commande and stores it in the facture
 */
    private void getFactureInfo(){
        this.id = table.getId();
        this.commande = table.getCommande();
        this.boissonMap = commande.getBoissonMap();
        this.platMap = commande.getPlatMap();
        this.totalPrice = commande.getTotalPrice();
    }

/**
 * It prints out the bill for a table
 */
    public void displayFacture(){
        System.out.println("\nFacture de la table " + this.id);
        System.out.println("Serveur : " + this.serveur.getNom());
        System.out.println("Commande : " + this.table.getId());
        System.out.println("\nPlats : ");
        for(Map.Entry<Food,Integer> entry : platMap.entrySet()){
            System.out.println(entry.getKey().getName() + " x" + entry.getValue() + " = " + entry.getKey().getPrice() * entry.getValue());
        }
        System.out.println("\nBoissons : ");
        for(Map.Entry<Drink,Integer> entry : boissonMap.entrySet()){
            System.out.println(entry.getKey().getName() + " x" + entry.getValue() + " = " + entry.getKey().getPrice() * entry.getValue());
        }
        System.out.println("\nTotal : " + this.totalPrice); 
    }

/**
 * It creates a file with the name of the table and the date and time, then it writes the name of the
 * table, the name of the waiter, the name of the food, the quantity, the price and the total price of
 * the food, the name of the drink, the quantity, the price and the total price of the drink, and
 * finally the total price for the table
 */
    public void saveFacture(){
        System.out.println("\nFacture de la table " + this.id + " sauvegardée à : ");

        try {
            //function that get date and time
            Date date = new Date();
            String dateString = date.toString();
            dateString  = dateString.replace(" ", "_");
            dateString  = dateString.replace(":", "_");
            String fileName = "Facture_" + this.id + "_" + dateString;
            System.out.println("\t" + fileName+".csv");
                
                   
            // Create file 
            FileWriter fstream = new FileWriter("./src/app/_Factures/"+fileName+".csv");
            BufferedWriter out = new BufferedWriter(fstream);
            
            out.write("Table;"+this.id+"\n" + "Serveur;"+this.serveur.getNom() + ";" + this.serveur.getPrenom() + "\n\n");
            out.write("Nom;Quantite;Prix;Total;\n");

            for (Map.Entry<Food, Integer> entry : platMap.entrySet()) {
                out.write(entry.getKey().getName() + ";" + entry.getValue() + ";" + entry.getKey().getPrice() +";"+ entry.getKey().getPrice()*entry.getValue()+"\n");
            }
            for (Map.Entry<Drink, Integer> entry : boissonMap.entrySet()) {
                out.write(entry.getKey().getName() + ";" + entry.getValue() + ";" + entry.getKey().getPrice() +";"+ entry.getKey().getPrice()*entry.getValue()+"\n");
            }
            out.write("\n;;;Total;"+this.totalPrice);
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    


}
