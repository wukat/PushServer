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
public class LagerBeerCheap implements Beer {

    private final LinkedHashMap<String, Integer> ingredients;

    public LagerBeerCheap() {
        ingredients = new LinkedHashMap();
        ingredients.put(lagerBeer, 400);
        ingredients.put(water, 100);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
