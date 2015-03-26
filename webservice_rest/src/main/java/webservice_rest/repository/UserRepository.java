package webservice_rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webservice_rest.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByStatus(Integer status);
	
	List<User> findByType(Integer type);

	List<User> findByStatusAndType(Integer status, Integer type);
	
	List<User> findByLastname(String lastname);
}
