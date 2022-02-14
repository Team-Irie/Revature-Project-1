package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Context;
import io.javalin.http.ForbiddenResponse;
import io.javalin.http.UnauthorizedResponse;

public class AuthenticationController {

    private final UserService userService = new UserService();

    public void authenticateLogin(Context context){
        String username = context.formParam("username");
        String password = context.formParam("password");

        User user = userService.getByEmailAndPassword(username, password);

        if(user == null) {
            throw new UnauthorizedResponse("Incorrect credentials");
        } else {
            String simpleToken = user.getRoleID()+"-TOKEN";
            context.header("Authorization", simpleToken);
            context.status(200);
        }
    }

    public void authorizeManagerToken(Context context) {
        String authHeader = context.header("Authorization");
        if(authHeader != null){
            if(authHeader.equals("MANAGER-TOKEN")) {
                return;
            } else if (authHeader.equals("EMPLOYEE-TOKEN")) {
                throw new ForbiddenResponse("students are unable to access this feature");
            }
        }
        throw new UnauthorizedResponse("please login and try again");
    }
}
