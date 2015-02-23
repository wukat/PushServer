/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChainOfResponsibility;

/**
 *
 * @author krzysztof
 */
public class WaterSupplier extends Supplier {
    
    public WaterSupplier(String stockName, Integer stockAmount) {
        super(stockName, stockAmount);
    }

    @Override
    protected Integer distributeStock(Integer amount) {
        return stockAmount;
    }
    
}
