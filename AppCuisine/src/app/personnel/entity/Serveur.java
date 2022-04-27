package app.personnel.entity;

import java.util.*;
import app.client.entity.*;

public  class Serveur extends Personnel {

    private Map<Integer, Table> tableMap = new HashMap<>();

    public Serveur(String id, String nom, String prenom, int salaire){
        super(id,nom,prenom,salaire);
    }

    public Map<Integer, Table> getTableMap() {
        return tableMap;
    }

    public Table getTableById(int id){
        return tableMap.get(id);
    }

    public void addTable(Table table){
        tableMap.put(table.getId(), table);
    }

    public void removeTable(int id){
        tableMap.remove(id);
    }
}