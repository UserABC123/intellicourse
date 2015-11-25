/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.course;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import model.interfaces.ISaveAndDelete;
import support.HibernateSupport;

/**
 *
 * @author Raphael
 */
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"CurriculumID", "Semester"}))
public class CurriculumSemester implements ISaveAndDelete
{
    @Id
    @Column(name = "CurriculumSemesterID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne    
    @JoinColumn(name="CurriculumID")
    private Curriculum curriculum;
    
    @ManyToMany(mappedBy="curriculumSemesters")
    private List<Course> courses;
    
    @Column(name="Semester",nullable=false)
    private int semester;

    public CurriculumSemester()
    {
    }
    
    CurriculumSemester(Curriculum curriculum, int semester)
    {
        this.curriculum = curriculum;
        this.semester = semester;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
