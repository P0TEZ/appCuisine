package app.personnel.entity;

import java.util.*;
import app.client.entity.*;

public  class Serveur extends Personnel {

    public static Map<Integer, Table> ingredientList = new HashMap<>();

    public Serveur(String nom, String prenom, int salaire){
        super(nom,prenom,salaire);
    }
}