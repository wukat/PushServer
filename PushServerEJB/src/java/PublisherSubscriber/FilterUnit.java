/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublisherSubscriber;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author wukat
 */
@Singleton
@LocalBean
public class FilterUnit {

    LinkedHashMap<String, LinkedList<Subscriber>> subscribers = new LinkedHashMap<>();

    public LinkedList<Subscriber> getTopicSubsribers(String topic) {
        for (String actTopic : subscribers.keySet()) {
            if (actTopic.equals(topic)) {
                return subscribers.get(actTopic);
            }
        }
        return new LinkedList<>();
    }

    public void addSubsriber(String topic, Subscriber subscriber) {
        if (subscribers.containsKey(topic)) {
            subscribers.get(topic).add(subscriber);
        } else {
            LinkedList<Subscriber> tempList = new LinkedList<>();
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
