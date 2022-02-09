package com.revature.application;

import com.revature.models.Reimbursement;
import com.revature.types.ReimbursementStatus;
import com.revature.types.ReimbursementType;
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
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        Reimbursement reimbursement = new Reimbursement();
        ReimbursementDaoImplementation reimbursementDaoImplementation = new ReimbursementDaoImplementation();
        System.out.println("this should work");
        ReimbursementDaoImplementation.readByAuthorAndStatusId(1, 1);
    }
}