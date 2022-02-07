package com.revature.application;

import com.revature.models.User;
import com.revature.types.UserRole;
import com.revature.daos.UserDaoImplementation;

public class ApplicationDriver {
    public static void main(String[] args){
        JavalinApplication application = new JavalinApplication();
        application.start(8080);
    }
}