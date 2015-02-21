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
            case "Bloody Mary" :
                return new BloodyMaryCheap(); 
            case "Pina Colada" :
                return new PinaColadaCheap();
        }
        return new Water();
    }

    @Override
    public Beer createBeer(String name) {
        switch (name) {
            case "Jasne" :
                return new LagerBeerCheap();
            case "Ciemne" :
                return new DarkBeerCheap();
        }
        return new Water();
    }

}
