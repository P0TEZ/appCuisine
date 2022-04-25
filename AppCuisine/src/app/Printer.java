package app;

import java.util.*;

import app.personnel.entity.*;

public class Printer {
    
    
    public void displayMenu(){    
        System.out.println("Quel ecran souhaitez vous afficher?");
        System.out.println("1-Ecran prise de commande");
        System.out.println("2-Ecran cuisine");
        System.out.println("3-Ecran bar");
        System.out.println("4-Ecran Monitoring");
        System.out.println("5-Fermer le programme");
        Scanner scanner = new Scanner(System.in);
        int choixEcran = scanner.nextInt();

        System.out.println("Vous avez choisi l'écran: " + choixEcran);
        
        if(choixEcran == 1){
            this.displayCommande();
        }
        else{
            System.out.println("pas encore implemente");
        }

        scanner.close();
    }

    public void displayCommande(){
        
        /*scanner get serveur nom*/
        System.out.println("Nom du serveur : ");
        Scanner scanner = new Scanner(System.in);

        String serveurNom = scanner.nextLine();

        /*scanner get serveur prenom*/
        System.out.println("Prenom du serveur : ");

        String serveurPrenom = scanner.nextLine();


        /*convert lowercase string to huppercase string*/
        serveurNom = serveurNom.toUpperCase();
        serveurPrenom = serveurPrenom.toUpperCase();

        Serveur serveur = new Serveur(serveurNom, serveurPrenom, 0);
        if(Data.serveurList.containsKey(serveur.getNom())){
            System.out.println("Le serveur est dans la liste");
        }
        else{
            System.out.println("Le serveur n'est pas dans la liste");
        }
        
        System.out.println("Numero de la table : ");

        int choixTable = scanner.nextInt();

        System.out.println("Vous avez choisi la table numero " + choixTable);

        scanner.close();
    }


    
}
