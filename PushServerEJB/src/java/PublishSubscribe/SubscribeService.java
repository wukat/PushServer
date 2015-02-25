package PublishSubscribe;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SubscribeService implements SubscribeServiceLocal {

    @EJB
    private FilterUnit filterUnit;
    
    @Override
    public void registerSubscriber(String topic, Subscriber subscriber) {
        filterUnit.addSubscriber(topic, subscriber);
    }
    
    @Override
    public void unregisterSubscriber(String topic, Subscriber subscriber) {
        filterUnit.removeSubscriber(topic, subscriber);
    }
}
