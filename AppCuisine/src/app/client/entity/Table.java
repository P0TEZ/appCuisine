package app.client.entity;

public class Table {
    private int id;
    private Commande commande;
    private int status;
    
    public Table(int id){
        this.id = id;
    }
    
    /* getters and setters */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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


