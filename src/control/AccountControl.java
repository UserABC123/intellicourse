/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import model.user.User;
import model.user.UserType;
import view.AccountDialog;

/**
 *
 * @author Raphael
 */
public class AccountControl
{
    private BaseControl bc;
    
    public AccountControl(BaseControl bc)
    {
        this.bc = bc;
    }
    
    public void displayAccountDialog()
    {
        (new AccountDialog(this)).setVisible(true);
    }

    public void requestTeacherPrivileges()
    {
        bc.getLoggedInAs().requestTeacherPrivileges();
    }

    public String getUserName()
    {
        return bc.getLoggedInAs().getUserName();
    }

    public Integer getUserMatNumber()
    {
        return bc.getLoggedInAs().getMatNumber();
    }

    public UserType getUserType()
    {
        return bc.getLoggedInAs().getType();
    }

    public boolean canUserRequestTeacherPrivileges()
    {
        return bc.getLoggedInAs().canRequestTeacherPrivileges();
    }
}
