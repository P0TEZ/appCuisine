package app;

import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Builder {

    public void generateIngredient(){
        JSONParser jsonP = new JSONParser();
        JSONObject jsonO = (JSONObject) jsonP.parse(new FileReader("./_data/ingredientList.json"));

        List<String> ingredientList = new ArrayList<String>();
        ingredientList = (String) jsonO.get("ingredient");
    }

}