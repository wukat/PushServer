package Alcohols;

import java.util.LinkedHashMap;

public class PinaColadaCheap implements Drink {

    private final LinkedHashMap<String, Integer> ingredients;

    public PinaColadaCheap() {
        ingredients = new LinkedHashMap();
        ingredients.put(RUM, 10);
        ingredients.put(COCONUT_CREAM, 10);
        ingredients.put(PINEAPPLE_JUICE, 70);
        ingredients.put(WATER, 60);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }
}
