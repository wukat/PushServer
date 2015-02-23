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
public class DarkBeerExpensive implements Beer {

    private final LinkedHashMap<String, Integer> ingredients;

    public DarkBeerExpensive() {
        ingredients = new LinkedHashMap();
        ingredients.put(darkBeer, 500);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
