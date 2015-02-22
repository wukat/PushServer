/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bar;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import org.apache.commons.collections4.queue.CircularFifoQueue;

/**
 *
 * @author wukat
 */
@Stateful(name="Barman")
public class Barman implements BarmanLocal {

    private BarLocal bar;
    private CircularFifoQueue<Order> events;
    
    @Override
    public void setBar(BarLocal bar) {
        this.bar = bar;
    }    
    
    
}
