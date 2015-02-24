package ChainOfResponsibility;

import java.util.LinkedHashMap;

public abstract class AbstractProvider implements Provider {

    protected LinkedHashMap<String, Integer> products;
    private Provider next;

    @Override
    public void handleRequest(String product, Integer amount, ProductReceiver receiver) {
        if (canHandle(product)) {
            receiver.receiveProduct(product, amount);
        } else if (next != null) {
            next.handleRequest(product, receiver);
        }
    }

    @Override
    public void handleRequest(String product, ProductReceiver receiver) {
        if (canHandle(product)) {
            receiver.receiveProduct(product, products.get(product));
        } else if (next != null) {
            next.handleRequest(product, receiver);
        }
    }

    private boolean canHandle(String product) {
        if (products != null) {
            return products.containsKey(product);
        }
        return false;
    }

    @Override
    public void setNext(Provider next) {
        this.next = next;
    }
}
