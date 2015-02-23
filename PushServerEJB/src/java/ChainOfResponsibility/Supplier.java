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
public abstract class Supplier {
    
    // zalozenie jest takie ze oni maja nieskonczona ilosc
    // produktu i przy kazdym zamowieniu zwracaja stockAmount produktu 
    protected Supplier next;
    protected String stockName;
    protected Integer stockAmount;
    
    public Supplier(String stockName, Integer stockAmount) {
        this.stockAmount = stockAmount;
        this.next = next;
    }
    
    public void setNext(Supplier supplier) {
        next = supplier;
    }
    
    public Integer buyStock(String requiredStock) {
        if (stockName.equals(requiredStock)) {
            return distributeStock(stockAmount);
        } else if (next != null) {
            next.buyStock(requiredStock);
        }
        return 0; // nikt nie ma żądanego zasobu
    }
    
    abstract protected Integer distributeStock(Integer amount);
    
}
