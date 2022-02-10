package com.revature.services;

import com.revature.models.Reimbursement;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementServiceTest {
    @Test
    void createReimbursementTest() {
        ReimbursementService reimbursementService = new ReimbursementService();
        Reimbursement reimbursement = new Reimbursement();
        assertTrue(reimbursementService.create(reimbursement));
    }

    @Test
    void readByAuthorAndStatusId() {
        ReimbursementService reimbursementService = new ReimbursementService();
        assertNotNull(reimbursementService.readByAuthorAndStatusId(1,2));
    }
}