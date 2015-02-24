package Bar;

import Factory.AlcoholFactory;
import Alcohols.Beer;
import Alcohols.Drink;
import ChainOfResponsibility.ProviderMainLocal;
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

public abstract class BarAbstract implements BarLocal {

    private final ProviderMainLocal providerMain = lookupProviderMainLocal();

    private final PublishServiceLocal publishService = lookupPublishServiceLocal();

    protected LinkedHashMap<String, Integer> products;
    protected LinkedList<String> drinks;
    protected LinkedList<String> beers;
    protected String barName;

    @Override
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
            currentDrink = alcoholFactory.createDrink(WATER);
            order = new Order(name + " - brak składników!", barName);
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
            currentBeer = alcoholFactory.createBeer(WATER);
            order = new Order(name + " - brak składników!", barName);
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
            providerMain.handleProductRequest(missingProduct, Integer.SIZE, this);
            return false;
        }
    }

    @Override
    public void sendEvent(Event event) {
        publishService.receiveEvent(event);
    }

    @Override
    public void receiveProduct(String product, Integer amount) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + amount);
        }
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

    private ProviderMainLocal lookupProviderMainLocal() {
        try {
            Context c = new InitialContext();
            return (ProviderMainLocal) c.lookup("java:global/PushServer/PushServerEJB/ProviderMain!ChainOfResponsibility.ProviderMainLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
