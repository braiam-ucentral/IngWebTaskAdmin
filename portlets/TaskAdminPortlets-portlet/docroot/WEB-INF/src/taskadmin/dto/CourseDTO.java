package taskadmin.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import taskadmin.model.Course;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class CourseDTO {

	private String code;
	private String name;
	private int capacity;
	private Date startDate;
	private Date endDate;
	
	private User teacher;
	
	
	public static CourseDTO from(Course c) throws PortalException, SystemException{
		CourseDTO dto = new CourseDTO();
		
		dto.setCode(c.getCode());
		dto.setName(c.getName());
		dto.setCapacity(c.getCapacity());
		dto.setStartDate(c.getStartDate());
		dto.setEndDate(c.getEndDate());
		
		dto.setTeacher(UserLocalServiceUtil.getUser(c.getTeacherId()));
		
		return dto;
		
	}
	

	public static List<CourseDTO> from(List<Course> courseList) throws PortalException, SystemException {
		List<CourseDTO> courseDtoList = new ArrayList<CourseDTO>();
		for(Course c : courseList){
			courseDtoList.add(CourseDTO.from(c));
		}
		return courseDtoList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	
}
