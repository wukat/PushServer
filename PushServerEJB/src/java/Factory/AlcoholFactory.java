package Factory;

import Alcohols.Beer;
import Alcohols.Drink;
import Consts.MagicStrings;
import javax.ejb.Local;

@Local
public interface AlcoholFactory extends MagicStrings {

    public abstract Drink createDrink(String name);

    public abstract Beer createBeer(String name);
}
