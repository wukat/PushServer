/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import PublisherSubscriber.Subscriber;
import java.util.LinkedList;
import javax.ejb.Local;

/**
 *
 * @author wukat
 */
@Local
public interface BarmanLocal extends Subscriber {

    public void setBar(BarLocal bar);

    public LinkedList<String> getOrdersList();

    public LinkedList<String> placeOrder(String kind, String productName);
}
