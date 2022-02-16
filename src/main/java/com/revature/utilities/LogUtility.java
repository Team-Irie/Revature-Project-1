package com.revature.utilities;

import io.javalin.http.Context;
import org.apache.log4j.Logger;

public class LogUtility {
    public final static Logger logger = Logger.getLogger(LogUtility.class);

    public static void logRequest(Context context){
        logger.info(context.method() +" request made to: " + context.path());
    }
}