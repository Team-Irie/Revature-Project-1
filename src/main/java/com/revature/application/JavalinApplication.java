package com.revature.application;

import com.revature.utilities.LogUtility;
import com.revature.controllers.AuthenticationController;
import com.revature.controllers.ReimbursementController;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImplementation;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImplementation;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import io.javalin.Javalin;
import com.revature.controllers.UserController;
import com.revature.exceptions.AppExceptionHandler;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApplication {
    private final UserDao userDao = new UserDaoImplementation();
    private final UserService userService = new UserService(userDao);
    private final UserController userController = new UserController(userService);

    private final AppExceptionHandler appExceptionHandler = new AppExceptionHandler();

    private final ReimbursementDao reimbursementDao = new ReimbursementDaoImplementation();
    private final ReimbursementService reimbursementService = new ReimbursementService(reimbursementDao);
    private final ReimbursementController reimbursementController = new ReimbursementController(reimbursementService);

    private final AuthenticationController authenticationController = new AuthenticationController();

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

        path("reimbursements", ()-> {
            before(authenticationController::authorizeManagerToken);
            put(reimbursementController::handleUpdate);
            get(reimbursementController::handleGetAll);
            post(reimbursementController::handleCreate);
            //get("{author}", reimbursementController::handleGetByAuthor);
            //get("{status_id}", reimbursementController::handleGetByStatusId);
            //get("{id}", reimbursementController::handleGetByAuthorAndStatusId);
        });

        path("login", ()-> {
            System.out.println("Login Called");
            post(authenticationController::authenticateLogin);
        });

        before("*", LogUtility::logRequest);
    }).exception(NumberFormatException.class, appExceptionHandler::handleNumberFormatException);

    public void start(int port) { javalin.start(port); }
}