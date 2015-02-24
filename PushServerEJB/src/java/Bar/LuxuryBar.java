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

@Singleton
@DependsOn("LuxuryAlcoholFactory")
public class LuxuryBar extends BarAbstract implements BarLocal {

    @EJB(beanName = "LuxuryAlcoholFactory")
    AlcoholFactory alcoholFactory;

    @PostConstruct
    public void postConstruct() {
        products = new LinkedHashMap<>();
        products.put(LAGER_BEER, 15000);
        products.put(DARK_BEER, 5000);
        products.put(WATER, 100000);
        products.put(VODKA, 1000);
        products.put(RUM, 1000);
        products.put(TOMATO_JUICE, 2000);
        products.put(TABASCO, 500);
        products.put(PINEAPPLE_JUICE, 1000);
        products.put(COCONUT_CREAM, 200);

        drinks = new LinkedList<>();
        drinks.add(BLOODY_MARY);
        drinks.add(PINA_COLADA);

        beers = new LinkedList<>();
        beers.add(LAGER_BEER);
        beers.add(DARK_BEER);

        barName = LUXURY_BAR;
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
