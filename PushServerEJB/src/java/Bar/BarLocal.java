/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import Factory.AlcoholFactory;
import Factory.Beer;
import Factory.Drink;
import Factory.IngredientsGetter;
import java.util.HashMap;
import java.util.LinkedList;
import javax.ejb.Local;

/**
 *
 * @author wukat
 */
@Local
public abstract class BarLocal {

    HashMap<String, Integer> products;
    LinkedList<String> drinks;
    LinkedList<String> beers;

    public LinkedList<String> getBeers() {
        return beers;
    }

    public LinkedList<String> getDrinks() {
        return drinks;
    }
    
    protected Drink makeDrinkPr(String name, AlcoholFactory alcoholFactory) {
        Drink currentDrink = alcoholFactory.createDrink(name);
        if (!checkCreation(currentDrink)) {
            currentDrink = alcoholFactory.createDrink("Water");
        }
        return currentDrink;
    }

    public abstract Drink makeDrink(String name);

    protected Beer makeBeerPr(String name, AlcoholFactory alcoholFactory) {
        Beer currentBeer = alcoholFactory.createBeer(name);
        if (!checkCreation(currentBeer)) {
            currentBeer = alcoholFactory.createBeer("Water");
        }
        return currentBeer;
    }

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
        if (missingProduct != null) {
            actualizeProductsState(alcohol);
            return true;
        } else {
            // call chain
            return false;
        }
    }
}
