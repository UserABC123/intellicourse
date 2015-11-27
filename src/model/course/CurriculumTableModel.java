/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.course;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import support.HibernateSupport;

/**
 *
 * @author Raphael
 */
public class CurriculumTableModel extends AbstractTableModel
{

    private List<Curriculum> curricula;
    private String[] columns =
    {
        "Name", "Semesters"
    };

    public CurriculumTableModel()
    {
        reloadTableData();
    }

    public void reloadTableData()
    {   
        curricula = HibernateSupport.readMoreObjects(Curriculum.class, null, true);
    }

    @Override
    public int getRowCount()
    {
        return curricula.size();
    }

    @Override
    public int getColumnCount()
    {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Curriculum curr = curricula.get(rowIndex);
        switch (columnIndex)
        {
            case 0:
                return curr.getName();
            case 1:
                return curr.getSemsterCount();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column)
    {
        return columns[column]; //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addCurriculum(String name, int semesterNumber)
    {
        boolean result;
        Curriculum curr = new Curriculum(name, semesterNumber);
        try
        {
            HibernateSupport.beginTransaction();
            result = curr.saveToDB();
            HibernateSupport.commitTransaction();
            curricula.add(curr);
            fireTableRowsInserted(curricula.size() - 2, curricula.size() - 1);
        }
        catch (org.hibernate.TransientObjectException toe)
        {
            HibernateSupport.rollbackTransaction();
            result = false;
        }
        return result;
    }

    public void deleteCurriculum(int index)
    {
        Curriculum curr = curricula.get(index);
        HibernateSupport.beginTransaction();
        curr.deleteFromDB();
        HibernateSupport.commitTransaction();
        curricula.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public Curriculum getCurriculumAt(int index)
    {
        return curricula.get(index);
    }
    
    

}
