/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bar;

import javax.ejb.Stateful;
import org.apache.commons.collections4.queue.CircularFifoQueue;

/**
 *
 * @author wukat
 */
@Stateful
public class Barman implements BarmanLocal {

    private String barName;
    private CircularFifoQueue<Order> events;
    
//    public makeDrink()
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void setBarName(String barName) {
        this.barName = barName;
    }

    @Override
    public String getBarName() {
        return barName;
    }
    
}
