package app.screen.entity;

import java.util.*;
import app.*;

public class Printer {
    public static String ESC = "\u001B";
    public static String GS = "\u001D";
    public static String InitializePrinter = ESC + "@";
    public static String BoldOn = ESC + "E" + "\u0001";
    public static String BoldOff = ESC + "E" + "\0";
    public static String DoubleOn = GS + "!" + "\u0011";  // 2x sized text (double-high + double-wide)
    public static String DoubleOff = GS + "!" + "\0";
    
    public static void displayMenu(){
        clearConsole();
        
        System.out.println("------------------------------------------");
        
        System.out.println("Quel ecran souhaitez vous afficher?\n");
        System.out.println("\t1-Ecran serveur");
        System.out.println("\t2-Ecran cuisine");
        System.out.println("\t3-Ecran bar");
        System.out.println("\t4-Ecran manager");
        System.out.println("\t5-Fermer le programme");
        
        int choixEcran = Scan.sc.nextInt();
        Scan.sc.nextLine(); 
        
        System.out.println("\nVous avez choisi l'écran: " + choixEcran);
        
        switch (choixEcran) {
            case 1:
                ServeurScreen serveurScreen = new ServeurScreen();
                serveurScreen.openServeurMenu();
                break;
            case 2:
                CuisinierScreen cuisinierScreen = new CuisinierScreen();
                cuisinierScreen.openCuisinierMenu();
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
                System.out.println("Sauvegarde des données");
                Saver.saveAll();
                System.exit(0);
                break;
            default:
                System.out.println("choix non reconnu");
                displayMenu();
                break;
        }
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void boldPrint(String input){
        System.out.println(BoldOn + input + BoldOff);
    }

    public static void doublePrint(String input){
        System.out.println(DoubleOn + input + DoubleOff);
    }
}
