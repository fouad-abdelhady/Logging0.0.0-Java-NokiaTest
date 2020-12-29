/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logger;

import logger.loogerLevels.LogEntry;

/**
 *
 * @author Fouad
 */
public class Appender {

    private static final String DATE = "Date";
    private static final String MESSAGE = "Message";
    private static final String LEVEL = "Level";

    public static String DEBUG_LEVEL;
    public static String WARNING_LEVEL;
    public static String ERROR_LEVEL;
    public static String INFO_LEVEL;
    private static String LOG_LEVEL;

    private boolean consolLog = true;
    private String format;

    public Appender() {
        consolLog = true;
        format = "Message|Level"; //"Date|Message|Level";
        

        DEBUG_LEVEL = Logging.ALL;
        WARNING_LEVEL = Logging.ERROR + "|" + Logging.WARNING;
        ERROR_LEVEL = Logging.ERROR;
        INFO_LEVEL = Logging.INFO;
        LOG_LEVEL = DEBUG_LEVEL;
    }

    public void display(LogEntry logEntry) {
        if (LOG_LEVEL.contains(Logging.ALL)) {
            // display 
            logThis(format(logEntry));
            return;
        }
        if (LOG_LEVEL.contains(logEntry.getLevel())) {
            // display 
            logThis(format(logEntry));
            return;
        }
    }

    private String format(LogEntry logEntry) {

        String formateScema = this.format;
        StringBuilder sb = new StringBuilder();
        while (!formateScema.equals("")) {
            // Message 
            if (formateScema.startsWith(DATE)) {
                sb.append(logEntry.getDate());
            } else if (formateScema.startsWith(MESSAGE)) {
                sb.append(logEntry.getMessage());
            } else if (formateScema.startsWith(LEVEL)) {
                sb.append(logEntry.getLevel());
            } else {
                break;
            }
            
            if (formateScema.contains("|")) {
                formateScema = formateScema.substring(formateScema.indexOf("|") + 1);
                sb.append(" : ");
            }
            else
                break;
        }
        return sb.toString();
    }

    private void logThis(String message) {

        System.out.println(message);
    }
/**
 * 
 * @param levels they are 1 to 3 levels values for adjusting log level defaults
 * can be Logging.(level)
 */
    public void adjustDEBUG_LEVEL(String... levels) {     
        DEBUG_LEVEL = getString(levels);
    }

    public void adjustWARNING_LEVEL(String... levels) {
        WARNING_LEVEL  = getString(levels);
    }

    public void adjustERROR_LEVEL(String... levels) {
        ERROR_LEVEL = getString(levels);
    }

    public void adjustINFO_LEVEL(String... levels) {
        INFO_LEVEL = getString(levels);
    }

    private String getString(String... levels) {
        
        StringBuilder sb = new StringBuilder();
        for (String level : levels) {
            sb.append(level);
            sb.append("|");
        }
        return sb.toString();
        
    }
    
    public void setLOG_LEVEL(String level){
        LOG_LEVEL = level;
    }
}

/*
>- Enable/disable logging to console
	>- Set logging format in case of console logging (date-time, message, level)
	>- Set the log level in case of console logging 
	>- Enable/disable logging to file
	>- Give the filename or filename pattern (e.g. log{0..}.txt means log0.txt, log1.txt, log2.txt, etc.)
	>- Set a log rotation (so when a log file is "full" another log file starts)
	>- Describe the condition of a log file treated as full
	- Set the number of log files in the rotation (the log.txt should be the active one, and when it is full, should be renamed to log1.txt and a new log.txt should be created)
	- Set the logging format in case of file logging
	- Set the log level in case of file logging
**/
