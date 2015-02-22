/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Alcohols;

import Consts.MagicStrings;
import java.util.HashMap;

/**
 *
 * @author krzysztof
 */
public class Water implements Drink, Beer, MagicStrings {

    private final HashMap<String, Integer> ingredients;
    
    public Water() {
        ingredients = new HashMap();
        ingredients.put(water, 200);
    }
    
    @Override
    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }
    
}
