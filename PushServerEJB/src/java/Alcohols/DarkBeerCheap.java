package Alcohols;

import java.util.LinkedHashMap;

public class DarkBeerCheap implements Beer {

    private final LinkedHashMap<String, Integer> ingredients;

    public DarkBeerCheap() {
        ingredients = new LinkedHashMap();
        ingredients.put(darkBeer, 400);
        ingredients.put(water, 100);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
