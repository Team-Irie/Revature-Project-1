package com.revature.controllers;

import io.javalin.http.Context;
import com.revature.models.Account;
import com.revature.services.AccountService;

public class AccountController {
    private final AccountService accountService = new AccountService();

    public void handleCreate(Context context) {
        if(accountService.create(context.bodyAsClass(Account.class))) {
            context.status(201);
        } else {
            context.status(400);
        }
    }

    public void handleReadAll(Context context) {
        context.json(accountService.readAll());
    }

    public void handleReadByNumber(Context context) {
        context.json(accountService.readByNumber(context.bodyAsClass(Account.class)));
    }

    public void handleUpdate(Context context) {
        Account account = context.bodyAsClass(Account.class);
        account.setAccountNumber(Integer.parseInt(context.pathParam("account_number")));

        if(accountService.update(account)) {
            context.status(200);
        } else {
            context.status(400);
        }
    }

    public void handleDelete(Context context) {
        context.status(405);
    }
}