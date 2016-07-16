import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.virtualpairprogrammers.webservices.Customer;
import com.virtualpairprogrammers.webservices.CustomerEndpoint;



public class Main {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("client.xml");

		CustomerEndpoint service = factory.getBean(CustomerEndpoint.class);
		
		List<Customer> allCustomers = service.getAllCustomers();
		for (Customer next: allCustomers)
		{
			System.out.println(next.getCustomerId());
			
			System.out.println(next.getCalls().size());
		}
		
		Customer newCustomer = new Customer();
		newCustomer.setCompanyName("VirtualPairProgrammers");
		newCustomer.setNotes("My company");
		newCustomer.setCustomerId("23897329872982");
		service.newCustomer(newCustomer);
		
	}

}
