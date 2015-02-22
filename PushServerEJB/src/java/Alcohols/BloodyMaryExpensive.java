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
public class BloodyMaryExpensive implements Drink {

    private final HashMap<String, Integer> ingredients;
    
    public BloodyMaryExpensive() {
        ingredients = new HashMap();
        ingredients.put("Vodka", 90);
        ingredients.put("TomatoJuice", 180);
        ingredients.put("Tabasco", 10);
    }
    
    @Override
    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }
    
}
