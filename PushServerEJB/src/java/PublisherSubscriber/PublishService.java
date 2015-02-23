/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublisherSubscriber;

import java.util.LinkedList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author wukat
 */
@Stateless
public class PublishService implements PublishServiceLocal {

    @EJB
    private FilterUnit filterUnit;

    @Override
    public void receiveEvent(Event event) {
        sendEvent(filterUnit.getTopicSubsribers(event.getTopic()), event);
    }

    private void sendEvent(LinkedList<Subscriber> subscribers, Event event) {
        for (Subscriber sub : subscribers) {
            sub.receiveEvent(event);
        }
    }
}
