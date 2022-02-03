package com.revature.application;

import io.javalin.Javalin;
import com.revature.utilities.LogUtility;
import com.revature.controllers.AccountController;
import com.revature.controllers.PersonController;
import com.revature.controllers.AppExceptionHandler;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApplication {
        final private LogUtility logUtility = new LogUtility();
        final private PersonController personController = new PersonController();
        final private AccountController accountController = new AccountController();
        final private AppExceptionHandler appExceptionHandler = new AppExceptionHandler();

        final private Javalin application = Javalin.create().routes(()->{
        path("people",()-> {
            post(personController::handleCreate);
            get(personController::handleReadAll);

            path("{id}", () -> {
                get(personController::handleReadByID);
                put(personController::handleUpdate);
                delete(personController::handleDelete);
            });
        });

        path("accounts", ()->{
            post(accountController::handleCreate);
            get(accountController::handleReadAll);

            path("{account_number}", () -> {
                get(accountController::handleReadByNumber);
                put(accountController::handleUpdate);
                delete(accountController::handleDelete);
            });
        });

            before("*", logUtility::logRequest);

        }).exception(NumberFormatException.class, appExceptionHandler::handleNumberFormatException);

    public void start(int port) {
        application.start(port);
    }
}