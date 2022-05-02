package app.personnel.entity;

import java.util.*;

import app.client.entity.*;
import app.carte.entity.*;
import app.*;

public  class Barman extends Personnel {


    public Barman(String id, String nom, String prenom, int salaire, int nbJourDeTravailDeSuite){
        super(id,nom,prenom,salaire,nbJourDeTravailDeSuite);
    }

    /*function that get all boisson commandes from all tables from all serveurs*/
    /**
     * It returns a list of maps of drinks and their quantities
     * 
     * @return A list of maps of drinks and integers.
     */
    public List<Map<Drink,Integer>> getAllCommande(){
        List<Map<Drink,Integer>> commandeList = new ArrayList<>();
        for (Serveur serveur : Data.serveurList.values()) {
            for (Table table : serveur.getTableMap().values()) {
                if(table.getStatus() == 1){
                    commandeList.add(table.getCommande().getBoissonMap());
                }
            }
        }
        return commandeList;
    }

    public void prepareDrink(String drinkName){

    }
}
