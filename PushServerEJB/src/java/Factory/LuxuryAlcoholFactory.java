/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factory;

import Alcohols.LagerBeerExpensive;
import Alcohols.BloodyMaryExpensive;
import Alcohols.Beer;
import Alcohols.Water;
import Alcohols.PinaColadaExpensive;
import Alcohols.DarkBeerExpensive;
import Alcohols.Drink;
import javax.ejb.Singleton;

/**
 *
 * @author wukat
 */
@Singleton
public class LuxuryAlcoholFactory implements AlcoholFactory {
    
    @Override
    public Drink createDrink(String name) {
        switch (name) {
            case bloodyMary :
                return new BloodyMaryExpensive();
            case pinaColada :
                return new PinaColadaExpensive();
        }
        return new Water();
    }

    @Override
    public Beer createBeer(String name) {
        switch (name) {
            case lagerBeer :
                return new LagerBeerExpensive();
            case darkBeer :
                return new DarkBeerExpensive();
        }
        return new Water();
    }
    
}
