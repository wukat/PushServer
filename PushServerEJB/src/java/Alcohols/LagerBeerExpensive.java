package Alcohols;

import java.util.LinkedHashMap;

public class LagerBeerExpensive implements Beer {

    private final LinkedHashMap<String, Integer> ingredients;

    public LagerBeerExpensive() {
        ingredients = new LinkedHashMap();
        ingredients.put(LAGER_BEER, 500);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }
}
