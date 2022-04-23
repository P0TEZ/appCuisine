package app;
// CIR3 projet TP2 Alexandre & Jérôme
import java.util.*;
import java.io.*;
import java.math.*;

import app.personnel.entity.*;
import app.carte.entity.*;

///////////////////////////////////////

public class AppCuisine {
    public static void main(String[] args) throws Exception {
        System.out.println("Debut de service"); 

        Builder builder = new Builder();
        Printer printer = new Printer();

        printer.displayMenu();


        System.out.println("Fin de service"); 
    }
}
