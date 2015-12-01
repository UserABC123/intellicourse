/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.course;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import support.HibernateSupport;
import static support.HibernateSupport.readOneObject;

/**
 *
 * @author Flo
 */
public class CurriculumTest {
    
    public CurriculumTest() {
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
     * Test of setId method, of class Curriculum.
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
        int semesters = 8;
        String name = "Test curriculum";
        Curriculum instance = new Curriculum(name, semesters);
        boolean result = instance.saveToDB();
        assertEquals(true, result);
        HibernateSupport.commitTransaction();
        
        int id = instance.getId();
        System.out.println("Id is " + id);
      
        Curriculum retrieved = readOneObjectByName(name);
        assertNotNull(retrieved);
        
        assertEquals(retrieved.getId(), id);
        assertEquals(retrieved.getName(), name);
        assertEquals(retrieved.getSemsterCount(), semesters);
        
        HibernateSupport.beginTransaction();
        retrieved.deleteFromDB();
        HibernateSupport.commitTransaction();
        
        retrieved = readOneObjectByName(name);
        assertNull(retrieved);
    } 
    
   private Curriculum readOneObjectByName(String name){
       List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("name", name));
        Object result = HibernateSupport.readOneObject(Curriculum.class, criterions);
        return (Curriculum) result;
   }
    
}
