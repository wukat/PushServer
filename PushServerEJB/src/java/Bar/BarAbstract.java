/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import Factory.AlcoholFactory;
import Alcohols.Beer;
import Alcohols.Drink;
import Factory.IngredientsGetter;
import PublisherSubscriber.Event;
import PublisherSubscriber.PublishServiceLocal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author wukat
 */
public abstract class BarAbstract implements BarLocal {

    PublishServiceLocal publishService = lookupPublishServiceLocal();

    LinkedHashMap<String, Integer> products;
    LinkedList<String> drinks;
    LinkedList<String> beers;
    String barName;

    public String getBarName() {
        return barName;
    }

    @Override
    public LinkedList<String> getBeers() {
        return beers;
    }

    @Override
    public LinkedList<String> getDrinks() {
        return drinks;
    }

    protected Drink makeDrinkPr(String name, AlcoholFactory alcoholFactory) {
        Drink currentDrink = alcoholFactory.createDrink(name);
        Order order = new Order(name, barName);
        if (!checkCreation(currentDrink)) {
            currentDrink = alcoholFactory.createDrink(water);
            order = new Order(water, barName);
        }
        sendEvent(order);
        return currentDrink;
    }

    @Override
    public abstract Drink makeDrink(String name);

    protected Beer makeBeerPr(String name, AlcoholFactory alcoholFactory) {
        Beer currentBeer = alcoholFactory.createBeer(name);
        Order order = new Order(name, barName);
        if (!checkCreation(currentBeer)) {
            currentBeer = alcoholFactory.createBeer(water);
            order = new Order(water, barName);
        }
        sendEvent(order);
        return currentBeer;
    }

    @Override
    public abstract Beer makeBeer(String name);

    protected String whichPorudctIsMissing(IngredientsGetter alcohol) {
        HashMap<String, Integer> ingredients = alcohol.getIngredients();
        for (String productName : ingredients.keySet()) {
            if (ingredients.get(productName) > products.get(productName)) {
                return productName;
            }
        }
        return null;
    }

    protected void actualizeProductsState(IngredientsGetter alcohol) {
        HashMap<String, Integer> ingredients = alcohol.getIngredients();
        for (String productName : ingredients.keySet()) {
            products.put(productName, products.get(productName) - ingredients.get(productName));
        }
    }

    protected boolean checkCreation(IngredientsGetter alcohol) {
        String missingProduct = whichPorudctIsMissing(alcohol);
        if (missingProduct == null) {
            actualizeProductsState(alcohol);
            return true;
        } else {
            // call chain
            return false;
        }
    }

    @Override
    public void sendEvent(Event event) {
        publishService.receiveEvent(event);
    }

    private PublishServiceLocal lookupPublishServiceLocal() {
        try {
            Context c = new InitialContext();
            return (PublishServiceLocal) c.lookup("java:global/PushServer/PushServerEJB/PublishService!PublisherSubscriber.PublishServiceLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
