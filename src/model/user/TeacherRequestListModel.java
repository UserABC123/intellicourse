/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;


/**
 *
 * @author Raphael
 */
public final class TeacherRequestListModel extends UserGroupListModel
{
    public TeacherRequestListModel()
    {
        super(UserType.REQ_TEACHER);
    }

    public void setTeacherPrivileges(int selectedIndex, boolean b)
    {
        if(selectedIndex>=0)
        {
            users.get(selectedIndex).setTeacherPrivileges(b);
            users.remove(selectedIndex);
            fireIntervalRemoved(this, selectedIndex, selectedIndex);
        }
    }
    
}
