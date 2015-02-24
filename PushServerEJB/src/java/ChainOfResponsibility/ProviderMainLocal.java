/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

import javax.ejb.Local;

/**
 *
 * @author wukat
 */
@Local
public interface ProviderMainLocal {

    public void handleProductRequest(String product, Integer amount, ProductReceiver requester);

    public void handleProductRequest(String product, ProductReceiver requester);
}
