package Alcohols;

import Consts.MagicStrings;
import java.util.LinkedHashMap;

public class Water implements Drink, Beer, MagicStrings {

    private final LinkedHashMap<String, Integer> ingredients;

    public Water() {
        ingredients = new LinkedHashMap();
        ingredients.put(water, 200);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }
}
