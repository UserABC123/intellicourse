/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import support.HibernateSupport;

/**
 *
 * @author Raphael
 */
public class UserGroupListModel extends AbstractListModel
{
    protected List<User> users;
    private final UserType type;
    
    public UserGroupListModel(UserType t)
    {
        this.type = t;
        refreshData();
    }
    
    /**
     *
     */
    public final void refreshData()
    {        
        List<Criterion> criterions = new ArrayList<>();
        criterions.add(Restrictions.eq("type", type));
        users = HibernateSupport.readMoreObjects(User.class, criterions);
    }
    
    public void clearData()
    {
        users = new ArrayList<>();
    }
    
    @Override
    public int getSize()
    {
        return users.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        return users.get(index);
    }
    
    public User getUserAt(int index)
    {
        return users.get(index);
    }
    
    public void addUser(User u)
    {
        users.add(u);
        fireIntervalAdded(this, users.size()-1, users.size()-1);
    }
    
    public void removeUser(int index)
    {
        users.remove(index);
        fireIntervalRemoved(this, index, index);
    }

    public boolean contains(User u)
    {
        return users.contains(u);
    }
    
    public List<User> getUsers()
    {
        return users;
    }
}
