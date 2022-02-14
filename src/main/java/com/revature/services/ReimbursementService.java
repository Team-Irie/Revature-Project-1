package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

import com.revature.daos.UserDao;
import com.revature.models.Reimbursement;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImplementation;

public class ReimbursementService {
    private ReimbursementDao reimbursementDao;

    public ReimbursementService() {}

    public ReimbursementService(ReimbursementDao reimbursementDao){
        this.reimbursementDao = reimbursementDao;
    }

    public boolean create(Reimbursement reimbursement) { return reimbursementDao.create(reimbursement); }

    public List<Reimbursement> getByAuthorAndStatusId(int author, int statusID) { return reimbursementDao.getByAuthorAndStatusId(author, statusID); }

    public boolean update(Timestamp timestamp, int author, int resolver, int statusID) { return reimbursementDao.update(timestamp, author, resolver, statusID); }

    public List<Reimbursement> getByStatusId(int statusID) { return reimbursementDao.getByStatusId(statusID ); }

    public List<Reimbursement> getByAuthor(int author) { return reimbursementDao.getByAuthor(author); }
}

