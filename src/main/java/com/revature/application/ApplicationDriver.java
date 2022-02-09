package com.revature.application;
import com.revature.models.Reimbursement;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImplementation;

import com.revature.models.User;
import com.revature.types.UserRole;
import com.revature.daos.UserDaoImplementation;

import java.sql.Timestamp;
import java.util.Date;

public class ApplicationDriver {
    public static void main(String[] args){
        JavalinApplication application = new JavalinApplication();
        application.start(8080);

        UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
        userDaoImplementation.create(new User(1,"UserName","password","FirstName","LastName","email@gmail.com", 0));
    }
}