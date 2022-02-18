package com.revature.services;

import java.util.List;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.daos.UserDao;
import com.revature.types.UserRole;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.*;

class UserServiceTest {
    private final UserDao userDaoMock = mock(UserDao.class);
    private final UserService userService = new UserService(userDaoMock);

    @Test
    void createShouldReturnTrue() {
        UserRole[] userRoles = UserRole.values();
        User user = new User(0,"username","password","first_name","last_name","email@gmail.com",userRoles[0]);
        when(userDaoMock.create(user)).thenReturn(true);
        Assertions.assertTrue(userService.create(user));
    }

    @Test
    void getAllShouldReturnListOfUsers() {
        List<User> users = new ArrayList<>();
        UserRole[] userRoles = UserRole.values();
        User user = new User(1,"username","password","first_name","last_name","email@gmail.com",userRoles[0]);
        users.add(user);
        when(userDaoMock.getAll()).thenReturn(users);
        Assertions.assertFalse(userService.getAll().isEmpty());
    }

    @Test
    void getByIDShouldReturnUser() {
        UserRole[] userRoles = UserRole.values();
        User user = new User(1,"username","password","first_name","last_name","email@gmail.com",userRoles[0]);
        when(userDaoMock.getByID(1)).thenReturn(user);
        Assertions.assertEquals(userService.getByID(1), user);
    }

    @Test
    void updateShouldReturnTrue() {
        UserRole[] userRoles = UserRole.values();
        User user = new User(0,"username","password","first_name","last_name","email@gmail.com",userRoles[0]);
        when(userDaoMock.update(user)).thenReturn(true);
        Assertions.assertTrue(userService.update(user));
    }

    @Test
    void deleteByIDShouldReturnTrue() {
        UserRole[] userRoles = UserRole.values();
        User user = new User(1,"username","password","first_name","last_name","email@gmail.com",userRoles[0]);
        when(userDaoMock.deleteByID(1)).thenReturn(true);
        Assertions.assertTrue(userService.deleteByID(1));
    }
}