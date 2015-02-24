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
            case bloodyMary:
                return new BloodyMaryCheap();
            case pinaColada:
                return new PinaColadaCheap();
        }
        return new Water();
    }

    @Override
    public Beer createBeer(String name) {
        switch (name) {
            case lagerBeer:
                return new LagerBeerCheap();
            case darkBeer:
                return new DarkBeerCheap();
        }
        return new Water();
    }
}
