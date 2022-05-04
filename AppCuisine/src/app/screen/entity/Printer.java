package app.screen.entity;

import java.io.IOException;

import app.*;

public class Printer {
    
    public static void displayMenu(){
        clearConsole();
        
        System.out.println("------------------------------------------");
        System.out.println("Choix de l'écran : ");
        System.out.println("------------------------------------------");

        System.out.println("\t1-Serveur");
        System.out.println("\t2-Cuisine");
        System.out.println("\t3-Bar");
        System.out.println("\t4-Manager");
        System.out.println("\t5-Quitter");
        
        int choixEcran = Scan.sc.nextInt();
        Scan.sc.nextLine(); 
                
        switch (choixEcran) {
            case 1:
                ServeurScreen serveurScreen = new ServeurScreen();
                serveurScreen.openServeurMenu();
                break;
            case 2:
                CuisinerScreen cuisinerScreen = new CuisinerScreen();
                cuisinerScreen.openCuisinierMenu();
                break;
            case 3:
                BarmanScreen barmanScreen = new BarmanScreen();
                barmanScreen.openBarmanMenu();
                break;
            case 4:
                ManagerScreen managerScreen = new ManagerScreen();
                managerScreen.openManagerMenu();
                break;
            case 5:
                System.out.println("Seul le manager peut fermer le restaurant");
                enterToContinue();
                displayMenu();

                break;
            default:
                System.out.println("choix non reconnu");
                Printer.enterToContinue();
                displayMenu();
                break;
        }
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void enterToContinue(){
        System.out.println("[Entrer] pour continuer");
        Scan.sc.nextLine();
    }

}
