package taskadmin.util;

import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

public abstract class FacesUtil {

	public static PortletRequest getPortletRequest() {
		return (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

}
