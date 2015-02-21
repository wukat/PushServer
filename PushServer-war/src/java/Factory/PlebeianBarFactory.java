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
public class PlebeianBarFactory extends BarFactory {

    @Override
    public Drink createBloodyMary() {
        return new LuxuryDrink();
    }

    @Override
    public Beer createMojito() {
        return new LuxuryBeer();
    }

    @Override
    public PinaColada createPinaColada() {
        return new CheapPinaColada();
    }
    
}
