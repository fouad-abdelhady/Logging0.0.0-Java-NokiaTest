/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logger.loogerLevels;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEntry {

    private static int ID_POSTFX = 0;

    private final String logID;
    private String message;
    private String level;

  
    private Object sourceP;

    private long date;

    public LogEntry(String level, String message, Object sourceP) {

        this.logID = System.currentTimeMillis() + "" + (ID_POSTFX++);
        this.level = level;
        this.message = message;
        this.sourceP = sourceP;
        this.date = System.currentTimeMillis();
    }

    public LogEntry(String level, String message) {
        this.logID = System.currentTimeMillis() + "" + (ID_POSTFX++);
        this.level = level;
        this.message = message;
        this.date = System.currentTimeMillis();
        
    }

    public String getLogID() {
        return this.logID;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getSourceP() {
        return this.sourceP;
    }

    public String getDate() {      
        return new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z").format(this.date);
    }
    
      public String getLevel() {
        return level;
    }
}
