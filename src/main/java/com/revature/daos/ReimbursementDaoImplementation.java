package com.revature.daos;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.utilities.ConnectionUtility;

/*

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

public class ReimbursementDaoImplementation implements ReimbursementDao {
    // Submit a reimbursement request
    @Override
    public boolean create(Reimbursement reimbursement) {
        String sql = "insert into reimbursement (id, amount, submitted, resolved, description, receipt, author, resolver, status_id, type_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionUtility.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, reimbursement.getId());
                ps.setInt(2, reimbursement.getAmount());
                ps.setTimestamp(3, reimbursement.getSubmitted());
                ps.setTimestamp(4, reimbursement.getResolved());
                ps.setString(5, reimbursement.getDescription());
                ps.setBytes(6, reimbursement.getReceipt());
                ps.setInt(7, reimbursement.getAuthor());
                ps.setInt(8, reimbursement.getResolver());
                ps.setInt(9, reimbursement.getStatusID());
                ps.setInt(10, reimbursement.getTypeID());
            if(ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Reimbursement> readByAuthorAndStatusId(int author, int statusID) {
        String sql = "select * from reimbursement where author = ? and statusID = ?";
        Reimbursement reimbursement = new Reimbursement();
        List<Reimbursement> reimbursements = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, reimbursement.getAuthor());
            ps.setInt(2, reimbursement.getStatusID());
            ResultSet resultSet = ps.executeQuery(sql);

            while(resultSet.next()) {
                reimbursement.setId(resultSet.getInt("id"));
                reimbursement.setAmount(resultSet.getInt("amount"));
                reimbursement.setSubmitted(resultSet.getTimestamp("submitted"));
                reimbursement.setResolved(resultSet.getTimestamp("resolved"));
                reimbursement.setDescription(resultSet.getString("description"));
                reimbursement.setReceipt(resultSet.getBytes("receipt"));
                reimbursement.setAuthor(resultSet.getByte("author"));
                reimbursement.setResolver(resultSet.getInt("resolver"));
                reimbursement.setStatusID(resultSet.getInt("statusID"));
                reimbursement.setTypeID((resultSet.getInt("typeID")));
                reimbursements.add(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;
    }
}