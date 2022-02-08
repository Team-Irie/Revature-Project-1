package com.revature.controllers;

import io.javalin.http.Context;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserController {
    private UserService userService = new UserService();

    public void handleCreate(Context context) {
        if(userService.create(context.bodyAsClass(User.class))) {
            context.status(201);
        } else {
            context.status(400);
        }
    }

    public void handleGetAll(Context context) {
        context.json(userService.getAll());
    }


    public void handleGetByID(Context context) {
        context.json(userService.getByID(context.bodyAsClass(User.class)));
    };

    public void handleUpdate (Context context) {
        User user = context.bodyAsClass(User.class);
        user.setId(Integer.parseInt(context.pathParam("id")));

        if(userService.update(user)) {
            context.status(200);
        } else {
            context.status(400);
        }
    }

    public void handleDelete(Context context) {
        context.status(405);
    }
}