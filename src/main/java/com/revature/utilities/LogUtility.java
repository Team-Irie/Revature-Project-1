package com.revature.utilities;

import io.javalin.http.Context;
import org.apache.log4j.Logger;

public class LogUtility {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void logRequest(Context context) {
        logger.info(context.method() + "Request made to: " + context.path());
    }
}