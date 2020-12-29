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
public class WarningC extends LogEntry{
    private static List<WarningC> L_WARNING_LIST = new LinkedList<>();

    public WarningC(String message, Object sourceP) {
        super(Logging.WARNING, message, sourceP);
        L_WARNING_LIST.add(this);
    }

    public WarningC(String message) {
        super(Logging.WARNING, message);
        L_WARNING_LIST.add(this);
    }
}
