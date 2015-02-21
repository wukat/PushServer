/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factory;

/**
 *
 * @author krzysztof
 */
public class LuxuryDrink extends Drink {

    @Override
    public String getComposition() {
        return "10ml wodki, 100ml soku pomidorowego, 20ml soku cytrynowego, tabasco";
    }
    
}
