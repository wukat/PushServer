/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import PublisherSubscriber.Event;
import PublisherSubscriber.SubscribeServiceLocal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import org.apache.commons.collections4.queue.CircularFifoQueue;

/**
 *
 * @author wukat
 */
@Stateful(name = "Barman")
public class Barman implements BarmanLocal {

    @EJB
    private SubscribeServiceLocal subscribeService;

    private BarLocal bar;
    private final CircularFifoQueue<Order> orders = new CircularFifoQueue<>();

    @Override
    public CircularFifoQueue<Order> getOrders() {
        return orders;
    }

    @Override
    public void setBar(BarLocal bar) {
        this.bar = bar;
    }

    @Override
    public LinkedList<String> placeOrder(String kind, String productName) {
        switch (kind) {
            case "drink":
                return listOfIngredients(bar.makeDrink(productName).getIngredients());
            case "beer":
                return listOfIngredients(bar.makeBeer(productName).getIngredients());
            default:
                return new LinkedList<>();
        }
    }

    private LinkedList<String> listOfIngredients(LinkedHashMap<String, Integer> ingredients) {
        LinkedList<String> result = new LinkedList<>();
        for (String product : ingredients.keySet()) {
            result.add(product + " " + ingredients.get(product).toString() + "\n");
        }
        return result;
    }

    @Override
    public void receiveEvent(Event event) {
        if (event.getClass().equals(Order.class)) {
            orders.add((Order) event);
        }
    }

    @Override
    public void register(String topic) {
        subscribeService.registerSubscriber(topic, this);
    }

    @Override
    public void unregister(String topic) {
        subscribeService.unregisterSubscriber(topic, this);
    }
}
