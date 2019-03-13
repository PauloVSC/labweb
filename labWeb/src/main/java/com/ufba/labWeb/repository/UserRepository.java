package com.ufba.labWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ufba.bean.User;

public interface UserRepository extends MongoRepository<User, Integer>{
	boolean findByName(String name);
	User findById(String id);
	User findByIdAndPassword(String id, String password);
}
