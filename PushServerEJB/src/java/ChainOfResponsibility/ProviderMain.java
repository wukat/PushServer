package ChainOfResponsibility;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ProviderMain implements ProviderMainLocal {

    @EJB(beanName = "BeerProvider")
    private Provider beerProvider;
    @EJB(beanName = "StrongAlcoholProvider")
    private Provider strongAlcoholProvider;
    @EJB(beanName = "SpecialsProvider")
    private Provider specialsProvider;

    @PostConstruct
    public void chainSetup() {
        beerProvider.setNext(strongAlcoholProvider);
        strongAlcoholProvider.setNext(specialsProvider);
    }

    @Override
    public void handleProductRequest(String product, Integer amount, ProductReceiver requester) {
        beerProvider.handleRequest(product, requester);
    }
    
    @Override
    public void handleProductRequest(String product, ProductReceiver requester) {
        beerProvider.handleRequest(product, requester);
    }

}
