package Bar;

import Alcohols.Beer;
import Alcohols.Drink;
import ChainOfResponsibility.ProductReceiver;
import Consts.MagicStrings;
import PublishSubscribe.Publisher;
import java.io.Serializable;
import java.util.LinkedList;
import javax.ejb.Local;

@Local
public interface BarLocal extends MagicStrings, Publisher, ProductReceiver, Serializable {

    public String getBarName();

    public LinkedList<String> getBeers();

    public LinkedList<String> getDrinks();

    public Drink makeDrink(String name);

    public Beer makeBeer(String name);
}
