/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

/**
 *
 * @author Raphael
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.course.Course;
import model.course.Curriculum;
import model.course.CurriculumSemester;

import org.hibernate.Criteria;
import model.user.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * This Class handles everything for communicating with the database
 *
 * @author Stettinger
 *
 */
public class HibernateSupport
{

    private static SessionFactory sessionFactory;

    static
    {
        System.out.println("HibernateSupport: Constructor");
        init();
    }

    public static void create()
    {
        // function is not necessary it only activates the static construction above
    }

    private static void init()
    {
        File configFile = new File("hibernate.cfg.xml");

        Configuration configuration = new Configuration();

        //TODO add all classes you want to annotate
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Curriculum.class);
        configuration.addAnnotatedClass(CurriculumSemester.class);
        configuration.configure(configFile);

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private static Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public static void beginTransaction()
    {
        getCurrentSession().beginTransaction();
    }

    public static void commitTransaction()
    {
        getCurrentSession().getTransaction().commit();
    }
    
    public static void rollbackTransaction()
    {
        getCurrentSession().getTransaction().rollback();
    }

    public static boolean commit(Object obj)
    {
        try
        {
            getCurrentSession().saveOrUpdate(obj);
        }
        catch (HibernateException e)
        {
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> List<T> readMoreObjects(Class<?> classToRetrieve, List<Criterion> criterions)
    {
       return readMoreObjects(classToRetrieve,criterions,false);
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> readMoreObjects(Class<?> classToRetrieve, List<Criterion> criterions, boolean distinct)
    {
        beginTransaction();
        Criteria criteria = getCurrentSession().createCriteria(classToRetrieve);
        if(distinct)
        {
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        }
        if (criterions != null)
        {
            for (Criterion criterion : criterions)
            {
                criteria.add(criterion);
            }
        }
        List<T> result = criteria.list();
        commitTransaction();
        return result;
    }

    public static <T> T readOneObject(Class<?> classToRetrieve, List<Criterion> criterions)
    {
        List<T> result = readMoreObjects(classToRetrieve, criterions);
        return (result.size() > 0) ? (result.get(0)) : (null);
    }

    public static <T> T readOneObjectByID(Class<?> classToRetrieve, String id)
    {
        List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.idEq(id));
        T result = readOneObject(classToRetrieve, criterions);
        return result;
    }

    public static <T> void deleteObject(T objectToDelete)
    {
        getCurrentSession().delete(objectToDelete);
    }

}
