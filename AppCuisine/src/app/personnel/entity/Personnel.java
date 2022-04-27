package app.personnel.entity;

public  abstract class Personnel {
    private String id;
    private String nom;
    private String prenom;
    private int salaire;
    private boolean IsEnService = false;
    
    public Personnel(String id,String nom, String prenom, int salaire){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
    }

    public String getId() {
        return id;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public int getSalaire() {
        return this.salaire;
    }
    
    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
    
    public boolean getIsEnService() {
        return this.IsEnService;
    }
    
    public void setIsEnService(boolean IsEnService) {
        this.IsEnService = IsEnService;
    }
    
}