package PublishSubscribe;

import java.io.Serializable;
import javax.ejb.Local;

@Local
public interface SubscribeServiceLocal extends Serializable {

    public void registerSubscriber(String topic, Subscriber subscriber);

    public void unregisterSubscriber(String topic, Subscriber subscriber);
}
