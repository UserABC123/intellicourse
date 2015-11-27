/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.course;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.user.User;
import support.HibernateSupport;

/**
 *
 * @author Raphael
 */
public class CourseTableModel extends AbstractTableModel
{

    private List<Course> courses;
    private String[] columns =
    {
        "ID", "Name", "Semester hours", "Teacher(s)"
    };

    public CourseTableModel()
    {
        reloadTableData();
    }

    public void reloadTableData()
    {
        courses = HibernateSupport.readMoreObjects(Course.class, null, true);
    }

    @Override
    public int getRowCount()
    {
        return courses.size();
    }

    @Override
    public int getColumnCount()
    {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Course c = courses.get(rowIndex);
        switch (columnIndex)
        {
            case 0:
                return c.getId();
            case 1:
                return c.getName();
            case 2:
                return c.getSemesterHours();
            case 3:
                List<User> teachers = c.getTeachers();
                if (teachers != null && teachers.size() > 0)
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append(teachers.get(0).getUserName());
                    for (int i=1; i<teachers.size();i++)
                    {
                        sb.append(", ").append(teachers.get(i).getUserName());
                    }
                    return sb.toString();
                }

            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column)
    {
        return columns[column]; //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addCourse(String id, String name, float semesterHours, List<User> teachers)
    {
        boolean result;
        // Check if object exists already
        if (HibernateSupport.readOneObjectByID(Course.class, id) != null)
        {
            return false;
        }

        Course c = new Course(id, name, semesterHours, teachers);
        try
        {
            HibernateSupport.beginTransaction();
            result = c.saveToDB();
            HibernateSupport.commitTransaction();
            if (result)
            {
                courses.add(c);
                fireTableRowsInserted(courses.size() - 2, courses.size() - 1);
            }
        }
        catch (org.hibernate.TransientObjectException toe)
        {
            HibernateSupport.rollbackTransaction();
            result = false;
        }
        return result;
    }

    public void deleteCourse(int index)
    {
        Course c = courses.get(index);
        HibernateSupport.beginTransaction();
        c.deleteFromDB();
        HibernateSupport.commitTransaction();
        courses.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    public Course getCourseAt(int index)
    {
        return courses.get(index);
    }
}
