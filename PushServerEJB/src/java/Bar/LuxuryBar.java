/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import Factory.AlcoholFactory;
import Factory.Beer;
import Factory.Drink;
import Factory.LuxuryAlcoholFactory;
import Factory.PlebeianAlcoholFactory;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author wukat
 */
@Singleton
@DependsOn("LuxuryAlcoholFactory")
public class LuxuryBar extends BarLocal {

    @EJB(beanName = "LuxuryAlcoholFactory")
    AlcoholFactory alcoholFactory;

    @PostConstruct
    public void postConstruct() {
        products = new HashMap<>();
        products.put("LagerBeer", 15000);
        products.put("DarkBeer", 5000);
        products.put("Water", 100000);
        products.put("Vodka", 1000);
        products.put("Rum", 1000);
        products.put("TomatoJuice", 2000);
        products.put("Tabasco", 500);
        products.put("PineappleJuice", 1000);
        products.put("CoconutCream", 200);
        
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
}
