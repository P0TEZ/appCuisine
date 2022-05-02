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

/**
 * It returns the id of the object.
 * 
 * @return The id of the object.
 */
    public String getId() {
        return id;
    }
    
/**
 * This function returns the name of the person
 * 
 * @return The name of the person.
 */
    public String getNom() {
        return this.nom;
    }
    
/**
 * This function sets the value of the variable nom to the value of the parameter nom
 * 
 * @param nom The name of the person
 */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
/**
 * This function returns the value of the variable prenom
 * 
 * @return The prenom of the person.
 */
    public String getPrenom() {
        return this.prenom;
    }
    
/**
 * This function sets the value of the variable prenom to the value of the parameter prenom
 * 
 * @param prenom the first name of the user
 */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
/**
 * It returns the value of the variable salaire.
 * 
 * @return The salary of the employee (int).
 */
    public int getSalaire() {
        return this.salaire;
    }
    
 /**
  * It sets the salary of the employee.
  * 
  * @param salaire the salary of the employee
  */
    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
    
/**
 * This function returns the value of the boolean variable IsEnService 0=no, 1=yes
 * 
 * @return The value of the IsEnService variable.
 */
    public boolean getIsEnService() {
        return this.IsEnService;
    }
    
/**
 * This function sets the value of the boolean variable IsEnService to the value of the boolean
 * variable IsEnService
 * 
 * @param IsEnService boolean
 */
    public void setIsEnService(boolean IsEnService) {
        this.IsEnService = IsEnService;
    }
    
}