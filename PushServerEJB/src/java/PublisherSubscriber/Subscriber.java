/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublisherSubscriber;

/**
 *
 * @author wukat
 */
public interface Subscriber {

    public void receiveEvent(Event event);

    public void register(String topic);

    public void unregister(String topic);
}
