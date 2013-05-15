package taskadmin.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
	public static EntityManagerFactory createEntityManagerFactory(){
		return Persistence.createEntityManagerFactory("TaskAdminPortletsPU");
	}
}
