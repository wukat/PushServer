package Bar;

import PublisherSubscriber.Event;
import java.util.Date;

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
