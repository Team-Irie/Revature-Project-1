package com.revature.application;

import io.javalin.Javalin;
import com.revature.utilities.LogUtility;
import com.revature.controllers.UserController;
import com.revature.controllers.AppExceptionHandler;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApplication {
        final private LogUtility logUtility = new LogUtility();
        final private UserController personController = new UserController();
        final private AppExceptionHandler appExceptionHandler = new AppExceptionHandler();

        final private Javalin application = Javalin.create().routes(()->{
        path("users",()-> {
            post(personController::handleCreate);
            get(personController::handleReadAll);

            path("{id}", () -> {
                get(personController::handleReadByID);
                put(personController::handleUpdate);
                delete(personController::handleDelete);
            });
        });

            before("*", logUtility::logRequest);

        }).exception(NumberFormatException.class, appExceptionHandler::handleNumberFormatException);

    public void start(int port) {
        application.start(port);
    }
}