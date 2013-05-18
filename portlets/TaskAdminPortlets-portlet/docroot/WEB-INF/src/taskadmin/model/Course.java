package taskadmin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import taskadmin.util.FacesUtil;
import taskadmin.util.PersistenceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;

@Entity
public class Course implements Serializable {

	// name code capacity start date end date teacher

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String code;
	private String name;
	private int capacity = 0;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	private long teacherId;
	
	@ElementCollection
	private List<Long> studentIds;
	

	public Course() {
	}

	public Course(String name, String code, int capacity, Date startDate,
			Date endDate) {
		this.name = name;
		this.code = code;
		this.capacity = capacity;
		this.startDate = startDate;
		this.endDate = endDate;

	}

	public static Course findByCode(String code){
		EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Course course = em.find(Course.class, code);

		em.close();
		emf.close();
		return course;		
	}
	
	public static List<Course> findAll() {
		EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		@SuppressWarnings("unchecked")
		List<Course> courseList = em.createQuery("SELECT c FROM Course c")
				.getResultList();

		em.close();
		emf.close();
		return courseList;
	}
	
	public static List<Course> findByCurrentTeacher() throws PortalException, SystemException{
		
		long currentTeacherId = PortalUtil.getUserId(FacesUtil.getPortletRequest());
		
		EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		
		Query query = em.createQuery("SELECT c FROM Course c WHERE c.teacherId = :teacherId");
		query.setParameter("teacherId", currentTeacherId);
		
		@SuppressWarnings("unchecked")
		List<Course> courseList = (List<Course>)query.getResultList();
		

		em.close();
		emf.close();
		return courseList;
	}
	

	public void save() {
		
		EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		try{
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.merge(this);
		
		tx.commit();
		} catch(Exception e){
			System.out.println(e);
		} finally {

			em.close();
			emf.close();			
		}

	}
	
	public static void removeByCode(String code) {
		EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Course course = em.find(Course.class, code);
		em.remove(course);
		tx.commit();

		em.close();
		emf.close();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	

	public List<Long> getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(List<Long> studentIds) {
		this.studentIds = studentIds;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Course: { ");
		sb.append("code=").append(this.getCode());
		sb.append("; name=").append(this.getName());
		sb.append("}");
		return sb.toString();
	}

}
