package taskadmin.model;

import java.util.Date;

public class Course {

	//name code capacity start date end date teacher
	
	
	private String name;
	private String code;
	private int capacity;
	private Date startDate;
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
		System.out.println("Saving course '" + name + "'");
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

	
	
	
}
