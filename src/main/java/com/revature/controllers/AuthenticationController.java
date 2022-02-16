package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Context;
import io.javalin.http.ForbiddenResponse;
import io.javalin.http.UnauthorizedResponse;

public class AuthenticationController {

    private final UserService userService = new UserService();

    public void authenticateLogin(Context context) {
        String email = context.formParam("email");
        String password = context.formParam("password");

        User user = userService.getByEmailAndPassword(email, password);

        if(user == null) {
            throw new UnauthorizedResponse("Incorrect credentials");
        } else {
            String token = user.getRoleID() + "-TOKEN";
            context.header("Authorization", token);
            context.status(200);
        }
    }

    public void authorizeManagerToken(Context context) {
        String header = context.header("Authorization");

        if(header != null){
            if(header.equals("MANAGER-TOKEN")) {
                return;
            } else if (header.equals("EMPLOYEE-TOKEN")) {
                throw new ForbiddenResponse("Employees are unable to access this feature");
            }
        }
        throw new UnauthorizedResponse("Please try to login again");
    }
}