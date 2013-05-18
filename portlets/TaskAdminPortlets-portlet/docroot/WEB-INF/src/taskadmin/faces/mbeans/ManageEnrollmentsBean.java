package taskadmin.faces.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import taskadmin.dto.CourseDTO;
import taskadmin.model.Course;

import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;

@ManagedBean
@ViewScoped
public class ManageEnrollmentsBean {

//	@ManagedProperty(value = "#{manageCoursesBean}")
//	private String courseCode = null;
	
//	@ManagedProperty(value="#{param.code}")
	private String courseCode = null;

	private Course course;
	private CourseDTO courseDTO;
	private List<User> studentList;
	private long selectedUserId;

	
	@PostConstruct
	public void init() {
		try {
			loadCourse();
			loadCourseDTO();
			loadStudentList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void loadCourse(){
		courseCode = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("code");
		System.out.println("Loading course with code = " + courseCode);
		course = Course.findByCode(courseCode);
	}
	
	protected void loadCourseDTO(){
		try {
			courseDTO = CourseDTO.from(course);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	protected void loadStudentList(){
		try{
			for (Long studentId : course.getStudentIds()) {
				studentList.add(UserUtil.findByPrimaryKey(studentId.longValue()));
			}
		} catch (Exception e){
			System.err.println(e.getMessage());
		}
	}
	
	

	public void enroll() {
		course.getStudentIds().add(selectedUserId);
		course.save();
		loadCourseDTO();
	}
	
	public CourseDTO getCourseDTO() {
		return courseDTO;
	}

	public void setCourseDTO(CourseDTO courseDTO) {
		this.courseDTO = courseDTO;
	}

	public List<User> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<User> studentList) {
		this.studentList = studentList;
	}

	public long getSelectedUserId() {
		return selectedUserId;
	}

	public void setSelectedUserId(long selectedUserId) {
		this.selectedUserId = selectedUserId;
	}


	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	

}
