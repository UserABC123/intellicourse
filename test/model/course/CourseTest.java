/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.course;

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
public class CourseTest {
    
    public CourseTest() {
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
     * Test of setId method, of class Course.
     * Exemplary for all getters/setters of the class.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        Course instance = new Course();
        instance.setId(id);
        String newId = instance.getId();
        assertEquals(id, newId);
    }

    /**
     * Test of DB saving, loading and deleting
     */
    @Test
    public void testDB() {
        HibernateSupport.beginTransaction();
        
        System.out.println("saveToDB");
        String id = "12345678";
        String name = "Test course";
        Course instance = new Course(id, name, 10.f, null);
        boolean result = instance.saveToDB();
        assertEquals(true, result);
        HibernateSupport.commitTransaction();
        
        Course retrieved = HibernateSupport.readOneObjectByID(Course.class, id);
        assertNotNull(retrieved);
        
        assertEquals(retrieved.getId(), id);
        assertEquals(retrieved.getName(), name);
        
        HibernateSupport.beginTransaction();
        instance.deleteFromDB();
        HibernateSupport.commitTransaction();
        
        retrieved = HibernateSupport.readOneObjectByID(Course.class, id);
        assertNull(retrieved);
    } 
}
