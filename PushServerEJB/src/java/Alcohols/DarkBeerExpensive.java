package Alcohols;

import java.util.LinkedHashMap;

public class DarkBeerExpensive implements Beer {

    private final LinkedHashMap<String, Integer> ingredients;

    public DarkBeerExpensive() {
        ingredients = new LinkedHashMap();
        ingredients.put(DARK_BEER, 500);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
