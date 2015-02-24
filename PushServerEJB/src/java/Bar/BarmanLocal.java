package Bar;

import PublishSubscribe.Subscriber;
import java.util.LinkedList;
import javax.ejb.Local;

@Local
public interface BarmanLocal extends Subscriber {

    public void setBar(BarLocal bar);

    public LinkedList<String> getOrdersList();

    public LinkedList<String> placeOrder(String kind, String productName);
}
