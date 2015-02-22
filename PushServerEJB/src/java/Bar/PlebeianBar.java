/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bar;

import Factory.AlcoholFactory;
import Alcohols.Beer;
import Alcohols.Drink;
import java.util.HashMap;
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
public class PlebeianBar extends BarLocal {

    @EJB(beanName = "PlebaianAlcoholFactory")
    AlcoholFactory alcoholFactory;

    @PostConstruct
    public void postConstruct() {
        products = new HashMap<>();
        products.put("LagerBeer", 10000);
        products.put("DarkBeer", 5000);
        products.put("Water", 100000);
        products.put("Vodka", 500);
        products.put("Rum", 200);
        products.put("TomatoJuice", 1000);
        products.put("Tabasco", 200);
        products.put("PineappleJuice", 5000);
        products.put("CoconutCream", 50);
        
        drinks = new LinkedList<>();
        drinks.add("Bloody Mary");
        drinks.add("Pina Colada");
        
        beers = new LinkedList<>();
        beers.add("Jasne");
        beers.add("Ciemne");
    }
    
    @Override
    public Drink makeDrink(String name) {
        return makeDrinkPr(name, alcoholFactory);
    }

    @Override
    public Beer makeBeer(String name) {
        return makeBeerPr(name, alcoholFactory);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
