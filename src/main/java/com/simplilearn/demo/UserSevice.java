package com.simplilearn.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSevice {
	
	@Autowired
	private UserRepo repo;
	
	public User addUser(User u) {
		return repo.save(u);
	}
	
	
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
	
	public User getuserbyid(int id) {
		if(repo.findById(id).isPresent())  
			return repo.findById(id).get();
		else
			return null;
	}
	
	
	public boolean deleteUser(int id) {
		
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	//update by id
	
		public User updateUser(User user,int id) {
			if(repo.findById(id).isPresent()) {
				User old= repo.findById(id).get();
				old.setName(user.getName());
				old.setEmail(user.getEmail());
				old.setCountry(user.getCountry());
				
				return repo.save(old);
			}else {
				return null;
			}
		}
	
	

}
