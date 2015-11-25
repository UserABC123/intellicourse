/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.course;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import model.interfaces.ISaveAndDelete;
import support.HibernateSupport;

/**
 *
 * @author Raphael
 */
@Entity
public class Curriculum implements ISaveAndDelete
{

    @Id
    @Column(name = "CurriculumID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "CurriculumName", unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)  
    @JoinTable(            
            name="CurriculumSemester_Curriculum",
            joinColumns = @JoinColumn( name="CurriculumID"),
            inverseJoinColumns = @JoinColumn( name="CurriculumSemesterID")
    )
    private List<CurriculumSemester> curriculumSemesters;

    public Curriculum()
    {
    }

    public Curriculum(String name, int numberOfSemesters)
    {
        this.name = name;
        curriculumSemesters = new ArrayList<>();
        for (int i = 1; i <= numberOfSemesters; i++)
        {
            curriculumSemesters.add(new CurriculumSemester(this, i));
        }
    }

    @Override
    public boolean saveToDB()
    {
        if (curriculumSemesters != null)
        {
            for (CurriculumSemester cs : curriculumSemesters)
            {
                if (!cs.saveToDB())
                {
                    return false;
                }
            }
        }
        return HibernateSupport.commit(this);
    }

    @Override
    public void deleteFromDB()
    {
        if (curriculumSemesters != null)
        {
            for (CurriculumSemester cs : curriculumSemesters)
            {
                cs.deleteFromDB();
            }
        }
        HibernateSupport.deleteObject(this);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public int getSemsterCount()
    {
        return curriculumSemesters.size();
    }
    
    
}
