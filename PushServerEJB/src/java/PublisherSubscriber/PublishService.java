package PublisherSubscriber;

import java.util.LinkedHashSet;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PublishService implements PublishServiceLocal {

    @EJB
    private FilterUnit filterUnit;

    @Override
    public void receiveEvent(Event event) {
        sendEvent(filterUnit.getTopicSubsribers(event.getTopic()), event);
    }

    private void sendEvent(LinkedHashSet<Subscriber> subscribers, Event event) {
        for (Subscriber sub : subscribers) {
            sub.receiveEvent(event);
        }
    }
}
