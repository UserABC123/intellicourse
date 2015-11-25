package support;

import control.UserControl;
import model.course.Course;
import model.course.Curriculum;
import model.course.CurriculumSemester;
import model.user.User;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 * 
 * @author Stettinger
 *
 */

public class DatabaseConstruction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start");
		
		Configuration configuration = new Configuration();
		
		//TODO add classes
		configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Curriculum.class);
                configuration.addAnnotatedClass(CurriculumSemester.class);                
		configuration.addAnnotatedClass(Course.class);
		configuration.configure("hibernate.cfg.xml");

		new SchemaExport(configuration).create(true, true);               
                
                
		System.out.println("Finished");
                
	}
	
}
