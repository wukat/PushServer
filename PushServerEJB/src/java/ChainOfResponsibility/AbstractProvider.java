/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChainOfResponsibility;

import Consts.MagicStrings;
import java.util.LinkedHashMap;

/**
 *
 * @author wukat
 */
public abstract class AbstractProvider implements Provider {

    Provider next;
    LinkedHashMap<String, Integer> products;
    
    @Override
    public void setNext(Provider provider) {
        next = provider;
    }

    @Override
    public void handleRequest(String product, Integer amount, ProductReceiver receiver) {
        receiver.receiveProduct(product, amount);
    }
    
    @Override
    public void handleRequest(String product, ProductReceiver receiver) {
        receiver.receiveProduct(product, products.get(product));
    }
    
    @Override
    public boolean canHandle(String product) {
        if (products != null) {
            return products.containsKey(product);
        }
        return false;
    }
}
