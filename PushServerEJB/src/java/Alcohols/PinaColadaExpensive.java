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
public class PinaColadaExpensive implements Drink {

    private final LinkedHashMap<String, Integer> ingredients;

    public PinaColadaExpensive() {
        ingredients = new LinkedHashMap();
        ingredients.put(rum, 30);
        ingredients.put(coconutCream, 30);
        ingredients.put(pineappleJuice, 90);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
