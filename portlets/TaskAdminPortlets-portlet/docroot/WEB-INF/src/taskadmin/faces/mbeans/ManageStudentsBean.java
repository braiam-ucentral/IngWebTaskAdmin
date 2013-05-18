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
public class ManageStudentsBean {

	public List<User> findAll() throws PortalException, SystemException {

		long[] userIds = UserLocalServiceUtil.getRoleUserIds(LiferayUtil.getRoleId(RoleNames.STUDENT));

		List<User> userList = new ArrayList<User>();

		for (int i = 0; i < userIds.length; i++) {
			userList.add(UserLocalServiceUtil.getUser(userIds[i]));
		}
		
		
		return userList;
	}
	
	

	// @ManagedProperty(value="#{param.id}")
	// private String id = null;
	//
	// private String mode = "new";
	//
	// private Student student = new Student();
	//
	// public ManageStudentsBean(){
	// String id =
	// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
	// if(id!=null){
	// student = Student.findById(id);
	// mode = "edit";
	// }
	// }
	//
	//
	// public List<Student> findAll(){
	// return Student.findAll();
	// }
	//
	//
	// public String saveStudent(){
	// student.save();
	// return "success";
	// }
	//
	// public String remove(){
	// Student.removeById(id);
	// return "remove-success";
	// }
	//
	// public String getId() {
	// return id;
	// }
	//
	//
	// public void setId(String id) {
	// this.id = id;
	// }
	//
	//
	// public String getMode() {
	// return mode;
	// }
	//
	//
	// public void setMode(String mode) {
	// this.mode = mode;
	// }
	//
	//
	// public Student getStudent() {
	// return student;
	// }
	//
	//
	// public void setStudent(Student student) {
	// this.student = student;
	// }

}
