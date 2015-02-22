/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bar;

import java.util.HashMap;
import java.util.LinkedList;
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
    
    @Override
    public LinkedList<String> placeOrder(String kind, String productName) {
        switch (kind)  {
            case "drink":
                return listOfIngredients(bar.makeDrink(productName).getIngredients());
            case "beer":
                return listOfIngredients(bar.makeBeer(productName).getIngredients());
            default:
                return new LinkedList<>();
        }
    }
    
    private LinkedList<String> listOfIngredients(HashMap<String, Integer> ingredients) {
        LinkedList<String> result = new LinkedList<>();
        for (String product : ingredients.keySet()) {
            result.add(product + " " + ingredients.get(product).toString() + "\n");
        }
        return result;
    }
}
