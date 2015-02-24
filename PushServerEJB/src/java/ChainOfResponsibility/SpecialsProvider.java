package ChainOfResponsibility;

import java.util.LinkedHashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless(name = "SpecialsProvider")
public class SpecialsProvider extends AbstractProvider implements Provider {

    @PostConstruct
    public void initialize() {
        products = new LinkedHashMap<>();
        products.put(tomatoJuice, 2000);
        products.put(coconutCream, 200);
        products.put(tabasco, 200);
    }
}
