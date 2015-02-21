/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bar;

import Factory.Beer;
import Factory.Drink;
import Factory.IngredientsGetter;
import Factory.PlebeianAlcoholFactory;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author wukat
 */
@Singleton
public class PlebeianBar extends BarLocal {

    @EJB
    PlebeianAlcoholFactory alcoholFactory;

    @PostConstruct
    public void postConstruct() {
        try {
            InitialContext ctx = new InitialContext();
            alcoholFactory = (PlebeianAlcoholFactory) ctx.lookup("java:global/PushServer/PushServerEJB/LuxuryAlcoholFactory");
        } catch (NamingException ex) {
            Logger.getLogger(LuxuryBar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
