/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import Factory.AlcoholFactory;
import Alcohols.Beer;
import Alcohols.Drink;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;

/**
 *
 * @author wukat
 */
@Singleton
@DependsOn("LuxuryAlcoholFactory")
public class LuxuryBar extends BarAbstract implements BarLocal {

    @EJB(beanName = "LuxuryAlcoholFactory")
    AlcoholFactory alcoholFactory;

    @PostConstruct
    public void postConstruct() {
        products = new LinkedHashMap<>();
        products.put(lagerBeer, 15000);
        products.put(darkBeer, 5000);
        products.put(water, 100000);
        products.put(vodka, 1000);
        products.put(rum, 1000);
        products.put(tomatoJuice, 2000);
        products.put(tabasco, 500);
        products.put(pineappleJuice, 1000);
        products.put(coconutCream, 200);

        drinks = new LinkedList<>();
        drinks.add(bloodyMary);
        drinks.add(pinaColada);

        beers = new LinkedList<>();
        beers.add(lagerBeer);
        beers.add(darkBeer);

        barName = luxuryBar;
    }

    @Override
    public Drink makeDrink(String name) {
        return makeDrinkPr(name, alcoholFactory);
    }

    @Override
    public Beer makeBeer(String name) {
        return makeBeerPr(name, alcoholFactory);
    }
}
