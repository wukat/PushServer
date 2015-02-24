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
@Stateless(name = "StrongAlcoholProvider")
public class StrongAlcoholProvider extends AbstractProvider implements Provider {

    @PostConstruct
    public void initialize() {
        products = new LinkedHashMap<>();
        products.put(vodka, 2000);
        products.put(rum, 1000);
    }
    
}
