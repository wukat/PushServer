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
public class PinaColadaCheap implements Drink {

    private final LinkedHashMap<String, Integer> ingredients;

    public PinaColadaCheap() {
        ingredients = new LinkedHashMap();
        ingredients.put(rum, 10);
        ingredients.put(coconutCream, 10);
        ingredients.put(pineappleJuice, 70);
        ingredients.put(water, 60);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
