package ChainOfResponsibility;

import java.util.LinkedHashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless(name = "StrongAlcoholProvider")
public class StrongAlcoholProvider extends AbstractProvider implements Provider {

    @PostConstruct
    public void initialize() {
        products = new LinkedHashMap<>();
        products.put(vodka, 2000);
        products.put(rum, 1000);
    }

}
