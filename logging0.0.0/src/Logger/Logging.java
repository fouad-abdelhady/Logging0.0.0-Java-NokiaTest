/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logger;

import java.util.List;
import logger.loogerLevels.DebugC;
import logger.loogerLevels.ErrorC;
import logger.loogerLevels.InfoC;
import logger.loogerLevels.LogEntry;
import logger.loogerLevels.WarningC;

/**
 *
 * @author Fouad
 */
public class Logging {

    public static final String DEBUG = "Debug";
    public static final String INFO = "Info";
    public static final String WARNING = "Warning";
    public static final String ERROR = "Error";
    public static final String ALL = "All";
    private Appender appender;

   

    public Logging() {
        this.appender = new Appender();
    }
    /**
     * 
     * @param level: represents static final level values in Logging(DEBUG, INFO, ..)
     * @param message: 
     * @param source 
     */
    public void log(String level, String message, Object source) {
        this.appender.display(createLogEntryOpj(level, message, source)); 
    }
/**
 * overload for the  function log
 * @param level 
 * @param message 
 */
    public void log(String level, String message) {
         this.appender.display(createLogEntryOpj(level, message, null));
    }
/**
 * get the list of created errors logs
 * @return List of type ErrorC containing the log details
 */
    public List<ErrorC> getErrors() {
        return ErrorC.getL_ERRORS_LIST();
    }

    public void clear(String logID) {
        if (!ErrorC.removeElement_ERRORS_LIST(logID)) {
            // log here
        }
    }

    private LogEntry createLogEntryOpj(String level, String message, Object source) {
        LogEntry logLeveobj;
        switch (level) {
            case Logging.DEBUG:
                logLeveobj = new DebugC(message, source);
                break;
            case Logging.ERROR:
                logLeveobj = new ErrorC(message, source);
                break;
            case Logging.INFO:
                logLeveobj = new InfoC(message, source);
                break;
            case Logging.WARNING:
                logLeveobj = new WarningC(message, source);
                break;
            default:
                return null;
        }
        return logLeveobj;
    }
  /**
   * 
   * @return  the Appender object for more customization
   */
     public Appender getAppender() {
        return appender;
    }
}
