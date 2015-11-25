/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JDialog;
import javax.swing.ListModel;
import javax.swing.table.TableModel;
import model.course.CourseTableModel;
import model.user.User;
import model.user.UserGroupListModel;
import model.user.UserType;
import org.hibernate.dialect.FirebirdDialect;
import view.CourseAddDialog;
import view.CourseDialog;

/**
 *
 * @author Raphael
 */
public class CourseControl
{

    private BaseControl bc;
    private CourseTableModel ctm;
    private JDialog courseDialog;
    private UserGroupListModel teacherCourseListModel;

    public CourseControl(BaseControl bc)
    {
        this.bc = bc;
        ctm = new CourseTableModel();
    }

    public boolean addCourse(String id, String name, float semesterHours)
    {
        if (id.equals("") || name.equals(""))
        {
            return false;
        }
        return ctm.addCourse(id, name, semesterHours, teacherCourseListModel.getUsers());
    }

    public void deleteCourse(int index)
    {
        if (index != -1)
        {
            ctm.deleteCourse(index);
        }
    }

    public void displayCourseView()
    {
        if (courseDialog == null)
        {
            courseDialog = new CourseDialog(this);
        }
        courseDialog.setVisible(true);
    }

    public TableModel getCourseModel()
    {
        return ctm;
    }

    public void displayAddCourseView()
    {
        teacherCourseListModel = new UserGroupListModel(UserType.TEACHER);
        teacherCourseListModel.clearData();
        bc.getUc().getTeachersListModel().refreshData();
        (new CourseAddDialog(this, teacherCourseListModel, bc.getUc().getTeachersListModel())).setVisible(true);
    }

    public void addTeacherToCourseList(int selectedIndex)
    {
        if (selectedIndex >= 0)
        {
            User u = bc.getUc().getTeachersListModel().getUserAt(selectedIndex);
            if (!teacherCourseListModel.contains(u))
            {
                teacherCourseListModel.addUser(u);
            }
        }
    }

    public void removeTeacherFromCourseList(int selectedIndex)
    {
        if (selectedIndex >= 0)
        {
            teacherCourseListModel.removeUser(selectedIndex);
        }
    }

}
