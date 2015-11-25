/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import model.course.Course;
import model.interfaces.ISaveAndDelete;
import support.HibernateSupport;

/**
 *
 * @author Raphael
 */
@Entity
public class User implements ISaveAndDelete
{
    @Id
    @Column(name="UserID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int userID;

    @Column(name="UserType")
    @Enumerated(EnumType.ORDINAL)
    protected UserType type;

    @Column(name="UserName",unique = true, nullable=false)
    protected String userName;
    
    @Column(name="Password",nullable=false)
    protected String password;
    
    @Column(name="MatNumber",unique=true, nullable=true)
    protected Integer matNumber;
    
    @ManyToMany(mappedBy="teachers")
    private List<Course> toughtCourses;
    
    @ManyToMany(mappedBy="participants")
    private List<Course> subscribedCourses;
    
    public User()
    {
    }   
    
    public User(String userName, String password, UserType type, Integer matNumber)
    {
        this.type = type;
        this.userName = userName;
        this.password = password;
        this.matNumber = matNumber;
    }

    @Override
    public boolean saveToDB()
    {
        return HibernateSupport.commit(this);
    }

    @Override
    public void deleteFromDB()
    {
        HibernateSupport.deleteObject(this);
    }

    public UserType getType()
    {
        return type;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }
    
    public boolean canRequestTeacherPrivileges()
    {        
        return (type == UserType.DEFAULT);
    } 

    public Integer getMatNumber()
    {
        return matNumber;
    }
    
    @Override
    public String toString()
    {
        return userName;
    }
    
    public void requestTeacherPrivileges()
    {
        type = UserType.REQ_TEACHER;
        HibernateSupport.beginTransaction();
        this.saveToDB();
        HibernateSupport.commitTransaction();
    }
    
    public void setTeacherPrivileges(boolean granted)
    {
        if(!granted)
        {
            type = UserType.DEFAULT;
        }
        else
        {
            type = UserType.TEACHER;
        }
        HibernateSupport.beginTransaction();
        this.saveToDB();
        HibernateSupport.commitTransaction();
    }
}
