package springbootrest.application.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class EmployeeDetails {

	private List<Employee> employeedetails;

	public List<Employee> getEmployeedetails() {
		return employeedetails;
	}

	public void setEmployeedetails(List<Employee> employeedetails) {
		this.employeedetails = employeedetails;
	}
}
