package PublisherSubscriber;

public interface Subscriber {

    public void receiveEvent(Event event);

    public void register(String topic);

    public void unregister(String topic);
}
