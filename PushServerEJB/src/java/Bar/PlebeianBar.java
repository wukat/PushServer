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
@DependsOn("PlebeianAlcoholFactory")
public class PlebeianBar extends BarAbstract implements BarLocal {

    @EJB(beanName = "PlebeianAlcoholFactory")
    AlcoholFactory alcoholFactory;

    @PostConstruct
    public void postConstruct() {
        products = new LinkedHashMap<>();
        products.put(LAGER_BEER, 10000);
        products.put(DARK_BEER, 5000);
        products.put(WATER, 100000);
        products.put(VODKA, 500);
        products.put(RUM, 200);
        products.put(TOMATO_JUICE, 1000);
        products.put(TABASCO, 200);
        products.put(PINEAPPLE_JUICE, 5000);
        products.put(COCONUT_CREAM, 50);

        drinks = new LinkedList<>();
        drinks.add(BLOODY_MARY);
        drinks.add(PINA_COLADA);

        beers = new LinkedList<>();
        beers.add(LAGER_BEER);
        beers.add(DARK_BEER);

        barName = PLEBEIAN_BAR;
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
