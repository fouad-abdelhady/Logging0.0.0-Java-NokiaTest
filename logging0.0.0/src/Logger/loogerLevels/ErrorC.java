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
public class ErrorC extends LogEntry {

    
    
    private static List<ErrorC> L_ERRORS_LIST = new LinkedList<>();

    public static List<ErrorC> getL_ERRORS_LIST() {
        return L_ERRORS_LIST;
    }

    public static boolean removeElement_ERRORS_LIST(String id) {
        for (ErrorC r : L_ERRORS_LIST) 
            if (r.getLogID().equals(id)) 
                return L_ERRORS_LIST.remove(r);                    
        return false;
    }

    
    
    
    public ErrorC(String message, Object sourceP) {
        super(Logging.ERROR ,message, sourceP);
        L_ERRORS_LIST.add(this);
    }

    public ErrorC(String message) {
        super(Logging.ERROR, message);
        L_ERRORS_LIST.add(this);
    }

}
