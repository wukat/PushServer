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
    public BloodyMary createBloodyMary() {
        return new ExpensiveBloodyMary();
    }

    @Override
    public Mojito createMojito() {
        return new ExpensiveMojito();
    }

    @Override
    public PinaColada createPinaColada() {
        return new ExpensivePinaColada();
    }
    
}
