package com.revature.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.javalin.http.Context;

public class LogUtility {
    private static Logger logger = LoggerFactory.getLogger(LogUtility.class);

    public void logRequest(Context ctx) {
        logger.info(ctx.method() + "Request made to: " + ctx.path());
    }
}