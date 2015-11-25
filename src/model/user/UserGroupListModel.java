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
    
    private void refreshData()
    {        
        List<Criterion> criterions = new ArrayList<>();
        criterions.add(Restrictions.eq("type", type));
        users = HibernateSupport.readMoreObjects(User.class, criterions);
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
}
