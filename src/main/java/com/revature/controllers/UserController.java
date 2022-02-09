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

    public void handleGetByID(Context context){
        String idParam = context.pathParam("id");
        int id = Integer.parseInt(idParam);
        User user = userService.getByID(id);
        context.json(user);
    }

    public void handleUpdate(Context context){
        User user = context.bodyAsClass(User.class);
        int id = Integer.parseInt(context.pathParam("id"));
        user.setId(id);

        if(userService.update(user)){
            context.status(200);
        } else {
            context.status(400);
        }
    }

    public void handleDeleteByID(Context context) {
        context.status(405);
    }
}