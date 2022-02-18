package com.revature.services;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.daos.ReimbursementDao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.*;

class ReimbursementServiceTest {
    private final ReimbursementDao reimbursementDaoMock = mock(ReimbursementDao.class);
    private final ReimbursementService reimbursementService = new ReimbursementService(reimbursementDaoMock);

    @Test
    void createShouldReturnTrue() {
        byte[] receipt = {};
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Reimbursement reimbursement = new Reimbursement(1, 100, timestamp, timestamp, "description", receipt, 0, 0, 0, 0);
        when(reimbursementDaoMock.create(reimbursement)).thenReturn(true);
        Assertions.assertTrue(reimbursementService.create(reimbursement));
    }

    @Test
    void getAllShouldReturnListOfReimbursements() {
        byte[] receipt = {};
        Date date = new Date();
        List<Reimbursement> reimbursements = new ArrayList<>();
        Timestamp timestamp = new Timestamp(date.getTime());
        Reimbursement reimbursement = new Reimbursement(1, 100, timestamp, timestamp, "description", receipt, 0, 0, 0, 0);
        reimbursements.add(reimbursement);
        when(reimbursementDaoMock.getAll()).thenReturn(reimbursements);
        Assertions.assertFalse(reimbursementService.getAll().isEmpty());
    }

    @Test
    void getByStatusIdShouldReturnListOfReimbursements() {
        byte[] receipt = {};
        Date date = new Date();
        List<Reimbursement> reimbursements = new ArrayList<>();
        Timestamp timestamp = new Timestamp(date.getTime());
        Reimbursement reimbursement = new Reimbursement(1, 100, timestamp, timestamp, "description", receipt, 0, 0, 0, 0);
        reimbursements.add(reimbursement);
        when(reimbursementDaoMock.getByStatusId(0)).thenReturn(reimbursements);
        Assertions.assertFalse(reimbursementService.getByStatusId(0).isEmpty());
    }

    @Test
    void getByAuthorShouldReturnListOfReimbursements() {
        byte[] receipt = {};
        Date date = new Date();
        List<Reimbursement> reimbursements = new ArrayList<>();
        Timestamp timestamp = new Timestamp(date.getTime());
        Reimbursement reimbursement = new Reimbursement(1, 100, timestamp, timestamp, "description", receipt, 0, 0, 0, 0);
        reimbursements.add(reimbursement);
        when(reimbursementDaoMock.getByAuthor(0)).thenReturn(reimbursements);
        Assertions.assertFalse(reimbursementService.getByAuthor(0).isEmpty());
    }

    @Test
    void getByAuthorAndStatusIdShouldReturnListOfReimbursements() {
        byte[] receipt = {};
        Date date = new Date();
        List<Reimbursement> reimbursements = new ArrayList<>();
        Timestamp timestamp = new Timestamp(date.getTime());
        Reimbursement reimbursement = new Reimbursement(1, 100, timestamp, timestamp, "description", receipt, 0, 0, 0, 0);
        reimbursements.add(reimbursement);
        when(reimbursementDaoMock.getByAuthorAndStatusId(0,0)).thenReturn(reimbursements);
        Assertions.assertFalse(reimbursementService.getByAuthorAndStatusId(0,0).isEmpty());
    }

    @Test
    void updateShouldReturnTrue() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        when(reimbursementDaoMock.update(timestamp, 0,0,0)).thenReturn(true);
        Assertions.assertTrue(reimbursementService.update(timestamp, 0,0,0));
    }
}