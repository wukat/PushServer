/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import Alcohols.Beer;
import Alcohols.Drink;
import java.util.LinkedList;
import javax.ejb.Local;

/**
 *
 * @author wukat
 */
@Local
public interface BarLocal {

    public LinkedList<String> getBeers();

    public LinkedList<String> getDrinks();

    public Drink makeDrink(String name);

    public Beer makeBeer(String name);
}
