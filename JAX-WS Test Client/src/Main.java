import employeemanagement.services.Employee;
import employeemanagement.services.EmployeeServiceImpl;
import employeemanagement.services.EmployeeServiceImplService;


public class Main {

	public static void main(String[] args) 
	{
		// call the webservice
		// URL: http://localhost:8080/any/name/you/like/employeeservice?wsdl
		
		EmployeeServiceImpl webservice = new EmployeeServiceImplService().getEmployeeServiceImplPort();
		
		Employee employee = webservice.getEmployeeById("1");
		
		System.out.println(employee.getName());
	}

}
