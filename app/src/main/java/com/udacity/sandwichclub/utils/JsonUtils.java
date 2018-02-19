package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject sandwichJson = new JSONObject(json);
        Sandwich sandwich = new Sandwich();

        // Getting name
        JSONObject nameJson = sandwichJson.getJSONObject("name");

        // Getting sandwich > name > mainName
        sandwich.setMainName(nameJson.getString("mainName"));

        // Getting sandwich > name > alsoKnownAs
        JSONArray alsoKnownAsJsonArray = nameJson.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAsList = populateFromJsonArray(alsoKnownAsJsonArray);
        sandwich.setAlsoKnownAs(alsoKnownAsList);

        // Getting sandwich > placeOfOrigin
        sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));

        // Getting sandwich > description
        sandwich.setDescription(sandwichJson.getString("description"));

        // Getting sandwich > image
        sandwich.setImage(sandwichJson.getString("image"));

        // Getting sandwich > ingredients
        JSONArray ingredientsJsonArray = sandwichJson.getJSONArray("ingredients");
        List<String> ingredientsList = populateFromJsonArray(ingredientsJsonArray);
        sandwich.setIngredients(ingredientsList);

        return sandwich;
    }
    private static List<String> populateFromJsonArray(JSONArray array) throws JSONException {
        List<String> elements = new ArrayList<>();
        for (int i=0; i < array.length(); i++) {
            String element = array.getString(i);
            elements.add(element);
        }
        return elements;
    }
}
