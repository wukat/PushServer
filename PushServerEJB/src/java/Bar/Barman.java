/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bar;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import org.apache.commons.collections4.queue.CircularFifoQueue;

/**
 *
 * @author wukat
 */
@Stateful
public class Barman implements BarmanLocal {

    @EJB
    private BarLocal bar;
    private CircularFifoQueue<Order> events;
    
    @Override
    public void setBar(String bar) {
        try {
            InitialContext ctx  = new InitialContext();

            //Barman is a stateful bean and therefore can not be injected into
            //servlet which is stateless and shared between multiple concurrent clients.
            //Always look up a new instance
            this.bar =
                (BarLocal) ctx.lookup("java:global/PushServer/PushServerEJB/Barman");
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }    
    
    
}
