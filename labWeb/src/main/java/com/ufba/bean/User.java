package com.ufba.bean;

import java.util.List;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String id;
	private String name;
	private String password;
	private List<Disciplina> disciplinas; //buscar pela id da disciplina
	
	
	public User() {
		super();
	}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void getDisciplina(Iterable<Disciplina> allDisciplinas) {
		// TODO Auto-generated method stub
		
	}
	
}
