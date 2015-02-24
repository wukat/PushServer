package PublisherSubscriber;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

@Singleton
@LocalBean
public class FilterUnit {

    private final LinkedHashMap<String, LinkedHashSet<Subscriber>> subscribers = new LinkedHashMap<>();

    public LinkedHashSet<Subscriber> getTopicSubsribers(String topic) {
        for (String actTopic : subscribers.keySet()) {
            if (actTopic.equals(topic)) {
                return subscribers.get(actTopic);
            }
        }
        return new LinkedHashSet<>();
    }

    public void addSubsriber(String topic, Subscriber subscriber) {
        if (subscribers.containsKey(topic)) {
            subscribers.get(topic).add(subscriber);
        } else {
            LinkedHashSet<Subscriber> tempList = new LinkedHashSet<>();
            tempList.add(subscriber);
            subscribers.put(topic, tempList);
        }
    }

    public void removeSubscriber(String topic, Subscriber subscriber) {
        if (subscribers.containsKey(topic)) {
            subscribers.get(topic).remove(subscriber);
        }
    }
}
