/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alcohols;

import Consts.MagicStrings;
import java.util.LinkedHashMap;

/**
 *
 * @author krzysztof
 */
public class Water implements Drink, Beer, MagicStrings {

    private final LinkedHashMap<String, Integer> ingredients;

    public Water() {
        ingredients = new LinkedHashMap();
        ingredients.put(water, 200);
    }

    @Override
    public LinkedHashMap<String, Integer> getIngredients() {
        return ingredients;
    }

}
