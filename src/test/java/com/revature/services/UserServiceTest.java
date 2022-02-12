package com.revature.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.revature.daos.UserDaoImplementation;

import org.mockito.*;
import org.junit.Before;
import com.revature.models.User;
import com.revature.daos.UserDao;
import com.revature.types.UserRole;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    @Mock
    static UserDao userDao = new UserDaoImplementation();

    @InjectMocks
    private static UserService userService;

    @Before
    public void initMocks(){
        MockitoAnnotations.openMocks(this);
    }
    /*
    @Test
    void createShouldReturnTrue() {
        UserRole[] user_roles = UserRole.values();
        doNothing().when(userDao).create(any());
        boolean test = userService.create(new User("UserName","Password","FirstName","LastName","email@gmail.com",user_roles[0]));
        Mockito.verify(userDao).create(any());
        assertTrue(test);
    }

    @Test
    void getAllShouldReturnList() {
    }

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