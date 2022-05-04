package app.personnel.entity;

import app.Data;

public  abstract class Personnel {
    private String id;
    private String nom;
    private String prenom;
    private int salaire;
    private boolean isEnService = false;
    private int nbJourDeTravailDeSuite = 0;
    
    public Personnel(String id,String nom, String prenom, int salaire, int nbJourDeTravailDeSuite){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
        this.nbJourDeTravailDeSuite = nbJourDeTravailDeSuite;
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
        return this.isEnService;
    }
    
    /**
    * This function sets the value of the boolean variable IsEnService to the value of the boolean
    * variable IsEnService
    * 
    * @param IsEnService boolean
    */
    public void setIsEnService(boolean isEnService) {
        this.isEnService = isEnService;
    }
    
    /**
    * This function sets the number of days worked in a row
    * 
    * @param nbJourDeTravailDeSuite number of days worked in a row
    */
    public void setNbJourDeTravailDeSuite(int nbJourDeTravailDeSuite) {
        this.nbJourDeTravailDeSuite = nbJourDeTravailDeSuite;
    }

    /**
     * This function adds one to the number of days worked in a row
     */
    public void addNbJourDeTravailDeSuite() {
        this.nbJourDeTravailDeSuite += 1;
    }
    
    /**
    * This function returns the number of days of work in a row
    * 
    * @return The number of days worked in a row.
    */
    public int getNbJourDeTravailDeSuite() {
        return nbJourDeTravailDeSuite;
    }

/**
 * If the employee is in service, return the number of days worked in a row plus one. Otherwise, return
 * the number of days worked in a row
 * 
 * @return The number of days the employee has worked in a row.
 */
    public int getNewNbJourDeTravailDeSuite() {
        if(this.isEnService){
            return this.nbJourDeTravailDeSuite + 1;
        }else{
            return 0;
        }
    }
    
    
    /**
    * It generates a random string of length 4, and if that string is already in use, it generates another
    * one
    * 
    * @return A string of length 4.
    */
    public static String generateId(){
        /*function that generate a rdn string of length 4 example 'aaaa'*/ 
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int string_length = 4;
        String randomString = "";
        for (Integer i = 0; i < string_length; i++) {
            int rnum = (int)Math.floor(Math.random() * chars.length());
            randomString += chars.substring(rnum, rnum + 1);
        }
        
        if(Data.serveurList.containsKey(randomString) || Data.cuisinierList.containsKey(randomString) || Data.barmanList.containsKey(randomString)){
            generateId();
        }
        
        return randomString;
    }
    
}