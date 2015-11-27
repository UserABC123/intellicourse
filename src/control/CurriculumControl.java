/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.AbstractListModel;
import javax.swing.JDialog;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import model.course.Course;
import model.course.CourseTableModel;
import model.course.Curriculum;
import model.course.CurriculumSemester;
import model.course.CurriculumSemesterCourseListModel;
import model.course.CurriculumSemesterListModel;
import model.course.CurriculumTableModel;
import view.CurriculumDialog;
import view.SemestersDialog;

/**
 *
 * @author Raphael
 */
public class CurriculumControl
{

    private BaseControl bc;
    private CurriculumTableModel ctm;
    private JDialog curriculumDialog;
    private CurriculumSemesterListModel semesterListModel = null;
    private CurriculumSemesterCourseListModel semesterCourseListModel = null;
    private CourseTableModel courseTableModel;
    private Curriculum selectedCurriculum;

    public CurriculumControl(BaseControl bc)
    {
        this.bc = bc;
        this.courseTableModel = bc.getCoc().getCourseTableModel();
        this.ctm = new CurriculumTableModel();
    }

    public boolean addCurriculum(String name, int semesterNumber)
    {
        if (name.equals(""))
        {
            return false;
        }
        return ctm.addCurriculum(name, semesterNumber);
    }

    public void deleteCurriculum(int index)
    {
        if (index != -1)
        {
            ctm.deleteCurriculum(index);
        }
    }

    public void displayCurriculumView()
    {
        if (curriculumDialog == null)
        {
            curriculumDialog = new CurriculumDialog(this);
        }
        curriculumDialog.setVisible(true);
    }

    public TableModel getCurriculumModel()
    {
        return ctm;
    }

    public boolean displaySemestersDialog(int selectedRow)
    {
        if (selectedRow >= 0)
        {
            selectedCurriculum = ctm.getCurriculumAt(selectedRow);
            (new SemestersDialog(this)).setVisible(true);
            return true;
        }
        return false;
    }

    public AbstractListModel getSemesterListModel()
    {
        semesterListModel =  new CurriculumSemesterListModel(selectedCurriculum.getCurriculumSemesters());
        return semesterListModel;
    }

    public AbstractListModel getSemesterCourseListModel(int index)
    {
        if (semesterCourseListModel == null)
        {
            semesterCourseListModel = new CurriculumSemesterCourseListModel();
        }
        else if(index >= 0)
        {
            semesterCourseListModel.setCourses(selectedCurriculum.getCurriculumSemesters().get(index).getCourses());
        }
        return semesterCourseListModel;
    }
    
    public AbstractTableModel getCourseTableModel()
    {
        return courseTableModel;
    }

    public boolean addCourseAtToSemesterAt(int courseIndex, int semesterIndex)
    {
        if(courseIndex >= 0 && semesterIndex >= 0)
        {
            Course c = courseTableModel.getCourseAt(courseIndex);
            CurriculumSemester cs = semesterListModel.getCurriculumSemesterAt(semesterIndex);
            cs.addCourse(c);
            semesterCourseListModel.addCourse(c);
            return true;
        }
        return false;
    }
}
