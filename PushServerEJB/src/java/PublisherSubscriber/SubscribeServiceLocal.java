package PublisherSubscriber;

import javax.ejb.Local;

@Local
public interface SubscribeServiceLocal {

    public void registerSubscriber(String topic, Subscriber subscriber);

    public void unregisterSubscriber(String topic, Subscriber subscriber);
}
