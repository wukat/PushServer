/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bar;

import Factory.Beer;
import Factory.Drink;
import Factory.PlebeianAlcoholFactory;
import java.util.HashMap;
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
public class PlebeianBar implements BarLocal {

    HashMap<String, Integer> products;
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
    }
    
    @Override
    public Drink makeDrink(String name) {
        return alcoholFactory.createDrink(name);
    }

    @Override
    public Beer makeBeer(String name) {
        return alcoholFactory.createBeer(name);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
