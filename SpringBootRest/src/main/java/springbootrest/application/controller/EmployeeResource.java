package springbootrest.application.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springbootrest.application.model.Employee;
import springbootrest.application.model.EmployeeDetails;
import springbootrest.application.service.EmployeeService;

@RestController
@RequestMapping("/myorg")
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/employees", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity getEmployees() {
		List<Employee> list = employeeService.getemployees();
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setEmployeedetails(list);
		return ResponseEntity.ok(employeeDetails);
	}

//	http://localhost:8080/myorg/employees/2
	@GetMapping(value = "/employees/{empid}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity getEmployees(@PathVariable int empid) {
		Employee list = employeeService.getEmployee(empid);
		return ResponseEntity.ok(list);
	}

//	http://localhost:8080/myorg/employee?joiningDate=10 April 2011
	@GetMapping(value = "/employee", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity getEmployees(@RequestParam String joiningDate) {
		List<Employee> list = employeeService.getEmployeeJoning(joiningDate);
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setEmployeedetails(list);
		return ResponseEntity.ok(employeeDetails);
	}

	@PostMapping(value = "/employee", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity addEmployee(@RequestBody Employee employee) {
		Boolean status = employeeService.addEmployee(employee);
		return ResponseEntity.ok("Employee Created");
	}

	@PutMapping(value = "/employee", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity updateEmployee(@RequestBody Employee employee) {
		Boolean status = employeeService.updateEmployee(employee);
		return ResponseEntity.ok("Employee updated");
	}

	@DeleteMapping(value = "/employee", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity deleteEmployee(@RequestBody Employee employee) {
		Boolean status = employeeService.deleteEmployee(employee);
		return ResponseEntity.ok("Employee updated");
	}

	@GetMapping("/health")
	public String health() {
		return "Service is UP";
	}
}
