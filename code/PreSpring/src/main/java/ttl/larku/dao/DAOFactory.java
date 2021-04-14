package ttl.larku.dao;


import java.util.ResourceBundle;

import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.dao.jpa.JpaStudentDAO;
import ttl.larku.service.StudentService;

/// not app code instead config code

public class DAOFactory {
	
	public static StudentDAO getStudentDAO() {
		ResourceBundle bundle = ResourceBundle.getBundle("larkUContext");
		String profile = bundle.getString("larku.profile.active");
		
		switch(profile) {
			case "dev":
				return new InMemoryStudentDAO();
			case "prod":
				return new JpaStudentDAO();
			default:
				throw new RuntimeException("Unknown profile: " + profile);
			
		}
		
	}
	
	// constructor injection
	public static StudentService getaStudentService() {
//		StudentDAO dao = new InMemoryStudentDAO();
		
		StudentDAO dao = getStudentDAO();
		StudentService ss = new StudentService(dao);
		return ss;
	}
}