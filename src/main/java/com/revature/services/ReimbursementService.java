package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.daos.ReimbursementDao;

public class ReimbursementService {
    private final ReimbursementDao reimbursementDao;

    public ReimbursementService(ReimbursementDao reimbursementDao){
        this.reimbursementDao = reimbursementDao;
    }

    public boolean create(Reimbursement reimbursement) { return reimbursementDao.create(reimbursement); }

    public List<Reimbursement> getAll() { return reimbursementDao.getAll(); }

    public List<Reimbursement> getByAuthorAndStatusId(int author, int statusID) { return reimbursementDao.getByAuthorAndStatusId(author, statusID); }

    public boolean update(Timestamp timestamp, int author, int resolver, int statusID) { return reimbursementDao.update(timestamp, author, resolver, statusID); }

    public List<Reimbursement> getByStatusId(int statusID) { return reimbursementDao.getByStatusId(statusID ); }

    public List<Reimbursement> getByAuthor(int author) { return reimbursementDao.getByAuthor(author); }
}

