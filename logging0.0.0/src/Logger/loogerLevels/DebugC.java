/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logger.loogerLevels;


import java.util.LinkedList;
import java.util.List;
import Logger.Logging;


/**
 *
 * @author Fouad
 */
public class DebugC extends LogEntry{
    private static List<DebugC> L_DEBUG_LIST = new LinkedList<>();
    
    public DebugC(String message, Object sourceP){
        super(Logging.DEBUG, message, sourceP);
        L_DEBUG_LIST.add(this);
    }
    
    public DebugC(String message){
        super(Logging.DEBUG, message);
        L_DEBUG_LIST.add(this);
    }
}
