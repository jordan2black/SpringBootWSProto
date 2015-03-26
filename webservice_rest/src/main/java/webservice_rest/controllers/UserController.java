package webservice_rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import webservice_rest.domain.User;
import webservice_rest.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository repository;

	public @ResponseBody List<User> getAllUser() {
		List<User> allUser = repository.findAll();

		return allUser;
	}

	public @ResponseBody List<User> getByLastname(String lastname){
		List<User> userByLastname = repository.findByLastname(lastname);
		
		return userByLastname;
	}
	
	public @ResponseBody List<User> getByStatus(Integer status) {
		List<User> someUser = repository.findByStatus(status);

		return someUser;
	}
	
	public @ResponseBody List<User> getByType(Integer type){
		List<User> someUser =repository.findByType(type);
		
		return someUser;
	}

	public @ResponseBody List<User> getByStatusType(Integer status, Integer type) {
		List<User> someUser = repository.findByStatusAndType(status, type);

		return someUser;
	}

	@RequestMapping(value = { "", "/", "/user" }, method = RequestMethod.GET)
	public String user(@ModelAttribute("model") ModelMap model) {
		model.addAttribute("User", getAllUser());

		return "user";
	}
	
	@RequestMapping(value="/user/lastname={lastname}", method = RequestMethod.GET)
	public String userLastname(@PathVariable("lastname") String lastname, @ModelAttribute("model") ModelMap model){
		model.addAttribute("User", getByLastname(lastname));
		
		return "user";
	}

	@RequestMapping(value = "/user/status={status}", method = RequestMethod.GET)
	public String userStatus(@PathVariable("status") Integer status,
			@ModelAttribute("model") ModelMap model) {
		model.addAttribute("User", getByStatus(status));

		return "user";
	}
	
	@RequestMapping(value="/user/type={type}", method=RequestMethod.GET)
	public String userTye(@PathVariable("type") Integer type, @ModelAttribute("model") ModelMap model){
		model.addAttribute("User", getByType(type));
		
		return "user";
	}

	@RequestMapping(value = "/user/status={status}/type={type}", method = RequestMethod.GET)
	public String userStatusType(@PathVariable("status") Integer status,
			@PathVariable("type") Integer type,
			@ModelAttribute("model") ModelMap model) {
		model.addAttribute("User", getByStatusType(status, type));

		return "user";
	}

}
