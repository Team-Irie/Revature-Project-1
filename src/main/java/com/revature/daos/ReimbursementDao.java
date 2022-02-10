package com.revature.daos;

import java.sql.Timestamp;
import java.util.List;
import com.revature.models.Reimbursement;

/*

As a manager I can:



*/

public interface ReimbursementDao {
    public boolean create(Reimbursement reimbursement);
    public List<Reimbursement> readByAuthorAndStatusId(int author, int status_id);
    public boolean update(Timestamp timestamp, int author, int resolver, int status_id);
    public List<Reimbursement> readByStatusId(int status_id);
    public List<Reimbursement> readByAuthor(int author);
}