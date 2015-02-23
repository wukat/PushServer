/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alcohols;

import java.util.LinkedHashMap;

/**
 *
 * @author krzysztof
 */
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
