package Alcohols;

import java.util.LinkedHashMap;

public class DarkBeerExpensive implements Beer {

    private final LinkedHashMap<String, Integer> ingredients;

    public DarkBeerExpensive() {
        ingredients = new LinkedHashMap();
        ingredients.put(darkBeer, 500);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
