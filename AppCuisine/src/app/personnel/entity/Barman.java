package app.personnel.entity;

import java.util.*;

import app.client.entity.*;
import app.carte.entity.*;
import app.*;

public  class Barman extends Personnel {


    public Barman(String id, String nom, String prenom, int salaire){
        super(id,nom,prenom,salaire);
    }

    /*function that get all commande from all tables from all serveurs*/
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
}
