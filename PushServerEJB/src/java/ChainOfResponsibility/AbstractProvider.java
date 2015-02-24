package ChainOfResponsibility;

import java.util.LinkedHashMap;

public abstract class AbstractProvider implements Provider {

    protected LinkedHashMap<String, Integer> products;

    @Override
    public void handleRequest(String product, Integer amount, ProductReceiver receiver) {
        receiver.receiveProduct(product, amount);
    }

    @Override
    public void handleRequest(String product, ProductReceiver receiver) {
        receiver.receiveProduct(product, products.get(product));
    }

    @Override
    public boolean canHandle(String product) {
        if (products != null) {
            return products.containsKey(product);
        }
        return false;
    }
}
