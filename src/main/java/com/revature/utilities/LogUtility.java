package com.revature.utilities;

import org.apache.log4j.*;
import io.javalin.http.Context;

public class LogUtility {
    private final Logger logger = Logger.getLogger(this.getClass());
    private ConsoleAppender consoleAppender = new ConsoleAppender();

    public void logTrace(String message) { logger.trace(message); }
    public void logRequest(Context context) { logger.info(context.method() + "Request made to: " + context.path()); }
}