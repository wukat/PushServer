/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factory;

import Alcohols.Beer;
import Alcohols.Drink;
import Consts.MagicStrings;
import javax.ejb.Local;

/**
 *
 * @author wukat
 */
@Local
public interface AlcoholFactory extends MagicStrings {
    public abstract Drink createDrink(String name);
    public abstract Beer createBeer(String name);
}
