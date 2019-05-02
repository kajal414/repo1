package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/getAllUsers")
	public List<UserRecord> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserRecord userRecord) 
	{
		userService.addUser(userRecord);
		return "successfuly added 1 record";
	}
	
	/*@RequestMapping(value="/user{id}", method=RequestMethod.POST)
	public Optional<UserRecord>getUser(@PathVariable int id)
	{
		return userService.getUser(id);
	}*/
	
	@PostMapping("/getUser")
	public Optional<UserRecord>getUser(@RequestParam int id)
	{
		//int id=Integer.parseInt(str);
		return userService.getUser(id);
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(@RequestParam int id)
	{
		 userService.delete(id);
		 return "successfuly deleted 1 record";
	}
	
	
}
