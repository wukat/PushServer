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
public class LagerBeerExpensive implements Beer {

    private final LinkedHashMap<String, Integer> ingredients;

    public LagerBeerExpensive() {
        ingredients = new LinkedHashMap();
        ingredients.put(lagerBeer, 500);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
