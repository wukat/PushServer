package Alcohols;

import java.util.LinkedHashMap;

public class PinaColadaCheap implements Drink {

    private final LinkedHashMap<String, Integer> ingredients;

    public PinaColadaCheap() {
        ingredients = new LinkedHashMap();
        ingredients.put(rum, 10);
        ingredients.put(coconutCream, 10);
        ingredients.put(pineappleJuice, 70);
        ingredients.put(water, 60);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }
}
