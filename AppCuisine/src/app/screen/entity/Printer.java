package app.screen.entity;

import java.util.*;

public class Printer {
    
    
    public static void displayMenu(){    
        System.out.println("Quel ecran souhaitez vous afficher?");
        System.out.println("1-Ecran serveur");
        System.out.println("2-Ecran cuisine");
        System.out.println("3-Ecran bar");
        System.out.println("4-Ecran Monitoring");
        System.out.println("5-Fermer le programme");
        Scanner scanner = new Scanner(System.in);
        int choixEcran = scanner.nextInt();

        System.out.println("Vous avez choisi l'écran: " + choixEcran);
        
        switch (choixEcran) {
            case 1:
                ServeurScreen serveurScreen = new ServeurScreen();
                serveurScreen.openServeurMenu();
                break;
            case 2:
                System.out.println("pas encore implemente");
                break;
            case 3:
                System.out.println("pas encore implemente");
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
