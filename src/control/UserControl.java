/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import model.user.TeacherRequestListModel;
import model.user.User;
import model.user.UserGroupListModel;
import model.user.UserType;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import support.HibernateSupport;
import view.LoginView;
import view.UserRequestDialog;

/**
 *
 * @author Raphael
 */
public class UserControl
{

    private BaseControl bc;
    private User loggedInAs;
    private TeacherRequestListModel trlm;
    private UserGroupListModel tlm = null;
    
    public UserControl(BaseControl bc)
    {
        this.bc = bc;
        this.trlm = new TeacherRequestListModel();        
    }

    /**
     * Adds a new student user to the database
     *
     * @param userName
     * @param password
     * @param type
     * @param matNumber
     * @return
     */
    public boolean addUser(String userName, String password, UserType type, Integer matNumber)
    {
        boolean result;
        
        if(getUserByName(userName)!=null)
        {
            return false;
        }
        
        User su = new User(userName, password, type, matNumber);
        HibernateSupport.beginTransaction();
        result = su.saveToDB();
        HibernateSupport.commitTransaction();
        return result;
    }

    /**
     * Returns true if the user enters a correct username and password
     * combination
     *
     * @param userName
     * @param password
     * @return
     */
    public boolean logIn(String userName, String password)
    {
        User u = getUserByName(userName);
        if (u != null && u.getPassword().equals(password))
        {
            loggedInAs = u;
            bc.getMc().displayMainView();
            return true;
        }
        return false;
    }

    public User getUserByName(String name)
    {
        List<Criterion> criterions = new ArrayList<>();
        criterions.add(Restrictions.eq("userName", name));
        return HibernateSupport.readOneObject(User.class, criterions);
    }

    public void start()
    {
        (new LoginView(this)).setVisible(true);
    }
    
    public void displayUserRequestDialog()
    {
        (new UserRequestDialog(this)).setVisible(true);
    }

    public User getLoggedInAs()
    {
        return loggedInAs;
    }
    
    public UserGroupListModel getTeachersListModel()
    {
        if(tlm == null)
        {
            tlm = new UserGroupListModel(UserType.TEACHER);
        }
        return tlm;
    }
    
    public ListModel getTeacherRequestListModel()
    {
        return trlm;
    }

    public void setTeacherPrivileges(int selectedIndex, boolean b)
    {
        trlm.setTeacherPrivileges(selectedIndex,b);        
    }

}
