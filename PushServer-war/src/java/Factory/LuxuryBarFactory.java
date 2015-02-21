/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factory;

/**
 *
 * @author krzysztof
 */
public class LuxuryBarFactory extends BarFactory {
    
    @Override
    public Drink createBloodyMary() {
        return new BloodyMary();
    }

    @Override
    public Beer createMojito() {
        return new CheapBeer();
    }

    @Override
    public PinaColada createPinaColada() {
        return new ExpensivePinaColada();
    }
    
}
