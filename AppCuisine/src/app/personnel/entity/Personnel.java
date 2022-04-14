package app.personnel.entity;

public  class Personnel {
    private String nom;
    private String prenom;

    private boolean IsEnService = false;
    
    public Personnel(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
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

}