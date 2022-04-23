package app.client.entity;

import app.personnel.entity.*;

public class Table {
    private int id;
    private Serveur serveur;
    private Commande commande;
    private int status;
    
    public Table(int id, Serveur serveur){
        this.id = id;
        this.serveur = serveur;
    }
    
    /* getters and setters */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Serveur getServeur() {
        return serveur;
    }
    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }
    public Commande getCommande() {
        return commande;
    }
    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}


