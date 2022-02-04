package com.revature.controllers;

import io.javalin.http.Context;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserController {
    UserService userService = new UserService();

    public void handleCreate(Context context) {
        if(userService.create(context.bodyAsClass(User.class))) {
            context.status(201);
        } else {
            context.status(400);
        }
    }

    public void handleReadAll(Context context) {
        context.json(userService.readAll());
    }

    public void handleReadByID(Context context) {
        context.json(userService.readByID(context.bodyAsClass(User.class)));
    }

    public void handleUpdate(Context context) {
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