package app.personnel.entity;

import java.util.*;

import app.client.entity.*;
import app.carte.entity.*;
import app.*;

public  class Cuisinier extends Personnel {


    public Cuisinier(String id, String nom, String prenom, int salaire){
        super(id,nom,prenom,salaire);
    }

    /*function that get all boisson commandes from all tables from all serveurs*/
    public List<Map<Food,Integer>> getAllCommande(){
        List<Map<Food,Integer>> commandeList = new ArrayList<>();
        for (Serveur serveur : Data.serveurList.values()) {
            for (Table table : serveur.getTableMap().values()) {
                if(table.getStatus() == 1){
                    commandeList.add(table.getCommande().getPlatMap());
                }
            }
        }
        return commandeList;
    }

    public void prepareFood(String drinkName){

    }
}
