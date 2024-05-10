package in.mahesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mahesh.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	public Customer findByemail(String email);

}
