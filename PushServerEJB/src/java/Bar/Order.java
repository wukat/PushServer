/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import PublisherSubscriber.Event;
import java.util.Date;

/**
 *
 * @author wukat
 */
public class Order implements Event {

    private final String orderedProduct;
    private final String topic;
    private final Date date;

    public Order(String orderedProduct, String topic) {
        this.orderedProduct = orderedProduct;
        this.date = new Date();
        this.topic = topic;
    }

    @Override
    public String toString() {
        return date.toString() + ": " + orderedProduct;
    }

    @Override
    public String getTopic() {
        return topic;
    }
}
