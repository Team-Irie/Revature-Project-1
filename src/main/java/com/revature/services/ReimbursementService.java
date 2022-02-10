package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImplementation;

public class ReimbursementService {
    private final ReimbursementDao reimbursementDao = new ReimbursementDaoImplementation();

    public boolean create(Reimbursement reimbursement) { return reimbursementDao.create(reimbursement); }

    public List<Reimbursement> readByAuthorAndStatusId(int author, int status_id) { return reimbursementDao.readByAuthorAndStatusId(author, status_id); }

    public boolean update(Timestamp timestamp, int author, int resolver, int status_id) { return reimbursementDao.update(timestamp, author, resolver, status_id); }

    public List<Reimbursement> readByStatusId(int status_id) { return reimbursementDao.readByStatusId(status_id ); }

    public List<Reimbursement> readByAuthor(int author) { return reimbursementDao.readByAuthor(author); }
}

