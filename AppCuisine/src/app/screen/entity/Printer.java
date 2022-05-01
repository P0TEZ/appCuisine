package app.screen.entity;

import java.util.*;

public class Printer {
    
    
    public static void displayMenu(){

        System.out.println("------------------------------------------");

        System.out.println("Quel ecran souhaitez vous afficher?");
        System.out.println("\t1-Ecran serveur");
        System.out.println("\t2-Ecran cuisine");
        System.out.println("\t3-Ecran bar");
        System.out.println("\t4-Ecran Monitoring");
        System.out.println("\t5-Fermer le programme");
        Scanner scanner = new Scanner(System.in);
        int choixEcran = scanner.nextInt();

        System.out.println("Vous avez choisi l'écran: " + choixEcran);
        System.out.println("------------------------------------------");
        System.out.println();
        
        switch (choixEcran) {
            case 1:
                ServeurScreen serveurScreen = new ServeurScreen();
                serveurScreen.openServeurMenu();
                break;
            case 2:
                System.out.println("pas encore implemente");
                break;
            case 3:
                BarmanScreen barmanScreen = new BarmanScreen();
                barmanScreen.openBarmanMenu();
                break;
            case 4:
                System.out.println("pas encore implemente");
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("choix non reconnu");
                displayMenu();
                break;
        }

        scanner.close();
    }
}
