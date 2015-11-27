/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.course;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Raphael
 */
public class CurriculumSemesterCourseListModel extends AbstractListModel
{
    private List<Course> courses;

    public CurriculumSemesterCourseListModel()
    {
        this.courses = new ArrayList<>();
    }
    
    public void setCourses(List<Course> courses)
    {
        int i = courses.size();
        this.courses = courses;
        fireContentsChanged(courses, 0, Math.max(i, courses.size()));
    }
    
    @Override
    public int getSize()
    {
        return courses.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        if(index < courses.size())
        {
        return courses.get(index).getName();
        }
        return null;
    }

    public void addCourse(Course c)
    {
        courses.add(c);
        fireIntervalAdded(this, courses.size()-1, courses.size()-1);
    }
}
