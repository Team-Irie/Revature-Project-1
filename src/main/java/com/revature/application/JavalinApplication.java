package com.revature.application;

import io.javalin.Javalin;
import com.revature.controllers.UserController;
import com.revature.exceptions.AppExceptionHandler;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApplication {
    private final UserController userController = new UserController();
    private final AppExceptionHandler appExceptionHandler = new AppExceptionHandler();

    private final Javalin javalin = Javalin.create().routes(() -> {
        path("users", () -> {
            get(userController::handleGetAll);
            post(userController::handleCreate);

            path("{id}", () -> {
                put(userController::handleUpdate);
                get(userController::handleGetByID);
                delete(userController::handleDeleteByID);
            });
        });
    }).exception(NumberFormatException.class, appExceptionHandler::handleNumberFormatException);

    public void start(int port) { javalin.start(port); }
}