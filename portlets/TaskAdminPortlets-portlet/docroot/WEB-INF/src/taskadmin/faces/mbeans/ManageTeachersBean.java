package taskadmin.faces.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import taskadmin.model.Teacher;


@ManagedBean
@RequestScoped
public class ManageTeachersBean {
	
	@ManagedProperty(value="#{param.id}")
	private String id = null;
	
	private String mode = "new";
	
	private Teacher teacher = new Teacher();
	
	public ManageTeachersBean(){
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id!=null){
			teacher = Teacher.findById(id);
			mode = "edit";
		}
	}
	
	
	public List<Teacher> findAll(){
		return Teacher.findAll();
	}


	public String saveTeacher(){
		teacher.save();
		System.out.println(teacher.toString());
		return "success";
	}
	
	public String remove(){
		Teacher.removeById(id);
		return "remove-success";
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
}
