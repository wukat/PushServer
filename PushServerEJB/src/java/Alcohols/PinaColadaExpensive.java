package Alcohols;

import java.util.LinkedHashMap;

public class PinaColadaExpensive implements Drink {

    private final LinkedHashMap<String, Integer> ingredients;

    public PinaColadaExpensive() {
        ingredients = new LinkedHashMap();
        ingredients.put(rum, 30);
        ingredients.put(coconutCream, 30);
        ingredients.put(pineappleJuice, 90);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }
}
