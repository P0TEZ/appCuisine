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
/**
 * It returns the commande.
 * 
 * @return The commande object.
 */
    public Commande getCommande() {
        return commande;
    }
/**
 * It sets the commande.
 * 
 * @param commande the commande object
 */
    public void setCommande(Commande commande) {
        this.commande = commande;
    }
/**
 * This function returns the status of the current object
 * 
 * @return The status of the order.
 */
    public int getStatus() {
        return status;
    }
/**
 * This function sets the status of the current object to the status passed in as a parameter
 * 
 * @param status The status of the response.
 */
    public void setStatus(int status) {
        this.status = status;
    }

/**
 * This function is used to reset the table
 */
    public void resetTable(){
        this.commande = new Commande();
        this.status = 0;
    }
}


