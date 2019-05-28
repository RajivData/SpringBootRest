package springbootrest.application.data;

import java.util.ArrayList;
import java.util.List;

import springbootrest.application.model.Employee;

public class EmployeeData {
	private static List<Employee> list = new ArrayList<Employee>();
	static {
		Employee e1 = new Employee();
		e1.setEmpId(1);
		e1.setEmpName("Rajiv");
		e1.setEmailId("rajiv@gmail.com");
		e1.setJoiningDate("21 march 2010");

		Employee e2 = new Employee();
		e2.setEmpId(2);
		e2.setEmpName("Anil");
		e2.setEmailId("anil@gmail.com");
		e2.setJoiningDate("10 April 2011");

		Employee e3 = new Employee();
		e3.setEmpId(3);
		e3.setEmpName("sanjiv");
		e3.setEmailId("sanjiv@gmail.com");
		e3.setJoiningDate("10 April 2011");

		Employee e4 = new Employee();
		e4.setEmpId(4);
		e4.setEmpName("Mukesh");
		e4.setEmailId("mukesh@gmail.com");
		e4.setJoiningDate("15 sep 2014");

		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);

	}

	public static List<Employee> getEmpData() {

		return list;
	}
	
	
}
