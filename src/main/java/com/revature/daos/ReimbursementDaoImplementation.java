package com.revature.daos;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.utilities.ConnectionUtility;

public class ReimbursementDaoImplementation implements ReimbursementDao {
    //Submit a reimbursement request
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

    //View pending reimbursement requests
    //View resolved reimbursement requests
    @Override
    public List<Reimbursement> readByAuthorAndStatusId(int author, int status_id) {
        List<Reimbursement> reimbursements = new ArrayList<>();

        String sql = "select * from reimbursement where author = ? and status_id = ?";

        try (Connection connection = ConnectionUtility.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            Reimbursement reimbursement = new Reimbursement();
            ps.setInt(1, author);
            ps.setInt(2, status_id);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                reimbursement.setId(resultSet.getInt("id"));
                reimbursement.setAmount(resultSet.getInt("amount"));
                reimbursement.setSubmitted(resultSet.getTimestamp("submitted"));
                reimbursement.setResolved(resultSet.getTimestamp("resolved"));
                reimbursement.setDescription(resultSet.getString("description"));
                reimbursement.setReceipt(resultSet.getBytes("receipt"));
                reimbursement.setAuthor(resultSet.getByte("author"));
                reimbursement.setResolver(resultSet.getInt("resolver"));
                reimbursement.setStatusID(resultSet.getInt("status_id"));
                reimbursement.setTypeID((resultSet.getInt("type_id")));
                reimbursements.add(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;
    }

    //Approve/Deny pending reimbursement requests
    @Override
    public boolean update(int author, int resolver, int statusID) {
        String sql = "update table set resolved = ?, resolver = ?, status_id = ? where author = ?";
        Reimbursement reimbursement = new Reimbursement();

        try (Connection connection = ConnectionUtility.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setTimestamp(1, reimbursement.getResolved());
            ps.setInt(2, reimbursement.getResolver());
            ps.setInt(3, reimbursement.getStatusID());
            ps.setInt(4, reimbursement.getAuthor());
            if(ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //View all pending requests of all employees
    //View all resolved requests of all employees
    @Override
    public List<Reimbursement> readByStatusId(int statusID) {
        String sql = "select * from reimbursement where statusID = ?";
        Reimbursement reimbursement = new Reimbursement();
        List<Reimbursement> reimbursements = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, reimbursement.getStatusID());
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

    //View reimbursement requests of a specific employee
    @Override
    public List<Reimbursement> readByAuthor(int statusID) {
        String sql = "select * from reimbursement where author = ?";
        Reimbursement reimbursement = new Reimbursement();
        List<Reimbursement> reimbursements = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, reimbursement.getAuthor());
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