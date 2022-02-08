package com.revature.daos;

import java.util.List;
import com.revature.models.Reimbursement;

/*
User Stories - implement a dao for each user story

As an employee I can:

Submit a reimbursement request
View pending reimbursement requests
View resolved reimbursement requests

As a manager I can:

Approve/Deny pending reimbursement requests
View all pending requests of all employees
View all resolved requests of all employees
View reimbursement requests of a specific employee

*/

public interface ReimbursementDao {
    // Employee - Submit a reimbursement request
    public boolean create(Reimbursement reimbursement);

    // Employee - View pending reimbursement requests
    // Employee - View resolved reimbursement requests
    public List<Reimbursement> readByAuthorAndStatusId(int author, int statusID);
}