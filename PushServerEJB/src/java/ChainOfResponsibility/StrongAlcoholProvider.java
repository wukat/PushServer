package ChainOfResponsibility;

import java.util.LinkedHashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless(name = "StrongAlcoholProvider")
public class StrongAlcoholProvider extends AbstractProvider implements Provider {

    @PostConstruct
    public void initialize() {
        products = new LinkedHashMap<>();
        products.put(VODKA, 2000);
        products.put(RUM, 1000);
    }

}
