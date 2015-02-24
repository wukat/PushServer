/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChainOfResponsibility;

/**
 *
 * @author wukat
 */
public interface ProductReceiver {
    public void receiveProduct(String name, Integer amount);
}
