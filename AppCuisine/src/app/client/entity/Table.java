package app.client.entity;

public class Table {
    private int id;
    private Commande commande;
    private int status = 0;// can be 0 for empty, 1 for occupied, 2 for ready, -1 for not available...
    
    public Table(int id){
        this.id = id;
        this.commande = new Commande();
    }
    
    /* getters and setters */
    public int getId() {
        return id;
    }
    /*
    public void setId(int id) {
        this.id = id;
    }*/
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


