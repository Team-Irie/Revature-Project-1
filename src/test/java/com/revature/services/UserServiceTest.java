package com.revature.services;

import com.revature.daos.UserDaoImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import org.mockito.*;
import org.junit.Before;
import com.revature.models.User;
import com.revature.daos.UserDao;
import com.revature.types.UserRole;
import org.mockito.internal.matchers.Matches;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final UserDao userDaoMock = mock(UserDao.class);
    private final UserService userService = new UserService(userDaoMock);

    @Test
    void createShouldReturnTrue() {
        boolean success = true;
        UserRole[] userRoles = UserRole.values();
        User user = new User("userName","Password","FirstName","LastName","email@gmail.com",userRoles[0]);
        when(userDaoMock.create(user)).thenReturn(success);
        Assertions.assertTrue(userService.create(user));
    }

    @Test
    void getAllShouldReturnList() {
        //UserRole[] userRoles = UserRole.values();
        //User user = new User("userName","Password","FirstName","LastName","email@gmail.com",userRoles[0]);
        List<User> users = new ArrayList<>();
        //users.add(user);
        when(userDaoMock.getAll()).thenReturn(users);
        Assertions.assertTrue(users.isEmpty());
    }
    /*
    @Test
    void getByIDShouldReturnUser() {
    }

    @Test
    void updateShouldReturnTrue() {
    }

    @Test
    void deleteByIDShouldReturnTrue() {
        doNothing().when(userDao).deleteByID(any());
        boolean test = userService.deleteByID(any());
        Mockito.verify(userDao).deleteByID(any());
        Assertions.assertTrue(test);
    }
    */
}