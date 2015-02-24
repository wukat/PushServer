package Factory;

import Alcohols.LagerBeerExpensive;
import Alcohols.BloodyMaryExpensive;
import Alcohols.Beer;
import Alcohols.Water;
import Alcohols.PinaColadaExpensive;
import Alcohols.DarkBeerExpensive;
import Alcohols.Drink;
import javax.ejb.Singleton;

@Singleton
public class LuxuryAlcoholFactory implements AlcoholFactory {

    @Override
    public Drink createDrink(String name) {
        switch (name) {
            case BLOODY_MARY:
                return new BloodyMaryExpensive();
            case PINA_COLADA:
                return new PinaColadaExpensive();
        }
        return new Water();
    }

    @Override
    public Beer createBeer(String name) {
        switch (name) {
            case LAGER_BEER:
                return new LagerBeerExpensive();
            case DARK_BEER:
                return new DarkBeerExpensive();
        }
        return new Water();
    }

}
