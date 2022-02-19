package com.revature.controllers;

import io.javalin.http.Context;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

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

    public void handleGetAllEmployees(Context context) {
        context.json(userService.getAllEmployees());
    }

    public void handleGetByID(Context context) {
        context.json(userService.getByID(Integer.parseInt(context.pathParam("id"))));
    }

    public void handleGetEmployeeByID(Context context) {
        context.json(userService.getEmployeeByID(Integer.parseInt(context.pathParam("id"))));
    }

    public void handleGetByEmailAndPassword(Context context) {
        context.json(userService.getByEmailAndPassword(context.formParam("email"), context.formParam("password")));
    }

    public void handleUpdate(Context context) {
        User user = context.bodyAsClass(User.class);
        user.setId(Integer.parseInt(context.pathParam("id")));

        if(userService.update(user)){
            context.status(200);
        } else {
            context.status(400);
        }
    }

    public void handleDeleteByID(Context context) {
        userService.deleteByID(Integer.parseInt(context.pathParam("id")));
    }
}