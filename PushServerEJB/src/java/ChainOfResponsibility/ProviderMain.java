/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author wukat
 */
@Stateless
public class ProviderMain implements ProviderMainLocal {

    @EJB(beanName = "BeerProvider")
    private Provider beerProvider;
    @EJB(beanName = "StrongAlcoholProvider")
    private Provider strongAlcoholProvider;
    @EJB(beanName = "SpecialsProvider")
    private Provider specialsProvider;

    @Override
    public void handleProductRequest(String product, Integer amount, ProductReceiver requester) {
        if (beerProvider.canHandle(product)) {
            beerProvider.handleRequest(product, amount, requester);
        } else if (strongAlcoholProvider.canHandle(product)) {
            strongAlcoholProvider.handleRequest(product, amount, requester);
        } else if (specialsProvider.canHandle(product)) {
            specialsProvider.handleRequest(product, amount, requester);
        }
    }
    
    @Override
    public void handleProductRequest(String product, ProductReceiver requester) {
        if (beerProvider.canHandle(product)) {
            beerProvider.handleRequest(product, requester);
        } else if (strongAlcoholProvider.canHandle(product)) {
            strongAlcoholProvider.handleRequest(product, requester);
        } else if (specialsProvider.canHandle(product)) {
            specialsProvider.handleRequest(product, requester);
        }
    }
    
}
