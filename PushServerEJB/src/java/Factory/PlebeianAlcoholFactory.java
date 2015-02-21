/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factory;

import javax.ejb.Singleton;

/**
 *
 * @author wukat
 */
@Singleton
public class PlebeianAlcoholFactory implements AlcoholFactory {

    @Override
    public Drink createDrink(String name) {
        switch (name) {
            case "BloodyMaryCheap" :
                return new BloodyMaryCheap(); 
            case "PinaColadaCheap" :
                return new PinaColadaCheap();
        }
        return new Water();
    }

    @Override
    public Beer createBeer(String name) {
        switch (name) {
            case "LagerBeerCheap" :
                return new LagerBeerCheap();
            case "DarkBeerCheap" :
                return new DarkBeerCheap();
        }
        return new Water();
    }

}
