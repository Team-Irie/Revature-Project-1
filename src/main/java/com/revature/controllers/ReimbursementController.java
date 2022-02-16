package com.revature.controllers;

import io.javalin.http.Context;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

import java.sql.Timestamp;

public class ReimbursementController {
    private ReimbursementService reimbursementService;

    public ReimbursementController(ReimbursementService userService){
        this.reimbursementService = userService;
    }

    public void handleCreate(Context context) {
        if(reimbursementService.create(context.bodyAsClass(Reimbursement.class))) {
            context.status(201);
        } else {
            context.status(400);
        }
    }

    public void handleGetAll(Context context) {
        context.json(reimbursementService.getAll());
    }

    public void handleGetByStatusId(Context context) {
        context.json(reimbursementService.getByStatusId(Integer.parseInt(context.pathParam("status_id"))));
    }

    public void handleGetByAuthor(Context context) {
        context.json(reimbursementService.getByAuthor(Integer.parseInt(context.pathParam("author"))));
    }

    public void handleGetByAuthorAndStatusId(Context context) {
        context.json(reimbursementService.getByAuthorAndStatusId(Integer.parseInt(context.pathParam("author")), Integer.parseInt(context.pathParam("status_id"))));
    }

    public void handleUpdate(Context context) {
        context.json(reimbursementService.update(Timestamp.valueOf(context.pathParam("resolved")), Integer.parseInt(context.pathParam("author")), Integer.parseInt(context.pathParam("resolver")), Integer.parseInt(context.pathParam("status_id"))));
    }
}