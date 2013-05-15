package taskadmin.faces.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import taskadmin.model.Course;

@ManagedBean
public class AdminCoursesBean {
	
	public List<Course> findAllCourses(){
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TaskAdminPortletsPU");
		EntityManager em = emf.createEntityManager();
		
		@SuppressWarnings("unchecked")
		List<Course> courseList = em.createQuery("SELECT c FROM Course c").getResultList();
		
		em.close();
		emf.close();
		
		return courseList;
	}
	
	
}
