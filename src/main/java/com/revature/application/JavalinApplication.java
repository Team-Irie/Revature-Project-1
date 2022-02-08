package com.revature.application;

import io.javalin.Javalin;
import com.revature.utilities.LogUtility;
import com.revature.controllers.UserController;
import com.revature.controllers.AppExceptionHandler;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApplication {
        final private UserController userController = new UserController();
        final private AppExceptionHandler appExceptionHandler = new AppExceptionHandler();

        final private Javalin application = Javalin.create().routes(() -> {
        path("users",()-> {
            post(userController::handleCreate);
            get(userController::handleGetAll);

            path("{id}", () -> {
                get(userController::handleGetByID);
                put(userController::handleUpdate);
                delete(userController::handleDelete);
            });
        });

            //before("*", LogUtility.logger("Test"));

        }).exception(NumberFormatException.class, appExceptionHandler::handleNumberFormatException);

    public void start(int port) {
        application.start(port);
    }
}