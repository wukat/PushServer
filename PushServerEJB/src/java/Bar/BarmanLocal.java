/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import PublisherSubscriber.Event;
import PublisherSubscriber.Subscriber;
import java.util.LinkedList;
import javax.ejb.Local;
import org.apache.commons.collections4.queue.CircularFifoQueue;

/**
 *
 * @author wukat
 */
@Local
public interface BarmanLocal extends Subscriber {

    public void setBar(BarLocal bar);

    public CircularFifoQueue<Order> getOrders();

    public LinkedList<String> placeOrder(String kind, String productName);
}
