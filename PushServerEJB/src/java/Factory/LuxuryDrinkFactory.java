/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factory;

import javax.ejb.Singleton;

/**
 *
 * @author wukat
 */
@Singleton
public class LuxuryDrinkFactory implements DrinkFactory {
    
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
