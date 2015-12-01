/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import java.util.ArrayList;
import java.util.List;
import model.course.Course;
import model.course.Curriculum;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   /**
     * Test of DB saving, loading and deleting
     */
    @Test
    public void testDB() {
        HibernateSupport.beginTransaction();
        
        String name = "TestUser";
        String pw = "12345678";
        
        // What if an admin does not have a matriculum number?
        User instance = new User(name, pw, UserType.DEFAULT, null);
        boolean result = instance.saveToDB();
        assertEquals(true, result);
        HibernateSupport.commitTransaction();
        
        User retrieved = readOneObjectByUserName(name);
        assertNotNull(retrieved);
        
        assertEquals(retrieved.getPassword(), pw);
        
        HibernateSupport.beginTransaction();
        instance.deleteFromDB();
        HibernateSupport.commitTransaction();
        
        retrieved = readOneObjectByUserName(name);
        assertNull(retrieved);
    } 
    
    /**
     * Test of canRequestTeacherPrivileges method, of class User.
     */
    @Test
    public void testCanRequestTeacherPrivileges() {
        String name = "TestUser";
        String pw = "12345678";
        
        // What if an admin does not have a matriculum number?
        User instance = new User(name, pw, UserType.TEACHER, null);
        
        boolean expResult = false;
        boolean result = instance.canRequestTeacherPrivileges();
        assertEquals(expResult, result);
    }
    
    private User readOneObjectByUserName(String name){
       List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("userName", name));
        Object result = HibernateSupport.readOneObject(User.class, criterions);
        return (User) result;
   }
}
