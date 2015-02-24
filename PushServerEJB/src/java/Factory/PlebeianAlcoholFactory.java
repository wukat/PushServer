package Factory;

import Alcohols.Beer;
import Alcohols.LagerBeerCheap;
import Alcohols.Water;
import Alcohols.Drink;
import Alcohols.PinaColadaCheap;
import Alcohols.BloodyMaryCheap;
import Alcohols.DarkBeerCheap;
import javax.ejb.Singleton;

@Singleton
public class PlebeianAlcoholFactory implements AlcoholFactory {

    @Override
    public Drink createDrink(String name) {
        switch (name) {
            case BLOODY_MARY:
                return new BloodyMaryCheap();
            case PINA_COLADA:
                return new PinaColadaCheap();
        }
        return new Water();
    }

    @Override
    public Beer createBeer(String name) {
        switch (name) {
            case LAGER_BEER:
                return new LagerBeerCheap();
            case DARK_BEER:
                return new DarkBeerCheap();
        }
        return new Water();
    }
}
