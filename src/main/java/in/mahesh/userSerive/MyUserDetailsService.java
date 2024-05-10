package in.mahesh.userSerive;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.mahesh.entity.Customer;
import in.mahesh.repo.CustomerRepo;

@Service
public class MyUserDetailsService implements UserDetailsService  {
	
	@Autowired
	private CustomerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = repo.findByemail(email);
		return new User(customer.getEmail() , customer.getPassword() , Collections.emptyList());
	}
	
	
	
	
	

}
