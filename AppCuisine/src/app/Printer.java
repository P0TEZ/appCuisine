package app;

import java.util.*;

public class Printer {


    public void displayMenu(){    
        System.out.println("Quel écran souhaitez vous afficher?");
        System.out.println("1-Ecran prise de commande");
        System.out.println("2-Ecran cuisine");
        System.out.println("3-Ecran bar");
        System.out.println("4-Ecran Monitoring");
        Scanner scanner = new Scanner(System.in);
        int choixEcran = scanner.nextInt();

        System.out.println("Vous avez choisi l'écran: " + choixEcran);}
    }
    