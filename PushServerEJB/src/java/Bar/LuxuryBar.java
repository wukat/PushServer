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
public class LuxuryBar implements BarLocal {

    HashMap<String, Integer> products;
    @EJB
    LuxuryAlcoholFactory alcoholFactory;

    @PostConstruct
    public void postConstruct() {
        try {
            InitialContext ctx = new InitialContext();
            alcoholFactory = (LuxuryAlcoholFactory) ctx.lookup("java:global/PushServer/PushServerEJB/LuxuryAlcoholFactory");
        } catch (NamingException ex) {
            Logger.getLogger(LuxuryBar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
