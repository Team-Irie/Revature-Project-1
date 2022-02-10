package com.revature.application;

import io.javalin.Javalin;
import com.revature.utilities.LogUtility;
import com.revature.controllers.UserController;
import com.revature.exceptions.AppExceptionHandler;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApplication {
    final private LogUtility logUtility = new LogUtility();
    final private UserController userController = new UserController();
    final private AppExceptionHandler appExceptionHandler = new AppExceptionHandler();

    private Javalin app = Javalin.create().routes(() -> {
        path("users", () -> {
            get(userController::handleGetAll);
            post(userController::handleCreate);

            path("{id}", () -> {
                put(userController::handleUpdate);
                get(userController::handleGetByID);
                delete(userController::handleDeleteByID);
            });
        });

        before("*", logUtility::logRequest);
    }).exception(NumberFormatException.class, appExceptionHandler::handleNumberFormatException);

    public void start(int port) { app.start(port); }
}