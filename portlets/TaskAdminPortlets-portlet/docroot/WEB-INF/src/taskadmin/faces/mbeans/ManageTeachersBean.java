package taskadmin.faces.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import taskadmin.util.LiferayUtil;
import taskadmin.util.RoleNames;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;


@ManagedBean
@RequestScoped
public class ManageTeachersBean {
	
//	@ManagedProperty(value="#{param.id}")
//	private String id = null;
//	
//	private String mode = "new";
//	
//	private Teacher teacher = new Teacher();
//	
//	public ManageTeachersBean(){
//		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
//		if(id!=null){
//			teacher = Teacher.findById(id);
//			mode = "edit";
//		}
//	}
//	
//	
	public List<User> findAll() throws PortalException, SystemException{
		
		long[] userIds = UserLocalServiceUtil.getRoleUserIds(LiferayUtil.getRoleId(RoleNames.TEACHER));
		
		List<User> userList = new ArrayList<User>();
		
		for(int i=0; i<userIds.length; i++){
			userList.add(UserLocalServiceUtil.getUser(userIds[i]));
		}

		return userList;
	}
	
	public User find(long teacherId) throws PortalException, SystemException{
		return UserLocalServiceUtil.getUser(teacherId);
	}
	
	
//
//
//	public String saveTeacher(){
//		teacher.save();
//		System.out.println(teacher.toString());
//		return "success";
//	}
//	
//	public String remove(){
//		Teacher.removeById(id);
//		return "remove-success";
//	}
//	
//	public String getId() {
//		return id;
//	}
//
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//
//	public String getMode() {
//		return mode;
//	}
//
//
//	public void setMode(String mode) {
//		this.mode = mode;
//	}
//
//
//	public Teacher getTeacher() {
//		return teacher;
//	}
//
//
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}

	
}
