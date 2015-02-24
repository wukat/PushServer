package Alcohols;

import java.util.LinkedHashMap;

public class BloodyMaryCheap implements Drink {

    private final LinkedHashMap<String, Integer> ingredients;

    public BloodyMaryCheap() {
        ingredients = new LinkedHashMap();
        ingredients.put(VODKA, 40);
        ingredients.put(WATER, 100);
        ingredients.put(TOMATO_JUICE, 130);
        ingredients.put(TABASCO, 10);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
