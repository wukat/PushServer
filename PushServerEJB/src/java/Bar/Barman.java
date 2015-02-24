package Bar;

import Consts.MagicStrings;
import PublisherSubscriber.Event;
import PublisherSubscriber.SubscribeServiceLocal;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.commons.collections4.queue.CircularFifoQueue;

@Named
@DependsOn("SubscribeServiceLocal")
@SessionScoped  // SERIALIZABLE OGARNAC - DODAC METODY
public class Barman implements BarmanLocal, Serializable, MagicStrings {

    @EJB(beanName = "SubscribeService")
    private SubscribeServiceLocal subscribeService;

    private BarLocal bar;
    private final CircularFifoQueue<Order> orders = new CircularFifoQueue<>(5);

    @Override
    public LinkedList<String> getOrdersList() {
        LinkedList<String> result = new LinkedList<>();
        while (!orders.isEmpty()) {
            result.add(orders.poll().toString());
        }
        return result;
    }

    @Override
    public void setBar(BarLocal bar) {
        this.bar = bar;
    }

    @Override
    public LinkedList<String> placeOrder(String kind, String productName) {
        switch (kind) {
            case drink:
                return listOfIngredients(bar.makeDrink(productName).getIngredients());
            case beer:
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

    @PreDestroy
    public void cleanUp() {
        unregister(bar.getBarName());
    }
}
