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
public class PinaColadaCheap implements Drink {

    private final HashMap<String, Integer> ingredients;
    
    public PinaColadaCheap() {
        ingredients = new HashMap();
        ingredients.put("Rum", 10);
        ingredients.put("CoconutCream", 10);
        ingredients.put("PineappleJuice", 70);
        ingredients.put("Water", 60);
    }
    
    @Override
    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }
    
}
