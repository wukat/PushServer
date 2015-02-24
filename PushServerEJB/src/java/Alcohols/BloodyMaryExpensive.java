package Alcohols;

import java.util.LinkedHashMap;

public class BloodyMaryExpensive implements Drink {

    private final LinkedHashMap<String, Integer> ingredients;

    public BloodyMaryExpensive() {
        ingredients = new LinkedHashMap();
        ingredients.put(vodka, 90);
        ingredients.put(tomatoJuice, 180);
        ingredients.put(tabasco, 10);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
