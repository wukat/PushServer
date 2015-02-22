/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Alcohols;

import java.util.HashMap;

/**
 *
 * @author krzysztof
 */
public class LagerBeerCheap implements Beer {

    private final HashMap<String, Integer> ingredients;
    
    public LagerBeerCheap() {
        ingredients = new HashMap();
        ingredients.put("LagerBeer", 400);
        ingredients.put("Water", 100);
    }
    
    @Override
    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }
    
}
