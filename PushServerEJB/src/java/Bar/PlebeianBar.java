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
@DependsOn("PlebeianAlcoholFactory")
public class PlebeianBar extends BarAbstract implements BarLocal {

    @EJB(beanName = "PlebeianAlcoholFactory")
    AlcoholFactory alcoholFactory;

    @PostConstruct
    public void postConstruct() {
        products = new LinkedHashMap<>();
        products.put(lagerBeer, 10000);
        products.put(darkBeer, 5000);
        products.put(water, 100000);
        products.put(vodka, 500);
        products.put(rum, 200);
        products.put(tomatoJuice, 1000);
        products.put(tabasco, 200);
        products.put(pineappleJuice, 5000);
        products.put(coconutCream, 50);

        drinks = new LinkedList<>();
        drinks.add(bloodyMary);
        drinks.add(pinaColada);

        beers = new LinkedList<>();
        beers.add(lagerBeer);
        beers.add(darkBeer);

        barName = plebeianBar;
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
