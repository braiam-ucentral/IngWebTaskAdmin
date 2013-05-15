package taskadmin.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import taskadmin.util.PersistenceUtil;



@Entity
@DiscriminatorValue(value="Teacher") 
public class Teacher extends Person{

	private String resume;

	
	public static List<Teacher> findAll(){
		EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		@SuppressWarnings("unchecked")
		List<Teacher> teacherList = em.createQuery("SELECT t FROM Teacher t")
				.getResultList();

		em.close();
		emf.close();
		return teacherList;
	}
	
	

	public static Teacher findById(String id){
		EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Teacher teacher = em.find(Teacher.class, id);

		em.close();
		emf.close();
		return teacher;		
	}

	public void save() {
		EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.merge(this);
		tx.commit();

		em.close();
		emf.close();
	}
	
	public static void removeById(String id) {
		EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Teacher course = em.find(Teacher.class, id);
		em.remove(course);
		tx.commit();

		em.close();
		emf.close();
	}
	
	
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Teacher:{ ");
		sb.append("id: ").append(id).append(", ");
		sb.append("name: ").append(name).append(", ");
		sb.append("resume: ").append(resume).append("");
		sb.append("}");
		return sb.toString();
	}
	
	
	
}
