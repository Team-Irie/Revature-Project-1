package com.revature.application;

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

        path("reimbursements", ()->{
            //post(reimbursementController::handleCreate);
            get(reimbursementController::handleGetAll);
            //get(reimbursementController::handleGetByAuthorAndStatusId);
            //before(authenticationController::authorizeManagerToken);
            //get("{id}", authenticationController::authenticateLogin);
        });

        path("login", ()->{
            post(authenticationController::authenticateLogin);
        });
    }).exception(NumberFormatException.class, appExceptionHandler::handleNumberFormatException);

    public void start(int port) { javalin.start(port); }
}