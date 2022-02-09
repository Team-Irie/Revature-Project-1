package com.revature.daos;

import java.util.List;
import com.revature.models.Reimbursement;

/*

As a manager I can:



*/

public interface ReimbursementDao {
    // Submit a reimbursement request
    public boolean create(Reimbursement reimbursement);

    // View pending reimbursement requests
    // View resolved reimbursement requests
    public List<Reimbursement> readByAuthorAndStatusId(int author, int status_id);

    // Approve/Deny pending reimbursement requests
    public boolean update(int author, int resolver, int status_id);

    // View all pending requests of all employees
    // View all resolved requests of all employees
    public List<Reimbursement> readByStatusId(int status_id);

    // View reimbursement requests of a specific employee
    public List<Reimbursement> readByAuthor(int author);
}