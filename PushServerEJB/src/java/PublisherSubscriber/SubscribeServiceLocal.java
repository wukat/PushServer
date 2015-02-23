/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublisherSubscriber;

import javax.ejb.Local;

/**
 *
 * @author wukat
 */
@Local
public interface SubscribeServiceLocal {

    public void registerSubscriber(String topic, Subscriber subscriber);

    public void unregisterSubscriber(String topic, Subscriber subscriber);
}
