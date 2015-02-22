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
public class BloodyMaryCheap implements Drink {

    private final HashMap<String, Integer> ingredients;
    
    public BloodyMaryCheap() {
        ingredients = new HashMap();
        ingredients.put(vodka, 40);
        ingredients.put(water, 100);
        ingredients.put(tomatoJuice, 130);
        ingredients.put(tabasco, 10);
    }
    
    @Override
    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }
    
}
