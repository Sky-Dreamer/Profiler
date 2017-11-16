/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profiler;

import profiler.ctrls.CtrlInfo;
import profiler.wrks.Wrk;

/**
 *
 * @author skyid
 */
public class Profiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wrk wrk = new Wrk();
        CtrlInfo ctrl = new CtrlInfo();
        wrk.getCommand();

    }

}
