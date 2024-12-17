package com.simplilearn.demo;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class MainController {
	
	@Autowired
	private UserSevice service;
	
	@PostMapping("/")
	public ResponseEntity<User> addUser(@RequestBody User u){
		User user= service.addUser(u);
		if(user!=null)
			return new ResponseEntity<User>(user,HttpStatus.CREATED);
		else
			return new ResponseEntity<User>(user, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/")
	public  List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<User> getUserbyId(@PathVariable int id){
		User user= service.getuserbyid(id);
		
		if(user!=null) 
			return new ResponseEntity<User>(user,HttpStatus.FOUND);
		else
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id){
		if(service.deleteUser(id))
			return new ResponseEntity<Object>("User Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No User Found",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user,@PathVariable int id){
		User data=service.updateUser(user, id);
		
		if(data!=null)
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("User Not Found",HttpStatus.NOT_FOUND);
	}

}
