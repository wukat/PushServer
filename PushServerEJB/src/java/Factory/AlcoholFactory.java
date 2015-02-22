/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factory;

import Alcohols.Beer;
import Alcohols.Drink;
import javax.ejb.Local;

/**
 *
 * @author wukat
 */
@Local
public interface AlcoholFactory {
    public abstract Drink createDrink(String name);
    public abstract Beer createBeer(String name);
}
