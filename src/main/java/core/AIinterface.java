/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.concurrent.Callable;

/**
 *
 * @author Ronald
 */
public interface AIinterface extends Callable {
   
    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception;
    
}
