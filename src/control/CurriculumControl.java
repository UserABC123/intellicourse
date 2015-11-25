/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;


import javax.swing.JDialog;
import javax.swing.table.TableModel;
import model.course.CurriculumTableModel;
import view.CurriculumDialog;

/**
 *
 * @author Raphael
 */
public class CurriculumControl
{
    private BaseControl bc;
    private CurriculumTableModel ctm;
    private JDialog curriculumDialog;
    
    public CurriculumControl(BaseControl bc)
    {
        this.bc = bc;
        ctm = new CurriculumTableModel();
    }
    
    
    public boolean addCurriculum(String name, int semesterNumber)
    {        
        if(name.equals(""))
        {
            return false;
        }
        return ctm.addCurriculum(name, semesterNumber);
    }
    
    public void deleteCurriculum(int index)
    {
        if(index != -1)
        {
            ctm.deleteCurriculum(index);
        }
    }
    
    public void displayCurriculumView()
    {
        if(curriculumDialog == null)
        {
            curriculumDialog = new CurriculumDialog(this);             
        }
        curriculumDialog.setVisible(true);
    }

    public TableModel getCurriculumModel()
    {
        return ctm;
    }
}
