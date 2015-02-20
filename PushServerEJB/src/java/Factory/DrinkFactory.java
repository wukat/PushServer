/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factory;

import javax.ejb.Local;

/**
 *
 * @author wukat
 */
@Local
public interface DrinkFactory {
    public abstract BloodyMary createBloodyMary();
    public abstract Mojito createMojito();
    public abstract PinaColada createPinaColada();
}
