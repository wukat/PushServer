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
public class PinaColadaExpensive implements Drink {

    private final HashMap<String, Integer> ingredients;
    
    public PinaColadaExpensive() {
        ingredients = new HashMap();
        ingredients.put(rum, 30);
        ingredients.put(coconutCream, 30);
        ingredients.put(pineappleJuice, 90);
    }
    
    @Override
    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }
    
}
