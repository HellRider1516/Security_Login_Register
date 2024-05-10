package in.mahesh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.mahesh.entity.Customer;
import in.mahesh.repo.CustomerRepo;

@RestController
public class CustomerRest {
	
	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private PasswordEncoder passEn;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody Customer c){
		
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(c.getEmail(), c.getPassword());
		
		try {
			Authentication a = authenticationManager.authenticate(token);

			if (a.isAuthenticated()) {
				return new ResponseEntity<>("Welcome To Ashok IT", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Invalid Credentials", HttpStatus.BAD_REQUEST);
		
	}
	
	
	@PostMapping("/register")
	public String registerCustomer(@RequestBody Customer customer) {
		
		// duplicate check

		String encodedPwd = passEn.encode(customer.getPassword());
		customer.setPassword(encodedPwd);

		repo.save(customer);

		return "User registered";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
