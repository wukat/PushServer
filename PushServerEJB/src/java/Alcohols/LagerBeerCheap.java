package Alcohols;

import java.util.LinkedHashMap;

public class LagerBeerCheap implements Beer {

    private final LinkedHashMap<String, Integer> ingredients;

    public LagerBeerCheap() {
        ingredients = new LinkedHashMap();
        ingredients.put(LAGER_BEER, 400);
        ingredients.put(WATER, 100);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }
}
