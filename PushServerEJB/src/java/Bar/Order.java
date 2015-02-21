/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bar;

import java.util.Date;

/**
 *
 * @author wukat
 */
public class Order {
    private final String orderedProduct;
    private final Date date;

    public Order(String orderedProduct) {
        this.orderedProduct = orderedProduct;
        this.date = new Date();
    }
    
    @Override
    public String toString() {
        return date.toString() + ": " + orderedProduct;
    }
}
