package app.personnel.entity;

import java.util.*;

import app.Data;
import app.client.entity.*;

public  class Serveur extends Personnel {

    //private Map<Integer, Table> tableMap = new HashMap<>();
    private List<Integer> idTableList = new ArrayList<>();

    public Serveur(String id, String nom, String prenom, int salaire){
        super(id,nom,prenom,salaire);
    }

    public Map<Integer, Table> getTableMap() {
        Map <Integer, Table> tmpTableMap = new HashMap<>();
        /*put every table in the tableMap that have a key in idtableList  */
        for (Integer idTable : idTableList) {
            tmpTableMap.put(idTable, Data.tableList.get(idTable));
        }
        return tmpTableMap;
    }

    public Table getTableById(int id){
        return Data.tableList.get(id);
    }

    public void addTable(int idTable){
        idTableList.add(idTable);
        Data.tableList.get(idTable).setStatus(1);
    }

    public void removeTable(int idTable){
        Iterator<Integer> id = idTableList.iterator();
        while (id.hasNext()) {
            if (id.next().equals(idTable)) {
                id.remove();
            }
        }
        Data.tableList.get(idTable).setStatus(0);
    }
}