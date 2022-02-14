package com.revature.daos;

import java.sql.Timestamp;
import java.util.List;
import com.revature.models.Reimbursement;

public interface ReimbursementDao {
    public boolean create(Reimbursement reimbursement);
    public List<Reimbursement> getAll();
    public List<Reimbursement> getByAuthorAndStatusId(int author, int statusID);
    public boolean update(Timestamp timestamp, int author, int resolver, int statusID);
    public List<Reimbursement> getByStatusId(int statusID);
    public List<Reimbursement> getByAuthor(int author);
}