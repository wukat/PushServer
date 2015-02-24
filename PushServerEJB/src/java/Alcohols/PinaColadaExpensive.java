package Alcohols;

import java.util.LinkedHashMap;

public class PinaColadaExpensive implements Drink {

    private final LinkedHashMap<String, Integer> ingredients;

    public PinaColadaExpensive() {
        ingredients = new LinkedHashMap();
        ingredients.put(RUM, 30);
        ingredients.put(COCONUT_CREAM, 30);
        ingredients.put(PINEAPPLE_JUICE, 90);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }
}
