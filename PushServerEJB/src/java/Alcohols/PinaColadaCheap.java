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
        ingredients.put(rum, 10);
        ingredients.put(coconutCream, 10);
        ingredients.put(pineappleJuice, 70);
        ingredients.put(water, 60);
    }
    
    @Override
    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }
    
}
