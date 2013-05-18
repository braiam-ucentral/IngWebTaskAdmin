package taskadmin.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public abstract class LiferayUtil {

	public static long getRoleId(String roleName) throws PortalException, SystemException {
		long companyId = PortalUtil.getCompanyId(FacesUtil.getPortletRequest());
		Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
		return role.getRoleId();
	}
}
