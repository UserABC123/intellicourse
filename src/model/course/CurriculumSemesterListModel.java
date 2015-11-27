/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.course;

import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Raphael
 */
public class CurriculumSemesterListModel extends AbstractListModel
{
    private List<CurriculumSemester> semesters;
    public CurriculumSemesterListModel(List<CurriculumSemester> semesters)
    {
        this.semesters = semesters;
    }
    
    @Override
    public int getSize()
    {
        return semesters.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        return semesters.get(index).getSemester();
    }
    
    public CurriculumSemester getCurriculumSemesterAt(int index)
    {
        return semesters.get(index);
    }
}
