package ChainOfResponsibility;

import javax.ejb.Local;

@Local
public interface ProviderMainLocal {

    public void handleProductRequest(String product, Integer amount, ProductReceiver requester);

    public void handleProductRequest(String product, ProductReceiver requester);
}
