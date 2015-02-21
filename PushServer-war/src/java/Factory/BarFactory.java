package Factory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krzysztof
 */
public abstract class BarFactory {
    public abstract Drink createBloodyMary();
    public abstract Beer createMojito();
    public abstract PinaColada createPinaColada();
}
