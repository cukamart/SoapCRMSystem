package com.virtualpairprogrammers.webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.virtualpairprogrammers.domain.Call;
import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;

/**
 * Treba takto na novo definovat triedu cisto pre WS pretoze nemozem mat
 * aj @Transactional aj @Webservice v jednej triede...
 */
@WebService(serviceName = "customerService")
public class CustomerEndpoint implements CustomerManagementService {
	private CustomerManagementService service;

	@WebMethod(exclude = true) // JAXB sa inak stnazi prekonvertovat na XML ale
								// toto je len DI nema nic spolocne s WS...
	public void setService(CustomerManagementService service) {
		this.service = service;
	}

	@Override
	public void newCustomer(Customer newCustomer) {
		service.newCustomer(newCustomer);
	}

	@Override
	public void updateCustomer(Customer changedCustomer) throws CustomerNotFoundException {
		service.updateCustomer(changedCustomer);
	}

	@Override
	public void deleteCustomer(Customer oldCustomer) throws CustomerNotFoundException {
		service.deleteCustomer(oldCustomer);
	}

	// metody ktore vracaju objekt musime pretransformovat objekt z proxy na
	// real...
	@Override
	public Customer findCustomerById(String customerId) throws CustomerNotFoundException {
		Customer customer = service.findCustomerById(customerId);
		customer.setCalls(null);
		return customer;
	}

	@Override
	public List<Customer> findCustomersByName(String name) {
		List<Customer> customers = service.findCustomersByName(name);
		for (Customer next : customers) {
			next.setCalls(null);
		}
		return customers;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = service.getAllCustomers();
		for (Customer next : customers) {
			next.setCalls(null);
		}
		return customers;
	}

	@Override
	public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
		return service.getFullCustomerDetail(customerId);
	}

	@Override
	public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
		service.recordCall(customerId, callDetails);
	}

}