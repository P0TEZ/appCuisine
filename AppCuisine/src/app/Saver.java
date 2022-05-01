package app;

import java.io.*;
import java.util.*;
import app.carte.entity.*;

public class Saver {
    /*function that save StockList in a file*/
    public static void saveStock() {
        try {
            // Create file 
            FileWriter fstream = new FileWriter("./src/app/_data/stock.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            
            for (Map.Entry<String, Integer> entry : Stock.getStock().entrySet()) {
                out.write(entry.getKey() + "_" + entry.getValue() + "_\n");
            }
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
