/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PublisherSubscriber;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author wukat
 */
@Stateless
public class SubscribeService implements SubscribeServiceLocal {

    @EJB
    private FilterUnit filterUnit;
    
    @Override
    public void registerSubscriber(String topic, Subscriber subscriber) {
        filterUnit.addSubsriber(topic, subscriber);
    }
    
    @Override
    public void unregisterSubscriber(String topic, Subscriber subscriber) {
        filterUnit.removeSubscriber(topic, subscriber);
    }
}
