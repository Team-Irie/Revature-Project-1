package com.revature.controllers;

import io.javalin.http.Context;
import com.revature.models.Person;
import com.revature.services.PersonService;

public class PersonController {
    PersonService personService = new PersonService();

    public void handleCreate(Context context) {
        if(personService.create(context.bodyAsClass(Person.class))) {
            context.status(201);
        } else {
            context.status(400);
        }
    }

    public void handleReadAll(Context context) {
        context.json(personService.readAll());
    }

    public void handleReadByID(Context context) {
        context.json(personService.readByID(context.bodyAsClass(Person.class)));
    }

    public void handleUpdate(Context context) {
        Person person = context.bodyAsClass(Person.class);
        person.setId(Integer.parseInt(context.pathParam("id")));

        if(personService.update(person)) {
            context.status(200);
        } else {
            context.status(400);
        }
    }

    public void handleDelete(Context context) {
        context.status(405);
    }
}