package PublishSubscribe;

import javax.ejb.Local;

@Local
public interface PublishServiceLocal {

    public void receiveEvent(Event event);
}
