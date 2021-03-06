/* 
 * Copyright (C) 2014 Center of Excellence in Information Assurance
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.coeia.cases;

import edu.coeia.constants.SystemConstant;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * This class represent the set of actions that the user can make on case
 * it will log each of these action in log file
 * 
 * @author wajdyessam
 */

final class CaseAuditing {
    private final static Logger logger = Logger.getLogger("DEM_AUDITING");
    private final Case aCase ;
    private final String logPath;
    
    private FileHandler fileHandler;
    
    public CaseAuditing(final Case aCase, final String path) {
        this.aCase = aCase;
        this.logPath = path;
    }
    
    public void init() throws IOException {
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        
        fileHandler = new FileHandler(this.logPath, true);
        fileHandler.setFormatter(new AuditingFormatter());
        logger.addHandler(fileHandler);
    }
    
    public void auditing(final String message) {
        logger.info(message);
    }
    
    private class AuditingFormatter extends Formatter{
        @Override
        public synchronized String format (final LogRecord logRecord) {
            StringBuilder buffer = new StringBuilder();

            String investigatorName = aCase.getInvestigatorName();
            String userName = SystemConstant.USER_NAME;
            String timeStamp = new Date(logRecord.getMillis()).toString();
            String message = logRecord.getMessage();
            String caseName = aCase.getCaseName();
            
            buffer.append(investigatorName);
            buffer.append(",");
            buffer.append(userName);
            buffer.append(",");
            buffer.append(timeStamp);
            buffer.append(",");
            buffer.append(caseName);
            buffer.append(",");
            buffer.append(message);
            buffer.append("\n");

            return buffer.toString();
        }
    }
    
    public void close() {
        for(Handler handler: logger.getHandlers()) {
            handler.close();
        }
    }
}
