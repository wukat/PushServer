/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bar;

import javax.ejb.Local;

/**
 *
 * @author wukat
 */
@Local
public interface BarmanLocal {
    public void setBar(BarLocal bar);
}
