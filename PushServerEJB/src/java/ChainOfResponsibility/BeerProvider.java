/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChainOfResponsibility;

import java.util.LinkedHashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 *
 * @author wukat
 */
@Stateless(name = "BeerProvider")
public class BeerProvider extends AbstractProvider implements Provider {
  
    @PostConstruct
    public void initialize() {
        products = new LinkedHashMap<>();
        products.put(lagerBeer, 4000);
        products.put(darkBeer, 4000);
    }
}
