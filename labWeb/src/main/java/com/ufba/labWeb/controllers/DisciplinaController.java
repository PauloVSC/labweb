package com.ufba.labWeb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufba.bean.Disciplina;
import com.ufba.bean.User;
import com.ufba.labWeb.repository.DisciplinaRepository;
import com.ufba.labWeb.repository.UserRepository;

@RestController
public class DisciplinaController {
	
	@Autowired
	DisciplinaRepository repository;
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "{id}/disciplinas/",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?>  get(@PathVariable(value = "id") String id)  {

		User user = userRepository.findById(id);
		
		List<Disciplina> allDisciplinas = (ArrayList<Disciplina>) repository.findByProfessor(user.getName());
						
		return new ResponseEntity<Object>(allDisciplinas, HttpStatus.OK);
	}
	

}
