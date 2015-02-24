/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

import Consts.MagicStrings;
import javax.ejb.Local;

/**
 *
 * @author wukat
 */
@Local
public interface Provider extends MagicStrings {

    public void setNext(Provider provider);

    public void handleRequest(String product, Integer amount, ProductReceiver receiver);

    public void handleRequest(String product, ProductReceiver requester);

    public boolean canHandle(String product);
}
