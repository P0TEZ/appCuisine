package app;
// CIR3 projet TP2 Alexandre & Jérôme
import app.screen.entity.*;


///////////////////////////////////////

public class AppCuisine {
    public static void main(String[] args) throws Exception {
        System.out.println("\n------------------------------------------");
        System.out.println("Debut de service\n"); 

        Builder builder = new Builder();
        builder.build();


        /////
        Data.serveurList.get("ABCD").setIsEnService(true);
        Data.setIsRestaurantOpen(true);
                
        Printer.displayMenu();

        System.out.println("Fin de service"); 
    }
}
