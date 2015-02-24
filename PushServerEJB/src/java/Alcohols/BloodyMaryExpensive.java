package Alcohols;

import java.util.LinkedHashMap;

public class BloodyMaryExpensive implements Drink {

    private final LinkedHashMap<String, Integer> ingredients;

    public BloodyMaryExpensive() {
        ingredients = new LinkedHashMap();
        ingredients.put(VODKA, 90);
        ingredients.put(TOMATO_JUICE, 180);
        ingredients.put(TABASCO, 10);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
