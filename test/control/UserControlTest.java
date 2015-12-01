/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.ListModel;
import model.user.User;
import model.user.UserGroupListModel;
import model.user.UserType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import support.HibernateSupport;

/**
 *
 * @author Flo
 */
public class UserControlTest {
    private UserControl instance;
    private AccountControl accountControl;
    
    private static final String DEFAULT_USER_NAME = "TestUser";
    private static final String TEACHER_USER_NAME = "TeacherTestUser";
    private static final String PASSWORD = "1234567";
    
    private void createDefaultUser(){
        String userName = DEFAULT_USER_NAME;
        String password = PASSWORD;
        UserType type = UserType.DEFAULT;
        Integer matNumber = null;

        deleteDefaultUser();
        
        boolean expResult = true;
        boolean result = instance.addUser(userName, password, type, matNumber);
        assertEquals(expResult, result);
    }
    
    private void createTeacherUser(){
        String userName = TEACHER_USER_NAME;
        String password = PASSWORD;
        UserType type = UserType.TEACHER;
        Integer matNumber = null;

        boolean expResult = true;
        boolean result = instance.addUser(userName, password, type, matNumber);
        assertEquals(expResult, result);
    }
    
    private void deleteDefaultUser(){
        User user = instance.getUserByName(DEFAULT_USER_NAME);
        HibernateSupport.beginTransaction();
        if (user != null) user.deleteFromDB();
        HibernateSupport.commitTransaction();
    }
    
    private void deleteTeacherUser(){
        User user = instance.getUserByName(TEACHER_USER_NAME);
        HibernateSupport.beginTransaction();
        user.deleteFromDB();
        HibernateSupport.commitTransaction();
    }
    
    public UserControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        BaseControl base = new BaseControl();
        instance = base.getUc();
        accountControl = base.getAc();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUser method, of class UserControl.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        
        createDefaultUser();
        
        boolean expResult = false;
        boolean result = instance.addUser(DEFAULT_USER_NAME, PASSWORD, UserType.DEFAULT, null);
        assertEquals(expResult, result);
        
        deleteDefaultUser();
    }

    /**
     * Test of logIn method, of class UserControl.
     */
    @Test
    public void testLogIn() {
        System.out.println("logIn");
        
        createDefaultUser();
        
        boolean expResult = true;
        boolean result = instance.logIn(DEFAULT_USER_NAME, PASSWORD);
        assertEquals(expResult, result);
        
        deleteDefaultUser();
    }
    
}
