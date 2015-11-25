/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.course;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import model.interfaces.ISaveAndDelete;
import model.user.User;
import support.HibernateSupport;

/**
 *
 * @author Raphael
 */
@Entity
public class Course implements ISaveAndDelete
{

    @Id
    @Column(name = "CourseID", unique=true)
    private String id;
    
    @Column(nullable=false, name = "CourseName")
    private String name;
    
    @Column(name ="SemesterHours")
    private float semesterHours;
    
    
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name="Course_Curriculumsemester", 
                joinColumns={@JoinColumn(name="CourseID")}, 
                inverseJoinColumns={@JoinColumn(name="CurriculumSemesterID")})
    private List<CurriculumSemester> curriculumSemesters;
    
    
    @ManyToMany(cascade = {CascadeType.PERSIST},fetch=FetchType.EAGER)
    @JoinTable(name="Course_Teacher", 
                joinColumns={@JoinColumn(name="CourseID")}, 
                inverseJoinColumns={@JoinColumn(name="UserID")})
    private List<User> teachers;
    
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name="Course_Student", 
                joinColumns={@JoinColumn(name="CourseID")}, 
                inverseJoinColumns={@JoinColumn(name="UserID")})
    private List<User> participants;
    
    
    
    public Course()
    {
    }

    public Course(String id, String name, float semesterHours, List<User> teachers)
    {
        this.id = id;
        this.name = name;
        this.semesterHours = semesterHours;
        this.teachers = teachers;
    }   
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public float getSemesterHours()
    {
        return semesterHours;
    }    

    public List<User> getTeachers()
    {
        return teachers;
    }

    public List<User> getParticipants()
    {
        return participants;
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
    
}
