package springbootrest.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springbootrest.application.data.EmployeeData;
import springbootrest.application.model.Employee;

@Service
public class EmployeeService {
	
	public List<Employee> getemployees(){
		return EmployeeData.getEmpData();
	}
	
	public Employee getEmployee(int empId) {
		List<Employee> emplist=EmployeeData.getEmpData();
		for(Employee emp:emplist) {
			if(emp.getEmpId()==empId) {
				return emp;
			}
		}
		return null;
	}
	
	public List<Employee> getEmployeeJoning(String joiningDate) {
		List<Employee> emplist=EmployeeData.getEmpData();
		List<Employee> empJoining = new ArrayList<Employee>();
		for(Employee emp:emplist) {
			if(emp.getJoiningDate().equalsIgnoreCase(joiningDate)) {
				empJoining.add(emp);
			}
		}
		return empJoining;
	}

	public Boolean addEmployee(Employee employee) {
		List<Employee> emplist=EmployeeData.getEmpData();
		emplist.add(employee);
		return true;
	}
	
	public Boolean updateEmployee(Employee employee) {
		List<Employee> emplist=EmployeeData.getEmpData();
		int i=0;
		for(Employee emp:emplist) {
			if(emp.getEmpId()==employee.getEmpId()) {
				emplist.set(i, employee);
				break;
			}
			i++;
		}
		return true;
	}

	public Boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> li=EmployeeData.getEmpData();
		int i=0;
		for(Employee emp: li) {
			if(emp.getEmpId()== employee.getEmpId())
			{
				li.remove(i);
				break;
			}
			i++;
		}
		return true;
	}
}
