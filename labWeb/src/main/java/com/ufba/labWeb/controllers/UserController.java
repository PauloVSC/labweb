package com.ufba.labWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufba.bean.User;
import com.ufba.labWeb.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository repository;
	
    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?>  get(@PathVariable(value = "id") String id)  {

		User user = repository.findById(id);
						
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?>  login(@RequestBody User user)  {
		
		User loginUser = repository.findByIdAndPassword(user.getName(), user.getPassword());
		if (!loginUser.equals(null)) {
			return new ResponseEntity<Object>(loginUser, HttpStatus.OK);
		}
						
		return new ResponseEntity<>("erro", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/save/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> save(@RequestBody User user) {
		
		User newUser = new User(user.getName(), user.getPassword());
		
		if( repository.findByName(user.getName())) {
			return new ResponseEntity<>("erro", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		repository.save(newUser);
		
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}
	
}
