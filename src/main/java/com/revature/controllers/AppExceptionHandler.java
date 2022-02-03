package com.revature.controllers;

import io.javalin.http.Context;

public class AppExceptionHandler {
    public void handleNumberFormatException(Exception exception, Context context) {
        context.status(400);
        context.result("Input cannot be parsed into an int");
    }
}