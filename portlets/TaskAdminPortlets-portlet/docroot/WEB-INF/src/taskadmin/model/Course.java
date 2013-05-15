package taskadmin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Course implements Serializable{

	//name code capacity start date end date teacher
	
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

	
	public Course(){}
	
	public Course(String name, String code, int capacity, Date startDate, Date endDate){
		this.name = name;
		this.code = code;
		this.capacity = capacity;
		this.startDate = startDate;
		this.endDate = endDate;
		
	}
	

	public void save() {
		try{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TaskAdminPortletsPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(this);
		tx.commit();

		em.close();
		emf.close();
		System.out.println("Saved " + this.toString());
		}catch(Exception e){
			System.err.println(e.getMessage());
		}

		
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
