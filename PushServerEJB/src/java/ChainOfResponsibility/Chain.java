/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChainOfResponsibility;

import Consts.MagicStrings;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author krzysztof
 */
@Singleton
public class Chain implements ChainLocal, MagicStrings {

    Supplier vodkaSupplier;
    Supplier waterSupplier;
    Supplier darkBeerSupplier;
    
    @PostConstruct
    public void postConstruct() {
        vodkaSupplier = new VodkaSupplier(vodka, 1000);
        waterSupplier = new WaterSupplier(water, 1000);
        vodkaSupplier.setNext(waterSupplier);
        darkBeerSupplier = new DarkBeerSupplier(darkBeer, 4000);
        waterSupplier.setNext(darkBeerSupplier);
    }
    
    @Override
    public Integer buyStock(String stockName) {
        return vodkaSupplier.buyStock(stockName);
    }
    
}
