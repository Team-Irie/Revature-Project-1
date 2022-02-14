package com.revature.controllers;

import io.javalin.http.Context;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;

public class ReimbursementController {
    private ReimbursementService reimbursementService;
    private ObjectMapper mapper = new ObjectMapper();

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

    public void getByAuthorAndStatusId(Context context) {
        context.json(reimbursementService.getByAuthorAndStatusId(Integer.parseInt(context.pathParam("author")), Integer.parseInt(context.pathParam("status_id"))));
    }
}