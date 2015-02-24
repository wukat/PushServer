package ChainOfResponsibility;

import Consts.MagicStrings;
import javax.ejb.Local;

@Local
public interface Provider extends MagicStrings {

    public void handleRequest(String product, Integer amount, ProductReceiver receiver);

    public void handleRequest(String product, ProductReceiver requester);

    public boolean canHandle(String product);
}
