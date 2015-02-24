package Alcohols;

import java.util.LinkedHashMap;

public class BloodyMaryCheap implements Drink {

    private final LinkedHashMap<String, Integer> ingredients;

    public BloodyMaryCheap() {
        ingredients = new LinkedHashMap();
        ingredients.put(vodka, 40);
        ingredients.put(water, 100);
        ingredients.put(tomatoJuice, 130);
        ingredients.put(tabasco, 10);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
