import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import com.srauta.entity.Employee;
import com.srauta.repository.EmployeeRepository;

@RestController
@EnableAutoConfiguration
@ComponentScan({"com.srauta.*"})
@EnableJpaRepositories("com.srauta.repositories.*")
public class Example {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping("/")
	String home() {
		createEmployee();
		return "Hello World!";
	}

	@RequestMapping("/index")
	String index() {
		return "Hello World with index!";
	}

	@RequestMapping(value = "/id") 
	String getIdByValue(@RequestParam("id") String personId){
		System.out.println("ID is "+personId);
		return "Get ID from query string of URL with value element"+personId;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}
	
	void createEmployee() {
		Employee employee = new Employee();
		employee.setFirstname("Samujjal");
		employee.setLastname("Majumder");
		employeeRepository.save(employee);	
	}

}