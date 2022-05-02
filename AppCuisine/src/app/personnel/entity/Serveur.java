package app.personnel.entity;

import java.util.*;

import app.Data;
import app.client.entity.*;

public  class Serveur extends Personnel {

    //private Map<Integer, Table> tableMap = new HashMap<>();
    private List<Integer> idTableList = new ArrayList<>();

    public Serveur(String id, String nom, String prenom, int salaire, int nbJourDeTravailDeSuite){
        super(id,nom,prenom,salaire, nbJourDeTravailDeSuite);
    }

/**
 * return evey tables that have a key in idtableList
 * 
 * @return A map of tables.
 */
    public Map<Integer, Table> getTableMap() {
        Map <Integer, Table> tmpTableMap = new HashMap<>();
        /*put every table in the tableMap that have a key in idtableList  */
        for (Integer idTable : idTableList) {
            tmpTableMap.put(idTable, Data.tableList.get(idTable));
        }
        return tmpTableMap;
    }

/**
 * It returns the table object from the tableList arraylist at the index of the id parameter
 * 
 * @param id The id of the table you want to get.
 * @return The table object with the id that was passed in.
 */
    public Table getTableById(int id){
        return Data.tableList.get(id);
    }

/**
 * It adds a table to the list of tables
 * 
 * @param idTable the id of the table
 */
    public void addTable(int idTable){
        idTableList.add(idTable);
        Data.tableList.get(idTable).setStatus(1);
    }

 /**
  * It removes a table from the list of tables
  * 
  * @param idTable the id of the table
  */
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