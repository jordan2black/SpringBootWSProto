package webservice_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import webservice_rest.domain.User;
import webservice_rest.repository.UserRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	public void run(String... args) throws Exception {
//		User user = new User("Max", "Mustermann");
//		repository.saveAndFlush(user);
//
//		List<User> allUser = repository.findAll();
//		for (User u : allUser) {
//			System.out.println(u.getFirstname() + ", " + u.getLastname());		
//		}
//	}

}
