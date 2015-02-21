/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bar;

import java.util.concurrent.LinkedBlockingQueue;
import javax.ejb.Stateful;

/**
 *
 * @author wukat
 */
@Stateful
public class Barman implements BarmanLocal {

    private String barName;
    private LinkedBlockingQueue events;
    
    
//    public makeDrink()
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
