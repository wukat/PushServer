package ChainOfResponsibility;

import java.util.LinkedHashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless(name = "BeerProvider")
public class BeerProvider extends AbstractProvider implements Provider {
  
    @PostConstruct
    public void initialize() {
        products = new LinkedHashMap<>();
        products.put(LAGER_BEER, 4000);
        products.put(DARK_BEER, 4000);
    }
}
