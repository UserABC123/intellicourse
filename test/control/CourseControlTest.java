/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.table.TableModel;
import model.course.Course;
import model.course.CourseTableModel;
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
public class CourseControlTest {
    private CourseControl instance;
    
    public CourseControlTest() {
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
        instance = base.getCoc();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addCourse method, of class CourseControl.
     */
    @Test
    public void testAddCourse() {
        System.out.println("addCourse");
        String id = "123456789";
        String name = "Test Course";
        float semesterHours = 1.0F;
        boolean expResult = true;
        boolean result = instance.addCourse(id, name, semesterHours);
        assertEquals(expResult, result);
        
        Course c = HibernateSupport.readOneObjectByID(Course.class, id);
        assertNotNull(c);
        
        HibernateSupport.beginTransaction();
        c.deleteFromDB();
        HibernateSupport.commitTransaction();
    }

    /**
     * Test of deleteCourse method, of class CourseControl.
     */
    @Test
    public void testDeleteCourse() {
        System.out.println("addCourse");
        String id = "123456789";
        String name = "Test Course";
        
        assertEquals(false,false);
    }


    /**
     * Test of getCourseModel method, of class CourseControl.
     */
    @Test
    public void testGetCourseModel() {
        System.out.println("getCourseModel");
        TableModel result = instance.getCourseModel();
        assertNotNull(result);
    }

    /**
     * Test of addTeacherToCourseList method, of class CourseControl.
     */
    @Test
    public void testAddTeacherToCourseList() {
        //TODO
    }

    /**
     * Test of removeTeacherFromCourseList method, of class CourseControl.
     */
    @Test
    public void testRemoveTeacherFromCourseList() {
        //TODO
    }
    
}
