/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import model.user.UserType;
import view.MainView;

/**
 *
 * @author Raphael
 */
public class MainControl
{
    private BaseControl bc;
    
    public MainControl(BaseControl bc)
    {
        this.bc = bc;
    }
    
    public void displayCurriculum()
    {
        bc.getCc().displayCurriculumView();
    }

    void displayMainView()
    {
        (new MainView(this)).setVisible(true);
    }
   

    public UserType getUserType()
    {
        return bc.getUc().getLoggedInAs().getType();
    }

    public void displayCourses()
    {
        bc.getCoc().displayCourseView();
    }
    
    public void displayAccount()
    {
        bc.getAc().displayAccountDialog();
    }

    public void displayUserDialog()
    {
        bc.getUc().displayUserRequestDialog();
    }
}
